package com.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name ="uomtabs")
public class Uom {

	@Id
	@GeneratedValue(generator="uom_id")
	@GenericGenerator(name="uom_id", strategy="increment")
	@Column(name = "u_id")
	private Integer id;
	
	@Column(name = "utype")
	private String type;
	
	@Column(name = "umodel")
	private String model;
	
	@Column(name = "udcpt")
	private String dcpt;
	
	public Uom() {
		super();
	}
	

	public Uom(Integer id, String type, String model, String dcpt) {
		super();
		this.id = id;
		this.type = type;
		this.model = model;
		this.dcpt = dcpt;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public String getModel() {
		return model;
	}


	public void setModel(String model) {
		this.model = model;
	}


	public String getDcpt() {
		return dcpt;
	}


	public void setDcpt(String dcpt) {
		this.dcpt = dcpt;
	}


	@Override
	public String toString() {
		return "Uom [id=" + id + ", type=" + type + ", model=" + model + ", dcpt=" + dcpt + "]";
	}

	

}
