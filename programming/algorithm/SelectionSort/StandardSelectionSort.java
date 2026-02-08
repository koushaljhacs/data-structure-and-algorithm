/**
 * =================================================================================
 * ALGORITHM: Selection Sort (In-place Comparison Sort)
 * PROBLEM:   Sort an array by repeatedly finding the minimum element
 * AUTHOR:    Koushal Jha
 * DATE:      2026-01-27
 * * DESCRIPTION:
 * Selection sort works by dividing the array into a sorted and an unsorted region.
 * It repeatedly selects the smallest element from the unsorted region and swaps 
 * it into its correct position at the end of the sorted region.
 * * TIME COMPLEXITY:  O(n²) - Worst, Average, and Best cases.
 * SPACE COMPLEXITY: O(1)   - In-place sorting.
 * =================================================================================
 */

package development.algorithm.SelectionSort;

import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.Arrays;

public class StandardSelectionSort {

    /**
     * Orchestrates the Selection Sort algorithm using meaningful variable tracking.
     * @param numbers The array of integers to be sorted.
     */
    public void sort(int[] numbers) {
        if (numbers == null || numbers.length <= 1) {
            return;
        }

        int totalElements = numbers.length;

        // One by one move the boundary of the unsorted subarray
        for (int currentBoundaryIndex = 0; currentBoundaryIndex < totalElements - 1; currentBoundaryIndex++) {
            
            // Assume the current boundary element is the minimum
            int minimumValueIndex = currentBoundaryIndex;

            // Scan the remaining unsorted portion to find the actual minimum
            for (int scanningIndex = currentBoundaryIndex + 1; scanningIndex < totalElements; scanningIndex++) {
                if (numbers[scanningIndex] < numbers[minimumValueIndex]) {
                    minimumValueIndex = scanningIndex;
                }
            }

            // Perform the swap only if a smaller element was found
            if (minimumValueIndex != currentBoundaryIndex) {
                swapElements(numbers, minimumValueIndex, currentBoundaryIndex);
            }
        }
    }

    /**
     * Utility method to swap two elements in an array using a temporary variable.
     * Encapsulating this logic follows the Single Responsibility Principle.
     * * @param array  The target array.
     * @param first  The index of the first element.
     * @param second The index of the second element.
     */
    private void swapElements(int[] array, int first, int second) {
        int temporaryStorage = array[first];
        array[first] = array[second];
        array[second] = temporaryStorage;
    }

    /**
     * Main entry point with robust error handling for user interaction.
     */
    public static void main(String[] args) {
        Scanner inputScanner = new Scanner(System.in);
        SelectionSort selectionSorter = new SelectionSort();

        System.out.println("=== SYSTEM AUDIT: SELECTION SORT ===");
        System.out.println("Author: Koushal Jha");

        try {
            System.out.print("Enter the size of the array: ");
            int arraySize = inputScanner.nextInt();

            // Error Handling: Negative Size
            if (arraySize < 0) {
                System.err.println("CRITICAL ERROR: Array size cannot be negative.");
                return;
            }

            // Handle empty array case
            if (arraySize == 0) {
                System.out.println("Array is empty. Nothing to sort.");
                return;
            }

            int[] numbers = new int[arraySize];
            System.out.println("Enter " + arraySize + " integers:");
            for (int i = 0; i < arraySize; i++) {
                numbers[i] = inputScanner.nextInt();
            }

            System.out.println("\nOriginal Array: " + Arrays.toString(numbers));
            
            // Execution of the sorting algorithm
            selectionSorter.sort(numbers);

            System.out.println("Sorted Array:   " + Arrays.toString(numbers));

        } catch (InputMismatchException e) {
            // Error Handling: Non-integer inputs
            System.err.println("CRITICAL ERROR: Invalid input. Please enter integers only.");
        } catch (Exception e) {
            System.err.println("SYSTEM ERROR: " + e.getMessage());
        } finally {
            inputScanner.close();
            System.out.println("\nProcess terminated.");
        }
    }
}