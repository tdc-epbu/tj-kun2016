package jp.co.tdc.epbu.tjkun.measure;

import jp.co.tdc.epbu.tjkun.section.Condition;
import lejos.utility.Stopwatch;

public class SectionRunActual {

	Stopwatch time = new Stopwatch();

	public SectionRunActual(){
		start();
	}

		public boolean notify(Condition condition){
			boolean notify = false;
		switch (condition.getConditionType()){
		case DISTANCE:
//			if (X >= 100000) { // 時間の基準はチューニングする必要あり
//			res = true;
//			return TouchStatus.Pressed;
//			}
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

