package org.vaadin.teemusa.flexlayout;

import com.vaadin.annotations.JavaScript;
import com.vaadin.server.AbstractJavaScriptExtension;
import com.vaadin.server.ClientConnector;
import com.vaadin.ui.Component;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * JavaScript extension to turn CssLayout into a CSS Flexbox layout.
 */
@JavaScript("flexlayout.js")
class FlexLayoutControl extends AbstractJavaScriptExtension {

    private Map<Component, AlignItems> componentAlignmentMap = new HashMap<>();

    @Override
    public void beforeClientResponse(boolean initial) {
        Set<Component> componentSet = new HashSet<>();
        getState().componentAlignMap.clear();
        getParent().getComponentIterator().forEachRemaining(component -> {
            componentSet.add(component);
            if (componentAlignmentMap.containsKey(component)) {
                getState().componentAlignMap.put(component.getConnectorId(),
                        componentAlignmentMap.get(component).name());
            }
        });

        // Clean up any removed component alignments.
        componentAlignmentMap.keySet().retainAll(componentSet);

        super.beforeClientResponse(initial);
    }

    @Override
    protected FlexLayoutState getState() {
        return (FlexLayoutState) super.getState();
    }

    /**
     * Sets a flexbox css property to given value. This value is stored in the state and applied on the
     * client-side by the JavaScript connector.
     *
     * @param attributeName the css property name in camel case
     * @param value         the css property value in camel case
     */
    void setFlexAttribute(String attributeName, String value) {
        getState().flexStyle.put(attributeName, value);
    }

    /**
     * Sets alignment for given component.
     *
     * @param component the component to align
     * @param value     the component alignment
     */
    void setComponentAlignment(Component component, AlignItems value) {
        componentAlignmentMap.put(component, value);
    }

    @Override
    protected Class<? extends ClientConnector> getSupportedParentType() {
        return FlexLayout.class;
    }

    @Override
    public FlexLayout getParent() {
        return (FlexLayout) super.getParent();
    }
}
