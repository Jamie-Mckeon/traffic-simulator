package com.trafficsim.ui;

import com.trafficsim.editor.RoadNetworkEditor;
import javafx.scene.layout.VBox;

/**
 * TODO: side panel showing editable properties for whatever is currently selected on the
 * canvas — speed limit and lane count for a road, or per-approach green-light timing for an
 * intersection. Listen to {@link RoadNetworkEditor#selectionProperty()} and rebuild the panel's
 * contents whenever the selection changes.
 */
public class PropertiesPanel extends VBox
{

    private final RoadNetworkEditor editor;

    public PropertiesPanel(RoadNetworkEditor editor, Runnable onChange)
    {
        this.editor = editor;
        // TODO: build the initial (empty) UI and listen for selection changes.
    }
}
