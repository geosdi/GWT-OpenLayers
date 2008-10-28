
/*
 * The sole purpose of this class is to relay calls to OpenLayers functions that
 * take an Array as parameter and that fail if the type of the parameter is not Array.
 *  
 * This is because GWT breaks type of Array when crossing JSNI/JS boundary.
 */

//make namespacing object
if(!com){
    var com = new Object();
    if(!com.eg){
        com.eg = new Object();
        if(!com.eg.gwt){
            com.eg.gwt = new Object();
            if(!com.eg.gwt.openLayers){
                com.eg.gwt.openLayers = new Object();
                if(!com.eg.gwt.openLayers.client){
                    com.eg.gwt.openLayers.client = new Object();
                }
            }
        }
    }
}

//function for converting Object to Array
com.eg.gwt.openLayers.client.convertToArray = function(o){
    var a = new Array();
    for(var i = 0, m = o.length; i < m; i++){
        a[i] = o[i];
    }
    return a;
}

//relay functions
com.eg.gwt.openLayers.client.relay = {

        /* copy, paste directly below here, adjust name of function, and specify body
        exampleRelayFnt : function(o){
        },
        */

        //paste new relay function here

        createPolygon : function(o){
            return new OpenLayers.Geometry.Polygon(
                    com.eg.gwt.openLayers.client.convertToArray(o));
        },
        
        createLinearRing : function(o){
            return new OpenLayers.Geometry.LinearRing(
                    com.eg.gwt.openLayers.client.convertToArray(o));
        },
        
        createLineString : function(o){
            return new OpenLayers.Geometry.LineString(
                    com.eg.gwt.openLayers.client.convertToArray(o));
        },
        
        vectorAddFeatures : function(vector, o){
            vector.addFeatures(com.eg.gwt.openLayers.client.convertToArray(o));
        }
}
