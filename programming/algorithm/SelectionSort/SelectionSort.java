/**
 * =================================================================================
 * ALGORITHM: Selection Sort (In-place Comparison Sort)
 * PROBLEM:   Sort an array by repeatedly finding the minimum element
 * AUTHOR:    Koushal Jha
 * DATE:      2026-01-27
 * * DESCRIPTION:
 * Selection sort divides the input list into two parts: a sorted sublist of items 
 * which is built up from left to right, and a sublist of the remaining unsorted items.
 * * TIME COMPLEXITY:  O(n²) - Worst, Average, and Best cases.
 * SPACE COMPLEXITY: O(1)   - In-place sorting.
 * =================================================================================
 */

package development.algorithm.SelectionSort;

import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.Arrays;

public class SelectionSort {

    /**
     * Core Selection Sort Logic
     * @param arr The array to be sorted
     */
    public void sort(int[] arr) {
        int n = arr.length;

        // One by one move boundary of unsorted subarray
        for (int i = 0; i < n - 1; i++) {
            // Find the minimum element in unsorted array
            int minIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIdx]) {
                    minIdx = j;
                }
            }

            // Swap the found minimum element with the first element
            if (minIdx != i) {
                int temp = arr[minIdx];
                arr[minIdx] = arr[i];
                arr[i] = temp;
            }
        }
    }

    /**
     * Main Driver with Robust Error Handling
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SelectionSort ss = new SelectionSort();

        System.out.println("=== SYSTEM AUDIT: SELECTION SORT ===");
        System.out.println("Author: Koushal Jha");

        try {
            System.out.print("Enter the size of the array: ");
            int size = sc.nextInt();

            // Error Handling: Negative Size
            if (size < 0) {
                System.err.println("CRITICAL ERROR: Array size cannot be negative.");
                return;
            }

            // Handle empty array case
            if (size == 0) {
                System.out.println("Array is empty. Nothing to sort.");
                return;
            }

            int[] arr = new int[size];
            System.out.println("Enter " + size + " integers:");
            for (int i = 0; i < size; i++) {
                arr[i] = sc.nextInt();
            }

            System.out.println("\nOriginal Array: " + Arrays.toString(arr));
            
            // Execution
            ss.sort(arr);

            System.out.println("Sorted Array:   " + Arrays.toString(arr));

        } catch (InputMismatchException e) {
            // Error Handling: Non-integer inputs
            System.err.println("CRITICAL ERROR: Invalid input. Please enter integers only.");
        } catch (Exception e) {
            System.err.println("SYSTEM ERROR: " + e.getMessage());
        } finally {
            sc.close();
            System.out.println("\nProcess terminated.");
        }
    }
}