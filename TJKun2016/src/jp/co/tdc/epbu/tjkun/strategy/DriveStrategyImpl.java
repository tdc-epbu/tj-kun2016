/**
 *
 */
package jp.co.tdc.epbu.tjkun.strategy;

import jp.co.tdc.epbu.tjkun.device.EV3;
import jp.co.tdc.epbu.tjkun.drive.Travel;
import jp.co.tdc.epbu.tjkun.drive.TravelJaggyImpl;
import jp.co.tdc.epbu.tjkun.drive.TravelPidImpl;
import jp.co.tdc.epbu.tjkun.measure.Calibrater;
import jp.co.tdc.epbu.tjkun.section.Course;
import jp.co.tdc.epbu.tjkun.section.Section;
import lejos.utility.Delay;
import lejos.utility.Stopwatch;

/**
 * @author Takayuki
 *
 */
public class DriveStrategyImpl implements DriveStrategy {

	private Calibrater calibrater;

	public DriveStrategyImpl(Calibrater calibrater) {

		this.calibrater = calibrater;
	}


	@Override
	public void operate(Course cource) {

		//Course cource = CourceFactory.create(CourceType.LEFT);
		Travel travel = new TravelPidImpl(this.calibrater);
		Travel jaggy = new TravelJaggyImpl(this.calibrater);
		
		Stopwatch sw = new Stopwatch();
		sw.reset();
		while (sw.elapsed() > 500) {
			Delay.msDelay(10);
			EV3.getInstance().controlBalance(0, 0, 85);
		}
		
		
		while(cource.isDriving()){

			Delay.msDelay(20);

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
