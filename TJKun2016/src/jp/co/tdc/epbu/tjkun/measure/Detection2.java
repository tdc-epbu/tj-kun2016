package jp.co.tdc.epbu.tjkun.measure;

public class Detection2 {

	private boolean LineCheck;
	private boolean LeftMoterCheck;
	private boolean RightMoterCheck;
	private boolean ObstaclesCheck;
	private boolean VibrationCheck;


	public boolean LineCheck() {
		this.ev3Control = ev3Control;
	}


		if (ev3Control.touchSensorIsPressed()) {
			pressStatus = true; // タッチセンサーが押された
			return TouchStatus.Pressed;
		} else {
			if (pressStatus) {
				pressStatus = false; // タッチセンサーが押された後に放した
				return TouchStatus.Released;
			}
		}

		return TouchStatus.NotPressed;
	}

}
