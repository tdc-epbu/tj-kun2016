/**
 * 
 */
package jp.co.tdc.epbu.tjkun.section;

/**
 * @author t2011002
 *
 */
public enum ConditionType {

	// 検知
	/** 黒色検知 */
	BLACK_DETECTION,
	/** 灰色検知 */
	GRAY_DETECTION,
	VIBRATION,
	/** 回転数 */
	DISTANCE,
	/** 経過時間(ミリ秒) */
	TIME,
	/** ライン未検知からの経過時間(ミリ秒) */
	WHITE_DURATION;
	
}
