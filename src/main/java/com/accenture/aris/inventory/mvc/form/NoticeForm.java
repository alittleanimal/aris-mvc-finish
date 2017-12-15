package com.accenture.aris.inventory.mvc.form;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class NoticeForm implements Serializable{

	public String getContext() {
		return context;
	}



	public void setContext(String context) {
		this.context = context;
	}



	public String getTitle() {
		return title;
	}



	public void setTitle(String title) {
		this.title = title;
	}



	private String context;
	private String title;


	
	@Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this,
            ToStringStyle.SHORT_PREFIX_STYLE);
    }



	
}
