/**
 *
 */
package jp.co.tdc.epbu.tjkun.section;

import jp.co.tdc.epbu.tjkun.drive.TravelType;
import jp.co.tdc.epbu.tjkun.drive.WheelSpeed;

/**
 * @author Takayuki
 *
 */
public class SectionType {


	private WheelSpeed wheelspeed;

	private TravelType travelType;

	SectionType(WheelSpeed wheelspeed, TravelType travelType){
		this.wheelspeed = wheelspeed;
		this.travelType = travelType;
	}

	/**
	 * 異常値を判定する
	 */
	public void judgeAbnormal(){
		// TODO
	}

	/**
	 * 区間の終了を判定する
	 * @return
	 */
	public boolean judgeEndOfSection(){
		// TODO
		return true;
	}

	public WheelSpeed getWheelspeed() {
		return wheelspeed;
	}

	public TravelType getTravelType() {
		return travelType;
	}
}
