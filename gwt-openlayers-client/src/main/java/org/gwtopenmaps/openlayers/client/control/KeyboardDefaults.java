package org.gwtopenmaps.openlayers.client.control;

import org.gwtopenmaps.openlayers.client.util.JSObject;

/**
 *
 * KeyBoardDefaults control wrapper.
 *
 * @author Martin Hultman - Swedish Meteorological and Hydrological Institute
 */
public class KeyboardDefaults extends Control {

	protected KeyboardDefaults(JSObject element) {
		super(element);
	}

	public KeyboardDefaults() {
		this(KeyboardDefaultsImpl.create());
	}

	public KeyboardDefaults(KeyboardDefaultOptions keyboardDefaultOptions) {
		this(KeyboardDefaultsImpl.create(keyboardDefaultOptions.getJSObject()));
	}

}
