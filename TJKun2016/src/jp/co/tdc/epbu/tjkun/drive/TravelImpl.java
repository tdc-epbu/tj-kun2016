package jp.co.tdc.epbu.tjkun.drive;

import jp.co.tdc.epbu.tjkun.device.EV3;
import lejos.hardware.lcd.LCD;
import lejos.utility.Stopwatch;

public class TravelImpl implements Travel {

	float P_GAIN = 0.9F; // Kp 0.6～0.95(推薦値)
	float I_GAIN = 0.0F; // Ki 0.6～0.7(推薦値)
	float D_GAIN = 0.3F; // Kd 0.3～0.45(推薦値)
	float targetLight; // 目標値
	float diff[] = new float[2]; // 差分
	float integral; // 積分
	float FREQUENCY; // 周期
	int SPEED = 100; // 速度の比例定数 例：1の場合1倍の速度　2の場合1/2の速度
	private Stopwatch stopwatch;
	int maxPid = 50;
	EV3 ev3 = EV3.getInstance();
	private static final float LIGHT_WHITE = 0.4F; // 白色のカラーセンサー輝度値
	private static final float LIGHT_BLACK = 0.0F; // 黒色のカラーセンサー輝度値
	private static final float THRESHOLD = (LIGHT_WHITE+LIGHT_BLACK)/2.0F; // ライントレースの閾値

	public void travel(TravelType type,WheelSpeed speed) {
		// PID制御 ON/OFF
		int idPid = type.getIdPid();
		// ライントレース ON/OFF
		int idTrace = type.getIdTrace();
		// 尻尾 下げ/上げ
		int idTail = type.getIdTail();
		// 倒立振子 ON/OFF
		int idThrow = type.getIdThrow();

		float forward = speed.getWheelSpeedScaleLeft(); // 前後進命令
		float motorLeft = speed.getWheelSpeedScaleLeft(); // 左モーターパワー
		float motorRight = speed.getWheelSpeedScaleRight(); // 右モーターパワー
		float turn = 0.0F; // 旋回命令
		int tail = 0;

		if (idPid == 1) {
			turn = CalcTurnValue(ev3.getBrightness());
		} else if(idPid == 0) {
			turn = jaggyTravel();
		}

		if (idTrace == 1) {

		} else if(idTrace == 0) {

		}

		if (idTail == 1) {
			tail = 110;
		} else if(idThrow == 0) {
			tail = 0;
		}

		if (idThrow == 1) {
			// 倒立振子制御
			ev3.controlBalance(forward, turn ,tail);
		} else if(idThrow == 0) {
			// 直接制御

		}

	}

	/**
	 * 現在の光センサの値により、PID制御を行い、回転量を算出します。
	 *
	 * @param nowLight
	 *            現在の光センサの値
	 * @return PID制御後の回転量
	 */
	private float CalcTurnValue(float nowLight) {

		LCD.drawString(Float.toString(nowLight), 0, 2);
		float tm = stopwatch.elapsed() / 250.0f;

		float P, I, D; // P,I,Dの値
		int turn; // 回転量

		// 前回の差分を更新する。
		diff[0] = diff[1];
		// 今回の差分を算出する。
		diff[1] = nowLight - targetLight;
		// 積分を算出する。
		integral = ((diff[1] + diff[0]) / 2) * tm;// FREQUENCY;

		P = P_GAIN * diff[1]; // 比例
		I = I_GAIN * integral; // 積分
		D = D_GAIN * (diff[1] - diff[0]) / tm;// FREQUENCY; // 微分

		// 回転量を算出する。
		turn = (int) (P + I + D);

		LCD.drawString("P+I+D：" + Float.toString(turn), 0, 5);
		stopwatch.reset();
		// 回転量を返す。
		return MathLimit(turn, this.maxPid, -this.maxPid);

	}
	/**
	 * 制限実施対象の値をInputし、上限値と下限値を超えているかを制限する。 上（下）限値を超えた場合、上（下）限値を返す。
	 * 上（下）限値を超えない場合、制限実施対象の値をそのまま返す。
	 *
	 * @param value
	 *            制限実施対象の値
	 * @param max
	 *            上限値
	 * @param min
	 *            下限値
	 * @return 制限実施後の値を返す。
	 */
	private float MathLimit(float value, float max, float min) {
		if (value > max) {
			return max;
		} else if (value < min) {
			return min;
		}
		return value;
	}

	/**
	 * ジグザグ走行制御
	 */
	public float jaggyTravel() {
		if (ev3.getBrightness() > THRESHOLD) {
                return 50.0F;  // 右旋回命令
            } else {
            	return -50.0F; // 左旋回命令
            }
        }

}
