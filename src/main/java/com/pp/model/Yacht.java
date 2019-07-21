package com.pp.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "Yachts")
public class Yacht {
	@Id
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	private int id;
	@Column(name = "yacht_name")
	private String yachtName;
	private String model;
	@Column(columnDefinition = "DECIMAL(6,2)")
	private float length;
	private int berths;
	@OneToMany(mappedBy = "yacht")
	private List<Cruise> cruises = new ArrayList<>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getYachtName() {
		return yachtName;
	}

	public void setYachtName(String yachtName) {
		this.yachtName = yachtName;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public float getLength() {
		return length;
	}

	public void setLength(float length) {
		this.length = length;
	}

	public int getBerths() {
		return berths;
	}

	public void setBerths(int berths) {
		this.berths = berths;
	}

	public List<Cruise> getCruises() {
		return cruises;
	}

	public void setCruises(List<Cruise> cruises) {
		this.cruises = cruises;
	}

}
