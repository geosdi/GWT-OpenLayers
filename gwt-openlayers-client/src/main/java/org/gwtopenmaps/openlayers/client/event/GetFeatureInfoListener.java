package org.gwtopenmaps.openlayers.client.event;

import org.gwtopenmaps.openlayers.client.control.WMSGetFeatureInfo;
import org.gwtopenmaps.openlayers.client.feature.VectorFeature;
import org.gwtopenmaps.openlayers.client.util.JSObject;


/**
 * @author Dave Potts
 * @author Lukas Johansson
 */
public interface GetFeatureInfoListener extends EventListener
{

    public void onGetFeatureInfo(GetFeatureInfoEvent eventObject);

    class GetFeatureInfoEvent extends EventObject
    {

        public GetFeatureInfoEvent(EventObject eventObject)
        {
            super(eventObject.getJSObject());
        }

        public WMSGetFeatureInfo getSource()
        {
            JSObject object = getSourceJSObject();

            return (object != null) ? WMSGetFeatureInfo.narrowToWMSGetFeatureInfo(object) : null;
        }

        public String getText()
        {
            return getJSObject().getPropertyAsString("text");
        }

        /**
         * Get the features returned by the request
         * If infoFormat was set to GML WmsGetFeatureInfo parses the result and populates
         * an array with the returned features. This method simple returns that array
         * @return array of features
         */
        public VectorFeature[] getFeatures()
        {
            JSObject[] jsArr = getJSObject().getPropertyAsArray("features");
            if (jsArr.length == 0)
            {
                return null;
            }
            // In some cases the parser seems to produces an array with length=1 but with null as element
            if (jsArr[0] == null)
            {
                return null;
            }

            VectorFeature[] result = new VectorFeature[jsArr.length];
            for (int i = 0; i < jsArr.length; i++)
            {
                VectorFeature vf = VectorFeature.narrowToVectorFeature(jsArr[i]);
                result[i] = vf;
            }

            return result;
        }

    }

}
