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
public class UserAccount {

	@Id
	@GeneratedValue
	private Long userAccountId;
	@Column(length=50)
	private String emailAddress;
	private String password;
	@Column(length=50)
	private String firstName;
	@Column(length=50)
	private String lastName;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="dateCreated", nullable=false ,columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	@JsonFormat(pattern="yyyy-MM-dd HH:mm a")
	private Date dateCreated = new Date();
	
	@Column(name = "active")
	private String active = "Y";

	public Long getUserAccountId() {
		return userAccountId;
	}

	public void setUserAccountId(Long userAccountId) {
		this.userAccountId = userAccountId;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
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

	public UserAccount(String emailAddress, String password, String firstName, String lastName) {
		this.emailAddress = emailAddress;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public UserAccount() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
    @Override
    public String toString() {
        return String.format(
                "User [id=%d, firstName='%s', lastName='%s']",
                userAccountId, firstName, lastName);
    }

}
