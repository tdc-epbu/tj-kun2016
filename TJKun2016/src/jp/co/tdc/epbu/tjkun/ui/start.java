package jp.co.tdc.epbu.tjkun.ui;

import jp.co.tdc.epbu.tjkun.device.EV3;
import jp.co.tdc.epbu.tjkun.measure.Button;
import jp.co.tdc.epbu.tjkun.measure.Calibrater;
import jp.co.tdc.epbu.tjkun.measure.TouchStatus;
import jp.co.tdc.epbu.tjkun.sample.PIDDriver;
import lejos.utility.Delay;
import lejos.utility.Stopwatch;

/**
 * キャリブレーションを実行し走行戦略の判定処理を呼び出す
 * @author TJ
 *
 */
public class start {

	public static void main(String[] args) {

		EV3 ev3 = EV3.getInstance();


		ev3.start();

		// キャリブレーション実行
		Button button = new Button(ev3);
		Calibrater calibrater = new Calibrater(ev3, button);
		calibrater.calibration();


		PIDDriver pidDriver = new PIDDriver(ev3, calibrater);

		// 尻尾を停止位置へ固定しスタート準備
		while (button.touchStatus() != TouchStatus.Released) {
			ev3.controlDirect(0, 0, 93);
			Delay.msDelay(10);
		}

		// デバッグ用
//		while (button.touchStatus() != TouchStatus.Released) {
//			ev3.controlBalance(0, 0, 0);
//			Delay.msDelay(4);
//		}

		Stopwatch sw = new Stopwatch();
		sw.reset();
		while(sw.elapsed() > 1000) {
			ev3.controlBalance(0, 0, 0);
		}
		pidDriver.drive(80, 13600, 13600);

		// Todo：スタート準備完了後、走行戦略の判定処理を呼び出す
		//DriveStrategy drivestrategy = new DriveStrategyImpl();
		//drivestrategy.operate();


		ev3.close();
	}

	public void waitForStart() {

	}

}
