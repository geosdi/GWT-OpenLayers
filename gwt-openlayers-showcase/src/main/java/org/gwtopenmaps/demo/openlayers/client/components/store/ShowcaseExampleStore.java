/*
 * Copyright 2012 sourceforge.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.gwtopenmaps.demo.openlayers.client.components.store;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;
import org.gwtopenmaps.demo.openlayers.client.ExampleBean;
import org.gwtopenmaps.demo.openlayers.client.examples.TransformFeature.TransformFeatureExample;
import org.gwtopenmaps.demo.openlayers.client.examples.basicbing.BasicBingExample;
import org.gwtopenmaps.demo.openlayers.client.examples.basicgooglev3.BasicGoogleV3Example;
import org.gwtopenmaps.demo.openlayers.client.examples.basicosm.BasicOsmExample;
import org.gwtopenmaps.demo.openlayers.client.examples.basictms.BasicTmsExample;
import org.gwtopenmaps.demo.openlayers.client.examples.canceldrawing.CancelDrawingExample;
import org.gwtopenmaps.demo.openlayers.client.examples.custommouseposition.CustomMousePositionExample;
import org.gwtopenmaps.demo.openlayers.client.examples.graticule.GraticuleExample;
import org.gwtopenmaps.demo.openlayers.client.examples.linestring2multilinestring.LineString2MultiLineStringExample;
import org.gwtopenmaps.demo.openlayers.client.examples.location.LocationExample;
import org.gwtopenmaps.demo.openlayers.client.examples.measure.MeasureExample;
import org.gwtopenmaps.demo.openlayers.client.examples.refresh.WfsRefreshExample;
import org.gwtopenmaps.demo.openlayers.client.examples.rotatevector.RotateVectorExample;
import org.gwtopenmaps.demo.openlayers.client.examples.selectfeature.SelectFeatureExample;
import org.gwtopenmaps.demo.openlayers.client.examples.snap.SnapFeatureExample;
import org.gwtopenmaps.demo.openlayers.client.examples.undoredodrawing.UndoRedoDrawingExample;
import org.gwtopenmaps.demo.openlayers.client.examples.vector.VectorExample;
import org.gwtopenmaps.demo.openlayers.client.examples.wmsfeatureinfo.WmsFeatureInfoExample;
import org.gwtopenmaps.demo.openlayers.client.examples.wmsrefresh.WmsRefreshExample;
import org.gwtopenmaps.demo.openlayers.client.examples.wmswfs.WmsWfsExample;
import org.gwtopenmaps.demo.openlayers.client.examples.wmswfsedit.WmsWfsEditExample;

/**
 *
 * @author Giuseppe La Scaleia - CNR IMAA geoSDI Group
 * @email giuseppe.lascaleia@geosdi.org
 */
@Singleton
public class ShowcaseExampleStore implements ExampleStore {

    private boolean isStoreSorted;
    /**
     * TODO : Change this implementation using {@link HashMap}
     */
    private List<ExampleBean> examples = new ArrayList<ExampleBean>();
    //
    @Inject
    static TransformFeatureExample transformFeature;
    @Inject
    static BasicBingExample bingExample;
    @Inject
    static BasicGoogleV3Example basicGoogleExample;
    @Inject
    static BasicOsmExample osmExample;
    @Inject
    static BasicTmsExample tmsExample;
    @Inject
    static CancelDrawingExample drawningExample;
    @Inject
    static CustomMousePositionExample mousePositionExample;
    @Inject
    static GraticuleExample graticuleExample;
    @Inject
    static LineString2MultiLineStringExample lineString2MultiLineStringExample;
    @Inject
    static LocationExample locationExample;
    @Inject
    static MeasureExample measureExample;
    @Inject
    static WfsRefreshExample wfsRefreshExample;
    @Inject
    static RotateVectorExample rotateVectorExample;
    @Inject
    static SelectFeatureExample selectFeatureExample;
    @Inject
    static SnapFeatureExample snapFeatureExample;
    @Inject
    static UndoRedoDrawingExample undoRedoDrawingExample;
    @Inject
    static VectorExample vectorExample;
    @Inject
    static WmsFeatureInfoExample wmsFeatureInfoExample;
    @Inject
    static WmsRefreshExample wmsRefreshExample;
    @Inject
    static WmsWfsExample wmsWfsExample;
    @Inject
    static WmsWfsEditExample wmsWfsEditExample;

    public ShowcaseExampleStore() {
        addExample(transformFeature.getExample());
        addExample(bingExample.getExample());
        addExample(basicGoogleExample.getExample());
        addExample(osmExample.getExample());
        addExample(tmsExample.getExample());
        addExample(drawningExample.getExample());
        addExample(mousePositionExample.getExample());
        addExample(graticuleExample.getExample());
        addExample(lineString2MultiLineStringExample.getExample());
        addExample(locationExample.getExample());
        addExample(measureExample.getExample());
        addExample(wfsRefreshExample.getExample());
        addExample(rotateVectorExample.getExample());
        addExample(selectFeatureExample.getExample());
        addExample(snapFeatureExample.getExample());
        addExample(undoRedoDrawingExample.getExample());
        addExample(vectorExample.getExample());
        addExample(wmsFeatureInfoExample.getExample());
        addExample(wmsRefreshExample.getExample());
        addExample(wmsWfsExample.getExample());
        addExample(wmsWfsEditExample.getExample());
    }

    public final void addExample(ExampleBean example) {
        this.examples.add(example);
    }

    public void sortStore() {
        if (!isStoreSorted) {
            Collections.sort(examples);
            this.isStoreSorted = true;
        }
    }

    public List<ExampleBean> getExamples() {
        return Collections.unmodifiableList(examples);
    }
}
