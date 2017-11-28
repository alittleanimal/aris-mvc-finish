package com.accenture.aris.inventory.mvc.form;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class InvitationCodeForm implements Serializable{

	private String invitation;

	
	@Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this,
            ToStringStyle.SHORT_PREFIX_STYLE);
    }

	public String getInvitation() {
		return invitation;
	}

	public void setInvitation(String invitation) {
		this.invitation = invitation;
	}


	
}
