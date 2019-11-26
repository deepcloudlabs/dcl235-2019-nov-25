package com.example.model;

import java.io.Serializable;

import com.example.swing.Column;

/**
 *
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 */
@SuppressWarnings("serial")
public class City implements Serializable {
	@Column(name = "Id",order=1)
	private int ID;
	@Column(name = "City Name",order=3)
	private String Name;
	@Column(name = "Country Code",order=2)
	private String CountryCode;
	@Column(name = "District",order=4)
	private String District;
	@Column(name = "Population",order=5)
	private int Population;

	public City() {
	}

	public String getCountryCode() {
		return CountryCode;
	}

	public void setCountryCode(String CountryCode) {
		this.CountryCode = CountryCode;
	}

	public String getDistrict() {
		return District;
	}

	public void setDistrict(String District) {
		this.District = District;
	}

	public int getID() {
		return ID;
	}

	public void setID(int ID) {
		this.ID = ID;
	}

	public String getName() {
		return Name;
	}

	public void setName(String Name) {
		this.Name = Name;
	}

	public int getPopulation() {
		return Population;
	}

	public void setPopulation(int Population) {
		this.Population = Population;
	}
}
