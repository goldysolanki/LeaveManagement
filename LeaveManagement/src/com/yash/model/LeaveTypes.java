package com.yash.model;

public class LeaveTypes {

	public LeaveTypes() {
	}

	public LeaveTypes(String typeId, String typeValue) {
		this.typeId = typeId;
		this.typeValue = typeValue;
	}

	private String typeId;

	private String typeValue;

	public String getTypeId() {
		return typeId;
	}

	public void setTypeId(String typeId) {
		this.typeId = typeId;
	}

	public String getTypeValue() {
		return typeValue;
	}

	public void setTypeValue(String typeValue) {
		this.typeValue = typeValue;
	}

}
