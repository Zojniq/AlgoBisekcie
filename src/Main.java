import java.io.File;
import java.io.FileNotFoundException;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    // Математична функція f(x) = x - cos(x)
    // Math.cos у Java автоматично приймає радіани
    static double f(double x) {
        return x - Math.cos(x);
    }

    // Метод шукає перший інтервал зміни знака і повертає масив з двох чисел [a, b]
    static double[] scanData() {
        File file = new File("src/data.txt"); // або просто "data.txt", якщо файл у корені

        try (Scanner scanner = new Scanner(file)) {
            scanner.useLocale(Locale.US);

            if (!scanner.hasNextDouble()) {
                System.out.println("Файл порожній");
                return null;
            }

            double prevX = scanner.nextDouble();
            double prevF = scanner.nextDouble();

            while (scanner.hasNextDouble()) {
                double currentX = scanner.nextDouble();
                double currentF = scanner.nextDouble();

                // Якщо знаки протилежні — інтервал знайдено
                if (prevF * currentF < 0) {
                    System.out.printf("Знайдено початковий інтервал: [%.2f, %.2f]\n", prevX, currentX);
                    return new double[]{prevX, currentX};
                }

                prevX = currentX;
                prevF = currentF;
            }

        } catch (FileNotFoundException e) {
            System.err.println("Файл не знайдено: " + e.getMessage());
        }

        return null;
    }

    // Метод бісекції
    static void algo(double a, double b) {
        Scanner scan = new Scanner(System.in);
        scan.useLocale(Locale.US);

        System.out.print("Введи іпсілон (наприклад, 0.001): ");
        double eps = scan.nextDouble();

        int step = 1;
        // Крутимо цикл, доки довжина відрізка (b - a) більша за точність
        while ((b - a) > eps) {
            double mid = (a + b) / 2.0;
            double fMid = f(mid);

            System.out.printf("Крок %d: a = %.6f, b = %.6f, mid = %.6f, f(mid) = %.6f\n",
                    step++, a, b, mid, fMid);

            // Якщо випадково потрапили точно в нуль
            if (fMid == 0.0) {
                a = mid;
                b = mid;
                break;
            }

            // Перевіряємо знак лівої половини [a, mid]
            if (f(a) * fMid < 0) {
                b = mid; // корінь зліва
            } else {
                a = mid; // корінь справа
            }
        }

        double root = (a + b) / 2.0;
        System.out.printf("\nОбчислення завершено! Наближений корінь: %.6f\n", root);
    }

    public static void main(String[] args) {
        // 1. Зчитуємо дані й отримуємо початковий інтервал
        double[] interval = scanData();

        // 2. Якщо інтервал успішно знайдено ,запускаємо метод бісекції
        if (interval != null) {
            algo(interval[0], interval[1]);
        } else {
            System.out.println("Інтервал для бісекції не вдалося знайти.");
        }
    }
}