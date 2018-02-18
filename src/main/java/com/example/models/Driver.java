package com.example.models;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "driver")
public class Driver {

	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private long driver_id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "ssn")
	private String ssn;
	
	
	public Driver() {
		super();
	}
	
	public Driver(long driver_id, String name, String ssn) {
		super();
		this.driver_id = driver_id;
		this.name = name;
		this.ssn = ssn;
	}
	

	public long getDriver_id() {
		return driver_id;
	}

	public void setDriver_id(long driver_id) {
		this.driver_id = driver_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	
	
	
}
