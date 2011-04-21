package org.gwtopenmaps.openlayers.client.style;

import org.gwtopenmaps.openlayers.client.util.JSObject;
import org.gwtopenmaps.openlayers.client.util.JSObjectWrapper;

/**
 * 
 * @author Maciej Jezierski - Pinocchio
 *
 * This class represents an SLD Rule, as being used for rule-based SLD styling.
 */

public class Rule extends JSObjectWrapper{

	public Rule(JSObject options) {
		super(RuleImpl.create(options));
	}

	public Rule() {
		super(RuleImpl.create());
	}
	
}
