/**
 *
 *   Copyright 2015 GWT OpenLayers Team.
 *
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 */
package org.gwtopenmaps.demo.openlayers.client.examples.sld.graphicfill;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.RadioButton;
import com.google.gwt.user.client.ui.TextArea;
import org.gwtopenmaps.demo.openlayers.client.basic.AbstractExample;
import org.gwtopenmaps.demo.openlayers.client.components.store.ShowcaseExampleStore;
import org.gwtopenmaps.openlayers.client.LonLat;
import org.gwtopenmaps.openlayers.client.Map;
import org.gwtopenmaps.openlayers.client.MapOptions;
import org.gwtopenmaps.openlayers.client.MapWidget;
import org.gwtopenmaps.openlayers.client.control.DrawFeature;
import org.gwtopenmaps.openlayers.client.control.LayerSwitcher;
import org.gwtopenmaps.openlayers.client.control.MousePosition;
import org.gwtopenmaps.openlayers.client.format.sld.SLD;
import org.gwtopenmaps.openlayers.client.format.sld.SLDResult;
import org.gwtopenmaps.openlayers.client.handler.PolygonHandler;
import org.gwtopenmaps.openlayers.client.layer.*;

import javax.inject.Inject;
import java.util.logging.Logger;

/**
 * @author Giuseppe La Scaleia - CNR IMAA geoSDI Group
 * @email giuseppe.lascaleia@geosdi.org
 */
public class GraphicFillExample extends AbstractExample {

    private static final Logger logger = Logger.getLogger(GraphicFillExample.class.getName());
    //
    private Vector polygonLayer;
    private DrawFeature drawPolygonControl;
    private RadioButton navigateButton;
    private RadioButton drawPolygonButton;
    private final SLD sld = new SLD();

    @Inject
    public GraphicFillExample(ShowcaseExampleStore store) {
        super("Graphic Fill Example", "Demonstrate GraphicFill for polygons.",
                new String[]{"SLD", "GraphicFill", "Polygon"}, store);
    }

