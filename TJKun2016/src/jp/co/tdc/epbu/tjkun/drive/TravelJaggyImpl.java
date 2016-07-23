package jp.co.tdc.epbu.tjkun.drive;

import jp.co.tdc.epbu.tjkun.device.EV3;

public class TravelJaggyImpl implements Travel {

	EV3 ev3 = EV3.getInstance();
	private static final float LIGHT_WHITE = 0.4F; // 白色のカラーセンサー輝度値
	private static final float LIGHT_BLACK = 0.0F; // 黒色のカラーセンサー輝度値
	private static final float THRESHOLD = (LIGHT_WHITE+LIGHT_BLACK)/2.0F; // ライントレースの閾値

	public void travel(WheelSpeed speed) {
		float forward = speed.getWheelSpeedScaleLeft();
		float turn = jaggyTravel();
		int tail = 0;
		ev3.controlBalance(forward, turn ,tail);
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
