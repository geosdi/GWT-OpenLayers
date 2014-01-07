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
package org.gwtopenmaps.demo.openlayers.client.basic;

import com.google.gwt.user.client.ui.LayoutPanel;
import com.google.gwt.user.client.ui.Widget;
import java.util.ArrayList;
import org.gwtopenmaps.openlayers.client.Map;
import org.gwtopenmaps.openlayers.client.MapOptions;
import org.gwtopenmaps.openlayers.client.MapWidget;

public class MapExample extends LayoutPanel {

    private MapOptions defaultMapOptions;
    // private MapWidget mapWidget;
    private Map map;
    private ArrayList<Widget> widgets = new ArrayList<Widget>();

    public MapExample() {
        this.defaultMapOptions = new MapOptions();

        // In OL, the map gets PanZoom, Navigation, ArgParser, and Attribution Controls
        // by default. Do removeDefaultControls to remove these.
        this.defaultMapOptions.removeDefaultControls();
        this.defaultMapOptions.setNumZoomLevels(16);
        this.defaultMapOptions.setProjection("EPSG:4326");
        initMapWidget(this.defaultMapOptions);
    }

    public MapExample(MapOptions options) {
        this.defaultMapOptions = options;
        initMapWidget(options);
    }

    private void initMapWidget(MapOptions options) {
        MapWidget mapWidget = new MapWidget("100%", "100%", options);
        this.map = mapWidget.getMap();
        add(mapWidget);

    }

    public Map getMap() {
        return this.map;
    }

    public void destroy() {
        this.map.destroy();

        for (int i = 0, max = widgets.size(); i < max; i++) {
            this.remove(widgets.get(i));
        }
    }

    @Override
    public void add(Widget w) {
        super.add(w);
    }
}
