package programming.algorithm.bubblesort;

import java.util.Scanner;

public class BubbleSortImplementation {
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void bubbleSort(int[] arr) {
        int outercount = 0;
        int innercount = 0;
        for (int i = 0; i < arr.length; i++) {
            boolean flag = true;
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                    flag = false;
                }
                innercount++;
            }
            printArray(arr);
            if (flag)
                break;
            outercount++;
            System.out.println("Total Outer loop run: " + outercount);
            System.out.println("Total inner loop run : " + innercount);
        }

    }

    public static void printArray(int[] arr) {
        for (int ele : arr) {
            System.out.print(ele + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner obj = new Scanner(System.in);
        System.out.print("Enter the size of the array: ");
        int size = obj.nextInt();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = obj.nextInt();
        }
        System.out.println();
        printArray(arr);
        bubbleSort(arr);

        obj.close();
    }
}
