package org.vaadin.teemusa;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.function.Supplier;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.ClassRule;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.vaadin.teemusa.flexlayout.AlignContent;
import org.vaadin.teemusa.flexlayout.AlignItems;
import org.vaadin.teemusa.flexlayout.FlexDirection;
import org.vaadin.teemusa.flexlayout.FlexWrap;
import org.vaadin.teemusa.flexlayout.JustifyContent;
import org.vaadin.teemusa.undertow.UndertowRule;

import com.vaadin.testbench.annotations.BrowserFactory;
import com.vaadin.testbench.annotations.RunLocally;
import com.vaadin.testbench.elements.CssLayoutElement;
import com.vaadin.testbench.elements.NativeSelectElement;
import com.vaadin.testbench.elementsbase.ServerClass;
import com.vaadin.testbench.parallel.Browser;
import com.vaadin.testbench.parallel.ParallelTest;

import io.github.bonigarcia.wdm.ChromeDriverManager;

@RunLocally(Browser.CHROME)
@BrowserFactory(HeadlessChromeFactory.class)
public class FlexFeaturesTest extends ParallelTest {

    @ClassRule
    public static UndertowRule serverRule = UndertowRule
            .withUI(FlexFeatures.class);

    @ServerClass("org.vaadin.teemusa.flexlayout.FlexLayout")
    public static class FlexLayoutElement extends CssLayoutElement {

        public FlexDirection getFlexDirection() {
            String value = getCssValue("flex-direction");
            return value != null ? FlexDirection.valueOf(camelCase(value))
                    : FlexDirection.getDefault();
        }

        public FlexWrap getFlexWrap() {
            String value = getCssValue("flex-wrap");
            return value != null ? FlexWrap.valueOf(camelCase(value))
                    : FlexWrap.getDefault();
        }

        public JustifyContent getJustifyContent() {
            String value = getCssValue("justify-content");
            return value != null ? JustifyContent.valueOf(camelCase(value))
                    : JustifyContent.getDefault();
        }

        public AlignContent getAlignContent() {
            String value = getCssValue("align-content");
            return value != null ? AlignContent.valueOf(camelCase(value))
                    : AlignContent.getDefault();
        }

        public AlignItems getAlignItems() {
            String value = getCssValue("align-items");
            return value != null ? AlignItems.valueOf(camelCase(value))
                    : AlignItems.getDefault();
        }

        private String camelCase(String cssValue) {
            StringBuilder resultBuilder = new StringBuilder();
            int previousDash = -1;
            for (int i = 0; i < cssValue.length(); ++i) {
                char current = cssValue.charAt(i);
                if (i == previousDash + 1) {
                    resultBuilder.append(Character.toUpperCase(current));
                } else if (current == '-') {
                    previousDash = i;
                } else {
                    resultBuilder.append(current);
                }
            }

            return resultBuilder.toString();
        }
    }

    FlexLayoutElement flexLayout;

    @Before
    public void setup() throws Exception {
        super.setup();

        getDriver().get(serverRule.getServer().getBaseURL());
        flexLayout = $(FlexLayoutElement.class).id("fiddle");
    }

    @Test
    public void testFlexDirections() {
        testFlexProperty(FlexDirection.class, FlexDirection.values(),
                flexLayout::getFlexDirection);
    }

    @Test
    public void testFlexWrap() {
        testFlexProperty(FlexWrap.class, FlexWrap.values(),
                flexLayout::getFlexWrap);
    }

    @Test
    public void testJustifyContent() {
        testFlexProperty(JustifyContent.class, JustifyContent.values(),
                flexLayout::getJustifyContent);
    }

    @Test
    public void testAlignContent() {
        testFlexProperty(AlignContent.class, AlignContent.values(),
                flexLayout::getAlignContent);
    }

    @Test
    public void testAlignItems() {
        testFlexProperty(AlignItems.class, AlignItems.values(),
                flexLayout::getAlignItems);
    }

    private <E> void testFlexProperty(Class<E> enumClass, E[] values,
            Supplier<E> getter) {
        String propertyName = enumClass.getSimpleName();
        NativeSelectElement select = $(NativeSelectElement.class)
                .id(propertyName);
        Arrays.stream(values).forEach(direction -> {
            select.selectByText(direction.toString());
            assertEquals(propertyName + " selection failed", direction,
                    getter.get());
        });
    }
}
