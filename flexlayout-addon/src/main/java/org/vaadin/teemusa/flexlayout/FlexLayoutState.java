package org.vaadin.teemusa.flexlayout;

import com.vaadin.shared.JavaScriptExtensionState;

import java.util.HashMap;
import java.util.Map;

/**
 * State object for {@link FlexLayoutControl}.
 */
public class FlexLayoutState extends JavaScriptExtensionState {
    public Map<String, String> flexStyle = new HashMap<>();
    public Map<String, String> componentAlignMap = new HashMap<>();
}
