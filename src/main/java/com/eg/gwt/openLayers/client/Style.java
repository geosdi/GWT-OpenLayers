package com.eg.gwt.openLayers.client;

import com.eg.gwt.openLayers.client.util.JSObject;

/**
 * @author Edwin Commandeur - Atlis EJS
 *
 */
public class Style extends OpenLayersWidget{
    
    public static final String STROKE_DASHSTYLE_SOLID = "solid";
    public static final String STROKE_DASHSTYLE_DASHDOT = "dashdot";
    
    
    protected Style(JSObject element){
        super(element);
    }
    
    public Style() {
        this(StyleImpl.create());
    }

    /**
     * @param c - hexidecimal color code or a W3C standard color name 
     */
    public void setFillColor(String c){
        StyleImpl.setFillColor(getJSObject(), c);
    }
    
    public String getFillColor(){
        return StyleImpl.getFillColor(getJSObject());
    }
    
    public void setFillOpacity(double o){
        StyleImpl.setFillOpacity(getJSObject(), o);
    }
    
    public double getFillOpacity(){
        double o = StyleImpl.getFillOpacity(getJSObject());
        return o;
    }

    public void setPointRadius(double r){
        StyleImpl.setPointRadius(getJSObject(), r);
    }

    public double getPointRadius(){
        return StyleImpl.getPointRadius(getJSObject());
    }

    
    /**
     * @param c - see setFillColor 
     */
    public void setStrokeColor(String c){
        StyleImpl.setStrokeColor(getJSObject(), c);
    }
    
    public String getStrokeColor(){
        return StyleImpl.getStrokeColor(getJSObject());
    }

    public void setStrokeWidth(double w){
        StyleImpl.setStrokeWidth(getJSObject(), w);
    }
    
    public double getStrokeWidth(){
        return StyleImpl.getStrokeWidth(getJSObject());
    }    
    
}
