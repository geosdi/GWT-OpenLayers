/**
 *
 *   Copyright 2015 sourceforge.
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
package org.gwtopenmaps.demo.openlayers.client.examples.format.xml;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.NodeList;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.resources.client.TextResource;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.InlineHTML;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;
import javax.inject.Inject;
import org.gwtopenmaps.demo.openlayers.client.basic.AbstractExample;
import org.gwtopenmaps.demo.openlayers.client.components.list.GwtOpenLayersULComponent;
import org.gwtopenmaps.demo.openlayers.client.components.store.ShowcaseExampleStore;
import org.gwtopenmaps.demo.openlayers.client.examples.format.xml.resources.XMLFormatExampleResources;
import org.gwtopenmaps.openlayers.client.format.format.XML;

/**
 *
 * @author Giuseppe La Scaleia - CNR IMAA geoSDI Group
 * @email giuseppe.lascaleia@geosdi.org
 */
public class XMLFormatExample extends AbstractExample {

    private static final TextResource xmlFormatResource = XMLFormatExampleResources.INSTANCE.xmlFormatResource();
    private static final XML xmlFormat = new XML();
    private static final Document baseEl;

    static {
        baseEl = (Document) xmlFormat.read(xmlFormatResource.getText());
    }

    @Inject
    public XMLFormatExample(ShowcaseExampleStore store) {
        super("XML Format Example", "Shows how to use XML Format.",
                new String[]{"XML", "Format"}, store);
    }

