package jp.co.tdc.epbu.tjkun.measure;

import jp.co.tdc.epbu.tjkun.device.EV3Control;
import jp.co.tdc.epbu.tjkun.section.Condition;
import lejos.utility.Stopwatch;

public class SectionRunActual {

	private EV3Control ev3Control;
	private Calibrater calibrater;

	Stopwatch time = new Stopwatch();
	int initMotorCount;

	public SectionRunActual(EV3Control ev3Control, Calibrater calibrater) {
		this.ev3Control = ev3Control;
		this.calibrater = calibrater;
	}

	public boolean notify(Condition condition) throws InterruptedException{
		boolean notify = false;
		switch (condition.getConditionType()){
		case DISTANCE:
			// 回転数
			int motorCount = Math.abs(ev3Control.getLMotorCount() - initMotorCount);
			if (condition.getConditionValue() <= motorCount) {
				notify = true;
			}
			break;
		case TIME:
			// 時間
			if (condition.getConditionValue() <= time.elapsed()) { // 時間の基準はチューニングする必要あり
				notify = true;
			}
			break;
		case GRAY_DETECTION:
			int i = 0;
			while (i < 10){ //1秒間の間に10回灰色検知を行い、全てtrueであれば値を返す。
				if (condition.getConditionValue() <= calibrater.grayBaseline()) {
					Thread.sleep(100);
				  i++;
				} else{
					break;
				}
				notify = true;
				}
			}
		return notify;
	}
	public void start(){

		time.reset();
		this.initMotorCount  = ev3Control.getLMotorCount();

	}
}

