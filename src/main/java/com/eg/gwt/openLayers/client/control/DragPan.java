package com.eg.gwt.openLayers.client.control;

import com.eg.gwt.openLayers.client.Options;
import com.eg.gwt.openLayers.client.util.JSObject;

/**
 * @author Aaron Novstrup - Stottler Henke Associates, Inc.
 */
public class DragPan extends Control
{
   protected DragPan(JSObject element) {
      super(element);
   }

   public DragPan() {
      this(DragPanImpl.create());
   }
   
   public DragPan(Options options)
   {
      this(DragPanImpl.create(options.getJSObject()));
   }
   
   public DragPan(DragPanOptions options){
       this(DragPanImpl.create(options.getJSObject()));
   }
   
}
