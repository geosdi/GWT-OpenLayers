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




/**
 * This class represents a comparison filter.
 * @author Frank Wynants/www.fks.be
 *
 */
public class ComparisonFilter extends Filter
{
    public enum Types
    {
        EQUAL_TO("=="), NOT_EQUAL_TO("!="), LESS_THAN("<"), GREATER_THAN(">"), LESS_THAN_OR_EQUAL_TO("<="), GREATER_THAN_OR_EQUAL_TO(">="),
            BETWEEN(".."), LIKE("~"), IS_NULL("NULL");
        private final String stringValue;
        private Types(final String s) { stringValue = s; }
        @Override
        public String toString() { return stringValue; }
    };

    /**
     * Constructor.
     */
    public ComparisonFilter()
    {
        super(ComparisonFilterImpl.create());
    }

    /**
     * Set the type of the comparison.
     * The type should be one of the enum types.
     * @param type Type of the comparison.
     *
     */
    public void setType(final Types type)
    {
        final String sType = type.toString();
        getJSObject().setProperty("type", sType);
    }

    /**
     * Set the name of the context property to compare.
     * @param property name of the context property to compare
     */
    public void setProperty(String property)
    {
        getJSObject().setProperty("property", property);
    }

    /**
     * Set comparison value for binary comparisons.
     * @param value In the case of a String, this can be a combination of text and propertyNames in the form “literal ${propertyName}”
     */
    public void setStringValue (String value)
    {
        getJSObject().setProperty("value", value);
    }

    /**
     * Set comparison value for binary comparisons.
     * @param value The value
     */
    public void setNumberValue (int value)
    {
        getJSObject().setProperty("value", value);
    }

    /**
     * Force case sensitive searches for EQUAL_TO and NOT_EQUAL_TO comparisons.
     * @param matchCase Force or not.
     */
    public void setMatchCase(boolean matchCase)
    {
        getJSObject().setProperty("matchCase", matchCase);
    }

    /**
     * Set the lower boundary for between comparisons.
     * @param lowerBoundary The lower boundary for between comparisons.
     *         In the case of a String, this can be a combination of text and propertyNames in the form “literal ${propertyName}”
     */
    public void setStringLowerBoundary(String lowerBoundary)
    {
        getJSObject().setProperty("lowerBoundary", lowerBoundary);
    }

    /**
     * Set the lower boundary for between comparisons.
     * @param lowerBoundary The lower boundary for between comparisons.
     */
    public void setNumberLowerBoundary(int lowerBoundary)
    {
        getJSObject().setProperty("lowerBoundary", lowerBoundary);
    }

    /**
     * Set the upper boundary for between comparisons.
     * @param upperBoundary The upper boundary for between comparisons.
     *         In the case of a String, this can be a combination of text and propertyNames in the form “literal ${propertyName}”
     */
    public void setStringUpperBoundary(String upperBoundary)
    {
        getJSObject().setProperty("upperBoundary", upperBoundary);
    }

    /**
     * Set the upper boundary for between comparisons.
     * @param upperBoundary The upper boundary for between comparisons.
     */
    public void setNumberUpperBoundary(int upperBoundary)
    {
        getJSObject().setProperty("upperBoundary", upperBoundary);
    }
}