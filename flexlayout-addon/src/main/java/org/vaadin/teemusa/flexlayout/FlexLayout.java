package org.vaadin.teemusa.flexlayout;


import com.vaadin.annotations.StyleSheet;
import com.vaadin.shared.Registration;
import com.vaadin.ui.*;

import java.util.Iterator;

@StyleSheet("flexlayout.css")
public class FlexLayout extends Composite implements Layout {

    private final FlexLayoutControl flexLayoutControl;
    private CssLayout cssLayout = new CssLayout();

    /**
     * Constructs a new FlexLayout.
     */
    public FlexLayout() {
        super();
        setCompositionRoot(cssLayout);
        cssLayout.setStyleName("flexlayout");
        flexLayoutControl = new FlexLayoutControl();
        addExtension(flexLayoutControl);
    }

    FlexLayout(FlexLayoutBuilder builder) {
        this();
        setAlignItems(builder.alignItems);
        setFlexDirection(builder.flexDirection);
        setFlexWrap(builder.flexWrap);
        setAlignContent(builder.alignContent);
        setJustifyContent(builder.justifyContent);
    }

    /**
     * This establishes the main-axis, thus defining the direction flex items are placed in the flex container.
     * FlexLayout is (aside from optional wrapping) a single-direction layout concept. Think of flex items as primarily
     * laying out either in horizontal rows or vertical columns.
     *
     * @param flexDirection the flex direction
     */
    public void setFlexDirection(FlexDirection flexDirection) {
        flexLayoutControl.setFlexAttribute(flexDirection.getClass().getSimpleName(), flexDirection.name());
    }

    /**
     * By default, flex items will all try to fit onto one line. You can change that and allow the items to wrap as
     * needed with this property.
     *
     * @param flexWrap the flex wrap
     */
    public void setFlexWrap(FlexWrap flexWrap) {
        flexLayoutControl.setFlexAttribute(flexWrap.getClass().getSimpleName(), flexWrap.name());
    }

    /**
     * This defines the default behaviour for how flex items are laid out along the cross axis on the current line.
     * Think of it as the justify-content version for the cross-axis (perpendicular to the main-axis).
     *
     * @param alignItems the item alignment
     */
    public void setAlignItems(AlignItems alignItems) {
        flexLayoutControl.setFlexAttribute(alignItems.getClass().getSimpleName(), alignItems.name());
    }

    /**
     * This defines the alignment along the main axis. It helps distribute extra free space left over when either all
     * the flex items on a line are inflexible, or are flexible but have reached their maximum size. It also exerts
     * some control over the alignment of items when they overflow the line.
     *
     * @param justifyContent the content justification
     */
    public void setJustifyContent(JustifyContent justifyContent) {
        flexLayoutControl.setFlexAttribute(justifyContent.getClass().getSimpleName(), justifyContent.name());
    }

    /**
     * This aligns a flex container's lines within when there is extra space in the cross-axis, similar to how
     * {@code justify-content} aligns individual items within the main-axis.
     * <p>
     * <strong>Note:</strong> this property has no effect when there is only one line of flex items.
     *
     * @param alignContent the content alignment
     */
    public void setAlignContent(AlignContent alignContent) {
        flexLayoutControl.setFlexAttribute(alignContent.getClass().getSimpleName(), alignContent.name());
    }


    @Override
    public void addComponent(Component component) {
        cssLayout.addComponent(component);
    }

    @Override
    public void addComponents(Component... components) {
        cssLayout.addComponents(components);
    }

    @Override
    public void removeComponent(Component component) {
        cssLayout.removeComponent(component);
    }

    @Override
    public void removeAllComponents() {
        cssLayout.removeAllComponents();
    }

    @Override
    public void replaceComponent(Component component, Component component1) {
        cssLayout.replaceComponent(component, component1);
    }

    @Override
    public Iterator<Component> getComponentIterator() {
        return cssLayout.getComponentIterator();
    }

    @Override
    public int getComponentCount() {
        return cssLayout.getComponentCount();
    }

    @Override
    public void moveComponentsFrom(ComponentContainer componentContainer) {
        cssLayout.moveComponentsFrom(componentContainer);
    }

    @Override
    public Registration addComponentAttachListener(ComponentAttachListener componentAttachListener) {
        return cssLayout.addComponentAttachListener(componentAttachListener);
    }

    @Override
    public void removeComponentAttachListener(ComponentAttachListener componentAttachListener) {
        cssLayout.removeComponentAttachListener(componentAttachListener);
    }

    @Override
    public Registration addComponentDetachListener(ComponentDetachListener componentDetachListener) {
        return cssLayout.addComponentDetachListener(componentDetachListener);
    }

    @Override
    public void removeComponentDetachListener(ComponentDetachListener componentDetachListener) {
        cssLayout.removeComponentDetachListener(componentDetachListener);
    }

    public static FlexLayoutBuilder create() {
        return new FlexLayoutBuilder();
    }
}
