package org.gwtopenmaps.demo.openlayers.client.widget;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.FlexTable;

import org.gwtopenmaps.demo.openlayers.client.examples.control.CustomMousePosition;
import org.gwtopenmaps.demo.openlayers.client.examples.control.GraticuleExample;
import org.gwtopenmaps.demo.openlayers.client.examples.control.MeasureExample;
import org.gwtopenmaps.demo.openlayers.client.examples.control.NavigationHistoryExample;
import org.gwtopenmaps.demo.openlayers.client.examples.control.SnappingExample;
import org.gwtopenmaps.demo.openlayers.client.examples.events.MapEvents;
import org.gwtopenmaps.demo.openlayers.client.examples.layers.TMSExample;
import org.gwtopenmaps.demo.openlayers.client.examples.raster.BasicWMS;
import org.gwtopenmaps.demo.openlayers.client.examples.raster.WMSGetFeatureInfoExample;
import org.gwtopenmaps.demo.openlayers.client.examples.vector.BasicDrawFeatures;
import org.gwtopenmaps.demo.openlayers.client.examples.vector.BasicWFS;
import org.gwtopenmaps.demo.openlayers.client.examples.vector.DragExample;
import org.gwtopenmaps.demo.openlayers.client.examples.vector.DrawFeatures;
import org.gwtopenmaps.demo.openlayers.client.examples.vector.LabeledFeature;
import org.gwtopenmaps.demo.openlayers.client.examples.vector.ModifyFeatureExample;
import org.gwtopenmaps.demo.openlayers.client.examples.vector.ReadWFS;
import org.gwtopenmaps.demo.openlayers.client.examples.vector.SelectFeatureExamples;


public class ShowcaseMenu extends FlexTable
{
    private int menuItemCount = 0;

