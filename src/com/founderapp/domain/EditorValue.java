package com.founderapp.domain;

import java.util.Date;
import java.util.UUID;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "edit_values")
public class EditorValue {

	@DatabaseField(id = true)
	String id = UUID.randomUUID().toString().replaceAll("-", "");
	
	@DatabaseField
	String pitchId;
	
	@DatabaseField
	String code;
	
	@DatabaseField
	String value;
	
	@DatabaseField
	Date lastUpdated = new Date();
	
	@DatabaseField
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
		String r = code + "=" + value;
		return r;
	}

	public String toShareTextContent() {
		StringBuffer sb = new StringBuffer();
		sb.append("\n\n#" + code + "#\n");
		sb.append(value);		
		return sb.toString();
	}
}
