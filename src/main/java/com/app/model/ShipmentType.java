package com.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "shipmenttabs")
public class ShipmentType {
	@Id
	@GeneratedValue(generator="spt_id")
	@GenericGenerator(name="spt_id", strategy="increment")
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "smode")
	private String mode;
	
	@Column(name = "scode")
	private String code;
	
	@Column(name = "senable")
	private String enable;
	
	@Column(name = "sgrade")
	private String grade;
	
	@Column(name = "sdcpt")
	private String dcpt;
	public ShipmentType() {
		super();
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getMode() {
		return mode;
	}
	public void setMode(String mode) {
		this.mode = mode;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getEnable() {
		return enable;
	}
	public void setEnable(String enable) {
		this.enable = enable;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getDcpt() {
		return dcpt;
	}
	public void setDcpt(String dcpt) {
		this.dcpt = dcpt;
	}
	@Override
	public String toString() {
		return "ShipmentType [id=" + id + ", mode=" + mode + ", code=" + code + ", enable=" + enable + ", grade="
				+ grade + ", dcpt=" + dcpt + "]";
	}
	
	

}
