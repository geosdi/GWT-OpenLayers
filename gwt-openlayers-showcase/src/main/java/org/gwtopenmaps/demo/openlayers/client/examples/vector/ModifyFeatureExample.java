package org.gwtopenmaps.demo.openlayers.client.examples.vector;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DockPanel;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.VerticalPanel;

import org.gwtopenmaps.demo.openlayers.client.examples.MapExample;
import org.gwtopenmaps.demo.openlayers.client.examples.ShowcaseExample;
import org.gwtopenmaps.openlayers.client.LonLat;
import org.gwtopenmaps.openlayers.client.Style;
import org.gwtopenmaps.openlayers.client.control.LayerSwitcher;
import org.gwtopenmaps.openlayers.client.control.ModifyFeature;
import org.gwtopenmaps.openlayers.client.control.MousePosition;
import org.gwtopenmaps.openlayers.client.control.NavToolbar;
import org.gwtopenmaps.openlayers.client.control.PanZoomBar;
import org.gwtopenmaps.openlayers.client.event.VectorFeatureModifiedListener;
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

public class ModifyFeatureExample implements ShowcaseExample {
	public static final String WMS_URL = "http://labs.metacarta.com/wms/vmap0";

	private MapExample example = new MapExample();

	private WMS wmsLayer;

	private VerticalPanel operationContents;

	private TextArea reportArea = new TextArea() {

		{
			this.setHeight("20em");
			this.setWidth("100%");
		}
	};

	private ModifyFeature modifyFeature;

	private int reportCount = 0;

	public ModifyFeatureExample() {
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
//		example.add(reportArea);
		this.createOperationContents();

	}

	private void createOperationContents() {
		operationContents = new VerticalPanel();
		operationContents.add(createModeButton("Resize", ModifyFeature.RESIZE));
		operationContents.add(createModeButton("Drag", ModifyFeature.DRAG));
		operationContents.add(createModeButton("Reshape", ModifyFeature.RESHAPE));
		operationContents.add(createModeButton("Rotate", ModifyFeature.ROTATE));

	}

	public VerticalPanel getOperationContents() {
		return operationContents;
	}

	public void setOperationContents(VerticalPanel operationContents) {
		this.operationContents = operationContents;
	}

	/**
	 * @param labelText
	 * @param mode
	 * @return
	 */
	private Button createModeButton(String labelText, final int mode) {
		Button button = new Button(labelText) {

			{
				this.addClickHandler(new ClickHandler() {
					public void onClick(ClickEvent evt) {
						modifyFeature.setMode(mode);
					}
				});

			}
		};

		return button;
	}

	public MapExample getMapExample() {
		return this.example;
	}

	private Style createStyle() {
		Style style = new Style();
		style.setStrokeColor("#000000");
		style.setStrokeWidth(1);
		style.setFillColor("#FF0000");
		style.setFillOpacity(0.5);
		style.setPointRadius(5);
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

		// create a polygon feature from a linear ring of points
		VectorFeature polygonFeature = createPolygon(point);

		layer.addFeature(polygonFeature);

		modifyFeature = createModifyFeature(layer);
		example.getMap().addControl(modifyFeature);
		modifyFeature.activate();

		layer.addVectorFeatureModifiedListener(new VectorFeatureModifiedListener() {
			public void onFeatureModified(FeatureModifiedEvent eventObject) {
				VectorFeature feature = eventObject.getVectorFeature();

				Polygon polygon = Polygon.narrowToPolygon(feature.getGeometry()
						.getJSObject());

				LinearRing linearRing = polygon.getComponents()[0];

				String message = "Total Vertexes: "
						+ linearRing.getNumberOfComponents();

				for (Point point : linearRing.getComponents()) {
					message += "\n(" + point.getX() + ";" + point.getY() + ") ";
				}

				report(feature, message);
			}
		});

		return layer;

	}

	private ModifyFeature createModifyFeature(Vector layer) {
		ModifyFeature modifyFeature = new ModifyFeature(layer);

		return modifyFeature;
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

	protected void report(VectorFeature vectorFeature, String message) {
		reportArea.setText(reportCount++ + ")" + vectorFeature.getFeatureId()
				+ " " + message + "\n\n");

	}
}
