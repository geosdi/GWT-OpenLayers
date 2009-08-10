package org.gwtopenmaps.demo.openlayers.client.examples.vector;

import org.gwtopenmaps.demo.openlayers.client.examples.MapExample;
import org.gwtopenmaps.demo.openlayers.client.examples.ShowcaseExample;
import org.gwtopenmaps.demo.openlayers.client.examples.raster.BasicWMS;
import org.gwtopenmaps.openlayers.client.LonLat;
import org.gwtopenmaps.openlayers.client.Style;
import org.gwtopenmaps.openlayers.client.control.LayerSwitcher;
import org.gwtopenmaps.openlayers.client.control.NavToolBar;
import org.gwtopenmaps.openlayers.client.feature.VectorFeature;
import org.gwtopenmaps.openlayers.client.format.WKT;
import org.gwtopenmaps.openlayers.client.geometry.LineString;
import org.gwtopenmaps.openlayers.client.geometry.LinearRing;
import org.gwtopenmaps.openlayers.client.geometry.Point;
import org.gwtopenmaps.openlayers.client.geometry.Polygon;
import org.gwtopenmaps.openlayers.client.layer.Layer;
import org.gwtopenmaps.openlayers.client.layer.Vector;
import org.gwtopenmaps.openlayers.client.layer.WMS;
import org.gwtopenmaps.openlayers.client.layer.WMSParams;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DockPanel;
import com.google.gwt.user.client.ui.TextArea;

public class BasicDrawFeatures implements ShowcaseExample {

    private MapExample example;

    private WMS wmsLayer;

    private final Vector vectorLayer = new Vector("Vector layer");

    private TextArea eventMessageArea;

    public BasicDrawFeatures(){

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
        example.getMap().addControl(new NavToolBar());
        example.getMap().addControl(new LayerSwitcher());

        double lon = 4.0;
        double lat = 5.0;
        int zoom = 5;
        example.getMap().setCenter(new LonLat(lon, lat), zoom);

        //Now draw some vector features...
        //TODO: first unstyled, then styled
        //Let's start with a point feature
        Point point = new Point(lon, lat);
        Style pointStyle = new Style();
        pointStyle.setFillColor("green");
        pointStyle.setStrokeColor("blue");
        VectorFeature pointFeature = new VectorFeature(point, pointStyle);
        vectorLayer.addFeature(pointFeature);

/*        Point point2 = new Point(4.0, 6.0);
        VectorFeature pointFeature2 = new VectorFeature(point2);
        vectorLayer.addFeature(pointFeature2);
*/        //Secondly, a line feature

        Point[] linePoints = {new Point(2.5, 4.0), new Point(4.0, 2.5)};
        LineString line = new LineString(linePoints);
        VectorFeature lineFeature = new VectorFeature(line);
        vectorLayer.addFeature(lineFeature);

        //Thirdly, a polygon feature
        Point[] pointArray = {new Point(4.5,5.5),
                new Point(4.5, 6.5),
                new Point(5.5, 6.5)

                };
        LinearRing linearRing = new LinearRing(pointArray);
        LinearRing[] linearRingArray = {linearRing};
        Polygon polygon = new Polygon(linearRingArray);
        Style polygonStyle = new Style();
        polygonStyle.setFillColor("red");
        polygonStyle.setStrokeColor("red");
        VectorFeature polygonFeature = new VectorFeature(polygon, polygonStyle);
        vectorLayer.addFeature(polygonFeature);

        //Finally, add the vector layer to the map
        example.getMap().addLayers(new Layer[] {this.vectorLayer});

        eventMessageArea = new TextArea();
        eventMessageArea.setText(" Feature info\n----------");
        eventMessageArea.setHeight("20em");
        //TODO this exposes that example is a DockPanel


        Button featureInfo = new Button("Feature info");
        featureInfo.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent evt) {
              VectorFeature[] fts = vectorLayer.getFeatures();
              int x = vectorLayer.getNumberOfFeatures();
              //normally you would have to check the class name
              Point p = Point.narrowToPoint(fts[0].getGeometry());
              LineString l = LineString.narrowToLineString(fts[1].getGeometry());
              Polygon pg = Polygon.narrowToPolygon(fts[2].getGeometry());
              LinearRing r = LinearRing.narrowToLinearRing(pg.getComponent(0));
              double[][] lcoord = l.getCoordinateArray();
              WKT wktFormat = new WKT();
              String wkt = wktFormat.write(fts);
              eventMessageArea.setText(wkt);
              Window.alert("Number of features: " + x + "\n"
                      + "Geometry class f1: " + fts[0].getGeometryClassName() + "\n"
                      + "Geometry class f2: " + fts[1].getGeometryClassName() + "\n"
                      + "Geometry class f3: " + fts[2].getGeometryClassName() + "\n"
                      + "Geometry coordinates f1: " + p.getX() + ", " + p.getY() + "\n"
                      + "Number of components f2: " + l.getNumberOfComponents() + "\n"
                      + "Geometry coordinates f2 - component 1: " + lcoord[0][0]+ ", " + lcoord[0][1] + "\n"
                      + "Number of components f3: " + pg.getNumberOfComponents() + "\n"
                      + "Number of subcomponents f3: " + r.getNumberOfComponents() + "\n");

            }
          });

        example.add(featureInfo, DockPanel.SOUTH);
        example.add(eventMessageArea, DockPanel.EAST);
    }

    public MapExample getMapExample() {
        return this.example;
    }


}
