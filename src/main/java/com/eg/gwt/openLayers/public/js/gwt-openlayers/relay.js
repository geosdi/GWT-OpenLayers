
/*
 * The sole purpose of this class is to relay calls to OpenLayers functions that
 * take an Array as parameter and that fail if the type of the parameter is not Array.
 *  
 */

var gwt = {
    openlayers : {
        relay : {
       
            /* copy, paste directly below here, adjust name of function, and specify body
            exampleRelayFnt : function(o){
            },
            */
    
            //paste new relay function here

            createPolygon : function(o){
                return new OpenLayers.Geometry.Polygon(
                        gwt.openlayers.convertToArray(o));
            },
            
            createLinearRing : function(o){
                return new OpenLayers.Geometry.LinearRing(
                        gwt.openlayers.convertToArray(o));
            },
            
            createLineString : function(o){
                return new OpenLayers.Geometry.LineString(
                        gwt.openlayers.convertToArray(o));
            },
            
            vectorAddFeatures : function(vector, o){
                vector.addFeatures(gwt.openlayers.convertToArray(o));
            }
        },
        
        //convert array-like Object to array of type Array
        //object should be an array created using JObjectArray
        convertToArray : function(o){
            var a = new Array();
            for(var i = 0, m = o.length; i < m; i++){
                a[i] = o[i];
                return a;
            }
        }
    }
}