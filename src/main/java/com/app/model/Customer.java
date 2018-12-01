package com.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="customer")
public class Customer {
	@Id
	@GeneratedValue(generator="cust_id")
	@GenericGenerator(name="cust_id", strategy="increment")
	@Column(name="cid")
	private Integer custId;
	@Column(name="ccode")
	private String custCode;
	@Column(name="caddr")
	private String custAddr;
	@Column(name="clocs")
	private String custLocs;
	@Column(name="cenabled")
	private String custEnabled;
	@Column(name="cemail")
	private String custEmail;
	@Column(name="ccontact")
	private String custContact;
	
	public Customer() {
		super();
	}

	public Integer getCustId() {
		return custId;
	}

	public void setCustId(Integer custId) {
		this.custId = custId;
	}

	public String getCustCode() {
		return custCode;
	}

	public void setCustCode(String custCode) {
		this.custCode = custCode;
	}

	public String getCustAddr() {
		return custAddr;
	}

	public void setCustAddr(String custAddr) {
		this.custAddr = custAddr;
	}

	public String getCustLocs() {
		return custLocs;
	}

	public void setCustLocs(String custLocs) {
		this.custLocs = custLocs;
	}

	public String getCustEnabled() {
		return custEnabled;
	}

	public void setCustEnabled(String custEnabled) {
		this.custEnabled = custEnabled;
	}

	public String getCustEmail() {
		return custEmail;
	}

	public void setCustEmail(String custEmail) {
		this.custEmail = custEmail;
	}

	public String getCustContact() {
		return custContact;
	}

	public void setCustContact(String custContact) {
		this.custContact = custContact;
	}

	@Override
	public String toString() {
		return "Customer [custId=" + custId + ", custCode=" + custCode + ", custAddr=" + custAddr + ", custLocs="
				+ custLocs + ", custEnabled=" + custEnabled + ", custEmail=" + custEmail + ", custContact="
				+ custContact + "]";
	}
	
	
	

}
