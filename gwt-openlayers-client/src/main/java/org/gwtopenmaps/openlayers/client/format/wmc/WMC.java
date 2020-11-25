/*
 *
 *   Copyright 2015 GWT OpenLayers Team.
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
package org.gwtopenmaps.openlayers.client.format.wmc;

import org.gwtopenmaps.openlayers.client.Map;
import org.gwtopenmaps.openlayers.client.format.Format;
import org.gwtopenmaps.openlayers.client.format.FormatImpl;
import org.gwtopenmaps.openlayers.client.util.JSObject;

/**
 *
 * A platform-independent description of a map, that can be retrieved by a
 * different client, to display that map in the second client.
 *
 * The WMC format written is extended with OpenLayers specific tags.
 *
 * Reference to WMC specification: url
 *
 * Now also OWC (ViewContext): url
 *
 * @author Edwin Commandeur - Atlis EJS
 *
 */
public class WMC extends Format<Map, String> {

    private WMCOptions wmcOptions;

    protected WMC(JSObject element) {
        super(element);
    }

    public WMC(WMCOptions theWMCOptions) {
        this(WMCImpl.create());
        this.wmcOptions = theWMCOptions;
    }

    public WMC() {
        this(new WMCOptions());
    }

    /**
     *
     * @param map
     *
     * @return {@link String} string
     */
    @Override
    public String write(Map map) {
        return FormatImpl.write(getJSObject(), map.getJSObject());
    }

    /**
     *
     * @param input
     *
     * @return {@link Map} map
     */
    @Override
    public Map read(String input) {
        if (this.wmcOptions == null) {
            throw new IllegalStateException("The property wmcOptions must not "
                    + "be null.");
        }
        Map map = Map.narrowToMap(FormatImpl.read(getJSObject(), input,
                this.wmcOptions.getJSObject()));

        return map;
    }

    /**
     * @return the wmcOption
     */
    public WMCOptions getWmcOptions() {
        return wmcOptions;
    }

    /**
     * <p>
     * The {@link WMCOptions} wmcOptions to use for read operation.
     * </p>
     *
     * @param wmcOptions the wmcOptions to set
     */
    public void setWmcOptions(WMCOptions wmcOptions) {
        this.wmcOptions = wmcOptions;
    }

}
