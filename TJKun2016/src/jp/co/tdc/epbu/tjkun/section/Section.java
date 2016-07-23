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
public class Section {


	private WheelSpeed wheelspeed;

	private TravelType travelType;
	
	private Condition endCondition;
	
	private Condition abnormalCondition;
	
	//private SectionRunActual sectionRunActual;

	public Section(WheelSpeed wheelspeed, TravelType travelType, Condition endCondition, Condition abnormalCondition){
		this.wheelspeed = wheelspeed;
		this.travelType = travelType;
		this.endCondition =endCondition;
		this.abnormalCondition = abnormalCondition;
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
