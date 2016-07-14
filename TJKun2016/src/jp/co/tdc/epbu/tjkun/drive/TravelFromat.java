package jp.co.tdc.epbu.tjkun.drive;

import jp.co.tdc.epbu.tjkun.device.EV3;

public class TravelFromat implements Travel {

	public void travel() {
		int idPid = TravelType.straght.getIdPid();
		int idTrace = TravelType.straght.getIdTrace();
		int idTail = TravelType.straght.getIdTail();
		int idThrow = TravelType.straght.getIdThrow();

		EV3 ev3 = EV3.getInstance();
		float forward = 50.0F; // 前後進命令
		float turn = 0.0F; // 旋回命令
		int tail = 0;

		if (idPid == 1) {

		}

		if (idTrace == 1) {

		}

		if (idTail == 1) {
			tail = 1;
		}

		if (idThrow == 1) {

		}
		ev3.controlBalance(forward, turn ,tail);

	}

}
