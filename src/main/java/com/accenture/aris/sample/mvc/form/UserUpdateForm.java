package com.accenture.aris.sample.mvc.form;

import java.io.Serializable;
import java.util.Date;


import javax.validation.constraints.Pattern;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

public class UserUpdateForm implements Serializable {

    private static final long serialVersionUID = 1L;


    @NotEmpty
    @Length(max=5)
    @Pattern(regexp = "^[a-zA-Z0-9]*$")
    private String id;

    @NotEmpty
    @Length(max=16)
    @Pattern(regexp = "^[a-zA-Z0-9]*$")
    private String name;

    @NotEmpty
    @Length(max=5)
    @Pattern(regexp = "^[a-zA-Z0-9]*$")
    private String roleId;

    @NotEmpty
    @Length(max=64)
    @Email
    private String email;

    @NotEmpty
    @Length(max=10)
    private String sex;
    
    @NotEmpty
    @Length(max=10)
    private String nationality;
    
    @Length(max=50)
    private String text;
    
    @Length(max=2)
    private String defkey;

    private Date startDate;
    private Date endDate;

    //ラベル用
    private String labelRoleId;
    private String labelSex;
    private String labelNationality;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getDefkey() {
        return defkey;
    }

    public void setDefkey(String defkey) {
        this.defkey = defkey;
    }


    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }
    public Date getEndDate() {
        return endDate;
    }
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getLabelRoleId() {
            return labelRoleId;
    }

    public void setLabelRoleId(String labelRoleId) {
        this.labelRoleId = labelRoleId;
    }

    public String getLabelSex() {
        return labelSex;
    }

    public void setLabelSex(String labelSex) {
        this.labelSex = labelSex;
    }

    public String getLabelNationality() {
        return labelNationality;
    }

    public void setLabelNationality(String labelNationality) {
        this.labelNationality = labelNationality;
    }

    public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }


}