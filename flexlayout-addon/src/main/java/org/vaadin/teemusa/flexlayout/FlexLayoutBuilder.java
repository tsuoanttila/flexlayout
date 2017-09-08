package org.vaadin.teemusa.flexlayout;

public class FlexLayoutBuilder {

    @FunctionalInterface
    interface SubBuilder {
        FlexLayoutBuilder getBuilder();
    }

    public interface AlignContentBuilder extends SubBuilder {

        default FlexLayoutBuilder start() {
            getBuilder().alignContent = AlignContent.FlexStart;
            return getBuilder();
        }

        default FlexLayoutBuilder end() {

            getBuilder().alignContent = AlignContent.FlexEnd;
            return getBuilder();
        }

        default FlexLayoutBuilder center() {
            getBuilder().alignContent = AlignContent.Center;
            return getBuilder();
        }

        default FlexLayoutBuilder spaceBetween() {
            getBuilder().alignContent = AlignContent.SpaceBetween;
            return getBuilder();
        }

        default FlexLayoutBuilder spaceAround() {
            getBuilder().alignContent = AlignContent.SpaceAround;
            return getBuilder();
        }

        default FlexLayoutBuilder strecth() {
            getBuilder().alignContent = AlignContent.Strecth;
            return getBuilder();
        }
    }

    public interface JustifyContentBuilder extends SubBuilder {

        default FlexLayoutBuilder start() {
            getBuilder().justifyContent = JustifyContent.FlexStart;
            return getBuilder();
        }

        default FlexLayoutBuilder end() {
            getBuilder().justifyContent = JustifyContent.FlexEnd;
            return getBuilder();
        }

        default FlexLayoutBuilder center() {
            getBuilder().justifyContent = JustifyContent.Center;
            return getBuilder();
        }

        default FlexLayoutBuilder spaceBetween() {
            getBuilder().justifyContent = JustifyContent.SpaceBetween;
            return getBuilder();
        }

        default FlexLayoutBuilder spaceAround() {
            getBuilder().justifyContent = JustifyContent.SpaceAround;
            return getBuilder();
        }

        default FlexLayoutBuilder spaceEvenly() {
            getBuilder().justifyContent = JustifyContent.SpaceEvenly;
            return getBuilder();
        }
    }

    public interface AlignItemsBuilder extends SubBuilder {

        default FlexLayoutBuilder start() {
            getBuilder().alignItems = AlignItems.FlexStart;
            return getBuilder();
        }

        default FlexLayoutBuilder end() {
            getBuilder().alignItems = AlignItems.FlexEnd;
            return getBuilder();
        }

        default FlexLayoutBuilder center() {
            getBuilder().alignItems = AlignItems.Center;
            return getBuilder();
        }

        default FlexLayoutBuilder baseline() {
            getBuilder().alignItems = AlignItems.Baseline;
            return getBuilder();
        }

        default FlexLayoutBuilder stretch() {
            getBuilder().alignItems = AlignItems.Strecth;
            return getBuilder();
        }
    }

    FlexDirection flexDirection = FlexDirection.Row;
    FlexWrap flexWrap = FlexWrap.Nowrap;
    AlignItems alignItems = AlignItems.Baseline;
    JustifyContent justifyContent = JustifyContent.FlexStart;
    AlignContent alignContent = AlignContent.FlexStart;

    public FlexLayoutBuilder horizontal() {
        flexDirection = FlexDirection.Row;
        return this;
    }

    public FlexLayoutBuilder horizontalReverse() {
        flexDirection = FlexDirection.RowReverse;
        return this;
    }

    public FlexLayoutBuilder vertical() {
        flexDirection = FlexDirection.Column;
        return this;
    }

    public FlexLayoutBuilder verticalReverse() {
        flexDirection = FlexDirection.ColumnReverse;
        return this;
    }

    public FlexLayoutBuilder wrap() {
        flexWrap = FlexWrap.Wrap;
        return this;
    }

    public FlexLayoutBuilder nowrap() {
        flexWrap = FlexWrap.Nowrap;
        return this;
    }

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

    public FlexLayout build() {
        return new FlexLayout(this);
    }
}
