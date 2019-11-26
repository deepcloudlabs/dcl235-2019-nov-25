package com.example.model;

import com.example.swing.Column;
import com.example.swing.IgnoreField;

/**
 *
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 */
public class Country {
	@Column(name = "Code", order = 1)
	private String Code;
	@Column(name = "Country Name", order = 2)
	private String Name;
	@Column(name = "Continent", order = 3)
	private String Continent;
	@Column(name = "Independence Year", order = 5)
	private int IndepYear;
	@Column(name = "Population", order = 4)
	private int Population;
	@Column(name = "Goverment Form", order = 6)
	private String GovernmentForm;
	@IgnoreField
	private String HeadOfState;

	public String getCode() {
		return Code;
	}

	public void setCode(String Code) {
		this.Code = Code;
	}

	public String getContinent() {
		return Continent;
	}

	public void setContinent(String Continent) {
		this.Continent = Continent;
	}

	public String getGovernmentForm() {
		return GovernmentForm;
	}

	public void setGovernmentForm(String GovernmentForm) {
		this.GovernmentForm = GovernmentForm;
	}

	public String getHeadOfState() {
		return HeadOfState;
	}

	public void setHeadOfState(String HeadOfState) {
		this.HeadOfState = HeadOfState;
	}

	public int getIndepYear() {
		return IndepYear;
	}

	public void setIndepYear(int IndepYear) {
		this.IndepYear = IndepYear;
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
