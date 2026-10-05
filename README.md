# Numerical Bisection Method

[Українська версія](README.uk.md)

A Java implementation of the numerical **bisection method**, also known as the interval halving method, for finding real roots of continuous functions.

## Problem description

By default, the program solves the equation:

$$f(x) = x - \cos(x) = 0$$

The program:

1. Reads pairs of values $(x, f(x))$ from `data.txt`.
2. Finds an initial interval in which the function changes sign.
3. Repeatedly divides the interval in half.
4. Stops when the interval length satisfies the requested `epsilon` accuracy.

## Algorithm flexibility

The program can be adapted to any continuous function for which an interval containing a sign change is known.

### 1. Change the function formula

Update the `f(double x)` method in the `Main` class:

```java
// Example 1: polynomial x^3 - x - 2 = 0
static double f(double x) {
    return Math.pow(x, 3) - x - 2;
}

// Example 2: equation exp(-x) - x = 0
static double f(double x) {
    return Math.exp(-x) - x;
}
```

### 2. Update `data.txt`

Replace the contents of `data.txt` with a new table of points for the selected function. The program will automatically search for neighboring points where the function changes sign.

> **Important:** The function must be continuous on the selected interval. For example, the bisection method must not be applied to an interval containing `x = 0` for the function $f(x) = \frac{1}{x}$.

## Input data format

The `data.txt` file must contain pairs of numbers separated by a space or tab:

```text
0.5 -0.377583
0.6 -0.225336
0.7 -0.064842
0.8 0.103293
0.9 0.278390
1.0 0.459698
```

## Running the project

### Requirements

- Java Development Kit (JDK 17+)
- IntelliJ IDEA or another Java-compatible IDE

### Run from the terminal

```bash
# Compile
javac -d out src/Main.java

# Run
java -cp out Main
```

## Example output

```text
Initial interval found: [0.70, 0.80]
Enter epsilon (for example, 0.001): 0.001
Step 1: a = 0.700000, b = 0.800000, mid = 0.750000, f(mid) = 0.018311
Step 2: a = 0.700000, b = 0.750000, mid = 0.725000, f(mid) = -0.023497
Step 3: a = 0.725000, b = 0.750000, mid = 0.737500, f(mid) = -0.002677
...
Calculation finished! Approximate root: 0.739063
```
