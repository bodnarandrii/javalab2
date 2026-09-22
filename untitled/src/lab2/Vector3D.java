package lab2;

import java.util.Scanner;

public class Vector3D {
    private double x;
    private double y;
    private double z;

    public static int vectorCount = 0;

    public Vector3D() {
        this(0, 0, 0);
    }

    public Vector3D(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
        vectorCount++;
    }

    public static int getVectorCount() {
        return vectorCount;
    }

    public Vector3D add(Vector3D other) {
        return new Vector3D(this.x + other.x, this.y + other.y, this.z + other.z);
    }

    public Vector3D subtract(Vector3D other) {
        return new Vector3D(this.x - other.x, this.y - other.y, this.z - other.z);
    }

    public double dotProduct(Vector3D other) {
        return this.x * other.x + this.y * other.y + this.z * other.z;
    }

    public Vector3D multiplyByScalar(double scalar) {
        return new Vector3D(this.x * scalar, this.y * scalar, this.z * scalar);
    }

    public double length() {
        return Math.sqrt(x * x + y * y + z * z);
    }

    public int compareLength(Vector3D other) {
        return Double.compare(this.length(), other.length());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Vector3D vector3D = (Vector3D) obj;
        return Double.compare(vector3D.x, x) == 0 &&
                Double.compare(vector3D.y, y) == 0 &&
                Double.compare(vector3D.z, z) == 0;
    }

    @Override
    public String toString() {
        return String.format("Vector3D(%.2f, %.2f, %.2f)", x, y, z);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введіть координати першого вектора (x y z):");
        Vector3D v1 = new Vector3D(in.nextDouble(), in.nextDouble(), in.nextDouble());

        System.out.println("Введіть координати другого вектора (x y z):");
        Vector3D v2 = new Vector3D(in.nextDouble(), in.nextDouble(), in.nextDouble());

        System.out.println("Введіть скаляр для множення:");
        double scalar = in.nextDouble();

        System.out.println("Вектор 1: " + v1.toString());
        System.out.println("Вектор 2: " + v2.toString());
        System.out.println("Додавання: " + v1.add(v2));
        System.out.println("Віднімання: " + v1.subtract(v2));
        System.out.println("Скалярний добуток: " + v1.dotProduct(v2));
        System.out.println("Множення Вектора 1 на скаляр: " + v1.multiplyByScalar(scalar));
        System.out.println("Довжина Вектора 1: " + v1.length());
        System.out.println("Вектори рівні? " + (v1.equals(v2) ? "Так" : "Ні"));
        System.out.println("Порівняння довжин: " + v1.compareLength(v2));
        System.out.println("Створено векторів: " + Vector3D.getVectorCount());

        in.close();
    }
}