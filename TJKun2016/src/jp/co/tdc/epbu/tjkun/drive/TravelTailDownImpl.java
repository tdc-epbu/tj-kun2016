package jp.co.tdc.epbu.tjkun.drive;

import jp.co.tdc.epbu.tjkun.device.EV3;

public class TravelTailDownImpl implements Travel {
	EV3 ev3 = EV3.getInstance();
	final public static int motor_adjust_left = 50;
	final public static int motor_adjust_right = 50;

	public void travel(WheelSpeed speed) {
		int left = 0;
		int right = 0;
		int tail_up = 90;
		int tail_down = 60;
		for (int i = tail_up; i <= tail_down; i--) {
			ev3.controlDirect(left, right, tail_down) ;
		}
	}


}
