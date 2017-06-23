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
public class OrderRequest {
	
	@Id
	@GeneratedValue
	private Long orderRequestId;
	private Long dataTypeId;
	private Long userAccountId;
	private Long customerId;
	private Long tempCustomerId;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="dateCreated", nullable=false ,columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	@JsonFormat(pattern="yyyy-MM-dd HH:mm a")
	private Date dateCreated = new Date();
	
	@Column(name = "active")
	private String active = "Y";

	public Long getOrderRequestId() {
		return orderRequestId;
	}

	public void setOrderRequestId(Long orderRequestId) {
		this.orderRequestId = orderRequestId;
	}

	public Long getDataTypeId() {
		return dataTypeId;
	}

	public void setDataTypeId(Long dataTypeId) {
		this.dataTypeId = dataTypeId;
	}

	public Long getUserAccountId() {
		return userAccountId;
	}

	public void setUserAccountId(Long userAccountId) {
		this.userAccountId = userAccountId;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public Long getTempCustomerId() {
		return tempCustomerId;
	}

	public void setTempCustomerId(Long tempCustomerId) {
		this.tempCustomerId = tempCustomerId;
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

	public OrderRequest(Long dataTypeId, Long userAccountId, Long customerId, Long tempCustomerId) {
		super();
		this.dataTypeId = dataTypeId;
		this.userAccountId = userAccountId;
		this.customerId = customerId;
		this.tempCustomerId = tempCustomerId;
	}

	
}
