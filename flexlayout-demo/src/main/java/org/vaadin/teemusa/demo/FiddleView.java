package org.vaadin.teemusa.demo;

import org.vaadin.teemusa.flexlayout.AlignContent;
import org.vaadin.teemusa.flexlayout.AlignItems;
import org.vaadin.teemusa.flexlayout.FlexDirection;
import org.vaadin.teemusa.flexlayout.FlexLayout;
import org.vaadin.teemusa.flexlayout.FlexWrap;
import org.vaadin.teemusa.flexlayout.JustifyContent;

import com.vaadin.data.Binder;
import com.vaadin.navigator.View;
import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.ui.Label;
import com.vaadin.ui.NativeSelect;
import com.vaadin.ui.VerticalLayout;

public class FiddleView extends VerticalLayout implements View {

    public FiddleView() {
        FlexLayout layoutEditor = FlexLayout.create().horizontal().alignItems()
                .center().justifyContent().spaceAround().alignContent()
                .spaceBetween().nowrap().build();
        layoutEditor.setWidth("100%");

        NativeSelect<FlexDirection> direction = new NativeSelect<>(
                "Flex Direction");
        direction.setItems(FlexDirection.values());
        direction.setEmptySelectionAllowed(false);
        NativeSelect<FlexWrap> wrapping = new NativeSelect<>("Flex Wrap");
        wrapping.setItems(FlexWrap.values());
        wrapping.setEmptySelectionAllowed(false);
        NativeSelect<AlignItems> itemAlign = new NativeSelect<>("Align Items");
        itemAlign.setItems(AlignItems.values());
        itemAlign.setEmptySelectionAllowed(false);
        NativeSelect<JustifyContent> contentJustify = new NativeSelect<>(
                "Justify Content");
        contentJustify.setItems(JustifyContent.values());
        contentJustify.setEmptySelectionAllowed(false);
        NativeSelect<AlignContent> contentAlign = new NativeSelect<>(
                "Align Content");
        contentAlign.setItems(AlignContent.values());
        contentAlign.setEmptySelectionAllowed(false);

        layoutEditor.addComponents(direction, wrapping, itemAlign,
                contentJustify, contentAlign);

        Binder<FlexLayout> layoutBinder = new Binder<>();
        layoutBinder.bind(direction, t -> null, FlexLayout::setFlexDirection);
        layoutBinder.bind(wrapping, t -> null, FlexLayout::setFlexWrap);
        layoutBinder.bind(itemAlign, t -> null, FlexLayout::setAlignItems);
        layoutBinder.bind(contentAlign, t -> null, FlexLayout::setAlignContent);
        layoutBinder.bind(contentJustify, t -> null,
                FlexLayout::setJustifyContent);

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

        FlexLayout componentAlignLayout = FlexLayout.create().vertical()
                .build();
        Label left = new Label("Left");
        Label middle = new Label("Middle");
        Label right = new Label("Right");
        Label base = new Label("Baseline");
        componentAlignLayout.addComponents(left, middle, right, base);
        componentAlignLayout.setComponentAlignment(left, AlignItems.FlexStart);
        componentAlignLayout.setComponentAlignment(middle, AlignItems.Center);
        componentAlignLayout.setComponentAlignment(right, AlignItems.FlexEnd);
        componentAlignLayout.setComponentAlignment(base, AlignItems.Baseline);
        base.addContextClickListener(e -> {
            componentAlignLayout.removeComponent(base);
            componentAlignLayout.setJustifyContent(JustifyContent.FlexEnd);
        });

        componentAlignLayout.setWidth("100%");
        componentAlignLayout.setHeightUndefined();

        addComponents(layoutEditor, flexLayout, componentAlignLayout);
        setSizeFull();
        setExpandRatio(flexLayout, 1.0f);
    }
}
