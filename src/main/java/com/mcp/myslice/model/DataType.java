package com.mcp.myslice.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class DataType {

	@Id
	@GeneratedValue
	private Long dataTypeId;
	private String typeName; //Example: Extra Large, Family Size
	private String groupName;
	public Long getDataTypeId() {
		return dataTypeId;
	}
	public void setDataTypeId(Long dataTypeId) {
		this.dataTypeId = dataTypeId;
	}
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	public DataType(String typeName, String groupName) {
		this.typeName = typeName;
		this.groupName = groupName;
	}
	public DataType() {
		super();
		// TODO Auto-generated constructor stub
	}

	
}
