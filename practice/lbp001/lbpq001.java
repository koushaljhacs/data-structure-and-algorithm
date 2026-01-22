package practice.lbp001;

import java.util.Scanner;
public class lbpq001 {
    public static boolean isPrimeDigit(int number) {
        if(number == 2 || number == 3 || number == 5 || number == 7) {
            return true;
        }
        return false;
    }
    public static int calculateSumOfPrimeDigit(int number) {
        int temp = number;
        int sum = 0;
        while(temp != 0) {
            int lastDigit = temp % 10;
            if(isPrimeDigit(lastDigit)) {
                sum += lastDigit;
            }
            temp /= 10;
        }
        return sum;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number: ");
        if(!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter only integer value.");
            scanner.close();
            return;
        }
        int number = scanner.nextInt();

        int result = calculateSumOfPrimeDigit(number);
        System.out.println("The sum of prime Digit: " + result);
        scanner.close();
    }
}
