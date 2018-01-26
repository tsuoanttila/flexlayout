package org.vaadin.teemusa.demo;

import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.vaadin.teemusa.flexlayout.AlignContent;
import org.vaadin.teemusa.flexlayout.AlignItems;
import org.vaadin.teemusa.flexlayout.FlexDirection;
import org.vaadin.teemusa.flexlayout.FlexLayout;
import org.vaadin.teemusa.flexlayout.FlexWrap;
import org.vaadin.teemusa.flexlayout.JustifyContent;

import com.vaadin.navigator.View;
import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.VerticalLayout;

public class ExampleView extends HorizontalLayout implements View {

    public ExampleView() {
        addComponent(createExample1());
        addComponent(createExample2());
        setSizeFull();
    }

    private Component createExample1() {
        // Example start
        FlexLayout horizontal1 = FlexLayout.create().horizontal().alignItems()
                .center().justifyContent().spaceAround().alignContent()
                .spaceBetween().nowrap().build();
        // Example end
        horizontal1.addStyleName("demolayout");
        horizontal1.setCaption("Example Layout 1: Builder");
        horizontal1.addComponents(createDemoContent(2));

        // Example start
        FlexLayout horizontal2 = new FlexLayout();
        horizontal2.setFlexDirection(FlexDirection.Row);
        horizontal2.setAlignItems(AlignItems.Center);
        horizontal2.setJustifyContent(JustifyContent.SpaceAround);
        horizontal2.setAlignContent(AlignContent.SpaceBetween);
        horizontal2.setFlexWrap(FlexWrap.Nowrap);
        // Example end
        horizontal2.addStyleName("demolayout");
        horizontal2.setCaption("Example Layout 1: Traditional API");
        horizontal2.addComponents(createDemoContent(2));

        VerticalLayout wrap = new VerticalLayout(horizontal1, horizontal2);
        horizontal1.setSizeFull();
        horizontal2.setSizeFull();
        wrap.setSizeFull();
        return wrap;
    }

    private Component createExample2() {
        // Example start
        FlexLayout vertical1 = FlexLayout.create().vertical().alignItems().end()
                .alignContent().stretch().justifyContent().spaceBetween().wrap()
                .build();
        // Example end
        vertical1.addStyleName("demolayout");
        vertical1.setCaption("Example Layout 2: Builder");
        vertical1.addComponents(createDemoContent(10));

        // Example start
        FlexLayout vertical2 = new FlexLayout();
        vertical2.setFlexDirection(FlexDirection.Column);
        vertical2.setAlignItems(AlignItems.FlexEnd);
        vertical2.setJustifyContent(JustifyContent.SpaceBetween);
        vertical2.setAlignContent(AlignContent.Stretch);
        vertical2.setFlexWrap(FlexWrap.Wrap);
        // Example end
        vertical2.addStyleName("demolayout");
        vertical2.setCaption("Example Layout 2: Traditional API");
        vertical2.addComponents(createDemoContent(10));

        VerticalLayout wrap = new VerticalLayout(vertical1, vertical2);
        vertical1.setSizeFull();
        vertical2.setSizeFull();
        wrap.setSizeFull();
        return wrap;
    }

    public static Component[] createDemoContent(int buttonsPerString) {
        return Stream.of("Foo", "Bar", "Baz")
                .flatMap(s -> IntStream.range(0, buttonsPerString).boxed()
                        .map(i -> s + " " + i))
                .map(Button::new).collect(Collectors.toList())
                .toArray(new Component[] {});
    }
}