    @Override
    public void buildPanel() {
        // create some MapOptions
        MapOptions defaultMapOptions = new MapOptions();
        defaultMapOptions.setNumZoomLevels(16);

        // Create a MapWidget
        final MapWidget mapWidget = new MapWidget("514px", "258px", defaultMapOptions);
        // Create a WMS layer as base layer
        WMSParams wmsParams = new WMSParams();
        wmsParams.setFormat("image/png");
        wmsParams.setLayers("basic");
        wmsParams.setStyles("");

        WMSOptions wmsLayerParams = new WMSOptions();
        wmsLayerParams.setUntiled();
        wmsLayerParams.setTransitionEffect(TransitionEffect.RESIZE);

        String wmsUrl = "http://vmap0.tiles.osgeo.org/wms/vmap0";
        WMS wmsLayer = new WMS("Basic WMS", wmsUrl, wmsParams, wmsLayerParams);

        this.polygonLayer = new Vector("Polygon Layer");

        // Add the WMS to the map
        Map map = mapWidget.getMap();
        map.addLayers(new Layer[]{wmsLayer, polygonLayer});
        map.addControl(new LayerSwitcher());
        map.addControl(new MousePosition());

        this.drawPolygonControl = new DrawFeature(polygonLayer,
                new PolygonHandler());

        map.addControl(drawPolygonControl);

        // Center and zoom to a location
        map.setCenter(new LonLat(0, 0), 3);

        navigateButton = new RadioButton("NavigateButton", "navigate");
        navigateButton.addValueChangeHandler(new ValueChangeHandler<Boolean>() {

            public void onValueChange(ValueChangeEvent<Boolean> event) {
                if (event.getValue()) {
                    drawPolygonControl.deactivate();
                    drawPolygonButton.setValue(Boolean.FALSE, Boolean.FALSE);
                }
            }
        });

        drawPolygonButton = new RadioButton("DrawPolygonButton",
                "draw polygon");
        drawPolygonButton.addValueChangeHandler(
                new ValueChangeHandler<Boolean>() {

                    public void onValueChange(ValueChangeEvent<Boolean> event) {
                        if (event.getValue()) {
                            drawPolygonControl.activate();
                            navigateButton.setValue(Boolean.FALSE, Boolean.FALSE);
                        }
                    }
                });

        drawPolygonButton.setValue(Boolean.TRUE, Boolean.TRUE);

        final TextArea sldArea = new TextArea();
        sldArea.setWidth("512px");
        sldArea.setHeight("300px");
        sldArea.setValue(
                "<?xml version=\"1.0\" encoding=\"ISO-8859-1\" standalone=\"yes\"?>\n"
                        + "<sld:StyledLayerDescriptor version=\"1.0.0\" xmlns:sld=\"http://www.opengis.net/sld\" xmlns:ogc=\"http://www.opengis.net/ogc\" xmlns:xlink=\"http://www.w3.org/1999/xlink\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.opengis.net/sld ./Sld/StyledLayerDescriptor.xsd\">\n"
                        + "	<sld:NamedLayer>\n"
                        + "		<sld:Name>Polygon</sld:Name>\n"
                        + "		<sld:UserStyle>\n"
                        + "			<sld:Name>Polygon</sld:Name>\n"
                        + "			<sld:FeatureTypeStyle>\n"
                        + "				<sld:FeatureTypeName>Polygon</sld:FeatureTypeName>\n"
                        + "				<sld:Rule>\n"
                        + "					<sld:Name>Polygon</sld:Name>\n"
                        + "					<sld:Title>Polygon</sld:Title>\n"
                        + "					<sld:PolygonSymbolizer>\n"
                        + "						<sld:Fill>\n"
                        + "							<sld:GraphicFill>\n"
                        + "								<sld:Graphic>\n"
                        + "									<sld:ExternalGraphic>\n"
                        + "										<sld:OnlineResource xmlns:xlink=\"http://www.w3.org/1999/xlink\" xlink:type=\"simple\" xlink:href=\"graphicfill.png\"/>\n"
                        + "										<sld:Format>image/png</sld:Format>\n"
                        + "										</sld:ExternalGraphic>\n"
                        + "									<sld:Size>20</sld:Size>\n"
                        + "								</sld:Graphic>\n"
                        + "							</sld:GraphicFill>\n"
                        + "						</sld:Fill>\n"
                        + "						<sld:Stroke>\n"
                        + "							<sld:CssParameter name=\"stroke\">#006666</sld:CssParameter>\n"
                        + "							<sld:CssParameter name=\"stroke-width\">2</sld:CssParameter>\n"
                        + "							<sld:CssParameter name=\"stroke-opacity\">1</sld:CssParameter>\n"
                        + "							<sld:CssParameter name=\"stroke-dasharray\">4 4</sld:CssParameter>\n"
                        + "						</sld:Stroke>\n"
                        + "					</sld:PolygonSymbolizer>\n"
                        + "				</sld:Rule>\n"
                        + "			</sld:FeatureTypeStyle>\n"
                        + "		</sld:UserStyle>\n"
                        + "	</sld:NamedLayer>\n"
                        + "</sld:StyledLayerDescriptor>");

        final Button applySld = new Button("Apply SLD");
        applySld.addClickHandler(new ClickHandler() {

            public void onClick(ClickEvent event) {
                SLDResult sldResult = sld.read(sldArea.getText());
                if (sldResult != null) {
                    logger.info("codice eseguito ###############");
                    polygonLayer.setStyleMap(sldResult.getUserStyleMap());
                    polygonLayer.redraw();
                }
            }
        });

        applySld.fireEvent(new ButtonClickEvent());

        contentPanel.add(new HTML(
                "Demonstrate GraphicFill for polygons."));
        contentPanel.add(mapWidget);
        contentPanel.add(navigateButton);
        contentPanel.add(drawPolygonButton);
        contentPanel.add(sldArea);
        contentPanel.add(applySld);

        initWidget(contentPanel);

        mapWidget.getElement().getFirstChildElement().getStyle().setZIndex(0); // force the map to fall behind popups
    }

    @Override
    public String getSourceCodeURL() {
        return GWT.getModuleBaseURL() + "examples/sld/graphicfill/"
                + "GraphicFillExample.txt";
    }

    private class ButtonClickEvent extends ClickEvent {

        public ButtonClickEvent() {
        }
    }

}
