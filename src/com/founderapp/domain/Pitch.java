package com.founderapp.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "pitches")
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
	Date lastUpdated = new java.util.Date();
	
	@DatabaseField
	String offering;
	
	@DatabaseField
	String secretSauce;
	
	@DatabaseField
	String solution;
	
	@DatabaseField
	Boolean hasTask = false;

	@DatabaseField
	Boolean closed = false;
	
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
	

	public Boolean isClosed() {
		return closed;
	}

	public void setClosed(Boolean closed) {
		this.closed = closed;
	}

	public String toString() {
		return companyName + "[" + id + "]";
	}
	
	public String toShareTextContent() {
		StringBuffer sb = new StringBuffer();
		
		sb.append("\n\n*Company Name*\n");
		sb.append(companyName);
		sb.append("\n\n*Is Developing*\n");
		sb.append(developing);
		sb.append("\n\n*Define Offering*\n");
		sb.append(offering);
		sb.append("\n\n*Audience*\n");
		sb.append(audience);
		sb.append("\n\n*Solve a Problem*\n");
		sb.append(solution);
		sb.append("\n\n*With Secret Sauce*\n");
		sb.append(secretSauce);
		
		return sb.toString();
	}

}
