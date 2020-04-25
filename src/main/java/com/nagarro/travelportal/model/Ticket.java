package com.nagarro.travelportal.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.nagarro.travelportal.Enum.Priority;
import com.nagarro.travelportal.Enum.TicketType;

// TODO: Auto-generated Javadoc
/**
 * The Entity Ticket.
 */
@Entity
@Table(name = "Ticket")
public class Ticket {

	/** The ticked id. */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int ticketId;
	
	/** The employee. */
	@JsonIgnore
	@ManyToOne
	private Employee employee;
	
	/** The request type. */
	@NotNull
	@Enumerated(EnumType.STRING)
	private TicketType requestType;

	/** The priority. */
	@NotNull
	@Enumerated(EnumType.STRING)
	private Priority priority;

	/** The travel city. */
	@NotNull
	private String travelCity;

	/** The from. */
	@NotNull
	@Column(name = "fromCity")
	private String from;

	/** The start date. */
	@NotNull
	@Temporal(TemporalType.DATE)
	private Date startDate;

	/** The end date. */
	@NotNull
	@Temporal(TemporalType.DATE)
	private Date endDate;

	/** The passport number. */
	@NotNull
	@Size(max = 25)
	private String passportNumber;

	/** The project name. */
	@NotNull
	private String projectName;

	/** The borne by. */
	@NotNull
	private String borneBy;

	/** The approver. */
	private String approver;

	/** The expected duration. */
	private String expectedDuration;

	/** The allowed amount. */
	private String allowedAmount;

	/** The extra details. */
	private String extraDetails;

	/**
	 * Instantiates a new ticket.
	 */
	public Ticket() {

	}

	/**
	 * Instantiates a new ticket.
	 *
	 * @param requestType      the request type
	 * @param priority         the priority
	 * @param travelCity       the travel city
	 * @param from             the from
	 * @param startDate        the start date
	 * @param endDate          the end date
	 * @param passportNumber   the passport number
	 * @param projectName      the project name
	 * @param borneBy          the borne by
	 * @param approver         the approver
	 * @param expectedDuration the expected duration
	 * @param allowedAmount    the allowed amount
	 * @param extraDetails     the extra details
	 */
	public Ticket(TicketType requestType, Priority priority, String travelCity, String from, Date startDate,
			Date endDate, String passportNumber, String projectName, String borneBy, String approver,
			String expectedDuration, String allowedAmount, String extraDetails) {
		super();
		this.requestType = requestType;
		this.priority = priority;
		this.travelCity = travelCity;
		this.from = from;
		this.startDate = startDate;
		this.endDate = endDate;
		this.passportNumber = passportNumber;
		this.projectName = projectName;
		this.borneBy = borneBy;
		this.approver = approver;
		this.expectedDuration = expectedDuration;
		this.allowedAmount = allowedAmount;
		this.extraDetails = extraDetails;
	}
	
	/**
	 * Gets the employee.
	 *
	 * @return the employee
	 */
	public Employee getEmployee() {
		return employee;
	}

