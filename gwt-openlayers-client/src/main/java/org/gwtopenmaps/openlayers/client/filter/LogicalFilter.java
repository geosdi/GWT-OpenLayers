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
package org.gwtopenmaps.openlayers.client.filter;

import org.gwtopenmaps.openlayers.client.util.JObjectArray;



/**
 * This class represents ogc:And, ogc:Or and ogc:Not rules.
 * @author Frank Wynants/www.fks.be
 *
 */
public class LogicalFilter extends Filter
{
    public enum Logical
    {
        AND("&&"), OR("||"), NOT("!");
        private final String stringValue;
        private Logical(final String s) { stringValue = s; }
        @Override
        public String toString() { return stringValue; }
    };

    /**
     * Constructor.
     */
    public LogicalFilter()
    {
        super(LogicalFilterImpl.create());
    }

    /**
     * Set the type of logical operator.
     * The type should be one of the enum types.
     * @param type Type of logical operator.
     *
     */
    public void setType(final Logical logical)
    {
        final String sLogical = logical.toString();
        getJSObject().setProperty("type", sLogical);
    }

    /**
     * Set the child filters for this filter.
     * @param filters Child filters for this filter.
     */
    public void setFilters(Filter[] filters)
    {
        JObjectArray array = new JObjectArray(filters);
        getJSObject().setProperty("filters", array.getJSObject());
    }
}