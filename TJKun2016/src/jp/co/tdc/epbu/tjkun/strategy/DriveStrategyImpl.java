/**
 *
 */
package jp.co.tdc.epbu.tjkun.strategy;

import jp.co.tdc.epbu.tjkun.drive.Travel;
import jp.co.tdc.epbu.tjkun.drive.TravelImpl;
import jp.co.tdc.epbu.tjkun.drive.TravelJaggyImpl;
import jp.co.tdc.epbu.tjkun.section.Course;
import jp.co.tdc.epbu.tjkun.section.Section;
import lejos.utility.Delay;

/**
 * @author Takayuki
 *
 */
public class DriveStrategyImpl implements DriveStrategy {

	@Override
	public void operate(Course cource) {

		//Course cource = CourceFactory.create(CourceType.LEFT);
		Travel travel = new TravelImpl();
		Travel jaggy = new TravelJaggyImpl();

		while(cource.isDriving()){

			Delay.msDelay(10);

			Section section = cource.DecideSpeed();

			switch(section.getTravelType()){
			case PID:
				travel.travel(section.getWheelspeed());
				break;
			case JAGGY:
				jaggy.travel(section.getWheelspeed());
				break;
			default:
				break;
			}

		}
	}

}
