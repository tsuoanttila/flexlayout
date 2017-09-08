package org.vaadin.teemusa.flexlayout;

import com.vaadin.annotations.JavaScript;
import com.vaadin.server.AbstractJavaScriptExtension;

@JavaScript("flexlayout.js")
class FlexLayoutControl extends AbstractJavaScriptExtension {

    @Override
    protected FlexLayoutState getState() {
        return (FlexLayoutState) super.getState();
    }

    void setFlexAttribute(String attributeName, String value) {
        getState().flexStyle.put(attributeName, value);
    }
}
