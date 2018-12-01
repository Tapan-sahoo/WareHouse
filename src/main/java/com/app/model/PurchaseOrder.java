package com.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "purchaseOrder_tab")
public class PurchaseOrder {
	@Id
	@GeneratedValue(generator = "po_id")
	@GenericGenerator(name = "po_id", strategy = "increment")
	@Column(name="p_id")
	private Integer id;
	
	@Column(name="p_ocode")
	private String orderCode;
	
	@ManyToOne
	@JoinColumn(name = "scodeFK")
	private ShipmentType sCode;
	
	@ManyToOne
	@JoinColumn(name = "whvenFK")
	private WhUserType vendorType;
	
	@Column(name="p_pno")
	private String prefenceNumber;
	
	@Column(name="p_qualcheck")
	private String qualityCheck;
	
	@Column(name="p_status")
	private String defaultStatus;
	
	@Column(name="p_dcpt")
	private String dcpt;
	
	public PurchaseOrder() {
		super();
	}

	public PurchaseOrder(Integer id, String orderCode, ShipmentType sCode, WhUserType vendorType, String prefenceNumber,
			String qualityCheck, String defaultStatus, String dcpt) {
		super();
		this.id = id;
		this.orderCode = orderCode;
		this.sCode = sCode;
		this.vendorType = vendorType;
		this.prefenceNumber = prefenceNumber;
		this.qualityCheck = qualityCheck;
		this.defaultStatus = defaultStatus;
		this.dcpt = dcpt;
	}
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getOrderCode() {
		return orderCode;
	}

	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}

	public ShipmentType getsCode() {
		return sCode;
	}

	public void setsCode(ShipmentType sCode) {
		this.sCode = sCode;
	}

	public WhUserType getVendorType() {
		return vendorType;
	}

	public void setVendorType(WhUserType vendorType) {
		this.vendorType = vendorType;
	}

	public String getPrefenceNumber() {
		return prefenceNumber;
	}

	public void setPrefenceNumber(String prefenceNumber) {
		this.prefenceNumber = prefenceNumber;
	}

	public String getQualityCheck() {
		return qualityCheck;
	}

	public void setQualityCheck(String qualityCheck) {
		this.qualityCheck = qualityCheck;
	}

	public String getDefaultStatus() {
		return defaultStatus;
	}

	public void setDefaultStatus(String defaultStatus) {
		this.defaultStatus = defaultStatus;
	}

	public String getDcpt() {
		return dcpt;
	}

	public void setDcpt(String dcpt) {
		this.dcpt = dcpt;
	}

	@Override
	public String toString() {
		return "PurchaseOrder [id=" + id + ", orderCode=" + orderCode + ", sCode=" + sCode + ", vendorType="
				+ vendorType + ", prefenceNumber=" + prefenceNumber + ", qualityCheck=" + qualityCheck
				+ ", defaultStatus=" + defaultStatus + ", dcpt=" + dcpt + "]";
	}

	
	
}
