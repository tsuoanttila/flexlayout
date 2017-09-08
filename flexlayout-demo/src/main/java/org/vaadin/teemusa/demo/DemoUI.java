package org.vaadin.teemusa.demo;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Title;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.data.Binder;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Label;
import com.vaadin.ui.NativeSelect;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import org.vaadin.teemusa.flexlayout.*;

import javax.servlet.annotation.WebServlet;

@Theme("demo")
@Title("FlexLayout Add-on Demo")
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
        NativeSelect<FlexWrap> wrapping = new NativeSelect<>("Flex Wrap");
        wrapping.setItems(FlexWrap.values());
        NativeSelect<AlignItems> itemAlign = new NativeSelect<>("Align Items");
        itemAlign.setItems(AlignItems.values());
        NativeSelect<JustifyContent> contentJustify = new NativeSelect<>("Justify Content");
        contentJustify.setItems(JustifyContent.values());
        NativeSelect<AlignContent> contentAlign = new NativeSelect<>("Align Content");
        contentAlign.setItems(AlignContent.values());

        layoutEditor.addComponents(direction, wrapping, itemAlign, contentJustify, contentAlign);

        Binder<FlexLayout> layoutBinder = new Binder<>();
        layoutBinder.bind(direction, t -> null, FlexLayout::setFlexDirection);
        layoutBinder.bind(wrapping, t -> null, FlexLayout::setFlexWrap);
        layoutBinder.bind(itemAlign, t -> null, FlexLayout::setAlignItems);
        layoutBinder.bind(contentAlign, t -> null, FlexLayout::setAlignContent);
        layoutBinder.bind(contentJustify, t -> null, FlexLayout::setJustifyContent);

        FlexLayout flexLayout = new FlexLayout();
        for (int i = 0; i < 100; ++i) {
            Label l = new Label("Label " + i);
            l.setSizeUndefined();
            flexLayout.addComponent(l);
        }
        flexLayout.setWidth("100%");
        flexLayout.setHeight("400px");

        layoutBinder.setBean(flexLayout);

        setContent(new VerticalLayout(layoutEditor, flexLayout));
    }
}
