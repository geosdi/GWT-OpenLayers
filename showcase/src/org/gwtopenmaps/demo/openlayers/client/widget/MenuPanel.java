package org.gwtopenmaps.demo.openlayers.client.widget;



import org.gwtopenmaps.demo.openlayers.client.examples.control.CustomMousePosition;
import org.gwtopenmaps.demo.openlayers.client.examples.events.MapEvents;
import org.gwtopenmaps.demo.openlayers.client.examples.raster.BasicWMS;
import org.gwtopenmaps.demo.openlayers.client.examples.vector.BasicDrawFeatures;
import org.gwtopenmaps.demo.openlayers.client.examples.vector.DrawFeatures;

import com.google.gwt.user.client.ui.ClickListener;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.Widget;

public class MenuPanel extends FlexTable {

	private int menuItemCount = 0;

	public MenuPanel(final ContentPanel contentPanel){


		// ===== SET DEFAULT EXAMPLE =====
/*        BasicWMS basicWms = new BasicWMS();
		contentPanel.setExample(basicWms.getMapExample());*/

/*        BasicDrawFeatures basicDrawFeatures = new BasicDrawFeatures();
		contentPanel.setExample(basicDrawFeatures.getMapExample());*/

		DrawFeatures drawFeatures = new DrawFeatures();
		contentPanel.setExample(drawFeatures.getMapExample());

		// ===== ADD MENU ITEMS =====
		ShowcaseMenuItem basicWMSItem = new ShowcaseMenuItem("Basic WMS",  "A simple map with a WMS Layer.");
		ShowcaseMenuItem vectorFeaturesItem = new ShowcaseMenuItem("Vector Features",  "Create vector features programmatically.");
		ShowcaseMenuItem drawFeaturesItem = new ShowcaseMenuItem("Draw Features",  "Draw vector features by hand.");
		ShowcaseMenuItem mapEventsItem = new ShowcaseMenuItem("Map Events", "Map event handlers.");
		ShowcaseMenuItem mpOutputItem = new ShowcaseMenuItem("MousePosition", "MousePosition custom output.");

		addMenuItem(basicWMSItem);
		addMenuItem(vectorFeaturesItem);
		addMenuItem(drawFeaturesItem);
		addMenuItem(mapEventsItem);
		addMenuItem(mpOutputItem);

		//this.setWidget(getMenuItemCount() + getMenuItemCount(), 0, menuItem4Link);
		//this.setWidget(getMenuItemCount() + getMenuItemCount() + 1, 0, menuItem4Desc);


		//TODO Refactor so clicklistener is set when instantiating menu item
		basicWMSItem.getLabel().addClickListener(new ClickListener(){

			public void onClick(Widget sender) {
				BasicWMS basicWms = new BasicWMS();
				contentPanel.setExample(basicWms.getMapExample());
			}
		});

		vectorFeaturesItem.getLabel().addClickListener(new ClickListener(){

			public void onClick(Widget sender) {
				BasicDrawFeatures basicDrawFeatures = new BasicDrawFeatures();
				contentPanel.setExample(basicDrawFeatures.getMapExample());
			}

		});

		drawFeaturesItem.getLabel().addClickListener(new ClickListener(){

			public void onClick(Widget sender) {
				DrawFeatures drawFeatures = new DrawFeatures();
				contentPanel.setExample(drawFeatures.getMapExample());
			}

		});

		//ShowcaseMenuItem should be passed a showcaseExample
		//  and add the listener
		//  however, it is a bit dirty to pass contentPanel ref to menuItem
		//  what is an easy way to implement a controller?
		mapEventsItem.getLabel().addClickListener(new ClickListener(){

			public void onClick(Widget sender) {
				MapEvents mapEvents = new MapEvents();
				contentPanel.setExample(mapEvents.getMapExample());
			}

		});

		mpOutputItem.getLabel().addClickListener(new ClickListener(){

			public void onClick(Widget sender) {
				CustomMousePosition mpOutput = new CustomMousePosition();
				contentPanel.setExample(mpOutput.getMapExample());
			}

		});

	}

	private void addMenuItem(ShowcaseMenuItem item){
		this.setWidget(getMenuItemCount() + getMenuItemCount() , 0, item.getLabel());
		this.setWidget(getMenuItemCount() + getMenuItemCount() + 1, 0, item.getShortDescription());
		incrementMenuItemCount();
	}

	private int getMenuItemCount(){
		return this.menuItemCount;
	}

	private void incrementMenuItemCount(){
		this.menuItemCount++;
	}
}
