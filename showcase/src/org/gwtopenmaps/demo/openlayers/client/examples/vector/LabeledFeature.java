package org.gwtopenmaps.demo.openlayers.client.examples.vector;

import org.gwtopenmaps.demo.openlayers.client.examples.MapExample;
import org.gwtopenmaps.demo.openlayers.client.examples.ShowcaseExample;
import org.gwtopenmaps.openlayers.client.LonLat;
import org.gwtopenmaps.openlayers.client.Style;
import org.gwtopenmaps.openlayers.client.StyleMap;
import org.gwtopenmaps.openlayers.client.control.LayerSwitcher;
import org.gwtopenmaps.openlayers.client.control.MousePosition;
import org.gwtopenmaps.openlayers.client.control.NavToolBar;
import org.gwtopenmaps.openlayers.client.control.PanZoomBar;
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
import org.gwtopenmaps.openlayers.client.util.Attributes;

public class LabeledFeature implements ShowcaseExample {

    private MapExample example;

    private WMS wmsLayer;

    private Vector labeledLayer;

    private Vector labeledLayerPicture;

    public static final String WMS_URL = "http://labs.metacarta.com/wms/vmap0";

    public LabeledFeature() {

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
	example.getMap().addControl(new NavToolBar());
	example.getMap().addControl(new MousePosition());
	example.getMap().addControl(new LayerSwitcher());

	// Center and Zoom
	example.getMap().setCenter(new LonLat(-111.04, 45.68), 3);

	createLabelLayer();

    }

    public MapExample getMapExample() {
	return this.example;
    }

    private void createLabelLayer() {
	Style styleVector = new Style();
	styleVector.setStrokeColor("#00FF00");
	styleVector.setStrokeWidth(3);
	styleVector.setFillColor("#FF5500");
	styleVector.setFillOpacity(0.5);
	styleVector.setPointRadius(6);
	styleVector.setStrokeOpacity(1.0);
	styleVector.setLabel("name: ${name}, age: ${age}");
	styleVector.setFontColor("${favColor}");
	styleVector.setFontSize("12px");
	styleVector.setFontFamily("Courier New, monospace");
	styleVector.setFontWeight("bold");
	styleVector.setLabelAlign("${align}");

	Style stylePicture = new Style();
	stylePicture.setFillOpacity(1);
	stylePicture.setExternalGraphic("${picture}");
	stylePicture.setGraphicSize(64, 35);
	stylePicture.setPointRadius(6);
	stylePicture.setGraphicOffset(-32, -30);
	stylePicture.setLabel("${plate}");
	stylePicture.setFontColor("${favColor}");
	stylePicture.setFontSize("12px");
	stylePicture.setFontFamily("Courier New, monospace");
	stylePicture.setFontWeight("bold");

	stylePicture.setLabelAlign("cb");

	// Needs to use StyleMap because when using VectorFeatureAttributes to
	// replace the keys of styles (like ${name}),
	// they only apply to styles inside a StyleMaps.
	StyleMap styleMapVector = new StyleMap(styleVector);
	StyleMap styleMapPicture = new StyleMap(stylePicture);

	VectorOptions vectorOptions = new VectorOptions();
	vectorOptions.setStyleMap(styleMapVector);

	VectorOptions vectorOptionsPicture = new VectorOptions();
	vectorOptionsPicture.setStyleMap(styleMapPicture);

	labeledLayer = new Vector("Labels", vectorOptions);
	labeledLayerPicture = new Vector("Labels Picture", vectorOptionsPicture);

	example.getMap().addLayer(labeledLayerPicture);
	example.getMap().addLayer(labeledLayer);

	// create a point feature
	Point point = new Point(-111.04, 45.68);
	VectorFeature pointFeature = new VectorFeature(point);
	pointFeature.setAttributes(new Attributes() {
	    {
		this.setAttribute("name", "toto");
		this.setAttribute("age", 20);
		this.setAttribute("favColor", "red");
		this.setAttribute("align", "cb");
	    }
	});

	// create a polygon feature from a linear ring of points
	Point[] pointList = new Point[7];
	for (int p = 0; p < 6; ++p) {
	    double a = p * (2 * Math.PI) / 7;
	    double r = Math.random() + 1;
	    Point newPoint = new Point(point.getX() + 5 + (r * Math.cos(a)),
		    point.getY() + 5 + (r * Math.sin(a)));
	    pointList[p] = newPoint;
	}
	pointList[6] = pointList[0];

	LinearRing linearRing = new LinearRing(pointList);
	VectorFeature polygonFeature = new VectorFeature(new Polygon(
		new LinearRing[] { linearRing }));
	polygonFeature.setAttributes(new Attributes() {
	    {
		this.setAttribute("name", "dude");
		this.setAttribute("age", 21);
		this.setAttribute("favColor", "purple");
		this.setAttribute("align", "lb");

	    }
	});

	// create a image feature
	VectorFeature imageFeatureRedCar = new VectorFeature(new Point(point
		.getX() + 5, point.getY() - 10));
	imageFeatureRedCar.setAttributes(new Attributes() {
	    {
		this.setAttribute("plate", "XYZ-1234");
		this.setAttribute("favColor", "red");
		this.setAttribute("picture", "redcar.png");
	    }
	});

	VectorFeature imageFeatureBlueCar = new VectorFeature(new Point(point
		.getX() - 5, point.getY() + 10));
	imageFeatureBlueCar.setAttributes(new Attributes() {
	    {
		this.setAttribute("plate", "ABC-9876");
		this.setAttribute("favColor", "blue");
		this.setAttribute("picture", "bluecar.png");
	    }
	});

	// create a multiple feature
	// TODO: add example using Collection when collection is full suported
	// by gwt-openlayers
	/*
	 * Collection collection = new Collection(){}; VectorFeature
	 * multiFeature = new VectorFeature( new Collection([ new
	 * OpenLayers.Geometry.LineString([ new
	 * OpenLayers.Geometry.Point(-105,40), new
	 * OpenLayers.Geometry.Point(-95,45) ]), new
	 * OpenLayers.Geometry.Point(-105, 40) ]), { name: "ball-and-chain",
	 * age: 30, favColor: 'black', align: 'rt' }); var nullFeature = new
	 * OpenLayers.Feature.Vector(null); nullFeature.attributes = { name:
	 * "toto is some text about the world", age: 20, favColor: 'red', align:
	 * "cm" };
	 */

	labeledLayer.addFeature(polygonFeature);
	labeledLayer.addFeature(pointFeature);
	labeledLayerPicture.addFeature(imageFeatureRedCar);
	labeledLayerPicture.addFeature(imageFeatureBlueCar);

    }

}
