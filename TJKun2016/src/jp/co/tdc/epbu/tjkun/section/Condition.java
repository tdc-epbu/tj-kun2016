/**
 * 
 */
package jp.co.tdc.epbu.tjkun.section;

/**
 * @author t2011002
 *
 */
public class Condition {

	private ConditionType conditionType;
	private float value;
	
	public Condition(ConditionType conditionType, float value){
		this.conditionType = conditionType;
		this.value = value;
	}

	public ConditionType getConditionType() {
		return conditionType;
	}

	public float getValue() {
		return value;
	}
	
}
	
