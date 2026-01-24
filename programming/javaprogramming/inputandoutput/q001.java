package javaprogramming.inputandoutput;

import java.util.Scanner;

public class q001 {
    public static void volumeOfSphere(float radius) {
        double volume = (4.0/3.0) * 3.14 * radius * radius * radius;
        System.out.println("Volume of Radius: " + volume);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        if(!scanner.hasNextFloat()) {
            System.out.println("Invalid input. Please enter a valid input");
            scanner.close();
            return;
        }
        float radiusOfBall = scanner.nextFloat();

        volumeOfSphere(radiusOfBall);
        scanner.close();
    }
}
