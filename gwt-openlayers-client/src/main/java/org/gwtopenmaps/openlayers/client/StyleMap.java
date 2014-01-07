/**
 *
 *   Copyright 2014 sourceforge.
 *
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 */
package org.gwtopenmaps.openlayers.client;

import org.gwtopenmaps.openlayers.client.feature.VectorFeature;
import org.gwtopenmaps.openlayers.client.style.Rule;
import org.gwtopenmaps.openlayers.client.util.JObjectArray;
import org.gwtopenmaps.openlayers.client.util.JSObject;

/**
 *
 * StyleMap contais a set of tree styles
 * <ul>
 * <li>default : the default style to render the feature </li>
 * <li>select : the style to render the feature when it is selected </li>
 * <li> temporary: style to render the feature when it is temporarily selected </li>
 * </ul>
 *
 * @author Rafael Ceravolo - LOGANN
 * @author Lukas Johansson
 */
public class StyleMap extends OpenLayersObjectWrapper {

	protected StyleMap(JSObject openLayersObject) {
		super(openLayersObject);
	}

	/**
	 * Creates a StyleMap with default properties
	 */
	public StyleMap() {
		this(StyleMapImpl.create());
	}

	/**
	 * Creates a StyleMap setting the same style for all renderer intents.
	 * <p>
	 * From OpenLayers documentation: If just one style hash or style object is
	 * passed, this will be used for all known render intents (default, select,
	 * temporary)
	 */
	public StyleMap(Style style) {
		this(
			StyleMapImpl.create(
				style.getJSObject(),
				style.getJSObject(),
				style.getJSObject()
			)
		);
	}

	/**
	 * Creates a StyleMap setting different styles for renderer intents.
	 * <p>
	 * Avoid passing null for one of the styles. If just want to use 2 style,
	 * pass the same style for selectStyle and tempraryStyle parameters.
	 *
	 * @param defaultStyle
	 *            the default style to render the feature
	 * @param selectStyle
	 *            the style to render the feature when it is selected
	 * @param temporaryStyle
	 *            style to render the feature when it is temporarily selected
	 */
	public StyleMap(Style defaultStyle, Style selectStyle, Style temporaryStyle) {
		this(
			StyleMapImpl.create(
				defaultStyle == null ? null : defaultStyle.getJSObject(),
				selectStyle == null ? null : selectStyle.getJSObject(),
				temporaryStyle == null ? null : temporaryStyle.getJSObject()
			)
		);
	}

    public StyleMap(OpenLayersStyle defaultStyle, OpenLayersStyle selectStyle, OpenLayersStyle temporaryStyle) {
		this(
				defaultStyle == null ? null : defaultStyle.getJSObject(),
				selectStyle == null ? null : selectStyle.getJSObject(),
				temporaryStyle == null ? null : temporaryStyle.getJSObject()
		);
	}

    private StyleMap(JSObject defaultStyle, JSObject selectStyle, JSObject temporaryStyle) {
        this(StyleMapImpl.create(defaultStyle, selectStyle, temporaryStyle));
    }

	public static StyleMap narrowToOpenLayersStyleMap(JSObject element) {
		return (element == null) ? null: new StyleMap(element);
	}

	public Style createSymbolizer(VectorFeature feature, String renderIntent){
		return Style.narrowToOpenLayersStyle(
			StyleImpl.createSymbolizer(
				getJSObject(),
				feature.getJSObject(),
				renderIntent
			)
		);
	}

	/**
	 * Add rules to the given Style of a StyleMap
	 * @param rules The rules to add
	 * @param symbolizer The symbolizer of the style (default, temporary, select, delete, ...)
	 * @return
	 */
    public void addRules(Rule[] rules, String symbolizer)
    {
        JObjectArray array = new JObjectArray(rules);
        JSObject style = getJSObject().getProperty("styles").getProperty(symbolizer);
        StyleImpl.addRules(style, array.getJSObject());
    }
}
