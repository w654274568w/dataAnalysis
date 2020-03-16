package cn.dataAnalysis.model;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;


/**
 * entity 父类
 * @author 
 *
 */
@SuppressWarnings("serial")
public class BaseEntity implements Serializable{

	@Override
	public String toString(){
		return ToStringBuilder.reflectionToString(this,
						ToStringStyle.SHORT_PREFIX_STYLE);
	}
}
