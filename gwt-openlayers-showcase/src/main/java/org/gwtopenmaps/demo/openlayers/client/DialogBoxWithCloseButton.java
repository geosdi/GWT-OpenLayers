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
package org.gwtopenmaps.demo.openlayers.client;

import com.google.gwt.user.client.ui.DialogBox;

/**
  * This will create a standard gwt-dialogbox with a close button. the css for
  * the close button:
  * <pre>
  * .gwt-DialogBox-closebutton {
  *     font-weight: bold;
  *     color: #dd0000;
  *     padding: 2px;
  *     margin-left: 2px;
  * }
  * .gwt-DialogBox-closebutton:ACTIVE {
  *     padding: 1px;
  *     border: thin #dd0000 solid;
  * }
  * .gwt-DialogBox-closebutton:HOVER {
  *     padding: 2px;
  *     color: #ee0000;
  * }
  * </pre>
  * @author Frank Wynants
  */
public class DialogBoxWithCloseButton extends DialogBox
{

     /** The count. */
     private static int count = 0;

     /**
      * Define closeDialog using JSNI.
      * @param dialogBox The dialog box.
      * @param functionName The name of the function to invoke.
      */
     private static native void redefineClose(DialogBox dialogBox, String functionName)
     /*-{
           $wnd[functionName] = function()
           {
              dialogBox.@org.gwtopenmaps.demo.openlayers.client.DialogBoxWithCloseButton::hideDialog()();
           }
      }-*/;

     /** The id. */
     private final String uid;

     /**
      * Creates an instance.
      */
     public DialogBoxWithCloseButton()
     {
         this(false);
     }

     /**
      * Creates an instance.
      * @param autoHide True to autohide.
      */
     public DialogBoxWithCloseButton(final boolean autoHide)
     {
         this(autoHide, true);
     }

     /**
      * Creates an instance.
      * @param autoHide True to autohide.
      * @param modal True to make the dialog modal.
      */
     public DialogBoxWithCloseButton(final boolean autoHide, final boolean modal)
     {
         super(autoHide, modal);
         setGlassEnabled(true);
         this.uid = "DialogBoxWithCloseButton_" + count++ + "_Close";
         setText("Dialog");
     }

     /**
      * Hides the dialog.
      */
     public void hideDialog()
     {
         super.hide();
     }

     /*
      * (non-Javadoc)
      * @see com.google.gwt.user.client.ui.DialogBox#setHTML(java.lang.String)
      */
     @Override
     public void setHTML(final String html)
     {
         final String styleName = getStyleName() + "-closebutton";
         super.setHTML("<table border='0' cellspacing='0' cellpadding='0' width='100%'><tr><td width='5%'>&nbsp;</td><td align='left' width='90%'>" + html + "</td><td align='right' valign='middle' width='5%'><span class='" + styleName + "' onclick='"
                 + this.uid + "()'>X</span></td></tr></table>");
         redefineClose(this, this.uid);
     }

     /*
      * (non-Javadoc)
      * @see com.google.gwt.user.client.ui.DialogBox#setText(java.lang.String)
      */
     @Override
     public void setText(final String text)
     {
         this.setHTML(text);
     }
}
