package org.vaadin.teemusa.flexlayout;

/**
 * JustifyContent defines the justification and spacing along the main-axis of the FlexLayout. If the
 * {@link FlexLayout} is using {@link FlexDirection#Row}, then {@link JustifyContent} defines the
 * horizontal justification.
 */
public enum JustifyContent {
    /**
     * Justifies all items at the start of the main-axis.
     */
    FlexStart,
    /**
     * Justifies all items at the end of the main-axis.
     */
    FlexEnd,
    /**
     * Justifies all items in the middle of the main-axis.
     */
    Center,
    /**
     * Divides all available empty space between each item. This means that the first item will be
     * at the start of the main-axis, and the last at the end of it.
     */
    SpaceBetween,
    /**
     * Divides all available empty space around each item. If there's any space to divide, there is
     * going to be space between the start and the first item, and equal amount between the last item
     * and end of the {@link FlexLayout}.
     */
    SpaceAround,
    /**
     * Each item gets the same amount of extra space after it. The whole content area along the main
     * axis is divided to evenly sized slots, each item occupying one slot.
     */
    SpaceEvenly;

    /**
     * Gets the default JustifyContent.
     *
     * @return default content justification
     */
    public static JustifyContent getDefault() {
        return FlexStart;
    }
}
