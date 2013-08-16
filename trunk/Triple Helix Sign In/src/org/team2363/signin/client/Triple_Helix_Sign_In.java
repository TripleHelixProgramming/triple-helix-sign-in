package org.team2363.signin.client;

import org.team2363.signin.client.layout.MainTabLayout;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.google.gwt.user.client.ui.RootPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class Triple_Helix_Sign_In implements EntryPoint {
	
	private MainTabLayout mainTabLayout;
	
	
	
	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {
		
		RootPanel.get().add(new HTML("<h1>Triple Helix - Sign In</h1>"));
		
		mainTabLayout = new MainTabLayout();
		RootLayoutPanel.get().add(mainTabLayout.getTabLayoutPanel());
		
	}
}
