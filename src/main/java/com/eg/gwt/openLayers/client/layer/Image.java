package com.eg.gwt.openLayers.client.layer;

import com.eg.gwt.openLayers.client.Bounds;
import com.eg.gwt.openLayers.client.Map;
import com.eg.gwt.openLayers.client.Size;
import com.eg.gwt.openLayers.client.util.JSObject;

/**
 * Displays data from a web accessible image.
 * The path to the image may be relative.
 *
 * @author Edwin Commandeur - Atlis EJS
 * @since GWT-OL 0.4, OL 2.2
 *
 */
public class Image extends Layer {

	protected Image(JSObject element) {
		super(element);
	}

	public static Image narrowToImage(JSObject layer){
		return new Image(layer);
	}

	/**
	 *
	 * @param name - OpenLayers layerName
	 * @param url - a relative url or web uri
	 * @param exent - ...
	 * @param size - the size of the picture
	 * @param options - see {@link ImageOptions}
	 */
	public Image(String name, String url, Bounds extent, Size size, ImageOptions options){
		this(ImageImpl.create(name, url, extent.getJSObject(), size.getJSObject(), options.getJSObject()));

	}

	public Bounds getExtent(){
		return Bounds.narrowToBounds(ImageImpl.getExtent(getJSObject()));
	}

	public Size getSize(){
		return Size.narrowToSize(ImageImpl.getSize(getJSObject()));
	}


	public void setMap(Map map){

	}

	/**
	 * Change the url for the image.
	 */
	public void setUrl(String url){
		ImageImpl.setUrl(getJSObject(), url);
	}


	/**
	 * @return String - the url of the Image
	 */
	public String getUrl(){
		return ImageImpl.getUrl(getJSObject());
	}
}