	/**
	 * Sets the employee.
	 *
	 * @param employee the employee to set
	 */
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}


	/**
	 * Gets the ticked id.
	 *
	 * @return the ticketId
	 */
	public int getTickedId() {
		return ticketId;
	}

	/**
	 * Sets the ticked id.
	 *
	 * @param ticketId the ticketId to set
	 */
	public void setTickedId(int ticketId) {
		this.ticketId = ticketId;
	}

	/**
	 * Gets the request type.
	 *
	 * @return the requestType
	 */
	public TicketType getRequestType() {
		return requestType;
	}

	/**
	 * Sets the request type.
	 *
	 * @param requestType the requestType to set
	 */
	public void setRequestType(TicketType requestType) {
		this.requestType = requestType;
	}

	/**
	 * Gets the priority.
	 *
	 * @return the priority
	 */
	public Priority getPriority() {
		return priority;
	}

	/**
	 * Sets the priority.
	 *
	 * @param priority the priority to set
	 */
	public void setPriority(Priority priority) {
		this.priority = priority;
	}

	/**
	 * Gets the travel city.
	 *
	 * @return the travelCity
	 */
	public String getTravelCity() {
		return travelCity;
	}

	/**
	 * Sets the travel city.
	 *
	 * @param travelCity the travelCity to set
	 */
	public void setTravelCity(String travelCity) {
		this.travelCity = travelCity;
	}

	/**
	 * Gets the from.
	 *
	 * @return the from
	 */
	public String getFrom() {
		return from;
	}

	/**
	 * Sets the from.
	 *
	 * @param from the from to set
	 */
	public void setFrom(String from) {
		this.from = from;
	}

	/**
	 * Gets the start date.
	 *
	 * @return the startDate
	 */
	public Date getStartDate() {
		return startDate;
	}

	/**
	 * Sets the start date.
	 *
	 * @param startDate the startDate to set
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	/**
	 * Gets the end date.
	 *
	 * @return the endDate
	 */
	public Date getEndDate() {
		return endDate;
	}

	/**
	 * Sets the end date.
	 *
	 * @param endDate the endDate to set
	 */
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	/**
	 * Gets the passport number.
	 *
	 * @return the passportNumber
	 */
	public String getPassportNumber() {
		return passportNumber;
	}

	/**
	 * Sets the passport number.
	 *
	 * @param passportNumber the passportNumber to set
	 */
	public void setPassportNumber(String passportNumber) {
		this.passportNumber = passportNumber;
	}

	/**
	 * Gets the project name.
	 *
	 * @return the projectName
	 */
	public String getProjectName() {
		return projectName;
	}

	/**
	 * Sets the project name.
	 *
	 * @param projectName the projectName to set
	 */
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	/**
	 * Gets the borne by.
	 *
	 * @return the borneBy
	 */
	public String getBorneBy() {
		return borneBy;
	}

	/**
	 * Sets the borne by.
	 *
	 * @param borneBy the borneBy to set
	 */
	public void setBorneBy(String borneBy) {
		this.borneBy = borneBy;
	}

	/**
	 * Gets the approver.
	 *
	 * @return the approver
	 */
	public String getApprover() {
		return approver;
	}

	/**
	 * Sets the approver.
	 *
	 * @param approver the approver to set
	 */
	public void setApprover(String approver) {
		this.approver = approver;
	}

	/**
	 * Gets the expected duration.
	 *
	 * @return the expectedDuration
	 */
	public String getExpectedDuration() {
		return expectedDuration;
	}

	/**
	 * Sets the expected duration.
	 *
	 * @param expectedDuration the expectedDuration to set
	 */
	public void setExpectedDuration(String expectedDuration) {
		this.expectedDuration = expectedDuration;
	}

	/**
	 * Gets the allowed amount.
	 *
	 * @return the allowedAmount
	 */
	public String getAllowedAmount() {
		return allowedAmount;
	}

	/**
	 * Sets the allowed amount.
	 *
	 * @param allowedAmount the allowedAmount to set
	 */
	public void setAllowedAmount(String allowedAmount) {
		this.allowedAmount = allowedAmount;
	}

	/**
	 * Gets the extra details.
	 *
	 * @return the extraDetails
	 */
	public String getExtraDetails() {
		return extraDetails;
	}

	/**
	 * Sets the extra details.
	 *
	 * @param extraDetails the extraDetails to set
	 */
	public void setExtraDetails(String extraDetails) {
		this.extraDetails = extraDetails;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Ticket [ticketId=" + ticketId + ", requestType=" + requestType + ", priority=" + priority
				+ ", travelCity=" + travelCity + ", from=" + from + ", startDate=" + startDate + ", endDate=" + endDate
				+ ", passportNumber=" + passportNumber + ", projectName=" + projectName + ", borneBy=" + borneBy
				+ ", approver=" + approver + ", expectedDuration=" + expectedDuration + ", allowedAmount="
				+ allowedAmount + ", extraDetails=" + extraDetails + "]";
	}

}