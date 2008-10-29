package com.eg.gwt.openLayers.client.layer;

public class WMSExtraParams extends LayerOptions {

    /**
     * By default singleTile is set to false.
     * Using this method the singleTile property can be set to true.
     * The map is served as a single tile instead of in separate tiles, 
     * when singleTile is true.
     * 
     * Why tile or not tile?
     *  TO DO insert some suggestions here
     */
    public void setSingleTile(boolean b){
        setAttribute("singleTile", b);
    }
   
    
    public void setUntiled(){
        setSingleTile(true);
    }
    
    
    public void setTransitionEffect(String transition){
        setAttribute("transitionEffect", transition);
    }
    /**
     * From the OpenLayers examples:
     * The 'resize' effect resamples the current tile and displays it stretched 
     * or compressed until the new tile is available.
     */
    public void setResizeTransitionEffect(){
        setTransitionEffect("resize");
    }
}
