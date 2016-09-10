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

		List<Section> sectionList;
		
		switch (courceType) {
		case LEFT:
			sectionList = createLeftCource();
			break;
		case RIGHT:
			sectionList = createRightCource();
			break;
		case GATE:
			sectionList = createGateCource();
			break;
		case STAIRS:
			sectionList = createStairsCource();
			break;
		default:
			sectionList = createLeftCource();
		}
		
		return new Course(sectionList);
	}

	private static List<Section> createGateCource() {

		List<Section> sectionList = new ArrayList<>();

		return sectionList;
	}

	private static List<Section> createStairsCource() {

		List<Section> sectionList = new ArrayList<>();

		return sectionList;
	}

	private static List<Section> createLeftCource() {

		List<Section> sectionList = new ArrayList<>();

		//スタート
		WheelSpeed speed1 = new WheelSpeed(60, 60);
		Condition condition1 = new Condition(ConditionType.DISTANCE, 400);
		sectionList.add(new Section(speed1, TravelType.JAGGY, condition1, null));
		
		//ストレート
		WheelSpeed speed2 = new WheelSpeed(90, 90);
		Condition condition2 = new Condition(ConditionType.DISTANCE, 3300);
		sectionList.add(new Section(speed2, TravelType.PID, condition2, null));
		//ストレート
		WheelSpeed speed3 = new WheelSpeed(75, 75);
		Condition condition3 = new Condition(ConditionType.DISTANCE, 700);
		sectionList.add(new Section(speed3, TravelType.PID, condition3, null));
		//ストレート
		WheelSpeed speed4 = new WheelSpeed(90, 90);
		Condition condition4 = new Condition(ConditionType.DISTANCE, 1800);
		sectionList.add(new Section(speed4, TravelType.PID, condition4, null));
		//ストレート
		WheelSpeed speed5 = new WheelSpeed(75, 75);
		Condition condition5 = new Condition(ConditionType.DISTANCE, 500);
		sectionList.add(new Section(speed5, TravelType.PID, condition5, null));
		//ストレート
		WheelSpeed speed6 = new WheelSpeed(90, 90);
		Condition condition6 = new Condition(ConditionType.DISTANCE, 2000);
		sectionList.add(new Section(speed6, TravelType.PID, condition6, null));
		//ストレート
		WheelSpeed speed7 = new WheelSpeed(75, 75);
		Condition condition7 = new Condition(ConditionType.DISTANCE, 500);
		sectionList.add(new Section(speed7, TravelType.PID, condition7, null));
		//ストレート
		WheelSpeed speed7_2 = new WheelSpeed(85, 85);
		Condition condition7_2 = new Condition(ConditionType.DISTANCE, 2700);
		sectionList.add(new Section(speed7_2, TravelType.PID, condition7_2, null));
		//ストップ
		WheelSpeed speed8 = new WheelSpeed(0, 0);
		Condition condition8 = new Condition(ConditionType.DISTANCE, 6000);
		sectionList.add(new Section(speed8, TravelType.PID, condition8, null));
		//ストップ
		WheelSpeed speed9 = new WheelSpeed(0, 0);
		Condition condition9 = new Condition(ConditionType.TIME, 5000);
		sectionList.add(new Section(speed9, TravelType.END, condition9, null));

		sectionList.addAll(createGateCource());
		
		return sectionList;
	}

	private static List<Section> createRightCource() {

		List<Section> sectionList = new ArrayList<>();

		//スタート
		WheelSpeed speed1 = new WheelSpeed(60, 60);
		Condition condition1 = new Condition(ConditionType.DISTANCE, 400);
		sectionList.add(new Section(speed1, TravelType.JAGGY, condition1, null));
		
		//ストレート
		WheelSpeed speed2 = new WheelSpeed(90, 90);
		Condition condition2 = new Condition(ConditionType.DISTANCE, 3300);
		sectionList.add(new Section(speed2, TravelType.PID, condition2, null));
		//ストレート
		WheelSpeed speed3 = new WheelSpeed(75, 75);
		Condition condition3 = new Condition(ConditionType.DISTANCE, 1000);
		sectionList.add(new Section(speed3, TravelType.PID, condition3, null));
		//ストレート
		WheelSpeed speed4 = new WheelSpeed(90, 90);
		Condition condition4 = new Condition(ConditionType.DISTANCE, 2100);
		sectionList.add(new Section(speed4, TravelType.PID, condition4, null));
		//ストレート
		WheelSpeed speed5 = new WheelSpeed(40, 40);
		Condition condition5 = new Condition(ConditionType.DISTANCE, 450);
		sectionList.add(new Section(speed5, TravelType.PID, condition5, null));
		//ストレート
		WheelSpeed speed5_2 = new WheelSpeed(80, 80);
		Condition condition5_2 = new Condition(ConditionType.DISTANCE, 500);
		sectionList.add(new Section(speed5_2, TravelType.PID, condition5_2, null));
		//ストレート
		WheelSpeed speed5_3 = new WheelSpeed(40, 40);
		Condition condition5_3 = new Condition(ConditionType.DISTANCE, 450);
		sectionList.add(new Section(speed5_3, TravelType.PID, condition5_3, null));
		//ストレート
		WheelSpeed speed6 = new WheelSpeed(90, 90);
		Condition condition6 = new Condition(ConditionType.DISTANCE, 1950);
		sectionList.add(new Section(speed6, TravelType.PID, condition6, null));
		//ストレート
		WheelSpeed speed7 = new WheelSpeed(75, 75);
		Condition condition7 = new Condition(ConditionType.DISTANCE, 500);
		sectionList.add(new Section(speed7, TravelType.PID, condition7, null));
		//ストレート
		WheelSpeed speed8 = new WheelSpeed(100, 100);
		Condition condition8 = new Condition(ConditionType.DISTANCE, 1800);
		sectionList.add(new Section(speed8, TravelType.PID, condition8, null));
		//ストレート
		WheelSpeed speed9 = new WheelSpeed(65, 65);
		Condition condition9 = new Condition(ConditionType.DISTANCE, 1000);
		sectionList.add(new Section(speed9, TravelType.PID, condition9, null));
		//ストップ
		WheelSpeed speed10 = new WheelSpeed(0, 0);
		Condition condition10 = new Condition(ConditionType.DISTANCE, 5000);
		sectionList.add(new Section(speed10, TravelType.PID, condition10, null));
		//ストップ
		WheelSpeed speed11 = new WheelSpeed(0, 0);
		Condition condition11 = new Condition(ConditionType.TIME, 5000);
		sectionList.add(new Section(speed11, TravelType.END, condition11, null));

		sectionList.addAll(createStairsCource());

		return sectionList;
	}
	

}
