package org.team2363.signin.shared.data;

import java.util.Date;

/**
 * @author Michael Snider
 *
 */
public class Season {
	
	private long id;
	private long startDate;
	private long endDate;
	
	
	public Season() {
		//nothing
	}
	
	public Season(long id, long startDate, long endDate) {
		setId(id);
		setStartDate(startDate);
		setEndDate(endDate);
	}
	
	
	
	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return the startDate
	 */
	public long getStartDate() {
		return startDate;
	}
	
	/**
	 * @param startDate the startDate to set
	 */
	public void setStartDate(long startDate) {
		this.startDate = startDate;
	}

	/**
	 * @return the endDate
	 */
	public long getEndDate() {
		return endDate;
	}

	/**
	 * @param endDate the endDate to set
	 */
	public void setEndDate(long endDate) {
		this.endDate = endDate;
	}
	
	/**
	 * @return new Date object with Season's startDate
	 */
	public Date getStartDateObj() {
		return new Date(this.startDate);
	}
	
	/**
	 * @return new Date object with Season's endDate
	 */
	public Date getEndDateObj() {
		return new Date(this.endDate);
	}
	
	
	/**
	 * @param time to compare the startDate and endDate
	 * @return Whether or not the time is within the startDate (inclusively) and endDate (inclusively)
	 */
	public boolean isInSeason(long time) {
		return (time >= this.startDate && time <= this.endDate);
	}
	
	
}
