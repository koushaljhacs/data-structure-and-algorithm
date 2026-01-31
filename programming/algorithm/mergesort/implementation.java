package programming.algorithm.mergesort;

import java.util.Scanner;

public class implementation {
    public static void printArray(int[] arr) {
        for (int ele : arr) {
            System.out.print(ele + " ");
        }
    }

    public static void mergeTwoArray(int[] arr, int[] brr, int[] ans) {
        int i = 0; // arr -> first partion
        int j = 0; // brr -> second partion
        int k = 0; // ans -> original array arr

        while (i < arr.length && j < brr.length) {
            if (arr[i] <= brr[j]) {
                ans[k] = arr[i];
                i++;
            } else {
                ans[k] = brr[j];
                j++;
            }
            k++;
        }

        while (i < arr.length) {
            ans[k] = arr[i];
            k++;
            i++;
        }
        while (j < brr.length) {
            ans[k] = brr[j];
            k++;
            j++;
        }
    }

    public static void mergeSort(int[] arr) {
        if (arr.length == 1)
            return;
        int[] firstPartition = new int[arr.length / 2];
        for (int i = 0; i < firstPartition.length; i++) {
            firstPartition[i] = arr[i];
        }

        int[] secondPartition = new int[arr.length - arr.length / 2];
        for (int j = 0; j < secondPartition.length; j++) {
            secondPartition[j] = arr[j + firstPartition.length];
        }

        mergeSort(firstPartition);
        mergeSort(secondPartition);
        mergeTwoArray(firstPartition, secondPartition, arr);
    }

    public static void main(String[] args) {
        int[] arr = { 10, 9, 8, 7, 6, 5, 4, 3, 2, 1 };

        mergeSort(arr);
        printArray(arr);
    }
}
