package com.pp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "Cruises")
public class Cruise {
	@Id
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	private int id;
	// TODO
	// private Captain name;
	@Column(name = "captain_name")
	private String captainName;
	private String location;
	private int distance;
	@ManyToOne
	private Yacht yacht;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCaptainName() {
		return captainName;
	}

	public void setCaptainName(String captainName) {
		this.captainName = captainName;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}

	public Yacht getYacht() {
		return yacht;
	}

	public void setYacht(Yacht yacht) {
		this.yacht = yacht;
	}

	@Override
	public String toString() {
		return "Cruise [id=" + id + ", captainName=" + captainName + ", location=" + location + ", distance=" + distance
				+ "]";
	}

}
