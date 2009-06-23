package org.gwtopenmaps.demo.openlayers.client.examples.vector;

import org.gwtopenmaps.demo.openlayers.client.examples.MapExample;
import org.gwtopenmaps.demo.openlayers.client.examples.ShowcaseExample;
import org.gwtopenmaps.demo.openlayers.client.examples.raster.BasicWMS;
import org.gwtopenmaps.openlayers.client.LonLat;
import org.gwtopenmaps.openlayers.client.control.DrawFeature;
import org.gwtopenmaps.openlayers.client.control.DrawFeatureOptions;
import org.gwtopenmaps.openlayers.client.control.EditingToolbar;
import org.gwtopenmaps.openlayers.client.control.LayerSwitcher;
import org.gwtopenmaps.openlayers.client.control.DrawFeature.FeatureAddedListener;
import org.gwtopenmaps.openlayers.client.feature.VectorFeature;
import org.gwtopenmaps.openlayers.client.geometry.LinearRing;
import org.gwtopenmaps.openlayers.client.handler.PolygonHandler;
import org.gwtopenmaps.openlayers.client.layer.Layer;
import org.gwtopenmaps.openlayers.client.layer.Vector;
import org.gwtopenmaps.openlayers.client.layer.WMS;
import org.gwtopenmaps.openlayers.client.layer.WMSParams;
import org.gwtopenmaps.openlayers.client.util.JSObject;

import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.ClickListener;
import com.google.gwt.user.client.ui.DockPanel;
import com.google.gwt.user.client.ui.ToggleButton;
import com.google.gwt.user.client.ui.Widget;

public class DrawFeatures implements ShowcaseExample {

	private final MapExample example;

	private WMS wmsLayer;

	private final Vector vectorLayer = new Vector("Vector layer");

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
		//example.getMap().addControl(new NavToolBar());
		example.getMap().addControl(new LayerSwitcher());

		double lon = 4.0;
		double lat = 5.0;
		int zoom = 5;
		example.getMap().setCenter(new LonLat(lon, lat), zoom);

		//Now to draw vector features...
		//example.getMap().addControl(new EditingToolbar(vectorLayer));

		//Finally, add the vector layer to the map
		example.getMap().addLayers(new Layer[] {this.vectorLayer});

		//JSObject polygonHandler = Polygon.getJSClass();

		FeatureAddedListener listener = new FeatureAddedListener(){
			public void onFeatureAdded(VectorFeature vf) {
				org.gwtopenmaps.openlayers.client.geometry.Polygon aoi =
					org.gwtopenmaps.openlayers.client.geometry.Polygon.narrowToPolygon(vf.getGeometry());
				LinearRing[] rings = aoi.getComponents();
				if(rings!=null){ rings[0].getComponents();}
				Window.alert("Feature of class " + vf.getGeometryClassName() +  " added!");
			}
		};

		DrawFeatureOptions drawFeatureOptions = new DrawFeatureOptions();
		drawFeatureOptions.onFeatureAdded(listener);
		//Options options = new Options();
		//final DrawFeature drawPolygon = new DrawFeature(vectorLayer, polygonHandler, listener, options);
		final DrawFeature drawPolygon = new DrawFeature(vectorLayer, new PolygonHandler(), drawFeatureOptions);
		example.getMap().addControl(drawPolygon);

		final ToggleButton drawPolygonBtn = new ToggleButton("Draw Polygon (listener)");
		drawPolygonBtn.setWidth("200px");
		drawPolygonBtn.addClickListener(new ClickListener(){
			public void onClick(Widget sender) {
				//TODO je wilt aan een control kunnen vragen of hij geactiveerd is
				if(drawPolygonBtn.isDown()){
					drawPolygon.activate();
				} else {
					drawPolygon.deactivate();
				}
			}
		});
		example.add(drawPolygonBtn, DockPanel.SOUTH);
		example.getMap().addControl(new EditingToolbar(vectorLayer));
	}

	public MapExample getMapExample() {
		return this.example;
	}


}
