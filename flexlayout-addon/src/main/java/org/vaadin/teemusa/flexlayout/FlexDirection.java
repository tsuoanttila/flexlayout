package org.vaadin.teemusa.flexlayout;

/**
 * FlexDirection defines the main-axis of the FlexLayout.
 */
public enum FlexDirection {
    /**
     * Horizontal main-axis, left to right.
     */
    Row,
    /**
     * Horizontal main-axis, right to left.
     */
    RowReverse,
    /**
     * Vertical main-axis, top to bottom.
     */
    Column,
    /**
     * Vertical main-axis, bottom to top.
     */
    ColumnReverse;

    /**
     * Gets the default FlexDirection.
     *
     * @return default flex diretion
     */
    public static FlexDirection getDefault() {
        return Row;
    }
}
