package jp.co.tdc.epbu.tjkun.drive;

import jp.co.tdc.epbu.tjkun.device.EV3;
import jp.co.tdc.epbu.tjkun.measure.Calibrater;

public class TravelTailImpl implements Travel {

	EV3 ev3 = EV3.getInstance();

	public TravelTailImpl(Calibrater calibrater) {
	}

	public void travel(WheelSpeed speed) {
		int left = speed.getWheelSpeedScaleLeft();
		int right = speed.getWheelSpeedScaleRight();
		int tail = 80;
		ev3.controlDirect(left, right, tail) ;
	}
}
