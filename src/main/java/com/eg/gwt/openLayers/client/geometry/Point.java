package com.eg.gwt.openLayers.client.geometry;

import com.eg.gwt.openLayers.client.JSObject;

/**
 * @author Edwin Commandeur - Atlis EJS
 * 
 */
public class Point extends Geometry {

    protected Point(JSObject point){
        super(point);
    }
    
    public Point(double x, double y) {
        super(PointImpl.create(x,y));
    }    
    
    public static Point narrowToPoint(JSObject point){
        return (point == null)?null: new Point(point);
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

    public double[] getXY(){
        double[] xy = {this.getX(), this.getY()};
        return xy;
    }
    
    public void setXY(double x, double y){
        this.setX(x);
        this.setY(y);
    }
}
