package jp.co.tdc.epbu.tjkun.drive;

public interface Travel {
	final public static int motor_adjust_left = 50;
	final public static int motor_adjust_right = 50;
	TravelType travelType = TravelType.straght;
	WheelSpeed wheelSpeed = null;

	public void travel() ;

}
