package leetcode;

import java.util.Scanner;
public class SearchInsertPosition {
    public static int searchIndexPosition(int[] arr, int target) {
        int low = 0;
        int high = arr.length-1;
        while(low <= high) {
            int mid = low + (high-low)/2;
            if(arr[mid] == target) {
                return mid;
            } else if(arr[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }
    
    public static void main(String[] args) {
        Scanner obj = new Scanner(System.in);
        System.out.print("Enter the size of the array: ");
        int size = obj.nextInt();

        int[] arr = new int[size];
        for(int i=0; i<size; i++) {
            arr[i] = obj.nextInt();
        }

        System.out.print("Enter the target element you want to search: ");
        int target = obj.nextInt();

        int index = searchIndexPosition(arr, target);
        System.out.println("The element found at index: " + index);
    }
}
