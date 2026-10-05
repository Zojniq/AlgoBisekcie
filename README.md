# Bisection Method (Metóda bisekcie)

A Java implementation of the numerical **bisection method** for approximating roots of non-linear equations, paired with root isolation via table evaluation.

---

## 📌 Problem Overview

The program finds the root of the equation:

$$f(x) = x - \cos(x) = 0$$

1. **Root Isolation (Separácia koreňov):** Reads a table of values from a data file (`data.txt`) to locate the initial interval $[a, b]$ where the function changes sign ($f(a) \cdot f(b) < 0$).
2. **Bisection Algorithm (Metóda polenia intervalu):** Iteratively halves the interval until the condition $b - a < \varepsilon$ is met, where $\varepsilon$ is the desired tolerance.

---

## 🚀 How It Works

1. The application parses `src/data.txt` containing tab- or space-separated pairs of $(x, f(x))$:
   ```text
   0.5 -0.377583
   0.6 -0.225336
   0.7 -0.064842
   0.8 0.103293
   0.9 0.278390
   1.0 0.459698
