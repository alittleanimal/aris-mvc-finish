package com.accenture.aris.inventory.mvc.form;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class AttendenceForm implements Serializable{

	private String attendenceId;

	
	@Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this,
            ToStringStyle.SHORT_PREFIX_STYLE);
    }

	public String getattendenceId() {
		return attendenceId;
	}

	public void setattendenceId(String attendenceId) {
		this.attendenceId = attendenceId;
	}


	
}
