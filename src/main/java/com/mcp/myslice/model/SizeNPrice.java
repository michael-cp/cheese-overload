package com.mcp.myslice.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class SizeNPrice {
	
	@Id
	@GeneratedValue
	private Long sizeNPrizeId;
	private String sizeCode; //Example: Extra Large, Family Size
	private String price;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="dateCreated", nullable=false ,columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	@JsonFormat(pattern="yyyy-MM-dd HH:mm a")
	private Date dateCreated = new Date();
	
	@Column(name = "active")
	private String active = "Y";
	
	private Long productId;


	public Long getSizeNPrizeId() {
		return sizeNPrizeId;
	}

	public void setSizeNPrizeId(Long sizeNPrizeId) {
		this.sizeNPrizeId = sizeNPrizeId;
	}

	public String getSizeCode() {
		return sizeCode;
	}

	public void setSizeCode(String sizeCode) {
		this.sizeCode = sizeCode;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public String getActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public SizeNPrice(String sizeCode, String price, Long productId) {
		super();
		this.sizeCode = sizeCode;
		this.price = price;
		this.productId = productId;
	}

	public SizeNPrice() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
