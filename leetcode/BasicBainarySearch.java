package leetcode;

import java.util.Scanner;
public class BasicBainarySearch {
    public static void printArray(int[] arr) {
        for(int ele: arr) {
            System.out.print(ele + " ");
        }
        System.out.println();
    }
    
    public static int search (int[] arr, int target) {
        int low = 0;
        int high = arr.length-1;
        while(low <= high) {
            int mid = low + (high-low)/2;
            if(arr[mid] == target) {
                return mid;
            }
            if(arr[mid] < target) {
                low = mid+1;
            } else if(arr[mid] > target) {
                high = mid - 1;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the size of the array: ");
        int size = scanner.nextInt();

        int[] arr = new int[size];
        for(int i=0; i<arr.length; i++) {
            arr[i] = scanner.nextInt();
        }

        System.out.print("Enter the element you want to search: ");
        int target = scanner.nextInt();
        
        int index = search(arr, target);
        System.out.println(index);
    }
}