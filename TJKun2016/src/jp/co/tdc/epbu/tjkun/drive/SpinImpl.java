package jp.co.tdc.epbu.tjkun.drive;

import jp.co.tdc.epbu.tjkun.device.EV3;

public class SpinImpl implements Spin {

	public void controlBalance() {
		EV3 ev3;
		ev3 = EV3.getInstance();
		ev3.controlBalance(forward_backword,spin_power,tail_angle);

	}

}
