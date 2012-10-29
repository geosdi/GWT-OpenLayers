/*
 * Copyright 2012 sourceforge.
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
package org.gwtopenmaps.demo.openlayers.client.basic;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.RequestBuilder;
import com.google.gwt.http.client.RequestCallback;
import com.google.gwt.http.client.RequestException;
import com.google.gwt.http.client.Response;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import org.gwtopenmaps.demo.openlayers.client.components.ShowcaseSearchPanel;

/**
 *
 * @author Frank Wynants
 * 
 * @author Giuseppe La Scaleia - CNR IMAA geoSDI Group
 * @email giuseppe.lascaleia@geosdi.org
 */
public abstract class AbstractSourceButton extends Composite implements
        ClickHandler {

    protected Button button = new Button(ShowcaseSearchPanel.I18N.viewSource(),
                                         this);
    private String sourceCodeURL;

    public AbstractSourceButton() {
        super.initWidget(button);
    }

    /**
     * @param sourceCodeURL the sourceCodeURL to set
     */
    public void setSourceCodeURL(String sourceCodeURL) {
        this.sourceCodeURL = sourceCodeURL;
    }

    /*
     * (non-Javadoc)
     * @see com.google.gwt.event.dom.client.ClickHandler#onClick(com.google.gwt.event.dom.client.ClickEvent)
     */
    public void onClick(ClickEvent event) {
        RequestBuilder reqBuilder = new RequestBuilder(RequestBuilder.GET,
                                                       this.sourceCodeURL);
        try {
            reqBuilder.sendRequest("", new RequestCallback() {
                public void onResponseReceived(Request request,
                                               Response response) {
                    showSourceCode(response.getText());
                }

                public void onError(Request request, Throwable exception) {
                }
            });
        } catch (RequestException ex) {
        }


    }

    protected native void doFormat() /*-{
     $wnd.SyntaxHighlighter.highlight();
     }-*/;

    protected abstract void showSourceCode(String sourceCode);
}
