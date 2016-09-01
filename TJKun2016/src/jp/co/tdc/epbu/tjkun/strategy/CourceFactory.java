/**
 *
 */
package jp.co.tdc.epbu.tjkun.strategy;

import java.util.ArrayList;
import java.util.List;

import jp.co.tdc.epbu.tjkun.drive.WheelSpeed;
import jp.co.tdc.epbu.tjkun.section.Condition;
import jp.co.tdc.epbu.tjkun.section.ConditionType;
import jp.co.tdc.epbu.tjkun.section.Course;
import jp.co.tdc.epbu.tjkun.section.Section;

/**
 * @author Takayuki
 *
 */
public class CourceFactory {

	public static Course create(CourceType courceType){

		switch (courceType) {
		case LEFT:
			return createLeftCource();
		case RIGHT:
			return createRightCource();
		default:
			return createLeftCource();
		}
	}

	private static Course createLeftCource() {

		List<Section> sectionList = new ArrayList<>();

//		WheelSpeed speed0 = new WheelSpeed(-60, -60);
//		Condition condition0 = new Condition(ConditionType.TIME, 200);
//		sectionList.add(new Section(speed0, TravelType.PID, condition0, null));
		//スタート
		WheelSpeed speed1 = new WheelSpeed(10, 10);
		Condition condition1 = new Condition(ConditionType.TIME, 1000);
		sectionList.add(new Section(speed1, TravelType.JAGGY, condition1, null));
		//WheelSpeed speed4 = new WheelSpeed(50, 50);
		//Condition condition4 = new Condition(ConditionType.DISTANCE, 360);
		//sectionList.add(new Section(speed4, TravelType.PID, condition4, null));
		
		//ストレート
		WheelSpeed speed2 = new WheelSpeed(80, 80);
		Condition condition2 = new Condition(ConditionType.DISTANCE, 13000);
		sectionList.add(new Section(speed2, TravelType.PID, condition2, null));
		//ストップ
		WheelSpeed speed3 = new WheelSpeed(0, 0);
		Condition condition3 = new Condition(ConditionType.DISTANCE, 6000);
		sectionList.add(new Section(speed3, TravelType.PID, condition3, null));

		return new Course(sectionList);
	}

	private static Course createRightCource() {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

}
