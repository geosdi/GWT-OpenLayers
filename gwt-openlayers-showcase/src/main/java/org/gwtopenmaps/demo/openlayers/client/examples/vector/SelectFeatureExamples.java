package org.gwtopenmaps.demo.openlayers.client.examples.vector;

import com.google.gwt.user.client.ui.DockPanel;
import com.google.gwt.user.client.ui.TextArea;

import org.gwtopenmaps.demo.openlayers.client.examples.MapExample;
import org.gwtopenmaps.demo.openlayers.client.examples.ShowcaseExample;
import org.gwtopenmaps.openlayers.client.LonLat;
import org.gwtopenmaps.openlayers.client.RenderIntent;
import org.gwtopenmaps.openlayers.client.Style;
import org.gwtopenmaps.openlayers.client.StyleMap;
import org.gwtopenmaps.openlayers.client.control.LayerSwitcher;
import org.gwtopenmaps.openlayers.client.control.MousePosition;
import org.gwtopenmaps.openlayers.client.control.NavToolbar;
import org.gwtopenmaps.openlayers.client.control.PanZoomBar;
import org.gwtopenmaps.openlayers.client.control.SelectFeature;
import org.gwtopenmaps.openlayers.client.control.SelectFeature.SelectFeatureListener;
import org.gwtopenmaps.openlayers.client.control.SelectFeature.UnselectFeatureListener;
import org.gwtopenmaps.openlayers.client.control.SelectFeatureOptions;
import org.gwtopenmaps.openlayers.client.event.BeforeFeatureHighlightedListener;
import org.gwtopenmaps.openlayers.client.event.FeatureHighlightedListener;
import org.gwtopenmaps.openlayers.client.event.FeatureUnhighlightedListener;
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


public class SelectFeatureExamples implements ShowcaseExample
{
    public static final String WMS_URL = "http://labs.metacarta.com/wms/vmap0";

    private MapExample example;

    private WMS wmsLayer;

    private TextArea reportArea = new TextArea()
        {

            {
                this.setHeight("20em");
            }
        };

    public SelectFeatureExamples()
    {
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
        example.getMap().setCenter(new LonLat(-111.04, 45.68), 3);

        example.getMap().addLayer(createLayer());

        example.add(reportArea, DockPanel.EAST);

    }

    public MapExample getMapExample()
    {
        return this.example;
    }

    private Style createStyle(String fillColor)
    {
        Style style = new Style();
        style.setStrokeColor("#000000");
        style.setStrokeWidth(3);
        style.setFillColor(fillColor);
        style.setFillOpacity(0.5);
        style.setPointRadius(10);
        style.setStrokeOpacity(1.0);

        return style;

    }

    private Layer createLayer()
    {
        // Create the style for each purpose
        Style styleNormal = createStyle("#FF0000");
        Style styleSelected = createStyle("#00FF00");
        Style styleHighlighted = createStyle("#0000FF");

        // Create the StyleMap to handle all styles
        StyleMap styleMapVector = new StyleMap(styleNormal, styleSelected,
                styleHighlighted);

        // Create the vectorOptions to use the styles
        VectorOptions vectorOptions = new VectorOptions();
        vectorOptions.setStyleMap(styleMapVector);

        Vector layer = new Vector("SelectFeature Layer", vectorOptions);

        // create a point feature
        Point point = new Point(-111.04, 45.68);
        VectorFeature pointFeature = new VectorFeature(point);

        // create a polygon feature from a linear ring of points
        Point[] pointList = new Point[7];

        for (int p = 0; p < 6; ++p)
        {
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

        layer.addFeature(polygonFeature);
        layer.addFeature(pointFeature);

        SelectFeature selectFeatureHover = new SelectFeature(layer,
                createSelectFeatureOptions(true));

        // Add Before Feature Highlighted event

        selectFeatureHover.addBeforeFeatureHighlightedListener(new BeforeFeatureHighlightedListener()
            {
                public void onBeforeFeatureHighlighted(
                    VectorFeature eventObject)
                {
                    report(eventObject, "Before Highlighted");

                }
            });

        selectFeatureHover.addFeatureHighlightedListener(new FeatureHighlightedListener()
            {
                public void onFeatureHighlighted(VectorFeature eventObject)
                {
                    report(eventObject, "Feature Highlighted");

                }
            });

        selectFeatureHover.addFeatureUnhighlightedListener(new FeatureUnhighlightedListener()
            {
                public void onFeatureUnhighlighted(VectorFeature eventObject)
                {
                    report(eventObject, "Feature Unhighlighted");

                }
            });

        SelectFeature selectFeatureClick = new SelectFeature(layer,
                createSelectFeatureOptions(false));

        example.getMap().addControl(selectFeatureClick);
        example.getMap().addControl(selectFeatureHover);

        selectFeatureHover.activate();
        selectFeatureClick.activate();

        return layer;

    }

    private SelectFeatureOptions createSelectFeatureOptions(boolean isHover)
    {
        // Create the SelectFeature and its Options
        SelectFeatureOptions selectFeatureOptions = new SelectFeatureOptions();

        if (isHover == true)
        {
            selectFeatureOptions.setHover();
            selectFeatureOptions.setHighlightOnly(true);
            selectFeatureOptions.setRenderIntent(RenderIntent.TEMPORARY);
        }

        // Add Select event
        selectFeatureOptions.onSelect(new SelectFeatureListener()
            {
                public void onFeatureSelected(VectorFeature vectorFeature)
                {
                    report(vectorFeature, "Selected");

                }
            });

        // Add Unselect event
        selectFeatureOptions.onUnSelect(new UnselectFeatureListener()
            {
                public void onFeatureUnselected(VectorFeature vectorFeature)
                {
                    report(vectorFeature, "UnSelected");

                }
            });

        return selectFeatureOptions;
    }

    protected void report(VectorFeature vectorFeature, String message)
    {
        reportArea.setText(reportArea.getText() + vectorFeature.getFeatureId() +
            " " + message + "\n\n");

    }

}
