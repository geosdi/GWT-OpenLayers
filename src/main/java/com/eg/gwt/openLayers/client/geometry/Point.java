package com.eg.gwt.openLayers.client.geometry;

import com.eg.gwt.openLayers.client.JSObject;
import com.eg.gwt.openLayers.client.OpenLayersWidget;

/**
 * 
 * @author Atlis EJS, Edwin Commandeur
 * 
 */
public class Point extends Geometry {

    public Point(JSObject point){
        super(point);
    }
    
    public Point(double x, double y) {
        super(PointImpl.create(x,y));
    }    
    
    public double getX(){
        return PointImpl.getX(getJSObject());
    }

    public double getY(){
        return PointImpl.getY(getJSObject());
    }
    
    public String getId(){
        return PointImpl.getId(getJSObject());
    }

    public void setX(double x){
        PointImpl.setX(getJSObject(), x);
    }
    
    public void setY(double y){
        PointImpl.setY(getJSObject(), y);
    }

}
