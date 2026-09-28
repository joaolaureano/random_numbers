# Random Numbers (LCG) — JavaFX Demo

🇧🇷 [Leia em Português](README.pt-BR.md) | 🇺🇸 English version below

## Objective

This project implements a simple **Linear Congruential Generator (LCG)** —
a classic pseudo-random number generation algorithm — in Java, and displays
the generated sequence on a scatter plot using **JavaFX**.

The LCG formula implemented is:

```
X(n+1) = (a * X(n) + c) mod m
```

where the result is then normalized to the `[0, 1)` range by dividing by `m`.

This was a **university (college) assignment project**, built to explore
pseudo-random number generation algorithms and basic JavaFX charting.

## Versions

- **[`v1.0-original`](../../releases/tag/v1.0-original)** — the original
  version submitted for the assignment, kept unmodified as a historical
  reference/tag.
- **Current version (this branch/`main`)** — the same project with the bugs
  described below fixed.

## Bugs found and fixed in the current version

1. **`NullPointerException` in `App.main`** — the loop that generated the
   random numbers ran *before* `randomGenerator` was instantiated
   (`randomGenerator = new Random(...)` was placed after the loop that used
   it). Fixed by creating the generator before generating numbers.
2. **The generator never advanced its internal state** — `Random.next()`
   always read/returned from the same `previous_number` field without ever
   updating it, so every call produced the **exact same number** instead of
   a sequence. Fixed by assigning the newly generated value back to
   `previous_number`.
3. **Degenerate LCG parameters** — the original parameters used
   `multiplier = 9` and `modulus = 9`, so `a mod m == 0`, collapsing the
   sequence to a constant value regardless of the fix above. Replaced with
   non-degenerate parameters (`multiplier = 5`, `sum = 3`, `modulus = 17`).
4. **The scatter plot was never actually shown** — `ScatterView.start()` was
   commented out in `App.main`, `setSize()`/`setData()` were never called,
   and `scatterChart` was never instantiated (it would have thrown another
   `NullPointerException` if used). Fixed by properly wiring the chart
   creation, axis setup and data population, and calling it from `main`.
5. **Build artifacts (`target/`) were committed to git** — removed from
   version control and added a `.gitignore`.

## How to run

Requires Java 11+ and Maven.

```bash
cd demo
mvn clean javafx:run
```

## Project structure

```
demo/
  pom.xml
  src/main/java/com/example/
    App.java          # entry point, generates the numbers
    Random.java        # LCG implementation
    ScatterView.java    # JavaFX scatter plot of the generated numbers
```
