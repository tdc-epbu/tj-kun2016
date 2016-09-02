package jp.co.tdc.epbu.tjkun.drive;

import jp.co.tdc.epbu.tjkun.device.EV3;

public class TravelTailSpinImpl implements TravelTail {

	EV3 ev3 = EV3.getInstance();
	public void travel(WheelSpeed speed) {
		int left = speed.getWheelSpeedScaleLeft();
		int right = speed.getWheelSpeedScaleRight();
		int tail = 92;
		ev3.controlDirect(left, right, tail) ;

	}
}
