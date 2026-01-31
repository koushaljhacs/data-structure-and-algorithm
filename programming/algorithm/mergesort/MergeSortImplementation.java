package programming.algorithm.mergesort;

/**
 * MERGE SORT ALGORITHM IMPLEMENTATION
 * ===================================
 * 
 * PURPOSE:
 * This class implements the Merge Sort algorithm, a divide-and-conquer
 * sorting algorithm with O(n log n) time complexity.
 * 
 * WHY USE MERGE SORT:
 * 1. Stable Algorithm: Maintains relative order of equal elements
 * 2. Predictable Performance: Always O(n log n) regardless of input
 * 3. Suitable for: Large datasets, linked lists, external sorting
 * 4. Disadvantages: Requires O(n) auxiliary space
 * 
 * ALGORITHM OVERVIEW:
 * 1. DIVIDE: Split array into two halves recursively until single elements
 * 2. CONQUER: Sort each half recursively
 * 3. COMBINE: Merge sorted halves back together
 * 
 * PARAMETERS EXPLANATION:
 * -----------------------
 * int[] array: The array to be sorted (in-place sorting)
 * int[] leftArray: First sorted half during merge phase
 * int[] rightArray: Second sorted half during merge phase  
 * int[] resultArray: Destination array for merged result
 * 
 * TIME COMPLEXITY: O(n log n) for all cases (best, average, worst)
 * SPACE COMPLEXITY: O(n) for auxiliary array storage
 * 
 * USAGE EXAMPLE:
 * --------------
 * int[] data = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
 * MergeSortImplementation.mergeSort(data);
 * MergeSortImplementation.printArray(data);
 * 
 * OUTPUT: 1 2 3 4 5 6 7 8 9 10
 * 
 * Author: Koushal Jha
 * Date: 31.01.2026
 * Version: 1.0
 */
public class MergeSortImplementation {
    
    /**
     * Displays the elements of an integer array
     * @param array The array to be printed
     * WHY: Utility method for visualization/debugging
     * USE: Call after sorting to verify results
     */
    public static void printArray(int[] array) {
        // Validate input to prevent NullPointerException
        if (array == null) {
            System.out.println("Array is null");
            return;
        }
        
        // Iterate through each element in the array
        for (int element : array) {
            System.out.print(element + " "); // Print element followed by space
        }
        System.out.println(); // Move to next line after printing all elements
    }

    /**
     * Merges two sorted arrays into a single sorted array
     * @param leftArray First sorted array (left partition)
     * @param rightArray Second sorted array (right partition) 
     * @param resultArray The array where merged result will be stored
     * @throws IllegalArgumentException if any input array is null
     * WHY: Core merging logic of merge sort
     * USE: Called recursively to combine sorted partitions
     */
    public static void mergeSortedArrays(int[] leftArray, int[] rightArray, int[] resultArray) {
        // Exception handling for null arrays
        if (leftArray == null || rightArray == null || resultArray == null) {
            throw new IllegalArgumentException("Input arrays cannot be null");
        }
        
        // Validate that result array has enough capacity
        if (resultArray.length < leftArray.length + rightArray.length) {
            throw new IllegalArgumentException("Result array is too small to hold merged elements");
        }
        
        int leftIndex = 0;    // Pointer for leftArray
        int rightIndex = 0;   // Pointer for rightArray
        int resultIndex = 0;  // Pointer for resultArray

        // Merge elements while both arrays have unprocessed elements
        while (leftIndex < leftArray.length && rightIndex < rightArray.length) {
            // Compare elements from both arrays and take the smaller one
            if (leftArray[leftIndex] <= rightArray[rightIndex]) {
                resultArray[resultIndex] = leftArray[leftIndex]; // Take from left array
                leftIndex++; // Move left pointer forward
            } else {
                resultArray[resultIndex] = rightArray[rightIndex]; // Take from right array
                rightIndex++; // Move right pointer forward
            }
            resultIndex++; // Move result pointer forward
        }

        // Copy any remaining elements from leftArray (if any)
        while (leftIndex < leftArray.length) {
            resultArray[resultIndex] = leftArray[leftIndex];
            resultIndex++;
            leftIndex++;
        }

        // Copy any remaining elements from rightArray (if any)
        while (rightIndex < rightArray.length) {
            resultArray[resultIndex] = rightArray[rightIndex];
            resultIndex++;
            rightIndex++;
        }
    }

    /**
     * Recursively sorts an array using the Merge Sort algorithm
     * @param array The array to be sorted (sorted in-place)
     * @throws IllegalArgumentException if input array is null
     * WHY: Public interface for sorting functionality
     * USE: Call this method to sort any integer array
     */
    public static void mergeSort(int[] array) {
        // Base case: If array is null, throw exception
        if (array == null) {
            throw new IllegalArgumentException("Input array cannot be null");
        }
        
        // Base case: Array with 0 or 1 element is already sorted
        if (array.length <= 1) {
            return; // No sorting needed for single element or empty array
        }
        
        // Calculate midpoint to split the array
        int midPoint = array.length / 2;
        
        // Create left partition (first half of the array)
        int[] leftPartition = new int[midPoint];
        // Copy elements from original array to left partition
        for (int i = 0; i < leftPartition.length; i++) {
            leftPartition[i] = array[i];
        }

        // Create right partition (second half of the array)
        int[] rightPartition = new int[array.length - midPoint];
        // Copy elements from original array to right partition
        for (int j = 0; j < rightPartition.length; j++) {
            rightPartition[j] = array[j + midPoint]; // Start from midpoint index
        }

        // Recursively sort left partition
        mergeSort(leftPartition);
        // Recursively sort right partition
        mergeSort(rightPartition);
        // Merge the sorted partitions back into original array
        mergeSortedArrays(leftPartition, rightPartition, array);
    }

    /**
     * Main method to demonstrate the Merge Sort algorithm
     * @param args Command line arguments (not used)
     * WHY: Test driver to demonstrate functionality
     * USE: Run this to see the algorithm in action
     */
    public static void main(String[] args) {
        try {
            // Test array with descending order elements
            int[] array = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
            
            System.out.println("Original array:");
            printArray(array);
            
            // Sort the array using merge sort
            mergeSort(array);
            
            System.out.println("\nSorted array:");
            printArray(array);
            
        } catch (Exception e) {
            // Catch any unexpected exceptions
            System.err.println("Unexpected error occurred: " + e.getMessage());
            e.printStackTrace();
        }
    }
}