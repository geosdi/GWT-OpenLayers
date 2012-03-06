/**
 * 
 */
package org.gwtopenmaps.demo.openlayers.client.examples.filter;

import org.gwtopenmaps.demo.openlayers.client.examples.MapExample;
import org.gwtopenmaps.demo.openlayers.client.examples.ShowcaseExample;
import org.gwtopenmaps.openlayers.client.LonLat;
import org.gwtopenmaps.openlayers.client.control.LayerSwitcher;
import org.gwtopenmaps.openlayers.client.control.MousePosition;
import org.gwtopenmaps.openlayers.client.control.NavToolbar;
import org.gwtopenmaps.openlayers.client.control.PanZoomBar;
import org.gwtopenmaps.openlayers.client.layer.Layer;
import org.gwtopenmaps.openlayers.client.layer.WMS;
import org.gwtopenmaps.openlayers.client.layer.WMSOptions;
import org.gwtopenmaps.openlayers.client.layer.WMSParams;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.i18n.shared.AnyRtlDirectionEstimator;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

/**
 * @author fizzi
 * 
 */
public class CQLFilter implements ShowcaseExample {

	public static final String WMS_URL = "http://v2.suite.opengeo.org/geoserver/wms/";

	private MapExample example;

	private WMS wmsLayer;

	private Button cqlButton = new Button("Filter");

	private TextBox cqlText = new TextBox();
	
	private VerticalPanel operationContents;

	public CQLFilter() {
		example = new MapExample();

		// Defining a WMSLayer and adding it to a Map
		final WMSParams wmsParams = new WMSParams();
		wmsParams.setFormat("image/png");
		wmsParams.setLayers("usa:states");
		wmsParams.setStyles("");

		WMSOptions wmsLayerParams = new WMSOptions();
		wmsLayerParams.setUntiled();

		wmsLayer = new WMS("Basic WMS", WMS_URL, wmsParams, wmsLayerParams);

		example.getMap().addLayers(new Layer[] { wmsLayer });

		// Adding controls to the Map
		example.getMap().addControl(new PanZoomBar());

		// use NavToolbar instead of deprecated MouseToolbar
		example.getMap().addControl(new NavToolbar());
		example.getMap().addControl(new MousePosition());
		example.getMap().addControl(new LayerSwitcher());

		// Center and Zoom
		double lon = -98;
		double lat = 38;
		int zoom = 3;

		cqlButton.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent arg0) {
				if (!cqlText.getValue().equals("")) {
					wmsParams.setParameter("CQL_FILTER", cqlText.getValue());
					wmsLayer.mergeNewParams(wmsParams);
				} else {
					
				}
			}
		});
		
		this.createOperationContents(cqlButton);

		example.getMap().setCenter(new LonLat(lon, lat), zoom);

	}

	private void createOperationContents(Button activationButton) {
		// Create a dialog box and set the caption text
		
		// Create a table to layout the content
		operationContents = new VerticalPanel();
		
		HTML details = new HTML(
				"<i>Write your filter<i><br /><p>Example: <strong>MALE > 1000000</strong></p> ");
		operationContents.add(details);
		operationContents.setCellHorizontalAlignment(details,
				HasHorizontalAlignment.ALIGN_LEFT);

		cqlText.ensureDebugId("cwBasicText-textbox");
		cqlText.setDirectionEstimator(AnyRtlDirectionEstimator.get());
		operationContents.add(cqlText);
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
