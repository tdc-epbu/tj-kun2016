package jp.co.tdc.epbu.tjkun.measure;

// import jp.co.tdc.epbu.tjkun.device.;
import jp.co.tdc.epbu.tjkun.device.EV3Control;
public class LineDetection {

	private EV3Control ev3Control;
	/**
	 * 通知をする条件は検討中。現段階では未実装
	 */

	if (ev3Control.touchSensorIsPressed() = ev3Control.getBrightness()) {
		pressStatus = true; // タッチセンサーが押された
		return TouchStatus.Pressed;
	} else {
		if (pressStatus) {
			pressStatus = false; // タッチセンサーが押された後に放した
			return TouchStatus.Released;
		}
	}



}

}
