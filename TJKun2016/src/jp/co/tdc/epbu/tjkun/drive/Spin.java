package jp.co.tdc.epbu.tjkun.drive;

public interface Spin {
	final public static int forward_backword = 0;
	final public static int spin_power = 50;
	final public static int tail_angle = 0;

	public void controlBalance(int forward_backword,int spin_power,int tail_angle) ;

}
