package com.example.models;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "trip")
public class Trip {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private long trip_id;
	
	@Column(name = "rate")
	private double rate;
	
	@Column(name = "date")
	private Date date;
	
	@OneToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinColumn(name="driver_id")
	private Driver driver;
	
	@OneToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinColumn(name="truck_id")
	private Truck truck;
	
	@OneToMany(mappedBy="trip",cascade = CascadeType.ALL)
	private Set<Penalties> penalties;
	
	@OneToMany(mappedBy="trip",cascade = CascadeType.ALL)
	private Set<Good> goods ;
	
	@OneToMany(mappedBy="trip", cascade=CascadeType.ALL)
	private Set<CheckPoints> check_points ;
	
	@ManyToOne
	@JoinColumn(name="source")
	private Location source;
	
	@ManyToOne
	@JoinColumn(name="destination")
	private Location destination;
	

	@ManyToOne
	@JoinColumn(name="parent")
	private Trip parent;

	@OneToMany(mappedBy="parent")
	private Set<Trip> childern;
	
	
	
	public Trip() {
		super();
	}

	
	
	public Trip(long trip_id, double rate, Date date, Driver driver, Truck truck, Set<Penalties> penalties,
			Set<Good> goods, Set<CheckPoints> check_points, Location source, Location destination, Trip parent,
			Set<Trip> childern) {
		super();
		this.trip_id = trip_id;
		this.rate = rate;
		this.date = date;
		this.driver = driver;
		this.truck = truck;
		this.penalties = penalties;
		this.goods = goods;
		this.check_points = check_points;
		this.source = source;
		this.destination = destination;
		this.parent = parent;
		this.childern = childern;
	}



	public Location getSource() {
		return source;
	}

	public void setSource(Location source) {
		this.source = source;
	}



	public Location getDestination() {
		return destination;
	}



	public void setDestination(Location destination) {
		this.destination = destination;
	}



	public Trip getParent() {
		return parent;
	}



	public void setParent(Trip parent) {
		this.parent = parent;
	}



	public Set<Trip> getChildern() {
		return childern;
	}



	public void setChildern(Set<Trip> childern) {
		this.childern = childern;
	}



	public long getTrip_id() {
		return trip_id;
	}

	public void setTrip_id(long trip_id) {
		this.trip_id = trip_id;
	}

	public double getRate() {
		return rate;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Driver getDriver() {
		return driver;
	}

	public void setDriver(Driver driver) {
		this.driver = driver;
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

	public Set<Good> getGoods() {
		return goods;
	}

	public void setGoods(Set<Good> goods) {
		this.goods = goods;
	}

	public Set<CheckPoints> getCheck_points() {
		return check_points;
	}

	public void setCheck_points(Set<CheckPoints> check_points) {
		this.check_points = check_points;
	}
	
	
	
}
