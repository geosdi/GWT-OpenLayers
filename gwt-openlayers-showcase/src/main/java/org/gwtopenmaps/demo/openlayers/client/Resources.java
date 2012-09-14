package org.gwtopenmaps.demo.openlayers.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.resources.client.TextResource;

/**
 * ImageResource stuff.
 *
 * @author fks/Frank Wynants
 *
 */
public interface Resources extends ClientBundle
{
    /**
     * The singleton instance.
     */
    Resources INSTANCE =  GWT.create(Resources.class);

    /**
     * The GWT-OL logo.
     *
     * @return The image resource.
     */
    @Source("resources/gwt-ol-a.png")
    ImageResource gwtOlLogo();

    /**
     * The info icon
     *
     * @return The image resource.
     */
    @Source("resources/icon-info.png")
    ImageResource icon_info();

    /**
     * The sourcecode for the examples
     */
    @Source("resources/SelectFeatureExample.txt")
    TextResource selectFeatureExample();
    @Source("resources/BasicOsmExample.txt")
    TextResource basicOsmExample();
    @Source("resources/BasicBingExample.txt")
    TextResource basicBingExample();
    @Source("resources/BasicGoogleV3Example.txt")
    TextResource basicGoogleV3Example();
    @Source("resources/WmsWfsExample.txt")
    TextResource wmsWfsExample();
    @Source("resources/WmsWfsEditExample.txt")
    TextResource wmsWfsEditExample();
    @Source("resources/BasicTmsExample.txt")
    TextResource basicTmsExample();
    @Source("resources/CustomMousePositionExample.txt")
    TextResource customMousePositionExample();
    @Source("resources/GraticuleExample.txt")
    TextResource graticuleExample();
    @Source("resources/WmsFeatureInfoExample.txt")
    TextResource wmsFeatureInfoExample();
    @Source("resources/VectorExample.txt")
    TextResource vectorExample();
    @Source("resources/MeasureExample.txt")
    TextResource measureExample();
    @Source("resources/LocationExample.txt")
    TextResource locationExample();
    @Source("resources/WfsRefreshExample.txt")
    TextResource wfsRefreshExample();
    @Source("resources/RotateVectorExample.txt")
    TextResource rotateVectorExample();
    @Source("resources/TransformFeatureExample.txt")
    TextResource transformFeatureExample();
}