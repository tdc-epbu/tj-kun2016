package jp.co.tdc.epbu.tjkun.drive;

import jp.co.tdc.epbu.tjkun.device.EV3;

public class TravelSpinImpl implements TravelDirect {

	EV3 ev3 = EV3.getInstance();
	public void travel(WheelSpeed speed) {
		int left = 20;
		int right = 20;
		int tail = 0;
		ev3.controlDirect(left, right, tail);
	}

	public void calculateSpin() {

	}

}
