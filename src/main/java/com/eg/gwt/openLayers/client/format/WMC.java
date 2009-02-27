package com.eg.gwt.openLayers.client.format;

import com.eg.gwt.openLayers.client.Map;
import com.eg.gwt.openLayers.client.util.JSObject;

/**
 *
 * A platform-independent description of a map, that can be retrieved
 * by a different client, to display that map in the second client.
 *
 * The WMC format written is extended with OpenLayers specific tags.
 *
 * Reference to WMC specification:
 * url
 *
 * Now also OWC (ViewContext):
 * url
 *
 * @author Edwin Commandeur - Atlis EJS
 *
 */
public class WMC extends Format {

	protected WMC(JSObject element) {
		super(element);
	}

	public WMC(){
		this(WMCImpl.create());
	}

	public String write(Map map){
		return FormatImpl.write(getJSObject(), map.getJSObject());
	}

	/**
	 *
	 * @param input
	 * @param options
	 * @return
	 */
	public Map read(String input, WMCOptions wmcOptions){
		Map map = Map.narrowToMap(FormatImpl.read(getJSObject(), input, wmcOptions.getJSObject()));
		return map;
	}


}
