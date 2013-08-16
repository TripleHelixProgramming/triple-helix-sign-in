package org.team2363.signin.client.layout;

import java.util.Date;

import com.google.gwt.dom.client.Style;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.TabLayoutPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

/**
 * @author Michael Snider
 *
 */
public class MainTabLayout {

	private TabLayoutPanel tabLayoutPanel;
	private VerticalPanel timesheetPanel, usersPanel;
	
	private static final DateTimeFormat DayFormat = DateTimeFormat.getFormat("EEE, MMM d, yyyy");
	
	
	public MainTabLayout() {
		init();
	}
	
	
	
	
	private void init() {
		
		tabLayoutPanel = new TabLayoutPanel(45.0, Style.Unit.PX);
		tabLayoutPanel.addStyleName("tabLayoutPanel");
		
		
		
		timesheetPanel = new VerticalPanel();
		timesheetPanel.addStyleName("tabPanel");
		timesheetPanel.setTitle(DayFormat.format(new Date()));
		
		HorizontalPanel timesheetTitle = new HorizontalPanel();
		HTML content = new HTML("<h3>Today's Timesheet</h3>");
		content.addStyleName("fillWidth");
		timesheetTitle.add(content);
		timesheetPanel.add(timesheetTitle);
		
		tabLayoutPanel.add(timesheetPanel, timesheetPanel.getTitle());
		
		
		
		usersPanel = new VerticalPanel();
		usersPanel.addStyleName("tabPanel");
		usersPanel.setTitle("Users");
		
		HorizontalPanel usersTitle = new HorizontalPanel();
		content = new HTML("<h3>List of Users</h3>");
		content.addStyleName("fillWidth");
		usersTitle.add(content);
		usersPanel.add(usersTitle);
		
		tabLayoutPanel.add(usersPanel, usersPanel.getTitle());
		
	}
	
	
	/**
	 * @return The TabLayoutPanel
	 */
	public TabLayoutPanel getTabLayoutPanel() {
		return this.tabLayoutPanel;
	}

}
