package com.example.models;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "location")
public class Location {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long Id;

	@Column(name = "Lat")
	private Double lat;

	@Column(name = "Lon")
	private Double lon;
	
	@Column(name = "speed")
	private Double speed;
	
	@OneToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinColumn(name="truck_id")
	private Truck truck;
	
	@OneToMany(mappedBy="location",cascade = CascadeType.ALL)
	private Set<Penalties> penalties;
	
	@OneToMany(mappedBy="source",cascade = CascadeType.ALL)
	private Set<Trip> sources;
	
	@OneToMany(mappedBy="destination",cascade = CascadeType.ALL)
	private Set<Trip> destinations;

	public Location() {
		super();
	}


	public Location(long id, Double lat, Double lon, Truck truck, Set<Penalties> penalties, Set<Trip> sources,
			Set<Trip> destinations) {
		super();
		Id = id;
		this.lat = lat;
		this.lon = lon;
		this.truck = truck;
		this.penalties = penalties;
		this.sources = sources;
		this.destinations = destinations;
	}


	public long getId() {
		return Id;
	}


	public void setId(long id) {
		Id = id;
	}


	public Double getLat() {
		return lat;
	}


	public void setLat(Double lat) {
		this.lat = lat;
	}


	public Double getLon() {
		return lon;
	}


	public void setLon(Double lon) {
		this.lon = lon;
	}


	public Truck getTruck() {
		return truck;
	}


	public void setTruck(Truck truck) {
		this.truck = truck;
	}


	public Set<Penalties> getPenalties() {
		return penalties;
	}


	public void setPenalties(Set<Penalties> penalties) {
		this.penalties = penalties;
	}


	public Set<Trip> getSources() {
		return sources;
	}


	public void setSources(Set<Trip> sources) {
		this.sources = sources;
	}


	public Set<Trip> getDestinations() {
		return destinations;
	}


	public void setDestinations(Set<Trip> destinations) {
		this.destinations = destinations;
	}


	public Double getSpeed() {
		return speed;
	}


	public void setSpeed(Double speed) {
		this.speed = speed;
	}
	
	

	
	
}
