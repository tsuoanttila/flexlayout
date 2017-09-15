package org.vaadin.teemusa.demo;

import com.vaadin.annotations.PreserveOnRefresh;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Title;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.data.Binder;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.*;
import org.vaadin.teemusa.flexlayout.*;

import javax.servlet.annotation.WebServlet;

@Theme("demo")
@Title("FlexLayout Add-on Demo")
@PreserveOnRefresh
@SuppressWarnings("serial")
public class DemoUI extends UI {

    @WebServlet(value = "/*", asyncSupported = true)
    @VaadinServletConfiguration(productionMode = false, ui = DemoUI.class)
    public static class Servlet extends VaadinServlet {
    }

    @Override
    protected void init(VaadinRequest request) {
        FlexLayout layoutEditor = FlexLayout.create()
                .horizontal()
                .alignItems().center()
                .justifyContent().spaceAround()
                .alignContent().spaceBetween()
                .nowrap()
                .build();
        layoutEditor.setWidth("100%");

        NativeSelect<FlexDirection> direction = new NativeSelect<>("Flex Direction");
        direction.setItems(FlexDirection.values());
        direction.setEmptySelectionAllowed(false);
        NativeSelect<FlexWrap> wrapping = new NativeSelect<>("Flex Wrap");
        wrapping.setItems(FlexWrap.values());
        wrapping.setEmptySelectionAllowed(false);
        NativeSelect<AlignItems> itemAlign = new NativeSelect<>("Align Items");
        itemAlign.setItems(AlignItems.values());
        itemAlign.setEmptySelectionAllowed(false);
        NativeSelect<JustifyContent> contentJustify = new NativeSelect<>("Justify Content");
        contentJustify.setItems(JustifyContent.values());
        contentJustify.setEmptySelectionAllowed(false);
        NativeSelect<AlignContent> contentAlign = new NativeSelect<>("Align Content");
        contentAlign.setItems(AlignContent.values());
        contentAlign.setEmptySelectionAllowed(false);

        layoutEditor.addComponents(direction, wrapping, itemAlign, contentJustify, contentAlign);

        Binder<FlexLayout> layoutBinder = new Binder<>();
        layoutBinder.bind(direction, t -> null, FlexLayout::setFlexDirection);
        layoutBinder.bind(wrapping, t -> null, FlexLayout::setFlexWrap);
        layoutBinder.bind(itemAlign, t -> null, FlexLayout::setAlignItems);
        layoutBinder.bind(contentAlign, t -> null, FlexLayout::setAlignContent);
        layoutBinder.bind(contentJustify, t -> null, FlexLayout::setJustifyContent);

        FlexLayout flexLayout = new FlexLayout();
        for (int i = 0; i < 100; ++i) {
            Component c;
            if (i % 5 == 0) {
                c = new Button("Button " + i);
            } else {
                String labelText = "Label " + i;
                if (i % 3 == 0) {
                    labelText = "Extra long " + labelText;
                }
                c = new Label(labelText);
            }
            c.setSizeUndefined();
            if (i % 7 == 0) {
                c.setHeight("50px");
            }
            flexLayout.addComponent(c);
        }
        flexLayout.setWidth("100%");
        flexLayout.setHeight("400px");
        flexLayout.addStyleName("demolayout");

        layoutBinder.setBean(flexLayout);
        direction.setValue(FlexDirection.getDefault());
        wrapping.setValue(FlexWrap.getDefault());
        itemAlign.setValue(AlignItems.getDefault());
        contentAlign.setValue(AlignContent.getDefault());
        contentJustify.setValue(JustifyContent.getDefault());

        setContent(new VerticalLayout(layoutEditor, flexLayout));
    }
}
