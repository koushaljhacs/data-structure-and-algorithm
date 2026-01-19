package leetcode;

import java.util.Scanner;

public class q88 {
    public static void main(String[] args) {
        Scanner obj = new Scanner(System.in);

        System.out.print("Entet the size of first array: ");
        int size1 = obj.nextInt();
        int[] arr = new int[size1];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = obj.nextInt();
        }

        System.out.print("Entet the size of the second array: ");
        int size2 = obj.nextInt();
        int[] brr = new int[size2];
        for (int j = 0; j < brr.length; j++) {
            brr[j] = obj.nextInt();
        }

        int[] crr = new int[arr.length + brr.length];
        printArray(arr);
        System.out.println();
        printArray(brr);
        mergeTwoSortedArray(arr, brr, crr);
        
        obj.close();
    }

    public static void mergeTwoSortedArray(int[] arr, int[] brr, int[] crr) {
        int i = 0, j = 0, k = 0;

            
        while (i < arr.length && brr.length > j) {
            if (arr[i] < brr[j]) {
                crr[k] = arr[i];
                i++;
                k++;
            } else {
                crr[k] = brr[j];
                j++;
                k++;
            }
        }

        // if first array exhaust
        if(i == arr.length) {
            while(j < brr.length) {
                crr[k] = brr[j];
                k++;
                j++;
            }
        }

        // if second array exhaust
        if(j == brr.length) {
            while(i < arr.length) {
                crr[k] = arr[i];
                k++;
                i++;
            }
        }
        System.out.println();
        printArray(crr);
    }

    public static void printArray(int[] crr) {
        for(int ele: crr) {
            System.out.print(ele + " ");
        }
    }
}
