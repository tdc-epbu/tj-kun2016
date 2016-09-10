package jp.co.tdc.epbu.tjkun.measure;

import jp.co.tdc.epbu.tjkun.device.EV3Control;
import lejos.hardware.lcd.LCD;
import lejos.utility.Delay;


/**
 * キャリブレーションのクラス<br>
 * 各基準値を取得する前に「calibration」を実行してください。
 * @author higashizono
 *
 */
public class Calibrater {

	private EV3Control ev3Control;
	private Button button;

	private float blackBaseline;
	private float whiteBaseline;
	private float grayBaseline;

	public Calibrater(EV3Control ev3Control, Button button) {

		this.ev3Control = ev3Control;
		this.button = button;
	}

	public void calibration() {

		LCD.drawString("Get Black...  ", 0, 4);

		blackBaseline = getBrightnessForTouchWait();
		LCD.drawString("Black:" + blackBaseline, 0, 5);


		LCD.drawString("Get White...  ", 0, 4);


		whiteBaseline = getBrightnessForTouchWait();
		LCD.drawString("White:" + whiteBaseline, 0, 6);

		LCD.drawString("Get Gray...  ", 0, 4);

		grayBaseline  = getBrightnessForTouchWait();
		LCD.drawString("Gray:" + grayBaseline, 0, 5);


	}

	private float getBrightnessForTouchWait() {

		while (button.touchStatus() != TouchStatus.Released) {

			Delay.msDelay(10);
		}
		return ev3Control.getBrightness();
	}

	public float blackBaseline() {
		return blackBaseline;

	}

	public float whiteBaseline() {
		return whiteBaseline;
	}

	public float grayBaseline() {
		return grayBaseline;
	}
}
