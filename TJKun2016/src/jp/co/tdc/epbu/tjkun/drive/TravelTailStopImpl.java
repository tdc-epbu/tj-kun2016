package jp.co.tdc.epbu.tjkun.drive;

import jp.co.tdc.epbu.tjkun.device.EV3;

public class TravelTailStopImpl implements Travel {

	EV3 ev3 = EV3.getInstance();
	public void travel(WheelSpeed speed) {
		float forward = speed.getWheelSpeedScaleLeft();
		float turn = 0.0F;
		int tail = 110;
		ev3.controlBalance(forward, turn ,tail);
	}


}
