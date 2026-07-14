package com.trafficsim.editor;

import com.trafficsim.model.RoadNetwork;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;

/**
 * TODO: translate canvas clicks into edits on a {@link RoadNetwork}: placing intersections,
 * drawing roads between them (probably a two-click flow: click a start intersection, then an
 * end intersection), selecting elements for a properties panel, and deleting elements.
 *
 * Worth keeping this independent of JavaFX rendering (it already only depends on the model
 * package) so the click-handling logic can be unit tested without a display.
 */
public class RoadNetworkEditor {

    private final RoadNetwork network;
    private final ObjectProperty<EditorMode> mode = new SimpleObjectProperty<>(EditorMode.SELECT);
    private final ObjectProperty<Selection> selection = new SimpleObjectProperty<>(Selection.NONE);

    public RoadNetworkEditor(RoadNetwork network) {
        this.network = network;
    }

    public RoadNetwork getNetwork() {
        return network;
    }

    public ObjectProperty<EditorMode> modeProperty() {
        return mode;
    }

    public ObjectProperty<Selection> selectionProperty() {
        return selection;
    }

    public Selection getSelection() {
        return selection.get();
    }

    /** TODO: handle a primary-button click on the canvas at the given model-space coordinates,
     *  branching on the current mode (see {@link EditorMode}). */
    public void handleClick(double x, double y) {
        throw new UnsupportedOperationException("TODO: implement");
    }

    /** TODO: delete whatever is currently selected (e.g. bound to the Delete/Backspace key). */
    public void deleteSelection() {
        throw new UnsupportedOperationException("TODO: implement");
    }
}
