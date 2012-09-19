package org.gwtopenmaps.demo.openlayers.client;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.gwtopenmaps.demo.openlayers.client.examples.TransformFeature.TransformFeatureExample;
import org.gwtopenmaps.demo.openlayers.client.examples.basicbing.BasicBingExample;
import org.gwtopenmaps.demo.openlayers.client.examples.basicgooglev3.BasicGoogleV3Example;
import org.gwtopenmaps.demo.openlayers.client.examples.basicosm.BasicOsmExample;
import org.gwtopenmaps.demo.openlayers.client.examples.basictms.BasicTmsExample;
import org.gwtopenmaps.demo.openlayers.client.examples.canceldrawing.CancelDrawingExample;
import org.gwtopenmaps.demo.openlayers.client.examples.custommouseposition.CustomMousePositionExample;
import org.gwtopenmaps.demo.openlayers.client.examples.graticule.GraticuleExample;
import org.gwtopenmaps.demo.openlayers.client.examples.linestring2multilinestring.LineString2MultiLineStringExample;
import org.gwtopenmaps.demo.openlayers.client.examples.location.LocationExample;
import org.gwtopenmaps.demo.openlayers.client.examples.measure.MeasureExample;
import org.gwtopenmaps.demo.openlayers.client.examples.refresh.WfsRefreshExample;
import org.gwtopenmaps.demo.openlayers.client.examples.rotatevector.RotateVectorExample;
import org.gwtopenmaps.demo.openlayers.client.examples.selectfeature.SelectFeatureExample;
import org.gwtopenmaps.demo.openlayers.client.examples.snap.SnapFeatureExample;
import org.gwtopenmaps.demo.openlayers.client.examples.undoredodrawing.UndoRedoDrawingExample;
import org.gwtopenmaps.demo.openlayers.client.examples.vector.VectorExample;
import org.gwtopenmaps.demo.openlayers.client.examples.wmsfeatureinfo.WmsFeatureInfoExample;
import org.gwtopenmaps.demo.openlayers.client.examples.wmsrefresh.WmsRefreshExample;
import org.gwtopenmaps.demo.openlayers.client.examples.wmswfs.WmsWfsExample;
import org.gwtopenmaps.demo.openlayers.client.examples.wmswfsedit.WmsWfsEditExample;
import org.gwtopenmaps.demo.openlayers.client.i18n.I18NMessages;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.BlurEvent;
import com.google.gwt.event.dom.client.BlurHandler;
import com.google.gwt.event.dom.client.FocusEvent;
import com.google.gwt.event.dom.client.FocusHandler;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;

/**
 * Entry point for GWT OpenLayers showcase.
 */
