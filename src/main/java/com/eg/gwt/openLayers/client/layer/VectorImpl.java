package com.eg.gwt.openLayers.client.layer;

import com.eg.gwt.openLayers.client.util.JSObject;

/**
 * 
 * @author Erdem Gunay
 * @author Edwin Commandeur - Atlis EJS
 * @author Curtis Jensen
 *
 */
class VectorImpl {

    public static native JSObject create(String name) /*-{
         return new $wnd.OpenLayers.Layer.Vector(name); 
    }-*/;

    public static native JSObject create(String name, JSObject options) /*-{
        return new $wnd.OpenLayers.Layer.Vector(name, options);
    }-*/;
    
    public static native void addFeature(JSObject self, JSObject feature) /*-{
        self.addFeatures(feature);
    }-*/;
    
    public static native void addFeatures(JSObject self, JSObject features) /*-{
         $wnd.gwt_openlayers_util.relay.vectorAddFeatures(self, features);
    }-*/;
    
    public static native JSObject getFeature(JSObject self, int index) /*-{
        return self.features[index];
    }-*/;
    
    public static native int getNumberOfFeatures(JSObject self) /*-{
        if(self.features){
            return self.features.length;
        } else {
            return -1;
        }
    }-*/;
    
    public static native void destroyFeatures(JSObject self) /*-{
        self.destroyFeatures();
    }-*/;
    
    public static native JSObject getFeatureById(JSObject self, String id) /*-{
        return self.getFeatureById(id);
    }-*/;

	public static native void redraw(JSObject vector)/*-{
		vector.redraw();
	}-*/;
	
	public static native void drawFeature(JSObject vector, JSObject feature, JSObject style)/*-{
		vector.drawFeature(feature, style);
	}-*/;
	
	public static native void eraseFeatures(JSObject vector)/*-{
		vector.eraseFeatures();
	}-*/;
	
	public static native void removeFeature(JSObject vector, JSObject feature)/*-{
    	vector.removeFeatures(feature);
	}-*/;

}
