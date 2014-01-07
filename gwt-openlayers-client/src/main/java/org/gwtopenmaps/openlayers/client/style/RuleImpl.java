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
package org.gwtopenmaps.openlayers.client.style;

import org.gwtopenmaps.openlayers.client.filter.Filter;
import org.gwtopenmaps.openlayers.client.util.JSObject;


public class RuleImpl
{
    public static native JSObject create() /*-{
        return new $wnd.OpenLayers.Rule();
    }-*/;

    public static native JSObject create(JSObject options) /*-{
        return $wnd.OpenLayers.Rule(options);
    }-*/;

    public static native void setId(JSObject self, String id) /*-{
        self.id = id;
    }-*/;

    public static native String getId(JSObject self) /*-{
        return self.id;
    }-*/;

    public static native void setName(JSObject self, String name) /*-{
        self.name = name;
    }-*/;

    public static native void setTitle(JSObject self, String title) /*-{
        self.title = title;
    }-*/;

    public static native void setDescription(JSObject self, String description) /*-{
        self.description = description;
    }-*/;

    public static native void setContext(JSObject self, JSObject context) /*-{
        self.context = context;
    }-*/;

    public static native void setFilter(JSObject self, Filter filter) /*-{
        self.filter = filter;
    }-*/;

    public static native void setElseFilter(JSObject self, boolean elseFilter) /*-{
        self.elseFilter = elseFilter;
    }-*/;

    public static native void setSymbolizer(JSObject self, Symbolizer symbolizer) /*-{
        self.symbolizer = symbolizer;
    }-*/;

    public static native void setSymbolizer(JSObject self, JSObject hashSymbolizer) /*-{
        self.symbolizer = hashSymbolizer;
    }-*/;

    public static native void setSymbolizer(JSObject self, Symbolizer[] symbolizer) /*-{
        self.symbolizers = symbolizer;
    }-*/;

    public static native void setMinScaleDenominator(JSObject self, int scale) /*-{
        self.minScaleDenominator = scale;
    }-*/;

    public static native void setMaxScaleDenominator(JSObject self, int scale) /*-{
        self.maxScaleDenominator = scale;
    }-*/;

    public static native void destroy(JSObject self) /*-{
        self.destroy();
    }-*/;

    public static native boolean evaluate(JSObject self, JSObject feature) /*-{
        return self.evaluate(feature);
    }-*/;

    public static native void setFilter(JSObject self, JSObject filter)
    /*-{
        self.filter = filter;
    }-*/;
}