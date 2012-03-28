package com.founderapp.domain;

import java.util.Date;

public class EditorValue {

	String id;
	String pitchId;
	String code;
	String value;
	Date lastUpdated;
	int version = 0;

	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPitchId() {
		return pitchId;
	}

	public void setPitchId(String pitchId) {
		this.pitchId = pitchId;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Date getLastUpdated() {
		return lastUpdated;
	}

	public void setLastUpdated(Date lastUpdated) {
		this.lastUpdated = lastUpdated;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public String toString() {
		return code;
	}

}
