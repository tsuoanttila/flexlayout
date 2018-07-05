package org.vaadin.teemusa;

import java.util.stream.Stream;

import org.vaadin.teemusa.flexlayout.AlignContent;
import org.vaadin.teemusa.flexlayout.FlexDirection;
import org.vaadin.teemusa.flexlayout.FlexLayout;
import org.vaadin.teemusa.flexlayout.FlexWrap;
import org.vaadin.teemusa.undertow.UndertowLauncher;

import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.Button;
import com.vaadin.ui.UI;
import com.vaadin.ui.themes.ValoTheme;

public class VerticalColumnLayout extends UI {

    public static void main(String[] args) {
        UndertowLauncher.withUI(VerticalColumnLayout.class).run();
    }

    @Override
    protected void init(VaadinRequest request) {
        FlexLayout tagLayout = new FlexLayout();
        tagLayout.setFlexDirection(FlexDirection.Row);
        tagLayout.setFlexWrap(FlexWrap.Wrap);
        tagLayout.setAlignContent(AlignContent.FlexStart);

        tagLayout.setWidth("200px");
        tagLayout.setHeight("100%");

        Stream.of("HTML", "CSS", "JavaScript", "Java", "Vaadin", "Undertow",
                "Internet Explorer", "Chrome", "Firefox", "Safari")
                .map(caption -> {
                    Button button = new Button(caption);
                    button.addStyleName(ValoTheme.BUTTON_LINK);
                    button.addClickListener(
                            e -> tagLayout.removeComponent(button));
                    return button;
                }).forEach(tagLayout::addComponent);

        setContent(tagLayout);
    }
}
