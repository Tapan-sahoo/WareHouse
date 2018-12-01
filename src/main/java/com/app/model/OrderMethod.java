package com.app.model;

import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OrderColumn;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "ordermethodtab")
public class OrderMethod {

	@Id
	@GeneratedValue(generator="odr_id")
	@GenericGenerator(name="odr_id", strategy="increment")
	@Column(name = "oid")
	private Integer id;

	@Column(name = "omode")
	private String mode;

	@Column(name = "ocode")
	private String code;

	@Column(name = "omethod")
	private String method;

	@ElementCollection(fetch=FetchType.EAGER)
	@CollectionTable(name = "oaccept", joinColumns = @JoinColumn(name = "oid"))
	@OrderColumn(name = "pos")
	@Column(name = "data")
	private List<String> accept;

	@Column(name = "dcpt")
	private String dcpt;

	public OrderMethod() {
		super();
	}

	public OrderMethod(Integer id, String mode, String code, String method, List<String> accept, String dcpt) {
		super();
		this.id = id;
		this.mode = mode;
		this.code = code;
		this.method = method;
		this.accept = accept;
		this.dcpt = dcpt;
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

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public List<String> getAccept() {
		return accept;
	}

	public void setAccept(List<String> accept) {
		this.accept = accept;
	}

	public String getDcpt() {
		return dcpt;
	}

	public void setDcpt(String dcpt) {
		this.dcpt = dcpt;
	}

	@Override
	public String toString() {
		return "OrderMethod [id=" + id + ", mode=" + mode + ", code=" + code + ", method=" + method + ", accept="
				+ accept + ", dcpt=" + dcpt + "]";
	}

}
