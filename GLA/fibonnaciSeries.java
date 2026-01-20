package GLA;

import java.util.Scanner;

public class fibonnaciSeries {
    public static void main(String[] args) {
        Scanner obj = new Scanner(System.in);
    int[] arr = {0, 1, 1, 2, 3, 5, 8};
    
    int sum = sumOfFibonnacci(int[] arr);
    System.out.println(sum);
    }

    public static int sumOfFibonnacci(int[] arr) {
        int a = arr[0];
        int b = arr[1];
        int sum = 0;
        int i = 0;
        while (2 < arr.length - 1) {
            sum = a + b;
            
            a = b;
            b = sum;
            i++;
        }
        return sum;
    }
}
