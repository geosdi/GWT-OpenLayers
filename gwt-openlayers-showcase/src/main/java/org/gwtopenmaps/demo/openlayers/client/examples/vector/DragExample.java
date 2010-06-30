package org.gwtopenmaps.demo.openlayers.client.examples.vector;

import org.gwtopenmaps.demo.openlayers.client.examples.MapExample;
import org.gwtopenmaps.demo.openlayers.client.examples.ShowcaseExample;
import org.gwtopenmaps.openlayers.client.LonLat;
import org.gwtopenmaps.openlayers.client.Pixel;
import org.gwtopenmaps.openlayers.client.Style;
import org.gwtopenmaps.openlayers.client.control.DragFeature;
import org.gwtopenmaps.openlayers.client.control.DragFeatureOptions;
import org.gwtopenmaps.openlayers.client.control.LayerSwitcher;
import org.gwtopenmaps.openlayers.client.control.MousePosition;
import org.gwtopenmaps.openlayers.client.control.NavToolbar;
import org.gwtopenmaps.openlayers.client.control.PanZoomBar;
import org.gwtopenmaps.openlayers.client.control.DragFeature.DragFeatureListener;
import org.gwtopenmaps.openlayers.client.feature.VectorFeature;
import org.gwtopenmaps.openlayers.client.geometry.LinearRing;
import org.gwtopenmaps.openlayers.client.geometry.Point;
import org.gwtopenmaps.openlayers.client.geometry.Polygon;
import org.gwtopenmaps.openlayers.client.layer.Layer;
import org.gwtopenmaps.openlayers.client.layer.TransitionEffect;
import org.gwtopenmaps.openlayers.client.layer.Vector;
import org.gwtopenmaps.openlayers.client.layer.VectorOptions;
import org.gwtopenmaps.openlayers.client.layer.WMS;
import org.gwtopenmaps.openlayers.client.layer.WMSOptions;
import org.gwtopenmaps.openlayers.client.layer.WMSParams;

import com.google.gwt.user.client.ui.DockPanel;
import com.google.gwt.user.client.ui.TextArea;

public class DragExample implements ShowcaseExample {

    private MapExample example;

    private WMS wmsLayer;

    public static final String WMS_URL = "http://labs.metacarta.com/wms/vmap0";

    private TextArea reportArea = new TextArea() {
	{
	    this.setHeight("20em");
	}
    };

    public DragExample() {

	example = new MapExample();

	// Defining a WMSLayer and adding it to a Map
	WMSParams wmsParams = new WMSParams();
	wmsParams.setFormat("image/png");
	wmsParams.setLayers("basic");
	wmsParams.setStyles("");

	WMSOptions wmsLayerParams = new WMSOptions();
	wmsLayerParams.setUntiled();
	wmsLayerParams.setTransitionEffect(TransitionEffect.RESIZE);

	wmsLayer = new WMS("Basic WMS", WMS_URL, wmsParams, wmsLayerParams);

	example.getMap().addLayers(new Layer[] { wmsLayer });

	// Adding controls to the Map
	example.getMap().addControl(new PanZoomBar());
	// use NavToolbar instead of deprecated MouseToolbar
	example.getMap().addControl(new NavToolbar());
	example.getMap().addControl(new MousePosition());
	example.getMap().addControl(new LayerSwitcher());

	// Center and Zoom
	example.getMap().setCenter(new LonLat(-111.04, 45.68), 4);

	example.getMap().addLayer(createLayer());

	example.add(reportArea, DockPanel.EAST);

    }

    public MapExample getMapExample() {
	return this.example;
    }

    private Style createStyle() {
	Style style = new Style();
	style.setStrokeColor("#000000");
	style.setStrokeWidth(3);
	style.setFillColor("#FF0000");
	style.setFillOpacity(0.5);
	style.setPointRadius(10);
	style.setStrokeOpacity(1.0);
	return style;

    }

    private Layer createLayer() {
	// Create the vectorOptions
	VectorOptions vectorOptions = new VectorOptions();
	vectorOptions.setStyle(createStyle());

	// Create the layer
	Vector layer = new Vector("Vector Layer", vectorOptions);

	// create a point feature
	Point point = new Point(-111.04, 45.68);
	VectorFeature pointFeature = new VectorFeature(point);

	// create a polygon feature from a linear ring of points
	VectorFeature polygonFeature = createPolygon(point);

	layer.addFeature(polygonFeature);
	layer.addFeature(pointFeature);

	DragFeature dragFeature = createDragFeature(layer);
	example.getMap().addControl(dragFeature);
	dragFeature.activate();

	return layer;

    }

    private DragFeature createDragFeature(Vector layer) {
	DragFeatureOptions dragFeatureOptions = new DragFeatureOptions();
	dragFeatureOptions.onDrag(createDragFeatureListener("onDrag"));
	dragFeatureOptions.onStart(createDragFeatureListener("onStart"));
	dragFeatureOptions.onComplete(createDragFeatureListener("onComplete"));

	DragFeature dragFeature = new DragFeature(layer, dragFeatureOptions);
	return dragFeature;
    }

    private DragFeatureListener createDragFeatureListener(final String type) {
	return new DragFeatureListener() {

	    @Override
	    public void onDragEvent(VectorFeature vectorFeature, Pixel pixel) {
		report(vectorFeature, type, pixel);

	    }
	};
    }

    private VectorFeature createPolygon(Point point) {
	Point[] pointList = new Point[7];
	for (int p = 0; p < 6; ++p) {
	    double a = p * (2 * Math.PI) / 7;
	    double r = 3;
	    Point newPoint = new Point(point.getX() + 5 + (r * Math.cos(a)),
		    point.getY() + 5 + (r * Math.sin(a)));
	    pointList[p] = newPoint;
	}
	pointList[6] = pointList[0];

	LinearRing linearRing = new LinearRing(pointList);
	VectorFeature polygonFeature = new VectorFeature(new Polygon(
		new LinearRing[] { linearRing }));
	return polygonFeature;

    }

    protected void report(VectorFeature vectorFeature, String message,
	    Pixel pixel) {
	reportArea.setText(vectorFeature.getFeatureId() + " " + message
		+ " (X;Y)=(" + pixel.x() + ";" + pixel.y() + ")\n\n");

    }

}
