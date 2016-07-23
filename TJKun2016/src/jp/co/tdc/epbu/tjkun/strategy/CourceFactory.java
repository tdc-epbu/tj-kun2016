/**
 *
 */
package jp.co.tdc.epbu.tjkun.strategy;

import java.util.ArrayList;
import java.util.List;

import jp.co.tdc.epbu.tjkun.drive.WheelSpeed;
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
		
		WheelSpeed speed = new WheelSpeed();
		
		sectionList.add(new Section(speed, TravelType.PID, null, null));
		
		Course course = new Course(sectionList);
		return null;
	}

	private static Course createRightCource() {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

}
