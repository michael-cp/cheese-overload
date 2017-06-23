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
public class ProductOrderRequest {

	
	@Id
	@GeneratedValue
	private Long productOrderId;

	private Long orderRequestId;
	private Long productId;
	private Long sizeNPricetId;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="dateCreated", nullable=false ,columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	@JsonFormat(pattern="yyyy-MM-dd HH:mm a")
	private Date dateCreated = new Date();
	
	@Column(name = "active")
	private String active = "Y";

	public Long getProductOrderId() {
		return productOrderId;
	}

	public void setProductOrderId(Long productOrderId) {
		this.productOrderId = productOrderId;
	}


	public Long getOrderRequestId() {
		return orderRequestId;
	}

	public void setOrderRequestId(Long orderRequestId) {
		this.orderRequestId = orderRequestId;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public Long getSizeNPricetId() {
		return sizeNPricetId;
	}

	public void setSizeNPricetId(Long sizeNPricetId) {
		this.sizeNPricetId = sizeNPricetId;
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

	public ProductOrderRequest(Long orderRequestId, Long productId, Long sizeNPricetId) {
		super();
		this.orderRequestId = orderRequestId;
		this.productId = productId;
		this.sizeNPricetId = sizeNPricetId;
	}

	public ProductOrderRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
