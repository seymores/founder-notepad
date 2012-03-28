package com.founderapp.domain;

import java.util.Date;

public class Pitch {

	String audience;
	String companyName;
	String developing;
	String id;
	Date lastUpdated;
	String offering;
	String secretSauce;
	String solution;
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

	public String toString() {
		return companyName;
	}

}
