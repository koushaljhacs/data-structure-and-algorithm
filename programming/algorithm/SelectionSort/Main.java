package development.algorithm.SelectionSort;

import java.util.Arrays;

public class Main {
    public static void swap(int[] arr, int i, int minIdx) {
        int temp = arr[i];
        arr[i] = arr[minIdx];
        arr[minIdx] = temp;
    }
    public static void selectionSort(int[] arr) {
        for(int i=0; i<arr.length-1; i++) {
            int minIdx = i;
            for(int j=i+1; j<arr.length; j++) {
                if(arr[j] < arr[minIdx]) {
                    minIdx = j;
                }
            }
            if(minIdx != i) {
                arr[i] = (arr[i] + arr[minIdx]) - (arr[minIdx] = arr[i]);
            }
        }
    }
    public static void main(String[] args) {
        int[] arr = {6,4,3,2,1};
        selectionSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
