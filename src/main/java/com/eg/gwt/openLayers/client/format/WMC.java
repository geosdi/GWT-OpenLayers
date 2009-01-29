/**
 *
 */
package com.eg.gwt.openLayers.client.format;

import com.eg.gwt.openLayers.client.JSObject;

/**
 *
 * Brief explanation of WMC format here.
 *
 * Reference to WMC specification.
 *
 * Now also OWC (ViewContext)
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

}