    public ShowcaseMenu(final ShowcaseContent contentPanel)
    {
        // ===== SET DEFAULT EXAMPLE =====

        DrawFeatures drawFeatures = new DrawFeatures();
        contentPanel.setExample(drawFeatures.getMapExample());

        // ===== ADD MENU ITEMS =====
        ShowcaseMenuItem basicWMSItem = new ShowcaseMenuItem("Basic WMS",
                "A simple map with a WMS Layer.", new ClickHandler()
                {
                    public void onClick(ClickEvent evt)
                    {
                        BasicWMS basicWms = new BasicWMS();
                        contentPanel.setExample(basicWms.getMapExample());
                        contentPanel.setExampleDescription("Description here.");
                        contentPanel.setExampleSource("Source here");
                        contentPanel.selectTab(0);
                    }
                });

        ShowcaseMenuItem measureItemItem = new ShowcaseMenuItem("Measure",
                "Measure distances and areas.", new ClickHandler()
                {
                    public void onClick(ClickEvent evt)
                    {
                        MeasureExample measureExample = new MeasureExample();
                        contentPanel.setExample(measureExample.getMapExample());
                        contentPanel.setExampleDescription("Description here.");
                        contentPanel.setExampleSource("Source here");
                        contentPanel.selectTab(0);
                    }
                });

        ShowcaseMenuItem snappingItem = new ShowcaseMenuItem("Snapping",
                "Snapping while editing.",
                new ClickHandler()
                {
                    public void onClick(ClickEvent evt)
                    {
                        SnappingExample snapping = new SnappingExample();
                        contentPanel.setExample(snapping.getMapExample());
                        contentPanel.setExampleDescription(
                            "Snapping description here.");
                        contentPanel.setExampleSource("Source here");
                        contentPanel.selectTab(0);
                    }
                });

        ShowcaseMenuItem graticuleItem = new ShowcaseMenuItem(
                "Graticule Control", "Activate / Deactivate graticule on map",
                new ClickHandler()
                {
                    public void onClick(ClickEvent evt)
                    {
                        GraticuleExample graticuleControl = new GraticuleExample();
                        contentPanel.setExample(graticuleControl.getMapExample());
                        contentPanel.setExampleDescription(
                            "The example shows how to activate / deactivate a graticule on the map.");
                        contentPanel.setExampleSource("Source here");
                        contentPanel.selectTab(0);
                    }
                });

        ShowcaseMenuItem wmsGetFeatureInfoItem = new ShowcaseMenuItem(
                "WMS GetFeatureInfo",
                "Demonstrates WMS GetFeatureInfo control.",
                new ClickHandler()
                {
                    public void onClick(ClickEvent evt)
                    {
                        WMSGetFeatureInfoExample wmsGetFeatureInfo = new WMSGetFeatureInfoExample();
                        contentPanel.setExample(
                            wmsGetFeatureInfo.getMapExample());
                        contentPanel.setExampleDescription("Description here.");
                        contentPanel.setExampleSource("Source here");
                        contentPanel.selectTab(0);
                    }
                });

        ShowcaseMenuItem vectorFeaturesItem = new ShowcaseMenuItem(
                "Vector Features", "Create vector features programmatically.",
                new ClickHandler()
                {
                    public void onClick(ClickEvent evt)
                    {
                        BasicDrawFeatures basicDrawFeatures = new BasicDrawFeatures();
                        contentPanel.setExample(
                            basicDrawFeatures.getMapExample());
                        contentPanel.setExampleDescription("Description here.");
                        contentPanel.setExampleSource("Source here");
                        contentPanel.selectTab(0);
                    }
                });

        ShowcaseMenuItem drawFeaturesItem = new ShowcaseMenuItem(
                "Draw Features", "Draw vector features by hand.",
                new ClickHandler()
                {
                    public void onClick(ClickEvent evt)
                    {
                        DrawFeatures drawFeatures = new DrawFeatures();
                        contentPanel.setExample(drawFeatures.getMapExample());
                        contentPanel.setExampleDescription("Description here.");
                        contentPanel.setExampleSource("Source here");
                        contentPanel.selectTab(0);
                    }
                });

        ShowcaseMenuItem mapEventsItem = new ShowcaseMenuItem("Map Events",
                "Map event handlers.", new ClickHandler()
                {
                    public void onClick(ClickEvent evt)
                    {
                        MapEvents mapEvents = new MapEvents();
                        contentPanel.setExample(mapEvents.getMapExample());
                        contentPanel.setExampleDescription("Description here.");
                        contentPanel.setExampleSource("Source here");
                        contentPanel.selectTab(0);
                    }
                });

        ShowcaseMenuItem mpOutputItem = new ShowcaseMenuItem("MousePosition",
                "MousePosition custom output.",
                new ClickHandler()
                {
                    public void onClick(ClickEvent evt)
                    {
                        CustomMousePosition mpOutput = new CustomMousePosition();
                        contentPanel.setExample(mpOutput.getMapExample());
                        contentPanel.setExampleDescription(
                            "Example of custom output of the mouse position control");
                        contentPanel.setExampleSource(
                            GWT.getHostPageBaseURL() +
                            "sourcetab/example_control_custom-mouseposition.html");
                        contentPanel.selectTab(0);
                    }
                });

        ShowcaseMenuItem labeledFeaturesItem = new ShowcaseMenuItem(
                "Labeled Features", "Create vector features with labels.",
                new ClickHandler()
                {
                    public void onClick(ClickEvent evt)
                    {
                        LabeledFeature labeledFeatureExamples = new LabeledFeature();
                        contentPanel.setExample(
                            labeledFeatureExamples.getMapExample());
                        contentPanel.setExampleDescription("Description here.");
                        contentPanel.setExampleSource("Source here");
                        contentPanel.selectTab(0);
                    }
                });

        ShowcaseMenuItem selectFeatureExamplesItem = new ShowcaseMenuItem(
                "SelectFeature Examples",
                "Examples of the SelectFeature events.",
                new ClickHandler()
                {
                    public void onClick(ClickEvent evt)
                    {
                        SelectFeatureExamples selectFeatureExamples = new SelectFeatureExamples();
                        contentPanel.setExample(
                            selectFeatureExamples.getMapExample());
                        contentPanel.setExampleDescription("Description here.");
                        contentPanel.setExampleSource("Source here");
                        contentPanel.selectTab(0);
                    }
                });

        ShowcaseMenuItem dragExamplesItem = new ShowcaseMenuItem(
                "Drag Example", "Example of the Drag features.",
                new ClickHandler()
                {
                    public void onClick(ClickEvent evt)
                    {
                        DragExample dragExamples = new DragExample();
                        contentPanel.setExample(dragExamples.getMapExample());
                        contentPanel.setExampleDescription("Description here.");
                        contentPanel.setExampleSource("Source here");
                        contentPanel.selectTab(0);
                    }
                });

        ShowcaseMenuItem modifyExampleItem = new ShowcaseMenuItem(
                "Modify Feature Example",
                "Example of the Modify feature control.", new ClickHandler()
                {
                    public void onClick(ClickEvent evt)
                    {
                        ModifyFeatureExample modifyExample = new ModifyFeatureExample();
                        contentPanel.setExample(modifyExample.getMapExample());
                        contentPanel.setExampleDescription("Description here.");
                        contentPanel.setExampleSource("Source here");
                        contentPanel.selectTab(0);
                    }
                });

        ShowcaseMenuItem basicWFSItem = new ShowcaseMenuItem(
                "Basic WFS Example",
                "WFS with the WFS protocol.", new ClickHandler()
                {
                    public void onClick(ClickEvent evt)
                    {
                        BasicWFS wfsExample = new BasicWFS();
                        contentPanel.setExample(wfsExample.getMapExample());
                        contentPanel.setExampleDescription("Description here.");
                        contentPanel.setExampleSource("Source here");
                        contentPanel.selectTab(0);
                    }
                });

        ShowcaseMenuItem readWFSItem = new ShowcaseMenuItem(
                "Read WFS Example",
                "Reading from the WFS protocol.",
                new ClickHandler()
                {
                    public void onClick(ClickEvent evt)
                    {
                        ReadWFS readWfsExample = new ReadWFS();
                        contentPanel.setExample(readWfsExample.getMapExample());

                        String description = "<span style='color:green;'>Green</span> : population < 4M <br>" +
                            "<span style='color:orange;'>Orange</span> : 4M < population < 10M <br>" +
                            "<span style='color:red;'>Red</span> : 10M < population";
                        contentPanel.setExampleDescription(description);
                        contentPanel.setExampleSource("Source here");
                        contentPanel.selectTab(0);
                    }
                });

        ShowcaseMenuItem navigationHistoryExamples = new ShowcaseMenuItem(
                "Navigation History Examples",
                "Example with Navigation History.",
                new ClickHandler()
                {
                    public void onClick(ClickEvent evt)
                    {
                        NavigationHistoryExample navHistoryExample = new NavigationHistoryExample();
                        contentPanel.setExample(
                            navHistoryExample.getMapExample());
                        contentPanel.setExampleDescription("Description here.");
                        contentPanel.setExampleSource("Source here");
                        contentPanel.selectTab(0);
                    }
                });

        ShowcaseMenuItem tmsExample = new ShowcaseMenuItem(
                "TMSExample",
                "TMSExample.",
                new ClickHandler()
                {
                    public void onClick(ClickEvent evt)
                    {
                        TMSExample tmsExample = new TMSExample();
                        contentPanel.setExample(
                            tmsExample.getMapExample());
                        contentPanel.setExampleDescription("Description here.");
                        contentPanel.setExampleSource("Source here");
                        contentPanel.selectTab(0);
                    }
                });

        addMenuItem(basicWMSItem);
        addMenuItem(wmsGetFeatureInfoItem);
        addMenuItem(vectorFeaturesItem);
        addMenuItem(drawFeaturesItem);
        addMenuItem(mapEventsItem);
        addMenuItem(mpOutputItem);
        addMenuItem(labeledFeaturesItem);
        addMenuItem(selectFeatureExamplesItem);
        addMenuItem(dragExamplesItem);
        addMenuItem(modifyExampleItem);
        addMenuItem(basicWFSItem);
        addMenuItem(readWFSItem);
        addMenuItem(graticuleItem);
        addMenuItem(snappingItem);
        addMenuItem(navigationHistoryExamples);
        addMenuItem(measureItemItem);
        addMenuItem(tmsExample);

        // this.setWidget(getMenuItemCount() + getMenuItemCount(), 0,
        // menuItem4Link);
        // this.setWidget(getMenuItemCount() + getMenuItemCount() + 1, 0,
        // menuItem4Desc);

    }

    private void addMenuItem(ShowcaseMenuItem item)
    {
        this.setWidget(getMenuItemCount() + getMenuItemCount(), 0,
            item.getLabel());
        this.setWidget(getMenuItemCount() + getMenuItemCount() + 1, 0,
            item.getShortDescription());
        incrementMenuItemCount();
    }

    private int getMenuItemCount()
    {
        return this.menuItemCount;
    }

    private void incrementMenuItemCount()
    {
        this.menuItemCount++;
    }
}
