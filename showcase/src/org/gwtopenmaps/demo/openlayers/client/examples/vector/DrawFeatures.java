package org.gwtopenmaps.demo.openlayers.client.examples.vector;

import org.gwtopenmaps.demo.openlayers.client.examples.MapExample;
import org.gwtopenmaps.demo.openlayers.client.examples.ShowcaseExample;
import org.gwtopenmaps.demo.openlayers.client.examples.raster.BasicWMS;
import org.gwtopenmaps.openlayers.client.Icon;
import org.gwtopenmaps.openlayers.client.LonLat;
import org.gwtopenmaps.openlayers.client.Pixel;
import org.gwtopenmaps.openlayers.client.Size;
import org.gwtopenmaps.openlayers.client.control.DrawFeature;
import org.gwtopenmaps.openlayers.client.control.DrawFeatureOptions;
import org.gwtopenmaps.openlayers.client.control.EditingToolbar;
import org.gwtopenmaps.openlayers.client.control.SelectFeature;
import org.gwtopenmaps.openlayers.client.control.SelectFeatureOptions;
import org.gwtopenmaps.openlayers.client.control.DrawFeature.FeatureAddedListener;
import org.gwtopenmaps.openlayers.client.feature.VectorFeature;
import org.gwtopenmaps.openlayers.client.format.KML;
import org.gwtopenmaps.openlayers.client.geometry.Geometry;
import org.gwtopenmaps.openlayers.client.geometry.LinearRing;
import org.gwtopenmaps.openlayers.client.handler.PolygonHandler;
import org.gwtopenmaps.openlayers.client.handler.RegularPolygonHandler;
import org.gwtopenmaps.openlayers.client.handler.RegularPolygonHandlerOptions;
import org.gwtopenmaps.openlayers.client.layer.Layer;
import org.gwtopenmaps.openlayers.client.layer.Vector;
import org.gwtopenmaps.openlayers.client.layer.WMS;
import org.gwtopenmaps.openlayers.client.layer.WMSParams;
import org.gwtopenmaps.openlayers.client.popup.AnchoredBubble;
import org.gwtopenmaps.openlayers.client.popup.Popup;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.DockPanel;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.ToggleButton;

public class DrawFeatures implements ShowcaseExample {

	private final MapExample example;

	private WMS wmsLayer;

	private final Vector vectorLayer = new Vector("Vector layer");
	private final Vector boxLayer = new Vector("Box Layer");

	private Popup popup;

