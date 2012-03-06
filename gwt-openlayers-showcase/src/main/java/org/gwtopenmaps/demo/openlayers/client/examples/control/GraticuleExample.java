/*
 * Copyright 2011 sourceforge.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.gwtopenmaps.demo.openlayers.client.examples.control;

import org.gwtopenmaps.demo.openlayers.client.examples.MapExample;
import org.gwtopenmaps.demo.openlayers.client.examples.ShowcaseExample;
import org.gwtopenmaps.demo.openlayers.client.examples.raster.BasicWMS;
import org.gwtopenmaps.openlayers.client.LonLat;
import org.gwtopenmaps.openlayers.client.control.Graticule;
import org.gwtopenmaps.openlayers.client.control.GraticuleOptions;
import org.gwtopenmaps.openlayers.client.control.MouseDefaults;
import org.gwtopenmaps.openlayers.client.layer.Layer;
import org.gwtopenmaps.openlayers.client.layer.WMS;
import org.gwtopenmaps.openlayers.client.layer.WMSParams;
import org.gwtopenmaps.openlayers.client.symbolizer.LineSymbolizer;
import org.gwtopenmaps.openlayers.client.symbolizer.LineSymbolizerOptions;
import org.gwtopenmaps.openlayers.client.symbolizer.TextSymbolizer;
import org.gwtopenmaps.openlayers.client.symbolizer.TextSymbolizerOptions;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.ToggleButton;
import com.google.gwt.user.client.ui.VerticalPanel;

/**
 * 
 * @author Giuseppe La Scaleia - CNR IMAA geoSDI Group
 * @email giuseppe.lascaleia@geosdi.org
 */
public class GraticuleExample implements ShowcaseExample {
	private MapExample example;
	private WMS wmsLayer;

	// Define buttons
	private ToggleButton activationButton = new ToggleButton("Graticula on/off");
	private Graticule grt;

	private VerticalPanel operationContents;

	public GraticuleExample() {
		example = new MapExample();

		// Add a WMS layer for a little background
		WMSParams wmsParams = new WMSParams();
		wmsParams.setFormat("image/png");
		wmsParams.setLayers("basic");
		wmsParams.setStyles("");

		// Center and Zoom
		double lon = 4.0;
		double lat = 5.0;
		int zoom = 5;

		wmsLayer = new WMS("Basic WMS", BasicWMS.WMS_URL, wmsParams);

		example.getMap().addLayers(new Layer[] { wmsLayer });
		example.getMap().setCenter(new LonLat(lon, lat), zoom);

		LineSymbolizerOptions lineOptions = new LineSymbolizerOptions();
		lineOptions.setStrokeColor("#ccccff");
		lineOptions.setStrokeOpacity(0.5);
		lineOptions.setStrokeWidth(1);

		LineSymbolizer line = new LineSymbolizer(lineOptions);

		TextSymbolizerOptions textOptions = new TextSymbolizerOptions();
		textOptions.setFontSize("9px");

		TextSymbolizer text = new TextSymbolizer(textOptions);

		final GraticuleOptions grtOptions = new GraticuleOptions();

		grtOptions.setTargetSize(200);
		grtOptions.setLabelled(true);
		grtOptions.setLineSymbolyzer(line);
		grtOptions.setLabelSymbolizer(text);
		grt = new Graticule(grtOptions);

		grt.setAutoActivate(false);

		example.getMap().addControl(new MouseDefaults());
		example.getMap().addControl(grt);

		activationButton.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent arg0) {
				// TODO Auto-generated method stub
				if (activationButton.isDown()) {
					grt.activate();
				} else {
					grt.deactivate();
				}
			}
		});

		// Adding the button to the example
		this.createOperationContents(activationButton);
		
	}

	private void createOperationContents(ToggleButton activationButton) {

		// Create a table to layout the content
		operationContents = new VerticalPanel();
		
		HTML details = new HTML(
				"<i>This is a toogle button that active / deactive Graticula Control</i> ");
		operationContents.add(details);
		operationContents.setCellHorizontalAlignment(details,
				HasHorizontalAlignment.ALIGN_LEFT);

		activationButton.setWidth("100px");
		operationContents.add(activationButton);

	}

	public VerticalPanel getOperationContents() {
		return operationContents;
	}

	public void setOperationContents(VerticalPanel operationContents) {
		this.operationContents = operationContents;
	}

	public MapExample getMapExample() {
		return this.example;
	}
}
