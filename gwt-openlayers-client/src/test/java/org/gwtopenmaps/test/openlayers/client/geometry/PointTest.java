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
package org.gwtopenmaps.test.openlayers.client.geometry;

import org.gwtopenmaps.openlayers.client.geometry.Point;
import org.gwtopenmaps.test.openlayers.client.BaseTestCase;


public class PointTest extends BaseTestCase
{

    private Point p;

    public void testPoint()
    {
        p = new Point(1.0, 2.0);
        assertEquals(1.0, p.getX());
        assertEquals(2.0, p.getY());
        // System.out.println("point X: " + p.getX());
    }

}
