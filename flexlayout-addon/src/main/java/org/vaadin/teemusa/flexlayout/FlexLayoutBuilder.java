package org.vaadin.teemusa.flexlayout;

/**
 * Builder class for configuring and building FlexLayouts.
 */
public class FlexLayoutBuilder {

    @FunctionalInterface
    interface SubBuilder {
        FlexLayoutBuilder getBuilder();
    }

    /**
     * Helper API for content alignment settings.
     */
    public interface AlignContentBuilder extends SubBuilder {

        /**
         * Sets the content alignment to start.
         *
         * @see AlignContent#FlexStart
         *
         * @return the flex layout builder
         */
        default FlexLayoutBuilder start() {
            getBuilder().alignContent = AlignContent.FlexStart;
            return getBuilder();
        }

        /**
         * Sets the content alignment to end.
         *
         * @see AlignContent#FlexEnd
         *
         * @return the flex layout builder
         */
        default FlexLayoutBuilder end() {

            getBuilder().alignContent = AlignContent.FlexEnd;
            return getBuilder();
        }

        /**
         * Sets the content alignment to center.
         *
         * @see AlignContent#Center
         *
         * @return the flex layout builder
         */
        default FlexLayoutBuilder center() {
            getBuilder().alignContent = AlignContent.Center;
            return getBuilder();
        }

        /**
         * Sets the content to divide the empty space between the slots along the cross-axis.
         *
         * @see AlignContent#SpaceBetween
         *
         * @return the flex layout builder
         */
        default FlexLayoutBuilder spaceBetween() {
            getBuilder().alignContent = AlignContent.SpaceBetween;
            return getBuilder();
        }

        /**
         * Sets the content to divide the empty space around the slots along the cross-axis.
         *
         * @see AlignContent#SpaceAround
         *
         * @return the flex layout builder
         */
        default FlexLayoutBuilder spaceAround() {
            getBuilder().alignContent = AlignContent.SpaceAround;
            return getBuilder();
        }

        /**
         * Sets the content to be stretched to take all empty space along the cross-axis.
         *
         * @see AlignContent#Stretch
         *
         * @return the flex layout builder
         */
        default FlexLayoutBuilder strecth() {
            getBuilder().alignContent = AlignContent.Stretch;
            return getBuilder();
        }
    }

    /**
     * Helper API for content justification settings.
     */
    public interface JustifyContentBuilder extends SubBuilder {

        /**
         * Sets the content to be justified at the start.
         *
         * @see JustifyContent#FlexStart
         *
         * @return the flex layout builder
         */
        default FlexLayoutBuilder start() {
            getBuilder().justifyContent = JustifyContent.FlexStart;
            return getBuilder();
        }

        /**
         * Sets the content to be justified at the end.
         *
         * @see JustifyContent#FlexEnd
         *
         * @return the flex layout builder
         */
        default FlexLayoutBuilder end() {
            getBuilder().justifyContent = JustifyContent.FlexEnd;
            return getBuilder();
        }

        /**
         * Sets the content to be justified at the center.
         *
         * @see JustifyContent#Center
         *
         * @return the flex layout builder
         */
        default FlexLayoutBuilder center() {
            getBuilder().justifyContent = JustifyContent.Center;
            return getBuilder();
        }

        /**
         * Sets the content to divide the empty space between the slots along the main-axis.
         *
         * @see JustifyContent#SpaceBetween
         *
         * @return the flex layout builder
         */
        default FlexLayoutBuilder spaceBetween() {
            getBuilder().justifyContent = JustifyContent.SpaceBetween;
            return getBuilder();
        }

        /**
         * Sets the content to divide the empty space around the slots along the main-axis.
         *
         * @see JustifyContent#SpaceAround
         *
         * @return the flex layout builder
         */
        default FlexLayoutBuilder spaceAround() {
            getBuilder().justifyContent = JustifyContent.SpaceAround;
            return getBuilder();
        }

        /**
         * Sets the content to divide the empty space evenly for all slots along the main-axis.
         *
         * @see JustifyContent#SpaceEvenly
         *
         * @return the flex layout builder
         */
        default FlexLayoutBuilder spaceEvenly() {
            getBuilder().justifyContent = JustifyContent.SpaceEvenly;
            return getBuilder();
        }
    }

    /**
     * Helper API for item alignment settings.
     */
    public interface AlignItemsBuilder extends SubBuilder {

        /**
         * Sets the items to be aligned at the start of the slot.
         *
         * @see AlignItems#FlexStart
         *
         * @return the flex layout builder
         */
        default FlexLayoutBuilder start() {
            getBuilder().alignItems = AlignItems.FlexStart;
            return getBuilder();
        }

