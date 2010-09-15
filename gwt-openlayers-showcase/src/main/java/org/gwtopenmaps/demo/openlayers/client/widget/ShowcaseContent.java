package org.gwtopenmaps.demo.openlayers.client.widget;

import org.gwtopenmaps.demo.openlayers.client.examples.MapExample;

import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.RequestBuilder;
import com.google.gwt.http.client.RequestCallback;
import com.google.gwt.http.client.Response;
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
public class ShowcaseContent extends TabPanel {

    private DockPanel examplePanel = new DockPanel();
    private MapExample mapExample;
    private HTMLPanel exampleDescription = new HTMLPanel("Description here.");

    private HTMLPanel srcPanel = new HTMLPanel("Source here.");

    public ShowcaseContent(){
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
    	replaceExampleDescription(x);
    }

    //TODO find out how to get pretty print source
    public void setExampleSource(String x) {
    	if(!(x.indexOf("http") == 0) && !(x.indexOf("file") == 0)){
    		replaceExampleSource(x);
    	} else {
    		RequestBuilder builder = new RequestBuilder(RequestBuilder.GET, x);
    		try { builder.sendRequest(null, new RequestCallback(){

				public void onError(Request request, Throwable exception) {
					replaceExampleSource("Error retreiving source.");
				}

				public void onResponseReceived(Request request,
						Response response) {
					replaceExampleSource(response.getText());
				}
    		});
    		} catch(Exception e){

    		}
    	}

    }

    public Panel getExamplePanel(){
        return this.examplePanel;
    }

    public Panel getSourcePanel(){
        return this.srcPanel;
    }

    public void replaceExampleSource(String html){
    	this.remove(srcPanel);
    	srcPanel = new HTMLPanel(html);
    	this.add(srcPanel, "source");
    }

    public void replaceExampleDescription(String html){
    	this.examplePanel.remove(exampleDescription);
    	exampleDescription = new HTMLPanel(html);
    	this.examplePanel.add(exampleDescription, DockPanel.SOUTH);
    }
}
