package org.gwtopenmaps.openlayers.client.layer;
/**
 * @author Michel Vitor A Rodrigues - Intec
 */
public class ArcGIS93RestOptions extends GridLayerOptions {


	public void setSingleTile(boolean b){
		getJSObject().setProperty("singleTile", b);
	}
	public void setUntiled(){
		setSingleTile(true);
	}

	public void setTransitionEffectResize(){
		setTransitionEffect(TransitionEffect.RESIZE);
	}
	public void setProjection(String epsgCode){
		getJSObject().setProperty("projection", epsgCode);
	}
	public void setUnits(String units){
		getJSObject().setProperty("units", units);
	}
	public void setWrapDateLine(boolean wrap) {
		getJSObject().setProperty("wrapDateLine", wrap);
	}
	public void setBuffer(int buffer){
		getJSObject().setProperty("buffer", buffer);
	}

	public void setRatio(int ratio){
		getJSObject().setProperty("ratio", ratio);
	}
}
