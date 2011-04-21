package org.gwtopenmaps.openlayers.client.style;

import org.gwtopenmaps.openlayers.client.util.JSObject;
import org.gwtopenmaps.openlayers.client.util.JSObjectWrapper;

public class Rule extends JSObjectWrapper{

	public Rule(JSObject options) {
		super(RuleImpl.create(options));
	}

	public Rule() {
		super(RuleImpl.create());
	}
	
}