    @Override
    public void buildPanel() {
        contentPanel.add(new HTML("Shows the use of the OpenLayers XML format class<br/>"
                + "OpenLayers has a very simple XML format class (OpenLayers.Format.XML) "
                + "that can be used to read/write XML docs. The methods available on the "
                + "XML format (or parser if you like) allow for reading and writing of "
                + "the various XML flavors used by the library - in particular the vector "
                + "data formats. It is by no means intended to be a full-fledged XML toolset. "
                + "Additional methods will be added only as needed elsewhere in the library.<br/>"
                + "This page loads an XML document and demonstrates a few of the methods available in the parser."));

        final Label outputValue = new Label();

        HorizontalPanel panel = new HorizontalPanel();

        Label statusLabel = new Label("Status : ");
        final InlineHTML statusLabelValue = new InlineHTML();
        statusLabelValue.setHTML("<strong>XML document loaded</strong>.");
        panel.add(statusLabel);
        panel.add(statusLabelValue);

        contentPanel.add(panel);

        contentPanel.add(new HTML("<p>After the XML document loads, see the result "
                + "of a few of the methods below. Assume that you start with the "
                + "following code: <br/>"
                + "var format = new OpenLayers.Format.XML();</p>"
                + "Sample methods"));

        VerticalPanel vp = new VerticalPanel();

        GwtOpenLayersULComponent uLComponent = new GwtOpenLayersULComponent();

        HorizontalPanel wp = new HorizontalPanel();
        Anchor write = new Anchor();
        write.setHTML("format.write()");
        wp.add(write);
        wp.add(new Label(" - write the XML doc as text"));
        write.addClickHandler(new ClickHandler() {

            public void onClick(ClickEvent event) {
                outputValue.setText(xmlFormat.write(baseEl));
            }
        });

        uLComponent.add(wp);

        HorizontalPanel ebyTagNames = new HorizontalPanel();
        Anchor tagNames = new Anchor();
        tagNames.setHTML("format.getElementsByTagNameNS()");
        ebyTagNames.add(tagNames);
        ebyTagNames.add(new Label(" - get all gml:MultiPolygon"));
        tagNames.addClickHandler(new ClickHandler() {

            public void onClick(ClickEvent event) {
                NodeList elements = xmlFormat.getElementsByTagNameNS(baseEl.getDocumentElement(),
                        "http://www.opengis.net/gml", "MultiPolygon");
                StringBuilder builder = new StringBuilder();
                for (int i = 0; i < elements.getLength(); i++) {
                    builder.append(xmlFormat.write(elements.getItem(i)));
                }
                outputValue.setText(builder.toString());
            }
        });

        uLComponent.add(ebyTagNames);

        HorizontalPanel hasAttributePanel = new HorizontalPanel();
        Anchor hasAttAnchor = new Anchor();
        hasAttAnchor.setHTML("format.hasAttributeNS()");
        hasAttributePanel.add(hasAttAnchor);
        hasAttributePanel.add(new Label(" - test to see schemaLocation "
                + "attribute exists in the http://www.w3.org/2001/XMLSchema-instance namespace"));
        hasAttAnchor.addClickHandler(new ClickHandler() {

            public void onClick(ClickEvent event) {
                outputValue.setText(String.valueOf(xmlFormat.hasAttributeNS(baseEl.getDocumentElement(),
                        "http://www.w3.org/2001/XMLSchema-instance",
                        "schemaLocation")));
            }
        });

        uLComponent.add(hasAttributePanel);

        vp.add(uLComponent);

        HorizontalPanel getAttrNodeNSPanel = new HorizontalPanel();
        Anchor getAttrNodeNSAnchor = new Anchor();
        getAttrNodeNSAnchor.setHTML("format.getAttributeNodeNS()");
        getAttrNodeNSPanel.add(getAttrNodeNSAnchor);
        getAttrNodeNSPanel.add(new Label(" - get schemaLocation attribute in "
                + "the http://www.w3.org/2001/XMLSchema-instance namespace"));
        getAttrNodeNSAnchor.addClickHandler(new ClickHandler() {

            public void onClick(ClickEvent event) {
                Element e = xmlFormat.getAttributeNodeNS(baseEl.getDocumentElement(),
                        "http://www.w3.org/2001/XMLSchema-instance",
                        "schemaLocation");
                outputValue.setText(e.getNodeName() + " = "
                        + e.getNodeValue());
            }
        });

        uLComponent.add(getAttrNodeNSPanel);

        HorizontalPanel getAttrNSHorizontalPanel = new HorizontalPanel();
        Anchor getAttrNSAnchor = new Anchor();
        getAttrNSAnchor.setHTML("format.getAttributeNS()");
        getAttrNSHorizontalPanel.add(getAttrNSAnchor);
        getAttrNSHorizontalPanel.add(new Label(" - get schemaLocation "
                + "attribute value in the http://www.w3.org/2001/"
                + "XMLSchema-instance namespace"));
        getAttrNSAnchor.addClickHandler(new ClickHandler() {

            public void onClick(ClickEvent event) {
                outputValue.setText(xmlFormat.getAttributeNS(baseEl.getDocumentElement(),
                        "http://www.w3.org/2001/XMLSchema-instance",
                        "schemaLocation"));
            }
        });

        uLComponent.add(getAttrNSHorizontalPanel);

        HorizontalPanel createElNSPanel = new HorizontalPanel();
        Anchor createElNSAnchor = new Anchor();
        createElNSAnchor.setHTML("format.createElementNS()");
        createElNSPanel.add(createElNSAnchor);
        createElNSPanel.add(new Label(" - create a foo:TestNode element"
                + " (and append it to the doc)"));
        createElNSAnchor.addClickHandler(new ClickHandler() {

            public void onClick(ClickEvent event) {
                Element e = xmlFormat.createElementNS("http://bar.com/foo",
                        "foo:TestNode");
                baseEl.getDocumentElement().appendChild(e);
                outputValue.setText(xmlFormat.write(baseEl));
            }
        });

        uLComponent.add(createElNSPanel);

        HorizontalPanel createTextNodePanel = new HorizontalPanel();
        Anchor createTextNodeAnchor = new Anchor();
        createTextNodeAnchor.setHTML("format.createTextNode()");
        createTextNodePanel.add(createTextNodeAnchor);
        createTextNodePanel.add(new Label(" - create a text node"
                + " (and append it to the doc)"));
        createTextNodeAnchor.addClickHandler(new ClickHandler() {

            public void onClick(ClickEvent event) {
                Element e = xmlFormat.createTextNode("test text ");
                baseEl.getDocumentElement().appendChild(e);
                outputValue.setText(xmlFormat.write(baseEl));
            }
        });

        uLComponent.add(createTextNodePanel);

        contentPanel.add(vp);
        contentPanel.add(new InlineHTML("<strong>Output</strong> :"));
        contentPanel.add(outputValue);

        initWidget(contentPanel);
    }

    @Override
    public String getSourceCodeURL() {
        return GWT.getModuleBaseURL() + "examples/format/xml/"
                + "XMLFormatExample.txt";
    }
}
