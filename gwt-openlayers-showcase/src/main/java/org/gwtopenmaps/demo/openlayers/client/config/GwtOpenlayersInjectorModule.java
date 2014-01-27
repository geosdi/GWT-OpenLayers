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
package org.gwtopenmaps.demo.openlayers.client.config;

import javax.inject.Singleton;

import org.gwtopenmaps.demo.openlayers.client.config.provider.ShowcaseLogoProvider;
import org.gwtopenmaps.demo.openlayers.client.examples.TransformFeature.TransformFeatureExample;
import org.gwtopenmaps.demo.openlayers.client.examples.basicbing.BasicBingExample;
import org.gwtopenmaps.demo.openlayers.client.examples.basicgooglev3.BasicGoogleV3Example;
import org.gwtopenmaps.demo.openlayers.client.examples.basicosm.BasicOsmExample;
import org.gwtopenmaps.demo.openlayers.client.examples.basicosm.BasicOsmUrlExample;
import org.gwtopenmaps.demo.openlayers.client.examples.basictms.BasicTmsExample;
import org.gwtopenmaps.demo.openlayers.client.examples.canceldrawing.CancelDrawingExample;
import org.gwtopenmaps.demo.openlayers.client.examples.click.ClickExample;
import org.gwtopenmaps.demo.openlayers.client.examples.cluster.AnimatedClusterStrategyTreshHoldExample;
import org.gwtopenmaps.demo.openlayers.client.examples.cluster.AnimatedClusterWithPopup;
import org.gwtopenmaps.demo.openlayers.client.examples.cluster.ClusterStrategyTreshHoldExample;
import org.gwtopenmaps.demo.openlayers.client.examples.cql.CqlWmsExample;
import org.gwtopenmaps.demo.openlayers.client.examples.custommouseposition.CustomMousePositionExample;
import org.gwtopenmaps.demo.openlayers.client.examples.dragfeature.DragFeatureExample;
import org.gwtopenmaps.demo.openlayers.client.examples.drawfeature.DrawRegularPolygonExample;
import org.gwtopenmaps.demo.openlayers.client.examples.drawfeaturestyle.DrawFeatureStyleExample;
import org.gwtopenmaps.demo.openlayers.client.examples.emptylayer.EmptyLayerExample;
import org.gwtopenmaps.demo.openlayers.client.examples.featurepopup.FeaturePopupExample;
import org.gwtopenmaps.demo.openlayers.client.examples.filter.ComparisonAndLogicalFilterExample;
import org.gwtopenmaps.demo.openlayers.client.examples.filter.FeatureIdFilterExample;
import org.gwtopenmaps.demo.openlayers.client.examples.filter.SpatialFilterExample;
import org.gwtopenmaps.demo.openlayers.client.examples.geodesiclength.GeodesicLengthExample;
import org.gwtopenmaps.demo.openlayers.client.examples.geojson.GeoJsonExample;
import org.gwtopenmaps.demo.openlayers.client.examples.geojson.GeoJsonFromGitHub;
import org.gwtopenmaps.demo.openlayers.client.examples.geolocate.GeolocateExample;
import org.gwtopenmaps.demo.openlayers.client.examples.graticule.GraticuleExample;
import org.gwtopenmaps.demo.openlayers.client.examples.imagelayer.ImageLayerExample;
import org.gwtopenmaps.demo.openlayers.client.examples.kml.KmlExample;
import org.gwtopenmaps.demo.openlayers.client.examples.label.LabelOverLeapExample;
import org.gwtopenmaps.demo.openlayers.client.examples.label.Labels;
import org.gwtopenmaps.demo.openlayers.client.examples.linestring2multilinestring.LineString2MultiLineStringExample;
import org.gwtopenmaps.demo.openlayers.client.examples.location.LocationExample;
import org.gwtopenmaps.demo.openlayers.client.examples.measure.MeasureExample;
import org.gwtopenmaps.demo.openlayers.client.examples.measure.StyledMeasureExample;
import org.gwtopenmaps.demo.openlayers.client.examples.minmaxzoom.MinMaxZoomExample;
import org.gwtopenmaps.demo.openlayers.client.examples.polygonselect.PolygonSelect;
import org.gwtopenmaps.demo.openlayers.client.examples.refresh.WfsRefreshExample;
import org.gwtopenmaps.demo.openlayers.client.examples.rotatevector.RotateVectorExample;
import org.gwtopenmaps.demo.openlayers.client.examples.rule.RuleExample;
import org.gwtopenmaps.demo.openlayers.client.examples.scale.ScaleExample;
import org.gwtopenmaps.demo.openlayers.client.examples.selectfeature.SelectFeatureExample;
import org.gwtopenmaps.demo.openlayers.client.examples.snap.SnapFeatureExample;
import org.gwtopenmaps.demo.openlayers.client.examples.undoredodrawing.UndoRedoDrawingExample;
import org.gwtopenmaps.demo.openlayers.client.examples.variablewfsstyle.VariableWfsStyle;
import org.gwtopenmaps.demo.openlayers.client.examples.vector.ClickFeatureListenerExample;
import org.gwtopenmaps.demo.openlayers.client.examples.vector.GetFeatureBoxSelectionExample;
import org.gwtopenmaps.demo.openlayers.client.examples.vector.GetFeatureClickSelectionExample;
import org.gwtopenmaps.demo.openlayers.client.examples.vector.HoverAndSelectExample;
import org.gwtopenmaps.demo.openlayers.client.examples.vector.VectorExample;
import org.gwtopenmaps.demo.openlayers.client.examples.vector.VectorResizeImageExample;
import org.gwtopenmaps.demo.openlayers.client.examples.vector.WellKnownGraphicExample;
import org.gwtopenmaps.demo.openlayers.client.examples.wfshoverhighlight.WfsHoverHighlightExample;
import org.gwtopenmaps.demo.openlayers.client.examples.wmsPost.WmsPostExample;
import org.gwtopenmaps.demo.openlayers.client.examples.wmsfeatureinfo.WmsFeatureInfoExample;
import org.gwtopenmaps.demo.openlayers.client.examples.wmsrefresh.WmsRefreshExample;
import org.gwtopenmaps.demo.openlayers.client.examples.wmswfs.WmsWfsExample;
import org.gwtopenmaps.demo.openlayers.client.examples.wmswfsedit.WmsWfsEditExample;
import org.gwtopenmaps.demo.openlayers.client.examples.wmts.WMTSExample;
import org.gwtopenmaps.demo.openlayers.client.examples.xyzlayer.XYZLayerExample;
import org.gwtopenmaps.demo.openlayers.client.puregwt.ShowcaseEventBus;
import org.gwtopenmaps.demo.openlayers.client.puregwt.ShowcaseEventBusImpl;

