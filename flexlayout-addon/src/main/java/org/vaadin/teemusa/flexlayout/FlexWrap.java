package org.vaadin.teemusa.flexlayout;

/**
 * FlexWrap defines whether too big content to fit the FlexLayout is overflowing or wrapping.
 */
public enum FlexWrap {
    /**
     * Wrap items.
     */
    Wrap,
    /**
     * Overflow items.
     */
    Nowrap,
    /**
     * Wrap items in reverse direction.
     */
    WrapReverse;

    /**
     * Gets the default FlexWrap.
     *
     * @return default wrapping
     */
    public static FlexWrap getDefault() {
        return Nowrap;
    }
}
