[![Published on Vaadin  Directory](https://img.shields.io/badge/Vaadin%20Directory-published-00b4f0.svg)](https://vaadin.com/directory/component/flexlayout-add-on)
[![Stars on Vaadin Directory](https://img.shields.io/vaadin-directory/star/flexlayout-add-on.svg)](https://vaadin.com/directory/component/flexlayout-add-on)

# FlexLayout Add-on for Vaadin 8

FlexLayout is a UI component add-on for Vaadin 8. This add-on brings the configuration of CSS Flexbox to the Java.

This add-on is implemented without the need for widgetset changes. It can be imported to a project without the need for client-side compilation.

## FlexLayout Terminology

### Slot

The `Flexbox` calucates an area inside the layout for each item. This area is here on known as `slot`.

Usually `slot` is the smallest space that fits the item in it. This can be modified with content justification and alignment.

### FlexDirection

`FlexDirection` is the main control for setting the direction of the `FlexLayout`. This direction is referred as `main-axis` later in this README.

| Name          | Actual direction         |
| ------------- | ------------------------ |
| *Row*         | Horizontal               |
| RowReverse    | Horizontal Right-To-Left |
| Column        | Vertical                 |
| ColumnReverse | Vertical Bottom-To-Top   |

### FlexWrap

`FlexWrap` determines if the layout is wrapping to next row or column or should scrolling be used.

Default mode, `Nowrap`, will use scrolling. `WrapReverse` will wrap to previous row or column.

### JustifyContent

`JustifyContent` defines the justification and spacing. This is relevant to the `main-axis` of the layout.

| Name         | Effect                                               |
| ------------ | ---------------------------------------------------- |
| *FlexStart*  | Content placed at the start of the layout            |
| FlexEnd      | Content placed at the end of the layout              |
| Center       | Content placed in middle of the layout               |
| SpaceBetween | All empty space is between the items                 |
| SpaceAround  | All empty space is divided around each item          |
| SpaceEvenly  | All empty space is used to make evenly sized `slots` |

Using `FlexStart`, `FlexEnd` or `Center` will not do any spacing around the items.

### AlignContent

`AlignContent` is used to determine how the `slots` behave perpendicular to the `main-axis` (from now on known as `cross-axis`).

| Name         | Effect                                               |
| ------------ | ---------------------------------------------------- |
| FlexStart    | Items are aligned to `top` or `start of row`         |
| FlexEnd      | Items are aligned to `bottom` or `end of row`        |
| Center       | Items are centered in the middle of the `cross-axis` |
| SpaceBetween | All empty space is between the items                 |
| SpaceAround  | All empty space is divided around each item          |
| *Stretch*    | `Slots` are stretched to fill all available content  |

Using `FlexStart`, `FlexEnd` or `Center` will not do any spacing around the items.

`SpaceBetween` and `SpaceAround` should only be used with `FlexWrap`.

`Stretch` is required for `AlignItems` to work properly.

### AlignItems

`AlignItems` determines the alignment of item along the `cross-axis` inside it's slot.

| Name       | Effect                                          |
| ---------- | ----------------------------------------------- |
| FlexStart  | Items are aligned to the start of the `slot`    |
| FlexEnd    | Items are aligned to the end of the `slot`      |
| Center     | Items are aligned in the middle of the `slot`   |
| Stretch    | Items are stretched to occupy the whole `slot`  |
| *Baseline* | Items are aligned so that their baselines align |

## Code Examples

### Horizontal FlexLayout for evenly spaced controls

This example layout can be used to create a row of controls. Using the `FlexLayout` builder:
```
FlexLayout.create().horizontal()
    .alignItems().center()
    .justifyContent().spaceAround()
    .alignContent().spaceBetween()
    .nowrap()
    .build();
```

Through traditional API:
```
FlexLayout horizontal = new FlexLayout();
horizontal.setFlexDirection(FlexDirection.Row);
horizontal.setAlignItems(AlignItems.Center);
horizontal.setJustifyContent(JustifyContent.SpaceAround);
horizontal.setAlignContent(AlignContent.SpaceBetween);
horizontal.setFlexWrap(FlexWrap.Nowrap);
```

### Vertical FlexLayout with columns aligned to end

This example layout places all items on columns.
```
FlexLayout.create().vertical()
    .alignItems().end()
    .alignContent().stretch()
    .justifyContent().spaceBetween()
    .wrap()
    .build();
```

Through traditional API:
```
FlexLayout vertical = new FlexLayout();
vertical.setFlexDirection(FlexDirection.Column);
vertical.setAlignItems(AlignItems.FlexEnd);
vertical.setJustifyContent(JustifyContent.SpaceBetween);
vertical.setAlignContent(AlignContent.Stretch);
vertical.setFlexWrap(FlexWrap.Wrap);
```

## Changelog

### 0.1

This is the initial release version of FlexLayout. 

- Configuration for `FlexDirection`, `FlexWrap`, `JustifyContent`, `AlignContent`, `AlignItems`.
- Builder for creating your `FlexLayout`.
