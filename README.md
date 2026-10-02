# Random Numbers (LCG) — V1 (original version)

**[Leia em português / Read this in Portuguese](README.pt-BR.md)**

A **Linear Congruential Generator (LCG)** in Java, `X(n+1) = (a * X(n) + c) mod m`
normalized to `[0, 1)`, meant to show the generated sequence on a **JavaFX**
scatter plot. Built as a college assignment to explore pseudo-random number
generation.

> **This is the archived original version**, exactly as it was submitted.
> The only change on top of it is this README. The fixed version lives on the
> [`master`](../../tree/master) branch.

## Running

Requires Java 11+ and Maven.

```bash
cd demo
mvn clean javafx:run
```

## Known issues in this version

These were found later and are fixed on `master`:

1. `App.main` uses the generator before creating it (`NullPointerException`).
2. `Random.next()` never updates its state, so every call returns the same
   number.
3. The parameters (`multiplier = 9`, `modulus = 9`) are degenerate and
   collapse the sequence to a constant.
4. The scatter plot is never shown: the call is commented out and the chart
   is never created.
5. Build artifacts (`target/`) are committed.
