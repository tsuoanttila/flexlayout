package org.vaadin.teemusa.demo;

import javax.servlet.annotation.WebServlet;

import org.vaadin.teemusa.flexlayout.FlexLayout;

import com.vaadin.annotations.PreserveOnRefresh;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Title;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.navigator.Navigator;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Button;
import com.vaadin.ui.Panel;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;

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
        Panel container = new Panel();

        Navigator navigator = new Navigator(this, container);
        navigator.addView("fiddle", FiddleView.class);
        navigator.addView("example", ExampleView.class);

        FlexLayout naviBar = FlexLayout.create().horizontal().justifyContent()
                .spaceAround().alignContent().end().nowrap().build();
        naviBar.addComponents(createNaviButton("fiddle"),
                createNaviButton("example"));
        naviBar.setHeight("41px");

        VerticalLayout content = new VerticalLayout(naviBar, container);
        setContent(content);
        navigator.navigateTo("fiddle");

        setSizeFull();
        content.setSizeFull();
        container.setSizeFull();

        content.setExpandRatio(container, 1.0f);
    }

    public Button createNaviButton(String viewName) {
        Button button = new Button(viewName,
                e -> getNavigator().navigateTo(viewName));
        button.setStyleName(ValoTheme.BUTTON_LINK);
        return button;
    }
}
