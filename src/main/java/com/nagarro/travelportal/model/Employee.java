package com.nagarro.travelportal.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

// TODO: Auto-generated Javadoc
/**
 * The Entity Employee.
 */
@Entity
@Table(name = "Employee")
public class Employee {

	/** The username. */
	@Id
	private String username;

	/** The password. */
	@NotNull
	private String password;

	/** The first name. */
	@NotNull
	private String firstName;

	/** The last name. */
	@NotNull
	private String lastName;

	/** The business unit. */
	@NotNull
	private String businessUnit;

	/** The title. */
	@NotNull
	private String title;

	/** The email. */
	@NotNull
	@Email
	// TODO:implement restrictive email as user@nagarro.com .
	private String email;

	/** The phone. */
	@NotNull
	@Size(max = 15)
	private String phone;

	/** The address 1. */
	@NotNull
	private String address1;

	/** The address 2. */
	private String address2;

	/** The city. */
	@NotNull
	private String city;

	/** The state. */
	@NotNull
	private String state;

	/** The zip. */
	@NotNull
	private String zip;

	/** The country. */
	@NotNull
	private String country;

	/** The tickets. */
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY, mappedBy = "employee")
	private List<Ticket> tickets;

	/**
	 * Instantiates a new employee.
	 */
	public Employee() {

	}
	/**
	 * Instantiates a new employee.
	 *
	 * @param firstName    the first name
	 * @param lastName     the last name
	 * @param businessUnit the business unit
	 * @param title        the title
	 * @param email        the email
	 * @param phone        the phone
	 * @param address1     the address 1
	 * @param address2     the address 2
	 * @param city         the city
	 * @param state        the state
	 * @param zip          the zip
	 * @param country      the country
	 */
	public Employee(String firstName, String lastName, String businessUnit, String title, String email,
			String phone, String address1, String address2, String city, String state, String zip, String country) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.businessUnit = businessUnit;
		this.title = title;
		this.email = email;
		this.phone = phone;
		this.address1 = address1;
		this.address2 = address2;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.country = country;
	}
	
	
	/**
	 * Instantiates a new employee.
	 *
	 * @param username the username
	 * @param password the password
	 * @param firstName the first name
	 * @param lastName the last name
	 * @param businessUnit the business unit
	 * @param title the title
	 * @param email the email
	 * @param phone the phone
	 * @param address1 the address 1
	 * @param address2 the address 2
	 * @param city the city
	 * @param state the state
	 * @param zip the zip
	 * @param country the country
	 */
	public Employee(String username, String password, String firstName, String lastName, String businessUnit,
			String title, String email, String phone, String address1, String address2, String city, String state,
			String zip, String country) {
		super();
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.businessUnit = businessUnit;
		this.title = title;
		this.email = email;
		this.phone = phone;
		this.address1 = address1;
		this.address2 = address2;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.country = country;
		// this.tickets = tickets;
	}

	/**
	 * Gets the username.
	 *
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	
	/**
	 * Sets the username.
	 *
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * Gets the password.
	 *
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Sets the password.
	 *
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Gets the first name.
	 *
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Sets the first name.
	 *
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * Gets the last name.
	 *
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * Sets the last name.
	 *
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * Gets the business unit.
	 *
	 * @return the businessUnit
	 */
	public String getBusinessUnit() {
		return businessUnit;
	}

	/**
	 * Sets the business unit.
	 *
	 * @param businessUnit the businessUnit to set
	 */
	public void setBusinessUnit(String businessUnit) {
		this.businessUnit = businessUnit;
	}

	/**
	 * Gets the title.
	 *
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Sets the title.
	 *
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * Gets the email.
	 *
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Sets the email.
	 *
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Gets the phone.
	 *
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * Sets the phone.
	 *
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * Gets the address 1.
	 *
	 * @return the address1
	 */
	public String getAddress1() {
		return address1;
	}

	/**
	 * Sets the address 1.
	 *
	 * @param address1 the address1 to set
	 */
	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	/**
	 * Gets the address 2.
	 *
	 * @return the address2
	 */
	public String getAddress2() {
		return address2;
	}

	/**
	 * Sets the address 2.
	 *
	 * @param address2 the address2 to set
	 */
	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	/**
	 * Gets the city.
	 *
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * Sets the city.
	 *
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * Gets the state.
	 *
	 * @return the state
	 */
	public String getState() {
		return state;
	}

	/**
	 * Sets the state.
	 *
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * Gets the zip.
	 *
	 * @return the zip
	 */
	public String getZip() {
		return zip;
	}

	/**
	 * Sets the zip.
	 *
	 * @param zip the zip to set
	 */
	public void setZip(String zip) {
		this.zip = zip;
	}

	/**
	 * Gets the country.
	 *
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * Sets the country.
	 *
	 * @param country the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}

	/**
	 * Gets the tickets.
	 *
	 * @return the tickets
	 */
	public List<Ticket> getTickets() {
		return tickets;
	}

	/**
	 * Sets the tickets.
	 *
	 * @param tickets the tickets to set
	 */
	public void setTickets(List<Ticket> tickets) {
		this.tickets = tickets;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Employee [username=" + username + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", businessUnit=" + businessUnit + ", title=" + title + ", email=" + email + ", phone=" + phone
				+ ", address1=" + address1 + ", address2=" + address2 + ", city=" + city + ", state=" + state + ", zip="
				+ zip + ", country=" + country + "]";
	}

}