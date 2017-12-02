package com.example.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "location")
public class Location {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private long Id;
	
	@Column(name = "Lat")
	private String lat;
	
	@Column(name = "Lon")
	private String lon;

	public Location() {
		super();
	}

	public Location(String lat, String lon) {
		super();
		this.lat = lat;
		this.lon = lon;
	}

	public long getId() {
		return Id;
	}

	public String getLat() {
		return lat;
	}

	public void setLat(String lat) {
		this.lat = lat;
	}

	public String getLon() {
		return lon;
	}

	public void setLon(String lon) {
		this.lon = lon;
	}
	
	
	

}
