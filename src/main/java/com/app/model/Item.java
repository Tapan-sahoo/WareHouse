package com.app.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "itemtabs")
public class Item {
	@Id
	@GeneratedValue(generator="item_id")
	@GenericGenerator(name="item_id", strategy="increment")
	@Column(name = "iid")
	private Integer itemId;
	@Column(name = "icode")
	private String itemCode;
	@Column(name = "iwidth")
	private double width;
	@Column(name = "ilength")
	private double length;
	@Column(name = "iheight")
	private double height;
	@Column(name = "icost")
	private double baseCost;
	@Column(name = "icurrency")
	private String baseCurrency;
	@Column(name = "idescription")
	private String dcpt;
	@ManyToOne
	@JoinColumn(name = "uidFK")
	private Uom uom;

	@ManyToOne
	@JoinColumn(name = "om_sale")
	private OrderMethod omSale;

	@ElementCollection(fetch=FetchType.EAGER)
	@ManyToOne
	@JoinColumn(name = "om_purchase")
	private OrderMethod omPurchase;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name="ven_tab", joinColumns=@JoinColumn(name="venFk"),inverseJoinColumns=@JoinColumn(name="whFK"))
	@Fetch(value = FetchMode.SUBSELECT)
	private List<WhUserType> whVendor=new ArrayList<WhUserType>(0);
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name="cust_tab", joinColumns=@JoinColumn(name="custFk"),inverseJoinColumns=@JoinColumn(name="wh1FK"))
	@Fetch(value = FetchMode.SUBSELECT)
	private List<WhUserType> whCustomer=new ArrayList<WhUserType>(0);

	public Item() {
		super();
	}

	public Item(Integer itemId, String itemCode, double width, double length, double height, double baseCost,
			String baseCurrency, String dcpt, Uom uom, OrderMethod omSale, OrderMethod omPurchase,
			List<WhUserType> whVendor, List<WhUserType> whCustomer) {
		super();
		this.itemId = itemId;
		this.itemCode = itemCode;
		this.width = width;
		this.length = length;
		this.height = height;
		this.baseCost = baseCost;
		this.baseCurrency = baseCurrency;
		this.dcpt = dcpt;
		this.uom = uom;
		this.omSale = omSale;
		this.omPurchase = omPurchase;
		this.whVendor = whVendor;
		this.whCustomer = whCustomer;
	}

	public Integer getItemId() {
		return itemId;
	}

	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}

	public String getItemCode() {
		return itemCode;
	}

	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public double getLength() {
		return length;
	}

	public void setLength(double length) {
		this.length = length;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public double getBaseCost() {
		return baseCost;
	}

	public void setBaseCost(double baseCost) {
		this.baseCost = baseCost;
	}

	public String getBaseCurrency() {
		return baseCurrency;
	}

	public void setBaseCurrency(String baseCurrency) {
		this.baseCurrency = baseCurrency;
	}

	public String getDcpt() {
		return dcpt;
	}

	public void setDcpt(String dcpt) {
		this.dcpt = dcpt;
	}

	public Uom getUom() {
		return uom;
	}

	public void setUom(Uom uom) {
		this.uom = uom;
	}

	public OrderMethod getOmSale() {
		return omSale;
	}

	public void setOmSale(OrderMethod omSale) {
		this.omSale = omSale;
	}

	public OrderMethod getOmPurchase() {
		return omPurchase;
	}

	public void setOmPurchase(OrderMethod omPurchase) {
		this.omPurchase = omPurchase;
	}

	public List<WhUserType> getWhVendor() {
		return whVendor;
	}

	public void setWhVendor(List<WhUserType> whVendor) {
		this.whVendor = whVendor;
	}

	public List<WhUserType> getWhCustomer() {
		return whCustomer;
	}

	public void setWhCustomer(List<WhUserType> whCustomer) {
		this.whCustomer = whCustomer;
	}

	@Override
	public String toString() {
		return "Item [itemId=" + itemId + ", itemCode=" + itemCode + ", width=" + width + ", length=" + length
				+ ", height=" + height + ", baseCost=" + baseCost + ", baseCurrency=" + baseCurrency + ", dcpt=" + dcpt
				+ ", uom=" + uom + ", omSale=" + omSale + ", omPurchase=" + omPurchase + ", whVendor=" + whVendor
				+ ", whCustomer=" + whCustomer + "]";
	}

	
	

}
