package org.gwtopenmaps.openlayers.client.layer;

import org.gwtopenmaps.openlayers.client.Bounds;
import org.gwtopenmaps.openlayers.client.Map;
import org.gwtopenmaps.openlayers.client.Size;
import org.gwtopenmaps.openlayers.client.util.JSObject;


/**
 * Displays data from a web accessible image.
 * The path to the image may be relative.
 *
 * @author Edwin Commandeur - Atlis EJS
 * @since GWT-OL 0.4, OL 2.2
 *
 */
public class Image extends Layer
{

    protected Image(JSObject imageLayer)
    {
        super(imageLayer);
    }

    /**
     *
     * @param name - OpenLayers layerName
     * @param url - a relative url or web uri
     * @param extent - bounds for the Image
     * @param size - the size of the picture
     * @param options - see {@link ImageOptions}
     */
    public Image(String name, String url, Bounds extent, Size size, ImageOptions options)
    {
        this(ImageImpl.create(name, url, extent.getJSObject(), size.getJSObject(), options.getJSObject()));

    }

    public Image narrowToImage(JSObject imageLayer)
    {
        return (imageLayer == null) ? null : new Image(imageLayer);
    }

    public Bounds getExtent()
    {
        return Bounds.narrowToBounds(ImageImpl.getExtent(getJSObject()));
    }

    public Size getSize()
    {
        return Size.narrowToSize(ImageImpl.getSize(getJSObject()));
    }


    public void setMap(Map map)
    {

    }

    /**
     * Change the url for the image.
     */
    public void setUrl(String url)
    {
        ImageImpl.setUrl(getJSObject(), url);
    }


    /**
     * @return String - the url of the Image
     */
    public String getUrl()
    {
        return ImageImpl.getUrl(getJSObject());
    }
}
