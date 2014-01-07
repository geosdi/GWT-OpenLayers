/**
 *
 *   Copyright 2014 sourceforge.
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
package org.gwtopenmaps.demo.openlayers.client;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Image;

/**
 * Een infopanel om algemene informatie aan de gebruiker te tonen.
 * <h2>CSS</h2>
 * <ul>
 * <li>infopanel</li>
 * </ul>
 *
 * @author fks/Robin Heymans, Bert Roex
 *
 */
public class InfoPanel extends Composite
{
    /**
     * The HTML widget that contains the message.
     */
    private HTML lblMessage = new HTML();

    /**
     * Maak een nieuw infopanel.
     *
     * @param message Het weer te geven bericht
     */
    public InfoPanel(String message)
    {
        HorizontalPanel container = new HorizontalPanel();
        Image imgInfo = new Image(Resources.INSTANCE.icon_info());
        lblMessage.setHTML(message);

        container.add(imgInfo);
        container.add(lblMessage);
        container.setCellWidth(imgInfo, "70px");
        container.setCellHorizontalAlignment(imgInfo, HasHorizontalAlignment.ALIGN_CENTER);
        container.setCellVerticalAlignment(lblMessage, HasVerticalAlignment.ALIGN_MIDDLE);
        container.setCellVerticalAlignment(imgInfo, HasVerticalAlignment.ALIGN_MIDDLE);

        initWidget(container);
        setStyleName("infopanel");
        setSize("480px", "60px");
    }

    /**
     * Sets the text shown in the infopanel.
     * @param message The HTML message to show
     */
    public void setText(String message)
    {
        lblMessage.setHTML(message);
    }
}
