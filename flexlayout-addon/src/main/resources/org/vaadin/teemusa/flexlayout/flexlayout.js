org_vaadin_teemusa_flexlayout_FlexLayoutControl = function () {
    function styleCase(camelCase) {
        var result = camelCase[0].toLowerCase();
        for (var i = 1; i < camelCase.length; ++i) {
            if (camelCase.charAt(i) == camelCase.charAt(i).toUpperCase()) {
                result += "-";
            }
            result += camelCase.charAt(i).toLowerCase()
        }
        return result;
    }

    var self = this;
    self.onStateChange = function () {
        var element = self.getElement(self.getParentId());
        var state = self.getState().flexStyle;
        var keys = Object.keys(state);
        for (var i = 0; i < keys.length; ++i) {
            element.style.setProperty(styleCase(keys[i]), styleCase(state[keys[i]]));
        }

        var alignMap = self.getState().componentAlignMap;
        var componentIds = Object.keys(alignMap);
        for (var i = 0; i < componentIds.length; ++i) {
            var componentElement = self.getElement(componentIds[i]);
            componentElement.style.setProperty("align-self", styleCase(alignMap[componentIds[i]]));
        }
    };
};