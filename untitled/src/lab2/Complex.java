package lab2;

import java.util.Scanner;

public class Complex {
    private double real;
    private double imaginary;

    public static int complexCount = 0;

    public Complex() {
        this(0, 0);
    }

    public Complex(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
        complexCount++;
    }

    public static void printInfo() {
        System.out.println("Загальна кількість комплексних чисел: " + complexCount);
    }

    public double modulus() {
        return Math.sqrt(real * real + imaginary * imaginary);
    }

    public double argument() {
        return Math.atan2(imaginary, real);
    }

    public Complex add(Complex other) {
        return new Complex(this.real + other.real, this.imaginary + other.imaginary);
    }

    public Complex subtract(Complex other) {
        return new Complex(this.real - other.real, this.imaginary - other.imaginary);
    }

    public Complex multiply(Complex other) {
        double newReal = this.real * other.real - this.imaginary * other.imaginary;
        double newImg = this.real * other.imaginary + this.imaginary * other.real;
        return new Complex(newReal, newImg);
    }

    public Complex divide(Complex other) {
        double denominator = other.real * other.real + other.imaginary * other.imaginary;
        double newReal = (this.real * other.real + this.imaginary * other.imaginary) / denominator;
        double newImg = (this.imaginary * other.real - this.real * other.imaginary) / denominator;
        return new Complex(newReal, newImg);
    }

    public Complex conjugate() {
        return new Complex(this.real, -this.imaginary);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Complex complex = (Complex) obj;
        return Double.compare(complex.real, real) == 0 &&
                Double.compare(complex.imaginary, imaginary) == 0;
    }

    @Override
    public String toString() {
        if (imaginary >= 0) {
            return String.format("%.2f + %.2fi", real, imaginary);
        } else {
            return String.format("%.2f - %.2fi", real, -imaginary);
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введіть дійсне та уявне значення першого числа (a b):");
        Complex c1 = new Complex(in.nextDouble(), in.nextDouble());

        System.out.println("Введіть дійсне та уявне значення другого числа (a b):");
        Complex c2 = new Complex(in.nextDouble(), in.nextDouble());

        System.out.println("Ч1: " + c1);
        System.out.println("Ч2: " + c2);
        System.out.println("Модуль Ч1: " + c1.modulus());
        System.out.println("Аргумент Ч1: " + c1.argument());
        System.out.println("Додавання: " + c1.add(c2));
        System.out.println("Віднімання: " + c1.subtract(c2));
        System.out.println("Множення: " + c1.multiply(c2));
        System.out.println("Ділення: " + c1.divide(c2));
        System.out.println("Спряження Ч1: " + c1.conjugate());
        System.out.println("Числа рівні? " + c1.equals(c2));
        Complex.printInfo();

        in.close();
    }
}
