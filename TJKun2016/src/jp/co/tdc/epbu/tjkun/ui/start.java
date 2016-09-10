package jp.co.tdc.epbu.tjkun.ui;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

import jp.co.tdc.epbu.tjkun.device.EV3;
import jp.co.tdc.epbu.tjkun.measure.Button;
import jp.co.tdc.epbu.tjkun.measure.Calibrater;
import jp.co.tdc.epbu.tjkun.measure.TouchStatus;
import jp.co.tdc.epbu.tjkun.sample.RemoteTask;
import jp.co.tdc.epbu.tjkun.section.Course;
import jp.co.tdc.epbu.tjkun.strategy.CourceFactory;
import jp.co.tdc.epbu.tjkun.strategy.CourceType;
import jp.co.tdc.epbu.tjkun.strategy.DriveStrategy;
import jp.co.tdc.epbu.tjkun.strategy.DriveStrategyImpl;
import lejos.utility.Delay;
import lejos.utility.Stopwatch;

/**
 * キャリブレーションを実行し走行戦略の判定処理を呼び出す
 *
 * @author TJ
 *
 */
public class start implements Runnable {

	private ScheduledExecutorService scheduler;
	private ScheduledFuture<?> futureDrive;
	private ScheduledFuture<?> futureRemote;
	private ScheduledFuture<?> futureStart;
	private DriveStrategy driveStrategy;

	private Course cource;
	
	public static void main(String[] args) {

		start starti = new start();

		starti.starter();

	}

	public void starter() {

		EV3 ev3 = EV3.getInstance();
		
		try {

			scheduler = Executors.newScheduledThreadPool(3);
			

			futureDrive = scheduler.scheduleAtFixedRate(ev3, 0, 4, TimeUnit.MILLISECONDS);
			ev3.controlDirect(0, 0, 0);
			
			// キャリブレーション実行
			Button button = new Button(ev3);
			Calibrater calibrater = new Calibrater(ev3, button);
			calibrater.calibration();
			


			driveStrategy = new DriveStrategyImpl(calibrater);

			
			cource = CourceFactory.create(CourceType.GATE);
			
			// PIDDriver pidDriver = new PIDDriver(ev3, calibrater);

			ev3.reset();;
			

			futureRemote = scheduler.scheduleAtFixedRate(RemoteTask.getInstance(), 0, 500, TimeUnit.MILLISECONDS);

			// 尻尾を停止位置へ固定しスタート準備
			while (button.touchStatus() != TouchStatus.Released
					&& !RemoteTask.getInstance().checkRemoteCommand(RemoteTask.REMOTE_COMMAND_START)) {
				ev3.controlDirect(0, 0, 91);
				Delay.msDelay(10);
			}

			// デバッグ用
			// while (button.touchStatus() != TouchStatus.Released) {
			// ev3.controlBalance(0, 0, 0);
			// Delay.msDelay(4);
			// }

			Stopwatch sw = new Stopwatch();
	
			sw.reset();
			while (sw.elapsed() > 500) {
				Delay.msDelay(10);
				EV3.getInstance().controlBalance(0, 0, 100);
			}
			
			futureDrive = scheduler.scheduleAtFixedRate(this, 0, 10, TimeUnit.MILLISECONDS);

			while (button.touchStatus() != TouchStatus.Released
					&& !RemoteTask.getInstance().checkRemoteCommand(RemoteTask.REMOTE_COMMAND_STOP)) {
				Delay.msDelay(250);
			}

			// pidDriver.drive(80, 13600, 13600);

			// Todo：スタート準備完了後、走行戦略の判定処理を呼び出す
			// DriveStrategy drivestrategy = new DriveStrategyImpl();
			// drivestrategy.operate();

		} finally {

			if (futureStart != null) {
				futureStart.cancel(true);
			}

			if (futureDrive != null) {
				futureDrive.cancel(true);
			}

			if (futureRemote != null) {
				futureRemote.cancel(true);
			}

			ev3.close();

			scheduler.shutdownNow();
		}
	}

	@Override
	public void run() {
		driveStrategy.operate(cource);
	}
	
}
