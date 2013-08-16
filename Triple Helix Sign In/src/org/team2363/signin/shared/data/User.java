package org.team2363.signin.shared.data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Michael Snider
 *
 */
public class User {
	
	private long id;
	private String name;
	private Rank rank;
	private boolean active;
	private List<TimeEntry> timeEntries;
	
	
	public User(long id) {
		this(id, "Anonymous");
	}
	
	public User(long id, String name) {
		this(id, name, Rank.MEMBER);
	}
	
	public User(long id, String name, Rank rank) {
		this(id, name, rank, true);
	}
	
	public User(long id, String name, Rank rank, boolean active) {
		this(id, name, rank, active, new ArrayList<TimeEntry>());
	}
	
	public User(long id, String name, Rank rank, boolean active, List<TimeEntry> timeEntries) {
		setId(id);
		setName(name);
		setRank(rank);
		setActive(active);
		setTimeEntries(timeEntries);
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
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the rank
	 */
	public Rank getRank() {
		return rank;
	}

	/**
	 * @param rank the rank to set
	 */
	public void setRank(Rank rank) {
		this.rank = rank;
	}
	
	/**
	 * @return Whether or not the User is an Administrator
	 */
	public boolean isAdmin() {
		return (this.rank == Rank.ADMINISTRATOR);
	}
	
	
	/**
	 * @return Whether or not the User is active
	 */
	public boolean isActive() {
		return active;
	}
	
	/**
	 * @param active Whether or not the User is active
	 */
	public void setActive(boolean active) {
		this.active = active;
	}
	
	
	

	/**
	 * @return the timeEntries
	 */
	public List<TimeEntry> getTimeEntries() {
		return timeEntries;
	}

	/**
	 * @param timeEntries the timeEntries to set
	 */
	public void setTimeEntries(List<TimeEntry> timeEntries) {
		this.timeEntries = timeEntries;
	}
	
	/**
	 * @param timeEntry to add to the List timeEntries
	 * @return Whether or not the TimeEntry was added to the List
	 */
	public boolean addTimeEntry(TimeEntry timeEntry) {
		
		if(this.timeEntries == null) {
			this.timeEntries = new ArrayList<TimeEntry>();
		}
		
		return this.timeEntries.add(timeEntry);
	}
	
	/**
	 * @param timeEntry to remove from the List timeEntries
	 * @return Whether or not the TimeEntry was removed from the List
	 */
	public boolean removeTimeEntry(TimeEntry timeEntry) {
		
		if(this.timeEntries == null) {
			return false;
		}
		
		return this.timeEntries.remove(timeEntry);
	}
	
	
	
	
	
	
	/**
	 * @param currentSeason to get a List of TimeEntry objects from
	 * @return Selected TimeEntry objects from currentSeason
	 */
	public List<TimeEntry> getTimeEntriesInSeason(Season currentSeason) {
		
		List<TimeEntry> selectedTimeEntries = new ArrayList<TimeEntry>();
		
		
		for(TimeEntry timeEntry : timeEntries) {
			
			//currently only checks startTime, you may want to also check endTime
			if(currentSeason.isInSeason(timeEntry.getStartTime())) {
				selectedTimeEntries.add(timeEntry);
			}
			
		}
		
		return selectedTimeEntries;
	}
	
	/**
	 * @param seasons to get a List of TimeEntry objects from
	 * @return Selected TimeEntry objects from seasons
	 */
	public List<TimeEntry> getTimeEntriesInSeason(List<Season> seasons) {
		
		List<TimeEntry> selectedTimeEntries = new ArrayList<TimeEntry>();
		
		
		for(Season currentSeason : seasons) {
			
			selectedTimeEntries.addAll(getTimeEntriesInSeason(currentSeason));
			
		}
		
		return selectedTimeEntries;
	}
	
	
	
	
	
	
	/**
	 * @param timeEntries to count hours from
	 * @return Hours accumulated from timeEntries
	 */
	private double countHours(List<TimeEntry> timeEntries) {
		double hours = 0.0;
		
		for(TimeEntry timeEntry : timeEntries) {
			
			long duration = (timeEntry.getEndTime() - timeEntry.getStartTime());
			hours += ((duration / 1000) / 3600);
		}
		
		return hours;
	}
	
	
	/**
	 * @return Hours from ALL timeEntries
	 */
	public double getHours() {
		return countHours(this.timeEntries);
	}
	
	/**
	 * @param currentSeason to get timeEntries from
	 * @return Hours from timeEntries within the currentSeason
	 */
	public double getHours(Season currentSeason) {
		
		List<TimeEntry> timeEntriesInSeason = getTimeEntriesInSeason(currentSeason);
		return countHours(timeEntriesInSeason);
	}
	
	
}
