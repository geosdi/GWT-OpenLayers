package org.gwtopenmaps.openlayers.client.style;

/**
 * Create a symbolizer for rendering points
 * @author Maciej Jezierski - Pinocchio
 *
 */
public class SymbolizerPoint extends SymbolizerPolygon {
	
	public SymbolizerPoint() {
		super(SymbolizerPointImpl.create());
	}
	
	public void setPointRadius(double radius) {
		SymbolizerPointImpl.setPointRadius(this.getJSObject(), radius);
	}
	
	public double getPointRadius() {
		return SymbolizerPointImpl.getPointRadius(this.getJSObject());
	}
	
	public void setExternalGraphic(String url) {
		SymbolizerPointImpl.setExternalGraphic(this.getJSObject(), url);
	}
	
	public String getExternalGraphic() {
		return SymbolizerPointImpl.getExtenalGraphic(this.getJSObject());
	}
	
	public void setGraphicWidth(int width) {
		SymbolizerPointImpl.setGraphicWidth(this.getJSObject(), width);
	}
	
	public int getGraphicWidth() {
		return SymbolizerPointImpl.getGraphicWidth(this.getJSObject());
	}
	
	public void setGraphicHeight(int height) {
		SymbolizerPointImpl.setGraphicHeight(this.getJSObject(), height);
	}
	
	public int getGraphicHeight() {
		return SymbolizerPointImpl.getGraphicHeight(this.getJSObject());
	}
	
	public void setGraphicOpacity(double opacity) {
		SymbolizerPointImpl.setGraphicOpacity(this.getJSObject(), opacity);
	}
	
	public double getGraphicOpacity() {
		return SymbolizerPointImpl.getGraphicOpacity(this.getJSObject());
	}
	
	public void setGraphicXOffset(int offset) {
		SymbolizerPointImpl.setGraphicXOffset(this.getJSObject(), offset);
	}
	
	public int getGraphicXOffset() {
		return SymbolizerPointImpl.getGraphicXOffset(this.getJSObject());
	}
	
	public void setGraphicYOffset(int offset) {
		SymbolizerPointImpl.setGraphicYOffset(this.getJSObject(), offset);
	}
	
	public int getGraphicYOffset() {
		return SymbolizerPointImpl.getGraphicYOffset(this.getJSObject());
	}
	
	public void setRotation(double rotation) {
		SymbolizerPointImpl.setRotation(this.getJSObject(), rotation);
	}
	
	public double getRotation() {
		return SymbolizerPointImpl.getRotation(this.getJSObject());
	}
	
	public void setGraphicName(String name) {
		SymbolizerPointImpl.setGraphicName(this.getJSObject(), name);
	}
	
	public String getGraphicName() {
		return SymbolizerPointImpl.getGraphicName(this.getJSObject());
	}
}
