/*
 * Utility class with helper functions and workarounds for problematic JSNI cases.
 *
 * gwt_openlayers_util.relay
 *   Relays calls to OpenLayers functions that taken an Array parameter
 *   and perform an instanceof test for the type Array, and possible for other
 *   corner cases.
 *
 * @author
 */

//make namespacing object
if(!gwt_openlayers_util){ var gwt_openlayers_util = new Object(); }


//function for converting Object to Array
gwt_openlayers_util.convertToArray = function(o){
	var a = new Array();
	for(var i = 0, m = o.length; i < m; i++){
		a[i] = o[i];
	}
	return a;
}

//function for converting JSNI created javascript Object to plain javascript Object
//GWT created javascript objects fail instanceof Object test
//  TO DO make recursive
gwt_openlayers_util.convertToPlainObject = function(o){
	var obj = new Object();
	for(prop in o){
		var x = prop;
	}
	return obj;
}

//to get around the test: if(this.eventListeners instanceof Object){ ...}
gwt_openlayers_util.eventListenersToObject = function(options){
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
gwt_openlayers_util.relay = {

	/* copy, paste directly below here, adjust name of function, and specify body
		exampleRelayFnt : function(o){
	},
	*/

	//paste new relay function here

	writeArray : function(format, o){
		return format.write(gwt_openlayers_util.convertToArray(o));
	},

	createPolygon : function(o){
		return new OpenLayers.Geometry.Polygon(
			gwt_openlayers_util.convertToArray(o));
	},

	createLinearRing : function(o){
		return new OpenLayers.Geometry.LinearRing(
			gwt_openlayers_util.convertToArray(o));
	},

	createLineString : function(o){
		return new OpenLayers.Geometry.LineString(
			gwt_openlayers_util.convertToArray(o));
	},

	vectorAddFeatures : function(vector, o){
		vector.addFeatures(gwt_openlayers_util.convertToArray(o));
	}

}

/**
 * Does output sanitization on strings that are inserted into the html dom at runtime.
 *
 * This is to prevent XSS.
 *
 * Output sanitization should always be based on a whitelist.
 */
//TODO look for smarter solutions or enhance this function further
gwt_openlayers_util.sanitize = function(input){
	var originalInput = input;
	var whiteListRegEx = [
		new RegExp("<b>", "g"),
		new RegExp("</b>", "g"),
		new RegExp("<em>", "g"),
		new RegExp("</em>", "g"),
		new RegExp("<bdo dir=\"rtl\">", "g"),
		new RegExp("<bdo dir=\"ltr\">", "g"),
		new RegExp("</bdo>", "g")
	];

	for(var i = 0, max = whiteListRegEx.length; i < max; i++){
		input = input.replace(whiteListRegEx[i], "")
	}

	var whiteListCharsRegEx = /^[a-zA-Z0-9\.\s",';:\u00B0]+$/;
	if(whiteListCharsRegEx.test(input)){
		return originalInput;
	} else {
		return "attempt at unsafe dom insertion";
	}
}


