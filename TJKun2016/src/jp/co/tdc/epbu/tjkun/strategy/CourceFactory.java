/**
 *
 */
package jp.co.tdc.epbu.tjkun.strategy;

import jp.co.tdc.epbu.tjkun.section.Course;

/**
 * @author Takayuki
 *
 */
public class CourceFactory {

	public static Course create(CourceType courceType){

		switch (courceType) {
		case LEFT:
			return createLeftCource();
		case RIGHT:
			return createRightCource();
		default:
			return createLeftCource();
		}
	}

	private static Course createLeftCource() {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	private static Course createRightCource() {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

}
