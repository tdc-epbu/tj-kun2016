package jp.co.tdc.epbu.tjkun.drive;

import jp.co.tdc.epbu.tjkun.device.EV3;
import jp.co.tdc.epbu.tjkun.measure.Calibrater;

public class TravelTailDownImpl implements Travel {
	EV3 ev3 = EV3.getInstance();

	public TravelTailDownImpl(Calibrater calibrater) {
	}

	public void travel(WheelSpeed speed) {
		int tail_up = 80;
		int tail_down = 90;
		ev3.controlBalance(0, 0, tail_down);
		ev3.controlDirect(10, 10, tail_down) ;
		for (int i = tail_down; i <= tail_up; i--) {
			ev3.controlDirect(0, 0, i) ;
		}
	}
}
