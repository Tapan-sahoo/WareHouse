package com.app.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="vendor")
public class Vendor {
	@Id
	@GeneratedValue(generator="ven_id")
	@GenericGenerator(name="ven_id", strategy="increment")
	@Column(name="vid")
	private Integer venId;
	@Column(name="vname")
	private String venName;
	@Column(name="vcode")
	private String venCode;
	@Column(name="vdesg")
	private String venDesg;
	@ElementCollection(fetch=FetchType.EAGER)
	@Column(name="vpreserve")
	private List<String> venPreserve;
	
	public Vendor() {
		super();
	}

	public Integer getVenId() {
		return venId;
	}

	public void setVenId(Integer venId) {
		this.venId = venId;
	}

	public String getVenName() {
		return venName;
	}

	public void setVenName(String venName) {
		this.venName = venName;
	}

	public String getVenCode() {
		return venCode;
	}

	public void setVenCode(String venCode) {
		this.venCode = venCode;
	}

	public String getVenDesg() {
		return venDesg;
	}

	public void setVenDesg(String venDesg) {
		this.venDesg = venDesg;
	}

	public List<String> getVenPreserve() {
		return venPreserve;
	}

	public void setVenPreserve(List<String> venPreserve) {
		this.venPreserve = venPreserve;
	}

	@Override
	public String toString() {
		return "Vendor [venId=" + venId + ", venName=" + venName + ", venCode=" + venCode + ", venDesg=" + venDesg
				+ ", venPreserve=" + venPreserve + "]";
	}
	
	

}
