package org.gwtopenmaps.demo.openlayers.client.widget;

import com.google.gwt.user.client.ui.InlineHTML;

public class ShowcaseMenuItem {

    InlineHTML label;
    InlineHTML shortDescription;

    public ShowcaseMenuItem(String label, String shortDescription){

        this.label = new InlineHTML("<a class='menu-label' href='#'>" + label + "</a>");
        this.shortDescription = new InlineHTML("<span class='menu-short-description'>"
                + shortDescription + "</span>");
    }

    public InlineHTML getLabel(){
        return this.label;
    }

    public InlineHTML getShortDescription(){
        return this.shortDescription;
    }
}
