package com.founderapp.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "pitch")
public class Pitch implements Serializable {

	private static final long serialVersionUID = 3528275926445908589L;

	@DatabaseField(id = true)
	String id = UUID.randomUUID().toString().replaceAll("-", "");
	
	@DatabaseField
	String audience;
	
	@DatabaseField
	String companyName;
	
	@DatabaseField
	String developing;
	
	@DatabaseField
	Date lastUpdated;
	
	@DatabaseField
	String offering;
	
	@DatabaseField
	String secretSauce;
	
	@DatabaseField
	String solution;
	
	@DatabaseField
	Boolean hasTask = false;

	@DatabaseField
	int version = 0;

	public String getAudience() {
		return audience;
	}

	public String getCompanyName() {
		return companyName;
	}

	public String getDeveloping() {
		return developing;
	}

	public String getId() {
		return id;
	}

	public Date getLastUpdated() {
		return lastUpdated;
	}

	public String getOffering() {
		return offering;
	}

	public String getSecretSauce() {
		return secretSauce;
	}

	public String getSolution() {
		return solution;
	}

	public int getVersion() {
		return version;
	}

	public void setAudience(String audience) {
		this.audience = audience;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public void setDeveloping(String developing) {
		this.developing = developing;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setLastUpdated(Date lastUpdated) {
		this.lastUpdated = lastUpdated;
	}

	public void setOffering(String offering) {
		this.offering = offering;
	}

	public void setSecretSauce(String secretSauce) {
		this.secretSauce = secretSauce;
	}

	public void setSolution(String solution) {
		this.solution = solution;
	}

	public void setVersion(int version) {
		this.version = version;
	}
	
	public Boolean hasTask() {
		return hasTask;
	}

	public void setHasTask(Boolean hasTask) {
		this.hasTask = hasTask;
	}

	public String toString() {
		return companyName;
	}

}
