package org.gwtopenmaps.demo.openlayers.client;

import org.gwtopenmaps.demo.openlayers.client.widget.ContentPanel;
import org.gwtopenmaps.demo.openlayers.client.widget.MenuPanel;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.DockPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.SimplePanel;

/**
 * Entry point for GWT OpenLayers showcase.
 */
public class GwtOpenLayersShowcase implements EntryPoint {

	/**
	 * main panel contains the showcase app
	 */
	//TODO borrow idea from gwtip calculator to make OpenLayerShowcaseApp
	// that extends Dockpanel
	private DockPanel mainPanel = new DockPanel();

	/**
	 *
	 */

	private SimplePanel bannerPanel = new SimplePanel();

	private ContentPanel contentPanel = new ContentPanel();

	private MenuPanel menuPanel = new MenuPanel(contentPanel);

	//private ContentPanel examplePanel = new ContentPanel();




	/**
	 * Entry point for the GWT OpenLayers Showcase
	 */
	public void onModuleLoad() {

		HTML tempBanner = new HTML("Welcome to the GWT OpenLayers showcase.");
		bannerPanel.add(tempBanner);


		//TODO menuPanel gets passed a ShowcaseMenu widget
		// the ShowcaseMenu widget gets passed a reference to the contentPanel

		menuPanel.setTitle("Menu");
		menuPanel.setWidth("200px");


		contentPanel.setTitle("Example");

		mainPanel.add(bannerPanel, DockPanel.NORTH);
		mainPanel.add(menuPanel, DockPanel.WEST);
		mainPanel.add(contentPanel, DockPanel.CENTER);
		RootPanel.get().add(mainPanel);
	}
}
