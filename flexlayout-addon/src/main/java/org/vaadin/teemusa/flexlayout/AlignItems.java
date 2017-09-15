package org.vaadin.teemusa.flexlayout;

/**
 * AlignItems defines the default alignment along the cross-axis inside each slot in FlexLayout.
 * The size of slots is defined by the biggest item together with the {@link AlignContent}.
 */
public enum AlignItems {
    /**
     * Items are aligned to the start of the slot.
     */
    FlexStart,
    /**
     * Items are aligned to the end of the slot.
     */
    FlexEnd,
    /**
     * Items are aligned to the middle of the slot.
     */
    Center,
    /**
     * Items are stretched to occupy the whole slot.
     */
    Stretch,
    /**
     * Items are aligned so that their baselines align.
     */
    Baseline;

    /**
     * Gets the default AlignItems.
     *
     * @return default item alignment
     */
    public static AlignItems getDefault() {
        return Baseline;
    }
}
