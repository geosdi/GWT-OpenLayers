/**
 *
 *   Copyright 2013 sourceforge.
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
package org.gwtopenmaps.openlayers.client.layer;

/**
 * The transition effect to use when the map is zoomed.
 */
public enum TransitionEffect
{
    /**
     * Existing tiles are resized on zoom to provide a visual effect of the zoom having taken place immediately.
     * As the new tiles become available, they are drawn on top of the resized tiles (this is the default setting).
     */
    RESIZE
    {
        @Override
        public String toString()
        {
            return "resize";
        }
    },
    /**
     * Existing tiles are resized on zoom and placed below the base layer. New tiles for the base layer will cover existing tiles.
     * This setting is recommended when having an overlay duplicated during the transition is undesirable (e.g. street labels or big transparent fills).
     */
    MAP_RESIZE
    {
        @Override
		public String toString()
        {
            return "map-resize";
        }
    },
    /**
     * No transition effect.
     */
    NONE
    {
        @Override
		public String toString()
        {
            return null;
        }
    };
    
	/**
	 * Gets the transition effect for the given value.
	 * Defaults to NONE for unknown values.
	 * @param value value from the transitionEffect property of a {@link Layer} or {@link LayerOptions} object.
	 * @return {@link TransitionEffect}
	 */
	public static TransitionEffect get(String value)
	{
		// walk through values
		for (TransitionEffect t : values())
		{
			String value2 = t.toString();
			if (value != null)
			{
				if (value.equals(value2))
				{
					return t;
				}
			}
			else if (value2 == null)
			{
				return t;
			}
		}
		// default is none
		return NONE;
    }
}
