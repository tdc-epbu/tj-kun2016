package jp.co.tdc.epbu.tjkun.drive;

public enum TravelType {
/*
 * PID制御 ON/OFF
 * ライントレース ON/OFF
 * 尻尾 上げ/下げ
 * 倒立振子 ON/OFF
 *
 */
	straght (1,1,0,1),
	curve   (1,1,0,1),
	jaggy   (0,1,0,1),
	lookup  (1,1,1,0),
	tailstop(1,1,1,0),
	back    (1,0,0,1);

	private final int id_pid;
	private final int id_trace;
	private final int id_tail;
	private final int id_throw;
	private TravelType(final int id_pid,final int id_trace,final int id_tail,final int id_throw) {
		this.id_pid = id_pid;
		this.id_trace = id_trace;
		this.id_tail = id_tail;
		this.id_throw = id_throw;
	}

	public int getIdPid() {
		return id_pid;
	}

	public int getIdTrace() {
		return id_trace;
	}

	public int getIdTail() {
		return id_tail;
	}

	public int getIdThrow() {
		return id_throw;
	}
}
