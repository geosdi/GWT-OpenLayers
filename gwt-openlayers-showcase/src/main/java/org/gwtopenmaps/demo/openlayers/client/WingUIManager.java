/**
 *
 */
package org.gwtopenmaps.demo.openlayers.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.LayoutPanel;
import com.google.gwt.user.client.ui.SplitLayoutPanel;
import com.google.gwt.user.client.ui.Widget;


/**
 * @author fizzi
 *
 */
public class WingUIManager extends Composite implements HasText
{

    private static WingUIManagerUiBinder uiBinder = GWT.create(WingUIManagerUiBinder.class);

    @UiField
    LayoutPanel mapZone;

    @UiField
    FlowPanel westCenterZone;
    @UiField
    FlowPanel southWestZone;

    public WingUIManager()
    {
        initWidget(uiBinder.createAndBindUi(this));
    }

    public WingUIManager(String firstName)
    {
        initWidget(uiBinder.createAndBindUi(this));

    }

    public LayoutPanel getMapZone()
    {
        return mapZone;
    }

    public void setMapZone(LayoutPanel mapZone)
    {
        this.mapZone = mapZone;
    }


    public FlowPanel getWestCenterZone()
    {
        return westCenterZone;
    }

    public void setWestCenterZone(FlowPanel westCenterZone)
    {
        this.westCenterZone = westCenterZone;
    }

    public FlowPanel getSouthWestZone()
    {
        return southWestZone;
    }

    public void setSouthWestZone(FlowPanel southWestZone)
    {
        this.southWestZone = southWestZone;
    }

    public String getText()
    {
        // TODO Auto-generated method stub
        return null;
    }

    public void setText(String text)
    {
        // TODO Auto-generated method stub

    }

    interface WingUIManagerUiBinder extends UiBinder<Widget, WingUIManager>
    {
    }

}
