package lab2;

import java.util.Scanner;

public class Drib {
    private int numerator;
    private int denominator;

    public static int operationsCount = 0;

    public Drib() {
        this(0, 1);
    }

    public Drib(int numerator, int denominator) {
        if (denominator == 0) {
            throw new IllegalArgumentException("Знаменник не може дорівнювати нулю!");
        }
        this.numerator = numerator;
        this.denominator = denominator;
        reduce();
    }

    public static int getOperationsCount() {
        return operationsCount;
    }

    private int gcd(int a, int b) {
        return b == 0 ? Math.abs(a) : gcd(b, a % b);
    }

    private void reduce() {
        int gcd = gcd(numerator, denominator);
        numerator /= gcd;
        denominator /= gcd;
        if (denominator < 0) {
            numerator = -numerator;
            denominator = -denominator;
        }
    }

    public Drib add(Drib other) {
        operationsCount++;
        int newNum = this.numerator * other.denominator + other.numerator * this.denominator;
        int newDen = this.denominator * other.denominator;
        return new Drib(newNum, newDen);
    }

    public Drib subtract(Drib other) {
        operationsCount++;
        int newNum = this.numerator * other.denominator - other.numerator * this.denominator;
        int newDen = this.denominator * other.denominator;
        return new Drib(newNum, newDen);
    }

    public Drib multiply(Drib other) {
        operationsCount++;
        return new Drib(this.numerator * other.numerator, this.denominator * other.denominator);
    }

    public Drib divide(Drib other) {
        operationsCount++;
        if (other.numerator == 0) {
            throw new ArithmeticException("Ділення на нуль!");
        }
        return new Drib(this.numerator * other.denominator, this.denominator * other.numerator);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Drib drib = (Drib) obj;
        return numerator == drib.numerator && denominator == drib.denominator;
    }

    @Override
    public String toString() {
        return denominator == 1 ? String.valueOf(numerator) : numerator + "/" + denominator;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введіть 4 цілих числа (чисельник і знаменник першого, потім другого дробу):");

        int n1 = in.nextInt();
        int d1 = in.nextInt();
        int n2 = in.nextInt();
        int d2 = in.nextInt();

        Drib dFirst = new Drib(n1, d1);
        Drib dSecond = new Drib(n2, d2);

        System.out.println("Дріб 1 (після скорочення): " + dFirst);
        System.out.println("Дріб 2 (після скорочення): " + dSecond);

        System.out.println("Додавання: " + dFirst.add(dSecond));
        System.out.println("Віднімання: " + dFirst.subtract(dSecond));
        System.out.println("Множення: " + dFirst.multiply(dSecond));
        System.out.println("Ділення: " + dFirst.divide(dSecond));
        System.out.println("Дроби рівні? " + dFirst.equals(dSecond));

        System.out.println("Всього виконано математичних операцій: " + Drib.getOperationsCount());

        in.close();
    }
}