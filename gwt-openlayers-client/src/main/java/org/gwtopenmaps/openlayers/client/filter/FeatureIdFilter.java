package org.gwtopenmaps.openlayers.client.filter;

import org.gwtopenmaps.openlayers.client.util.JStringArray;

/**
 * @author Mikael Couzic
 */
public class FeatureIdFilter extends Filter {

	public FeatureIdFilter(String[] fids) {
		super(FeatureIdFilterImpl.create(new JStringArray(fids).getJSObject()));
	}

}
