package jp.co.tdc.epbu.tjkun.drive;

import jp.co.tdc.epbu.tjkun.device.EV3;

public class SpinImpl implements Spin {

	public void controlBalance(int forward_backword,int spin_power,int tail_angle) {
		EV3 ev3;
		ev3 = EV3.getInstance();
		ev3.controlBalance(forward_backword,spin_power,tail_angle);

	}

}