        /**
         * Sets the items to be aligned at the end of the slot.
         *
         * @see AlignItems#FlexEnd
         *
         * @return the flex layout builder
         */
        default FlexLayoutBuilder end() {
            getBuilder().alignItems = AlignItems.FlexEnd;
            return getBuilder();
        }

        /**
         * Sets the items to be aligned at the center of the slot.
         *
         * @see AlignItems#Center
         *
         * @return the flex layout builder
         */
        default FlexLayoutBuilder center() {
            getBuilder().alignItems = AlignItems.Center;
            return getBuilder();
        }

        /**
         * Sets the items to be aligned according to their baselines.
         *
         * @see AlignItems#Baseline
         *
         * @return the flex layout builder
         */
        default FlexLayoutBuilder baseline() {
            getBuilder().alignItems = AlignItems.Baseline;
            return getBuilder();
        }

        /**
         * Sets the items to be stretched to occupy the whole slot.
         *
         * @see AlignItems#Stretch
         *
         * @return the flex layout builder
         */
        default FlexLayoutBuilder stretch() {
            getBuilder().alignItems = AlignItems.Stretch;
            return getBuilder();
        }
    }

    FlexDirection flexDirection = FlexDirection.getDefault();
    FlexWrap flexWrap = FlexWrap.getDefault();
    AlignItems alignItems = AlignItems.getDefault();
    JustifyContent justifyContent = JustifyContent.getDefault();
    AlignContent alignContent = AlignContent.getDefault();

    /**
     * Sets the main-axis to be horizontal.
     *
     * @see FlexDirection#Row
     *
     * @return the builder
     */
    public FlexLayoutBuilder horizontal() {
        flexDirection = FlexDirection.Row;
        return this;
    }

    /**
     * Sets the main-axis to be horizontal with reverse direction.
     *
     * @see FlexDirection#RowReverse
     *
     * @return the builder
     */
    public FlexLayoutBuilder horizontalReverse() {
        flexDirection = FlexDirection.RowReverse;
        return this;
    }

    /**
     * Sets the main-axis to be horizontal.
     *
     * @see FlexDirection#Row
     *
     * @return the builder
     */
    public FlexLayoutBuilder vertical() {
        flexDirection = FlexDirection.Column;
        return this;
    }

    /**
     * Sets the main-axis to be vertical with reverse direction.
     *
     * @see FlexDirection#ColumnReverse
     *
     * @return the builder
     */
    public FlexLayoutBuilder verticalReverse() {
        flexDirection = FlexDirection.ColumnReverse;
        return this;
    }

    /**
     * Sets the wrapping of items on.
     *
     * @see FlexWrap#Wrap
     *
     * @return the builder
     */
    public FlexLayoutBuilder wrap() {
        flexWrap = FlexWrap.Wrap;
        return this;
    }

    /**
     * Sets the wrapping of items off.
     *
     * @see FlexWrap#Nowrap
     *
     * @return the builder
     */
    public FlexLayoutBuilder nowrap() {
        flexWrap = FlexWrap.Nowrap;
        return this;
    }

    /**
     * Sets the wrapping of items on with reverse direction.
     *
     * @see FlexWrap#WrapReverse
     *
     * @return the builder
     */
    public FlexLayoutBuilder wrapReverse() {
        flexWrap = FlexWrap.WrapReverse;
        return this;
    }

    /**
     * This aligns a flex container's lines within when there is extra space in the cross-axis, similar to how
     * {@code justify-content} aligns individual items within the main-axis.
     * <p>
     * <strong>Note:</strong> this property has no effect when there is only one line of flex items.
     *
     * @return builder instance for setting content alignment
     */
    public AlignContentBuilder alignContent() {
        return () -> this;
    }

    /**
     * This defines the alignment along the main axis. It helps distribute extra free space left over when either all
     * the flex items on a line are inflexible, or are flexible but have reached their maximum size. It also exerts
     * some control over the alignment of items when they overflow the line.
     *
     * @return builder instance for setting content justification
     */
    public JustifyContentBuilder justifyContent() {
        return () -> this;
    }

    /**
     * This defines the default behaviour for how flex items are laid out along the cross axis on the current line.
     * Think of it as the justify-content version for the cross-axis (perpendicular to the main-axis).
     *
     * @return builder instance for setting item alignment
     */
    public AlignItemsBuilder alignItems() {
        return () -> this;
    }

    /**
     * Creates a FlexLayout instance from the settings in this FlexLayoutBuilder.
     *
     * @return the flex layout
     */
    public FlexLayout build() {
        return new FlexLayout(this);
    }
}