	public DrawFeatures(){

		example = new MapExample();

		//Add a WMS layer for a little background
		WMSParams wmsParams = new WMSParams();
		wmsParams.setFormat("image/png");
		wmsParams.setLayers("basic");
		wmsParams.setStyles("");

		wmsLayer = new WMS(
				"Basic WMS",
				BasicWMS.WMS_URL,
				wmsParams);

		example.getMap().addLayers(new Layer[] {wmsLayer});

		double lon = 4.0;
		double lat = 5.0;
		int zoom = 5;
		example.getMap().setCenter(new LonLat(lon, lat), zoom);

		//Add vector layer and editing toolbar...
		example.getMap().addLayers(new Layer[] {this.vectorLayer});
		example.getMap().addControl(new EditingToolbar(vectorLayer));


		/*
		 * NOW FOR CUSTOM DRAW / SELECT BEHAVIOUR...
		 *
		 * The 'Draw Polygon' button activates DrawFeature control to draw polygon.
		 * When the polygon has been added the FeatureAdded event is fired to which the FeatureAddedListener responds.
		 *
		 * Similar to this the 'Draw Rectangle' draws a regular polygon.
		 *
		 * TODO: make button toggling smarter and foolproof
		 *
		 */

		FeatureAddedListener listener = new FeatureAddedListener(){
			public void onFeatureAdded(VectorFeature vf) {
				org.gwtopenmaps.openlayers.client.geometry.Polygon aoi =
					org.gwtopenmaps.openlayers.client.geometry.Polygon.narrowToPolygon(vf.getGeometry().getJSObject());
				LinearRing[] rings = aoi.getComponents();
				if(rings!=null){ rings[0].getComponents();}
				Geometry geo = vf.getGeometry();

				Window.alert("Feature of class " + geo.getClassName() +  " added with bounds " + geo.getBounds().toString());
			}
		};

		//Define controls
		DrawFeatureOptions drawPolygonFeatureOptions = new DrawFeatureOptions();
		drawPolygonFeatureOptions.onFeatureAdded(listener);
		final DrawFeature drawPolygon = new DrawFeature(vectorLayer, new PolygonHandler(), drawPolygonFeatureOptions);
		example.getMap().addControl(drawPolygon);

		DrawFeatureOptions drawRegularPolygonFeatureOptions = new DrawFeatureOptions();
		drawRegularPolygonFeatureOptions.onFeatureAdded(listener);
		RegularPolygonHandlerOptions regularPolygonHandlerOptions = new RegularPolygonHandlerOptions();
		regularPolygonHandlerOptions.setSides(4);
		regularPolygonHandlerOptions.setIrregular(true);
		drawRegularPolygonFeatureOptions.setHandlerOptions(regularPolygonHandlerOptions);
		final DrawFeature drawRegularPolygon = new DrawFeature(boxLayer, new RegularPolygonHandler(), drawRegularPolygonFeatureOptions);
		example.getMap().addControl(drawRegularPolygon);

		SelectFeatureOptions selectFeatureOptions = new SelectFeatureOptions();
		selectFeatureOptions.onSelect(new SelectFeature.SelectFeatureListener() {

			@Override
			public void onFeatureSelected(VectorFeature vectorFeature) {
				popup = new AnchoredBubble("info",
					new LonLat(0,0),
					new Size(100,100),
					"<p>" + new KML().write(vectorFeature) + "</p>",
					new Icon("", new Size(0,0), new Pixel(0,0)),
					true
				);
				example.getMap().addPopup(popup);
			}
		});
		final SelectFeature selectFeature = new SelectFeature(vectorLayer, selectFeatureOptions);
		example.getMap().addControl(selectFeature);

		//Define buttons
		final ToggleButton drawPolygonBtn = new ToggleButton("Draw Polygon");
		final ToggleButton drawRegularPolygonBtn = new ToggleButton("Draw Rectangle");
		final ToggleButton selectPolygonFeatureBtn = new ToggleButton("Select Polygon");
		final ToggleButton selectRegularPolygonFeatureBtn = new ToggleButton("Select Rectangle");

		//Add behaviour to buttons
		drawPolygonBtn.addClickHandler(new ClickHandler(){
			public void onClick(ClickEvent evt) {
				//TODO add isActivated method to Controls
				if(drawPolygonBtn.isDown()){
					if(drawRegularPolygonBtn.isDown()){
						drawRegularPolygonBtn.setDown(false);
					}
					if(selectPolygonFeatureBtn.isDown()){
						selectPolygonFeatureBtn.setDown(false);
					}
					if(selectRegularPolygonFeatureBtn.isDown()){
						selectRegularPolygonFeatureBtn.setDown(false);
					}
					drawPolygon.activate();
				} else {
					drawPolygon.deactivate();
				}
			}
		});

		drawRegularPolygonBtn.addClickHandler(new ClickHandler(){
			public void onClick(ClickEvent evt) {
				if ( drawRegularPolygonBtn.isDown() ) {
					if(drawPolygonBtn.isDown()){
						drawPolygonBtn.setDown(false);
					}
					if(selectPolygonFeatureBtn.isDown()){
						selectPolygonFeatureBtn.setDown(false);
					}
					if(selectRegularPolygonFeatureBtn.isDown()){
						selectRegularPolygonFeatureBtn.setDown(false);
					}
					drawRegularPolygon.activate();
				} else {
					drawRegularPolygon.deactivate();
				}
			}

		});

		selectPolygonFeatureBtn.addClickHandler(new ClickHandler(){
			public void onClick(ClickEvent event) {
				if(selectPolygonFeatureBtn.isDown()){
					if(drawPolygonBtn.isDown()){
						drawPolygonBtn.setDown(false);
					}
					if(drawRegularPolygonBtn.isDown()){
						drawRegularPolygonBtn.setDown(false);
					}
					if(selectRegularPolygonFeatureBtn.isDown()){
						selectRegularPolygonFeatureBtn.setDown(false);
					}
					selectFeature.activate();
				} else {
					selectFeature.deactivate();
				}
			}
		});


		selectRegularPolygonFeatureBtn.addClickHandler(new ClickHandler(){
			public void onClick(ClickEvent event) {
				if(selectRegularPolygonFeatureBtn.isDown()){
					if(drawPolygonBtn.isDown()){
						drawPolygonBtn.setDown(false);
					}
					if(drawRegularPolygonBtn.isDown()){
						drawRegularPolygonBtn.setDown(false);
					}
					if(selectPolygonFeatureBtn.isDown()){
						selectPolygonFeatureBtn.setDown(false);
					}
					//example.getMap()
				} else {
				}
			}
		});

		Grid buttons = new Grid(2, 2);
		buttons.setWidget(0, 0, drawPolygonBtn);
		buttons.setWidget(0, 1, drawRegularPolygonBtn);
		buttons.setWidget(1, 0, selectPolygonFeatureBtn);
		buttons.setWidget(1, 1, selectRegularPolygonFeatureBtn);
		example.add(buttons, DockPanel.SOUTH);
		example.getMap().addLayer(boxLayer);
	}

	public MapExample getMapExample() {
		return this.example;
	}


}
