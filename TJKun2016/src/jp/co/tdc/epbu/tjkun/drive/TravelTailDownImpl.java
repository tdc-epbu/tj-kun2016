package jp.co.tdc.epbu.tjkun.drive;

import jp.co.tdc.epbu.tjkun.device.EV3;

public class TravelTailDownImpl implements Travel {
	EV3 ev3 = EV3.getInstance();
	final public static int motor_adjust_left = 50;
	final public static int motor_adjust_right = 50;

	public void travel(WheelSpeed speed) {
		float forward = speed.getWheelSpeedScaleLeft();
		float turn = 0.0F;
		int tail = 110;
		ev3.controlBalance(forward, turn ,tail);

	}


}
