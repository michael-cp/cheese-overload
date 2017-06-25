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
public class Store {
	
	@Id
	@GeneratedValue
	private Long storeId;
	private String propertyNumber;
	private String street;
	private String suburb;
	private String city;
	private String region;
	private String postCode;
	
	private String businessHours;
	private String options; // Dine-in, Take-away, Delivery
	
	private Double latitude;
	private Double longitude;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="dateCreated", nullable=false ,columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	@JsonFormat(pattern="yyyy-MM-dd HH:mm a")
	private Date dateCreated = new Date();
	
	@Column(name = "active")
	private String active = "Y";

	public Long getStoreId() {
		return storeId;
	}

	public void setStoreId(Long storeId) {
		this.storeId = storeId;
	}

	public String getPropertyNumber() {
		return propertyNumber;
	}

	public void setPropertyNumber(String propertyNumber) {
		this.propertyNumber = propertyNumber;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getSuburb() {
		return suburb;
	}

	public void setSuburb(String suburb) {
		this.suburb = suburb;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	public String getBusinessHours() {
		return businessHours;
	}

	public void setBusinessHours(String businessHours) {
		this.businessHours = businessHours;
	}

	public String getOptions() {
		return options;
	}

	public void setOptions(String options) {
		this.options = options;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
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

	public Store(String propertyNumber, String street, String suburb, String city, String region, String postCode,
			String businessHours, String options, Double latitude, Double longitude) {
		this.propertyNumber = propertyNumber;
		this.street = street;
		this.suburb = suburb;
		this.city = city;
		this.region = region;
		this.postCode = postCode;
		this.businessHours = businessHours;
		this.options = options;
		this.latitude = latitude;
		this.longitude = longitude;
	}

	public Store() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
