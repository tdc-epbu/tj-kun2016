package jp.co.tdc.epbu.tjkun.ui;

import jp.co.tdc.epbu.tjkun.device.EV3;
import jp.co.tdc.epbu.tjkun.measure.Button;
import jp.co.tdc.epbu.tjkun.measure.Calibrater;
import jp.co.tdc.epbu.tjkun.strategy.DriveStrategy;
import jp.co.tdc.epbu.tjkun.strategy.DriveStrategyImpl;

/**
 * キャリブレーションを実行し走行戦略の判定処理を呼び出す
 * @author TJ
 *
 */
public class start {

	public static void main(String[] args) {

		// キャリブレーション実行
		Button button = new Button(EV3.getInstance());
		Calibrater calibrater = new Calibrater(EV3.getInstance(), button);
		calibrater.calibration();

		// キャリブレーション完了後、走行戦略の判定処理呼び出し
		DriveStrategy drivestrategy = new DriveStrategyImpl();
		drivestrategy.operate();

	}

}
