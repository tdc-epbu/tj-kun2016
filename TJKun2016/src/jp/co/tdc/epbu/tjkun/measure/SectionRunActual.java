package jp.co.tdc.epbu.tjkun.measure;

import jp.co.tdc.epbu.tjkun.section.Condition;
import jp.co.tdc.epbu.tjkun.device.EV3Control;
import lejos.utility.Stopwatch;

public class SectionRunActual {

	Stopwatch time = new Stopwatch();

	public SectionRunActual(){
		start();
	}
	public SectionRunActual(EV3Control ev3Control) {
		this.ev3Control = ev3Control;
	}

		public boolean notify(Condition condition){
			boolean notify = false;
			int     motor  = ev3Control.getLMotorCount();
		switch (condition.getConditionType()){
		case DISTANCE:
			distance = time.elapsed() * motor;
			if (condition.getConditionValue() <= distance) { // 時間の基準はチューニングする必要あり
			notify = true;
			}
			break;
		case TIME:
		// 計測開始(経過ミリ秒をコンソールに出力)
			// 計測開始(経過ミリ秒をコンソールに出力)
			if (condition.getConditionValue() <= time.elapsed()) { // 時間の基準はチューニングする必要あり
			notify = true;
			}
			break;
		case LINE_COLOR:
//			/未実装
		}

		//TODO 			 time.elapsed()
		//TODO 		if(notify){
		//TODO 		}

		return notify;
		}
		public void start(){

		time.reset();

		}
}

