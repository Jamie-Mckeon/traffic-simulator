# Traffic Simulator

A JavaFX desktop application for building and simulating road traffic networks: place
intersections and roads, set per-road speed limits and lane counts, configure traffic lights,
and watch vehicles navigate the network.

Planned to start as a JavaFX desktop app, then get a web front end later.

## Status

Early scaffold. The project structure, Maven build, and package layout are in place; the actual
model/simulation/UI logic is still to be written (see the `TODO`s throughout `src/main/java`).

## Tech stack

- Java 21
- JavaFX 21 (via the `javafx-maven-plugin`)
- Maven
- JUnit 5

## Project layout

```
src/main/java/com/trafficsim/
  model/        Road, Intersection, Vehicle, TrafficLightController, RoadNetwork
  simulation/   IdmCalculator, SimulationEngine, SimulationStats
  editor/       RoadNetworkEditor, EditorMode, Selection
  ui/           MainApp, NetworkCanvas, EditorToolbar, PropertiesPanel, StatsPanel
  util/         Observable (a tiny framework-agnostic property/listener type)
```

`model`, `simulation`, `editor`, and `util` have no JavaFX imports — only `ui` does. That's
intentional: if this ever grows a web front end, the simulation engine and editing logic should
be reusable as-is behind a different UI (e.g. a web backend exposing them over REST/WebSocket),
rather than rewritten.

## Running it

```
mvn javafx:run
```

## Testing

```
mvn test
```

## Roadmap

- [ ] Road network editor: place/select intersections and roads on a canvas
- [ ] Per-road speed limits and lane counts, editable from a properties panel
- [ ] Traffic lights with configurable per-approach timing
- [ ] Vehicle simulation (car-following model, routing between intersections)
- [ ] Live stats overlay (throughput, average speed, queue lengths)
- [ ] Web version
