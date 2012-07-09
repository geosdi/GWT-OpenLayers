package org.gwtopenmaps.demo.openlayers.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.ImageResource;

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

}