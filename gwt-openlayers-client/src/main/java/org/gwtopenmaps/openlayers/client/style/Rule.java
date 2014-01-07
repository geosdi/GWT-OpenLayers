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
package org.gwtopenmaps.openlayers.client.style;

import org.gwtopenmaps.openlayers.client.feature.Feature;
import org.gwtopenmaps.openlayers.client.filter.Filter;
import org.gwtopenmaps.openlayers.client.util.JSObject;
import org.gwtopenmaps.openlayers.client.util.JSObjectWrapper;


/**
 *
 * @author Maciej Jezierski - Pinocchio
 *
 * This class represents an SLD Rule, as being used for rule-based SLD styling.
 */

public class Rule extends JSObjectWrapper
{

    public Rule(JSObject options)
    {
        super(RuleImpl.create(options));
    }

    public Rule()
    {
        super(RuleImpl.create());
    }

    /**
     * Set unique id for this session.
     * @param id
     */
    public void setId(String id) {
        RuleImpl.setId(this.getJSObject(), id);
    }

    /**
     * Get unique id for this session.
     * @return id
     */
    public String getId() {
        return RuleImpl.getId(this.getJSObject());
    }

    /**
     * Name of this rule
     * @param name
     */
    public void setName(String name) {
        RuleImpl.setName(this.getJSObject(), name);
    }

    /**
     * Title of this rule (set if included in SLD)
     * @param title
     */
    public void setTitle(String title) {
        RuleImpl.setTitle(this.getJSObject(), title);
    }

    /**
     * Description of this rule (set if abstract is included in SLD)
     * @param description
     */
    public void setDescription(String description) {
        RuleImpl.setDescription(this.getJSObject(), description);
    }

    /**
     *  An optional object with properties that the rule should be evaluated against.
     * @param context
     */
    public void setContext(JSObject context) {
        RuleImpl.setContext(getJSObject(), context);
    };

    /**
     * Optional filter for the rule.
     * @param filter
     */
    public void setFilter(Filter filter) {
        RuleImpl.setFilter(this.getJSObject(), filter.getJSObject());
    }

    /**
     * Determines whether this rule is only to be applied only if no other rules match (ElseFilter according to the SLD specification).
     * @param self
     * @param elseFilter
     */
    public void setElseFilter(boolean elseFilter) {
        RuleImpl.setElseFilter(this.getJSObject(), elseFilter);
    }

    /**
     *  Symbolizer for this rule.
     * @param symbolizer
     */
    public void setSymbolizer(Symbolizer symbolizer){
        RuleImpl.setSymbolizer(this.getJSObject(), symbolizer.getJSObject());
    }

    /**
     * Symbolizers for this rule.
     * @param symbolizer
     */
    public void setSymbolizer(JSObject self, Symbolizer[] symbolizer) {
        RuleImpl.setSymbolizer(this.getJSObject(), symbolizer);
    }

    /**
     * Minimum scale at which to draw the feature.
     * @param symbolizer
     */
    public void setMinScaleDenominator(int scale) {
        RuleImpl.setMinScaleDenominator(this.getJSObject(), scale);
    }

    /**
     * Maximum scale at which to draw the feature.
     * @param scale
     */
    public void setMaxScaleDenominator(int scale) {
        RuleImpl.setMaxScaleDenominator(this.getJSObject(), scale);
    }

    /**
     * nullify references to prevent circular references and memory leaks.
     */
    public void destroy() {

        RuleImpl.destroy(this.getJSObject());
    }

    /**
     * evaluates this rule for a specific feature
     * @param feature feature to apply the rule to
     * @return true if the rule applies, false if it does not.  This rule is the default rule and always returns true.
     */
    public boolean evaluate(Feature feature) {
        return RuleImpl.evaluate(this.getJSObject(), feature.getJSObject());
    }

}
