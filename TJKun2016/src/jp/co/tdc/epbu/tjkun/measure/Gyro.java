package jp.co.tdc.epbu.tjkun.measure;

import jp.co.tdc.epbu.tjkun.device.EV3Control;


public class Gyro {

	private int GyroStatus;
    private EV3Control ev3Control;


	public Gyro(EV3Control ev3Control) {
		this.ev3Control = ev3Control;
	}

	public boolean gyroStatus() {
		if (ev3Control.GyroValue > 0) {  //傾き閾値判定

			return res;
		} else if (ev3Control.GyroValue < 0) {
			return res;
		}

    }


		return res;
	}


}
