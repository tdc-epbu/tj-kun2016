/**
 *
 */
package jp.co.tdc.epbu.tjkun.section;

import jp.co.tdc.epbu.tjkun.drive.WheelSpeed;
import jp.co.tdc.epbu.tjkun.measure.SectionRunActual;
import jp.co.tdc.epbu.tjkun.strategy.TravelType;

/**
 * @author Takayuki
 *
 */
public class Section {


	private WheelSpeed wheelSpeed;

	private TravelType travelType;
	
	private Condition endCondition;
	
	private Condition abnormalCondition;
	
	private SectionRunActual sectionRunActual;

	public Section(WheelSpeed wheelSpeed, TravelType travelType, Condition endCondition, Condition abnormalCondition){
		this.wheelSpeed = wheelSpeed;
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
		return sectionRunActual.notify(endCondition);
	}

	public void startMeasure(){
		sectionRunActual = new SectionRunActual();
	}
	
	
	public WheelSpeed getWheelspeed() {
		return wheelSpeed;
	}

	public TravelType getTravelType() {
		return travelType;
	}
}
