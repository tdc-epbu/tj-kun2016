/**
 *
 */
package jp.co.tdc.epbu.tjkun.strategy;

import jp.co.tdc.epbu.tjkun.drive.Travel;
import jp.co.tdc.epbu.tjkun.drive.TravelImpl;
import jp.co.tdc.epbu.tjkun.section.Course;
import jp.co.tdc.epbu.tjkun.section.SectionType;

/**
 * @author Takayuki
 *
 */
public class DriveStrategyImpl implements DriveStrategy {

	@Override
	public void operate() {

		Course cource = CourceFactory.create(CourceType.LEFT);
		Travel travel = new TravelImpl();

		while(cource.isDriving()){

			Delay.msDelay(10);

			SectionType section = cource.DecideSpeed();

			travel.travel();

		}
	}

}
