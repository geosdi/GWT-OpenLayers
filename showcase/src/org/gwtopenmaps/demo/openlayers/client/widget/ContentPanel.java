package org.gwtopenmaps.demo.openlayers.client.widget;

import org.gwtopenmaps.demo.openlayers.client.examples.MapExample;

import com.google.gwt.user.client.ui.DockPanel;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.TabPanel;


/**
 *
 * @author Edwin Commandeur - Atlis EJS
 *
 * TODO make this a composite
 */
public class ContentPanel extends TabPanel {

    private DockPanel examplePanel = new DockPanel();
    private MapExample mapExample;
    private HTMLPanel exampleDescription = new HTMLPanel("description here");

    private HTMLPanel srcPanel = new HTMLPanel("source here");

    public ContentPanel(){
        //examplePanel.add(mapExample, DockPanel.CENTER);
        examplePanel.add(exampleDescription, DockPanel.SOUTH);
        add(examplePanel, "example");
        add(srcPanel, "source");
        this.selectTab(0);
    }

    public void setExample(MapExample x){
        if(mapExample != null){
            mapExample.destroy();
            examplePanel.remove(mapExample);
        }
        examplePanel.add(x, DockPanel.CENTER);
        mapExample = x;
    }

    public void setExampleDescription(String x){

    }

    //TODO find out how to get pretty print source
    public void setExampleSource(String x) {

    }

    public Panel getExamplePanel(){
        return this.examplePanel;
    }

    public Panel getSourcePanel(){
        return this.srcPanel;
    }

}
