package org.team2363.signin.shared.data;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.google.gwt.i18n.shared.DateTimeFormat;

/**
 * @author Michael Snider
 * 
 */
public class TimeEntry {
	
	private long id;
	private long startTime;
	private long endTime;
	
	private static final DateTimeFormat DayFormat = DateTimeFormat.getFormat("EEE, MMM d, yyyy");
	private static final DateTimeFormat TimeFormat = DateTimeFormat.getFormat("h:mm a");
	
	
	public TimeEntry() {
		//nothing
	}
	
	public TimeEntry(long id, long startTime, long endTime) {
		setId(id);
		setStartTime(startTime);
		setEndTime(endTime);
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
	 * @return the startTime
	 */
	public long getStartTime() {
		return startTime;
	}
	
	/**
	 * @param startTime the startTime to set
	 */
	public void setStartTime(long startTime) {
		this.startTime = startTime;
	}
	
	/**
	 * @return the endTime
	 */
	public long getEndTime() {
		return endTime;
	}
	
	/**
	 * @param endTime the endTime to set
	 */
	public void setEndTime(long endTime) {
		this.endTime = endTime;
	}
	
	
	
	
	
	/**
	 * @return new Date object with TimeEntry's startTime
	 */
	public Date getStartDate() {
		return new Date(this.startTime);
	}
	
	/**
	 * @return new Date object with TimeEntry's endTime
	 */
	public Date getEndDate() {
		return new Date(this.endTime);
	}
	
	
	/**
	 * @return Start Date in time format
	 */
	public String getStartDateFormatted() {
		return TimeFormat.format(getStartDate());
	}
	
	/**
	 * @return End Date in time format
	 */
	public String getEndDateFormatted() {
		return TimeFormat.format(getEndDate());
	}
	
	/**
	 * @return Day of the TimeEntry, currently based on day of startTime
	 */
	public String getDayFormatted() {
		return DayFormat.format(getStartDate());
	}
	
	
	
	
	
	
	@Override
	public String toString() {
		
		return (getDayFormatted() + " from " + 
				     getStartDateFormatted() + " - " + 
				     getEndDateFormatted());
	}
	
	@Override
	public boolean equals(Object o) {
		
		if(o instanceof TimeEntry) {
			TimeEntry otherEntry = (TimeEntry) o;
			
			return (this.id == otherEntry.getId());
			//return (this.startTime == otherEntry.getStartTime() && this.endTime == otherEntry.getEndTime());
		}
		
		return false;
	}
	
}
