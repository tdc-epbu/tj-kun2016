package jp.co.tdc.epbu.tjkun.drive;

import jp.co.tdc.epbu.tjkun.device.EV3;

public class TravelTailControlRun implements Travel {

	public int tail;


	public TravelTailControlRun(int tail) {

		this.tail = tail;

	}


	@Override
	public void travel(WheelSpeed speed) {

		EV3.getInstance().controlBalance(0, 0 ,tail);

	}

}