public class GwtOpenLayersShowcase implements EntryPoint, FocusHandler,
        BlurHandler, KeyUpHandler {

    public static final I18NMessages I18N = (I18NMessages) GWT.create(
            I18NMessages.class);
    private final TextBox txtSearch = new TextBox();
    private final Label lblNumberOfExamples = new Label("(0)");
    private final FlowPanel examplesPanel = new FlowPanel();
    private final List<ExampleBean> examples = new ArrayList<ExampleBean>();

    /**
     * main panel contains the showcase app
     */
    /**
     * Entry point for the GWT OpenLayers Showcase
     */
    public void onModuleLoad() {
        loadExamples();
        if (Window.Location.getParameter("example") != null) {
            for (ExampleBean example : examples) {
                if (example.getName().equals(Window.Location.getParameter(
                        "example"))) {
                    example.getExample().buildPanel();
                    RootPanel.get().add(example.getExample());
                }
            }
        } else {
            buildTopPanel();
            buildExamplePanels("");
        }
    }

    /**
     * Reads in all the examples.
     */
    private void loadExamples() {
        String name = "";

        name = "Basic OSM example";
        examples.add(new ExampleBean(name, "Show a simple OSM map.",
                                     new String[]{"openstreetmap", "OSM", "basic"},
                                     new BasicOsmExample(name)));

        name = "Basic Bing example";
        examples.add(
                new ExampleBean(name, "Demonstrates the use of Bing layers.",
                                new String[]{"Bing", "Microsoft", "Virtual Earth", "basic"},
                                new BasicBingExample(name)));

        name = "Basic Google V3 example";
        examples.add(
                new ExampleBean(name,
                                "Demonstrates the use of Google V3 layers.",
                                new String[]{"Google", "V3", "basic"},
                                new BasicGoogleV3Example(name)));

        name = "WMS with WFS overlay";
        examples.add(
                new ExampleBean(name,
                                "Demonstrates the use of WMS base layer with a WFS overlay.",
                                new String[]{"WMS", "WFS", "overlay"},
                                new WmsWfsExample(name)));

        name = "WMS with an editable WFS overlay";
        examples.add(
                new ExampleBean(name,
                                "Demonstrates the use of WMS base layer with a WFS overlay that can be edited.",
                                new String[]{"WMS", "WFS", "WFS-T", "WFST", "WFS T", "save", "overlay", "edit", "modify"},
                                new WmsWfsEditExample(name)));

        name = "Basic TMS example";
        examples.add(
                new ExampleBean(name, "Demonstrates the use of a TMS layer.",
                                new String[]{"TMS", "basic"},
                                new BasicTmsExample(name)));

        name = "Custom mouse position";
        examples.add(
                new ExampleBean(name,
                                "Demonstrates how to add a custom mouse position control to the map.",
                                new String[]{"mouse", "position"},
                                new CustomMousePositionExample(name)));

        name = "Graticule";
        examples.add(
                new ExampleBean(name,
                                "Demonstrates how to add a graticule raster to the map.",
                                new String[]{"graticule", "raster", "control"},
                                new GraticuleExample(name)));

        name = "WMS get featuretype example";
        examples.add(
                new ExampleBean(name,
                                "Demonstrates how to get feature information from a WMS layer.",
                                new String[]{"WMS", "feature", "featuretype", "get"},
                                new WmsFeatureInfoExample(name)));

        name = "Clickable vector example";
        examples.add(
                new ExampleBean(name,
                                "Demonstrates how to add Vector data to the map and make it clickable. Using this you can for example create markers.",
                                new String[]{"marker", "feature", "clickable", "vector", "line"},
                                new VectorExample(name)));

        name = "Measure control example";
        examples.add(
                new ExampleBean(name,
                                "Demonstrates how to add a measure control.",
                                new String[]{"measure", "control"},
                                new MeasureExample(name)));

        name = "GPS location example";
        examples.add(
                new ExampleBean(name,
                                "Demonstrates how to display the users current location on the map",
                                new String[]{"gps", "location", "osm"},
                                new LocationExample(name)));

        name = "WFS refresh";
        examples.add(
                new ExampleBean(name,
                                "Demonstrates how to you can reload a WFS to the server state after moving (but not saving) the features.",
                                new String[]{"wfs", "edit", "refresh"},
                                new WfsRefreshExample(name)));

        name = "Rotate vector features";
        examples.add(
                new ExampleBean(name,
                                "Details on how to create and rotate vector features programmatically.",
                                new String[]{"features", "rotate", "geometry"},
                                new RotateVectorExample(name)));

        name = "Transform vector features";
        examples.add(
                new ExampleBean(name,
                                "Details on how to create and transform vector features. Use the small Handels to transform and the greater ones to rotate.",
                                new String[]{"features", "transform", "geometry"},
                                new TransformFeatureExample(name)));

        name = "Select and edit feature example";
        examples.add(
                new ExampleBean(name,
                                "Demonstrates on how to create new features, and select features (on click, on hover and by selecting them in a box)",
                                new String[]{"features", "drawing", "geometry", "select", "vector", "point", "line", "polygon", "edit"},
                                new SelectFeatureExample(name)));

        name = "Snap, edit and delete features example";
        examples.add(
                new ExampleBean(name,
                                "Demonstrates on how to create new features and delete features. In this example snapping on the features is enabled.",
                                new String[]{"features", "drawing", "geometry", "edit", "vector", "line", "polygon", "snapping", "snap", "delete"},
                                new SnapFeatureExample(name)));

        name = "Convert a LINESTRING VectorFeature to a MULTILINESTRING";
        examples.add(
                new ExampleBean(name,
                                "Demonstrates how to convert a LINESTRING to a MULTILINESTRING. This is needed when you receive a " +
                                "\"Error performing insert: java.lang.String cannot be cast to com.vividsolutions.jts.geom.Geometry\" when sending" +
                                "newly created lines to geoserver using WFS-T.",
                                new String[]{"LINESTRING", "MULTILINESTRING", "geoserver", "wfs", "wfst", "wfs-t", "error", "cast", "vividsolutions", "geometry"},
                                new LineString2MultiLineStringExample(name)));

        name = "WMS refresh";
        examples.add(
                new ExampleBean(name,
                                "Demonstrates how to you can reload a WMS to the server state.",
                                new String[]{"wms", "refresh"},
                                new WmsRefreshExample(name)));

        name = "Undo/Redo drawing";
        examples.add(
                new ExampleBean(name,
                                "Demonstrates the use of the undo and redo methods on DrawFeature WHILE DRAWING.",
                                new String[]{"undo", "redo", "vector", "feature", "drawing", "sketch"},
                                new UndoRedoDrawingExample(name)));

        name = "Cancel drawing";
        examples.add(
                new ExampleBean(name,
                                "Demonstrates the use of the cancel method on DrawFeature to cancel a current sketch.",
                                new String[]{"cancel", "vector", "feature", "drawing", "sketch"},
                                new CancelDrawingExample(name)));

        Collections.sort(examples);
    }

    /**
     * Creates a panel for each available example.
     */
    private void buildExamplePanels(final String filter) {
        examplesPanel.clear();

        int numberOfExamples = 0;

        for (ExampleBean example : examples) {
            boolean show = false;
            String[] tags = example.getTags();
            if ((filter == null) || (filter.trim().equals(""))) {
                show = true;
            } else {
                for (String tag : tags) {
                    if (tag.trim().toLowerCase().contains(
                            filter.trim().toLowerCase())) {
                        show = true;
                        break;
                    }
                }
            }


            if (show) {
                examplesPanel.add(new ExamplePanel(example));
                numberOfExamples++;
            }
        }

        lblNumberOfExamples.setText("(" + numberOfExamples + ")");
    }

    /**
     * Builds the top panel containing the logo, the searchbox, and the number
     * of examples currently shown.
     */
    private void buildTopPanel() {
        final HorizontalPanel hpTop = new HorizontalPanel();
        hpTop.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
        hpTop.setStyleName("top");

        final Image imgLogo = new Image(Resources.INSTANCE.gwtOlLogo());
        hpTop.add(imgLogo);
        final HorizontalPanel hpTopSearch = new HorizontalPanel();
        hpTopSearch.setSpacing(3);
        hpTop.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
        hpTopSearch.add(txtSearch);
        hpTopSearch.add(lblNumberOfExamples);
        hpTop.add(hpTopSearch);
        hpTop.setCellWidth(imgLogo, "1px");

        txtSearch.setText(I18N.filterByKeywords());
        txtSearch.setStyleName("emptytextbox");

        txtSearch.addFocusHandler(this);
        txtSearch.addBlurHandler(this);
        txtSearch.addKeyUpHandler(this);

        RootPanel.get().add(hpTop);
        examplesPanel.setWidth("100%");
        RootPanel.get().add(examplesPanel);
    }

    /*
     * (non-Javadoc)
     * @see com.google.gwt.event.dom.client.FocusHandler#onFocus(com.google.gwt.event.dom.client.FocusEvent)
     */
    public void onFocus(FocusEvent event) {
        if (event.getSource() == txtSearch) {
            if (txtSearch.getText().equals(I18N.filterByKeywords())) {
                txtSearch.setText("");
                txtSearch.removeStyleName("emptytextbox");
            }
        }
    }

    /*
     * (non-Javadoc)
     * @see com.google.gwt.event.dom.client.BlurHandler#onBlur(com.google.gwt.event.dom.client.BlurEvent)
     */
    public void onBlur(BlurEvent event) {
        if (event.getSource() == txtSearch) {
            if (txtSearch.getText().trim().equals("")) {
                txtSearch.setText(I18N.filterByKeywords());
                txtSearch.addStyleName("emptytextbox");
            }
        }
    }

    /*
     * (non-Javadoc)
     * @see com.google.gwt.event.dom.client.KeyUpHandler#onKeyUp(com.google.gwt.event.dom.client.KeyUpEvent)
     */
    public void onKeyUp(KeyUpEvent event) {
        if (event.getSource() == txtSearch) {
            buildExamplePanels(txtSearch.getText());
        }

    }
}