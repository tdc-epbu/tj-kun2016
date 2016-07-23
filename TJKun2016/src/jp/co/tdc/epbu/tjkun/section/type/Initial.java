/**
 *
 */
package jp.co.tdc.epbu.tjkun.section.type;

import jp.co.tdc.epbu.tjkun.drive.TravelType;
import jp.co.tdc.epbu.tjkun.drive.WheelSpeed;
import jp.co.tdc.epbu.tjkun.section.Condition;
import jp.co.tdc.epbu.tjkun.section.Section;

/**
 * @author Takayuki
 *
 */
public class Initial extends Section {

public Initial(WheelSpeed wheelspeed, TravelType travelType, Condition endCondition, Condition abnormalCondition) {
		super(wheelspeed, travelType, endCondition, abnormalCondition);
		// TODO 自動生成されたコンストラクター・スタブ
	}

	private float time;
}
