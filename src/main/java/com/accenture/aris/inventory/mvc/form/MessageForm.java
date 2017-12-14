package com.accenture.aris.inventory.mvc.form;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class MessageForm implements Serializable{

	private String text;

	
	@Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this,
            ToStringStyle.SHORT_PREFIX_STYLE);
    }

	public String gettext() {
		return text;
	}

	public void settext(String text) {
		this.text = text;
	}


	
}
