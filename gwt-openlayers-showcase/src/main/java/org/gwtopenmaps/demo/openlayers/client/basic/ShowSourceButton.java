package org.gwtopenmaps.demo.openlayers.client.basic;

import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.ScrollPanel;
import org.gwtopenmaps.demo.openlayers.client.DialogBoxWithCloseButton;
import org.gwtopenmaps.demo.openlayers.client.components.ShowcaseSearchPanel;

/**
 *
 * @author Frank Wynants
 *
 * @author Giuseppe La Scaleia - CNR IMAA geoSDI Group
 * @email giuseppe.lascaleia@geosdi.org
 */
public class ShowSourceButton extends AbstractSourceButton {

    protected void showSourceCode(String sourceCode) {
        sourceCode = sourceCode.replaceAll("<", "&lt,").replace(">", "&gt;");

        final String html = "<pre class=\"brush: java; toolbar: false;\">" + sourceCode + "</pre>";
        ScrollPanel sp = new ScrollPanel();
        sp.setSize((Window.getClientWidth() * 0.6) + "px",
                   (Window.getClientHeight() * 0.7) + "px");
        sp.add(new HTML(html));

        DialogBoxWithCloseButton dialogBox = new DialogBoxWithCloseButton(false);
        dialogBox.setWidget(sp);
        dialogBox.setText(ShowcaseSearchPanel.I18N.viewSource());
        dialogBox.center();

        super.doFormat();
    }
}
