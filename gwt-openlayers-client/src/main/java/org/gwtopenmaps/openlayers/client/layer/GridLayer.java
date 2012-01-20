package org.gwtopenmaps.openlayers.client.layer;

import org.gwtopenmaps.openlayers.client.util.JSObject;


/**
* Wrapper of OpenLayers.Layer.Grid in OpenLayers. Renamed Grid to GridLayer
* in order to avoid confusion around the generic term Grid.
*
* From OL API docs:
* Base class for layers that use a lattice of tiles.
*
* @author Edwin Commandeur - Atlis EJS
* @author Michel Vitor A Rodrigues - Intec
*
*/
public class GridLayer extends HTTPRequestLayer
{

    protected GridLayer(JSObject gridLayer)
    {
        super(gridLayer);
    }

    public GridLayer(String name, String url, WMSParams params, GridLayerOptions options)
    {

        this(GridLayerImpl.create(name, url, params.getJSObject(), options.getJSObject()));
    }

    public GridLayer(String name, String url, WMSParams params)
    {

        this(GridLayerImpl.create(name, url, params.getJSObject()));
    }

    public GridLayer narrowToGridLayer(JSObject gridLayer)
    {
        return (gridLayer == null) ? null : new GridLayer(gridLayer);

    }

    public void setTitleSize(Integer tileSize)
    {
        GridLayerImpl.setTitleSize(getJSObject(), tileSize);
    }

    public void setSingleTile(boolean singleTile)
    {
        GridLayerImpl.setSingleTile(getJSObject(), singleTile);
    }

    public void setRatio(float ratio)
    {
        GridLayerImpl.setRatio(getJSObject(), ratio);
    }

    public void setBuffer(Integer buffer)
    {
        GridLayerImpl.setBuffer(getJSObject(), buffer);
    }

    public void setNumLoadingTiles(Integer numLoadingTiles)
    {
        GridLayerImpl.setNumLoadingTiles(getJSObject(), numLoadingTiles);
    }

}
