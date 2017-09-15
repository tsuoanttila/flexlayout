package org.vaadin.teemusa.flexlayout;

/**
 * AlignContent defines the alignment of the whole content <i>perpendicular to the main-axis</i> (cross-axis)
 * of the FlexLayout. If the {@link FlexLayout} is using {@link FlexDirection#Row}, then {@link AlignContent}
 * defines the vertical alignment.
 */
public enum AlignContent {
    /**
     * Aligns the whole content at the start of the cross-axis.
     */
    FlexStart,
    /**
     * Aligns the whole content at the end of the cross-axis.
     */
    FlexEnd,
    /**
     * Aligns the whole content in the middle of the cross-axis.
     */
    Center,
    /**
     * Each slot (line) of content is stretched to occupy all extra space.
     */
    Stretch,
    /**
     * Divides all available empty space around each item. If there's any space to divide, there is
     * going to be space between the start of cross-axis and the first item, and equal amount
     * between the last item and end of the cross-axis.
     */
    SpaceAround,
    /**
     * Divides all available empty space between each item. This means that the first item will be
     * at the start of the main-axis, and the last at the end of it.
     */
    SpaceBetween;

    /**
     * Gets the default AlignContent.
     *
     * @return default content alignment
     */
    public static AlignContent getDefault() {
        return Stretch;
    }
}
