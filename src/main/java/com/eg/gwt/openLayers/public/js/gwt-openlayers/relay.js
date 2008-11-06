
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

//function for converting GWT enhanced javascript Object to plain javascript Object
//GWT enhances javascript object with the functions of Object from Java
//  TO DO make recursive
com.eg.gwt.openLayers.client.convertToPlainObject = function(o){
    var obj = new Object();
    for(prop in o){
        var x = prop;
    }
    return obj;
}

//code to get around the test: if(this.eventListeners instanceof Object){ ...}
com.eg.gwt.openLayers.client.eventListenersToObject = function(options){
    if(options.eventListeners){
        var obj = new Object();
        for(i in options.eventListeners){
            alert(i)
            obj[i] = options.eventListeners[i]
        }
        options.eventListeners = new Object();
        for(j in obj){
            options.eventListeners[j] = obj[j]
        }
    }
    return options;
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