import com.google.gwt.inject.client.AbstractGinModule;
import com.google.gwt.user.client.ui.Image;

/**
 *
 * @author Giuseppe La Scaleia - CNR IMAA geoSDI Group
 * @email giuseppe.lascaleia@geosdi.org
 */
public class GwtOpenlayersInjectorModule extends AbstractGinModule {

    @Override
    protected void configure() {
        bind(ShowcaseEventBus.class).to(ShowcaseEventBusImpl.class).in(
                Singleton.class);

        bind(Image.class).toProvider(ShowcaseLogoProvider.class).in(
                Singleton.class);

        bind(TransformFeatureExample.class).asEagerSingleton();
        bind(BasicBingExample.class).asEagerSingleton();
        bind(BasicGoogleV3Example.class).asEagerSingleton();
        bind(BasicOsmExample.class).asEagerSingleton();
        bind(BasicOsmUrlExample.class).asEagerSingleton();
        bind(BasicTmsExample.class).asEagerSingleton();
        bind(CancelDrawingExample.class).asEagerSingleton();
        bind(CustomMousePositionExample.class).asEagerSingleton();
        bind(GraticuleExample.class).asEagerSingleton();
        bind(LineString2MultiLineStringExample.class).asEagerSingleton();
        bind(LocationExample.class).asEagerSingleton();
        bind(MeasureExample.class).asEagerSingleton();
        bind(StyledMeasureExample.class).asEagerSingleton();
        bind(WfsRefreshExample.class).asEagerSingleton();
        bind(RotateVectorExample.class).asEagerSingleton();
        bind(SelectFeatureExample.class).asEagerSingleton();
        bind(SnapFeatureExample.class).asEagerSingleton();
        bind(UndoRedoDrawingExample.class).asEagerSingleton();
        bind(VectorExample.class).asEagerSingleton();
        bind(WmsFeatureInfoExample.class).asEagerSingleton();
        bind(WmsRefreshExample.class).asEagerSingleton();
        bind(WmsWfsExample.class).asEagerSingleton();
        bind(WmsWfsEditExample.class).asEagerSingleton();
        bind(CqlWmsExample.class).asEagerSingleton();
        bind(VariableWfsStyle.class).asEagerSingleton();
        bind(WfsHoverHighlightExample.class).asEagerSingleton();
        bind(KmlExample.class).asEagerSingleton();
        bind(ImageLayerExample.class).asEagerSingleton();
        bind(GetFeatureClickSelectionExample.class).asEagerSingleton();
        bind(GetFeatureBoxSelectionExample.class).asEagerSingleton();
        bind(FeatureIdFilterExample.class).asEagerSingleton();
        bind(SpatialFilterExample.class).asEagerSingleton();
        bind(ComparisonAndLogicalFilterExample.class).asEagerSingleton();
        bind(DragFeatureExample.class).asEagerSingleton();
        bind(ClickExample.class).asEagerSingleton();
        bind(WmsPostExample.class).asEagerSingleton();
        bind(RuleExample.class).asEagerSingleton();
        bind(ClusterStrategyTreshHoldExample.class).asEagerSingleton();
        bind(EmptyLayerExample.class).asEagerSingleton();
        bind(FeaturePopupExample.class).asEagerSingleton();
        bind(ClickFeatureListenerExample.class).asEagerSingleton();
        bind(LabelOverLeapExample.class).asEagerSingleton();
        bind(XYZLayerExample.class).asEagerSingleton();
        bind(GeoJsonExample.class).asEagerSingleton();
        bind(Labels.class).asEagerSingleton();
        bind(GeolocateExample.class).asEagerSingleton();
        bind(WMTSExample.class).asEagerSingleton();
        bind(DrawRegularPolygonExample.class).asEagerSingleton();
        bind(PolygonSelect.class).asEagerSingleton();
        bind(GeodesicLengthExample.class).asEagerSingleton();
        bind(AnimatedClusterStrategyTreshHoldExample.class).asEagerSingleton();
        bind(AnimatedClusterWithPopup.class).asEagerSingleton();
        bind(VectorResizeImageExample.class).asEagerSingleton();
        bind(GeoJsonFromGitHub.class).asEagerSingleton();
        bind(MinMaxZoomExample.class).asEagerSingleton();
        bind(DrawFeatureStyleExample.class).asEagerSingleton();
        bind(ScaleExample.class).asEagerSingleton();
        bind(HoverAndSelectExample.class).asEagerSingleton();
        bind(WellKnownGraphicExample.class).asEagerSingleton();
    }
}
