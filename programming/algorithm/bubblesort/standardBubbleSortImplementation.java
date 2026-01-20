/**
 * @author Koushal Jha
 * * --- ALGORITHM: THE "BUBBLE UP" GAME (FOR KIDS) ---
 * Imagine a row of numbers standing in a line. We want to sort them from smallest to biggest.
 * * 1. THE SCAN: We start at the beginning of the line and look at the first two numbers.
 * 2. THE COMPARE: We ask, "Is the left number bigger than the right number?"
 * 3. THE SWAP: If the left one is bigger, they swap places! Now the bigger one is on the right.
 * 4. THE STEP: We move one step to the right and compare the next two numbers.
 * 5. THE BUBBLE: By the time we reach the end of the line, the biggest number has "bubbled" 
 * all the way to the last spot, just like a bubble rising in water!
 * 6. REPEAT: We do this again and again for the rest of the numbers until everyone is 
 * in the right order.
 */

package programming.algorithm.bubblesort;

import java.util.Scanner;

/**
 * Implementation class for the Bubble Sort algorithm.
 * Demonstrates basic sorting logic and array manipulation.
 */
public class standardBubbleSortImplementation {

    /**
     * Swaps two elements in an array given their indices.
     * * @param array The array where elements need to be swapped.
     * @param firstIndex Index of the first element.
     * @param secondIndex Index of the second element.
     */
    public static void swapElements(int[] array, int firstIndex, int secondIndex) {
        int temporaryValue = array[firstIndex];
        array[firstIndex] = array[secondIndex];
        array[secondIndex] = temporaryValue;
    }

    /**
     * Sorts an array of integers in ascending order using Bubble Sort.
     * * @param array The integer array to be sorted.
     */
    public static void performBubbleSort(int[] array) {
        // Handle edge cases: if array is null or has only 1 element, no sorting needed
        if (array == null || array.length <= 1) {
            return;
        }

        int totalElements = array.length;

        // Outer loop: Controls the number of passes through the array
        for (int pass = 0; pass < totalElements; pass++) {
            
            // Optimization: Track if any swap happened in this pass
            boolean wasAnyElementSwapped = false;

            // Inner loop: Compares adjacent neighbors
            // We subtract 'pass' because the largest elements are already at the end
            for (int currentIndex = 0; currentIndex < totalElements - 1 - pass; currentIndex++) {
                
                // If the current element is larger than the next one, they are out of order
                if (array[currentIndex] > array[currentIndex + 1]) {
                    
                    // SWAP the neighbors (This was the fix!)
                    swapElements(array, currentIndex, currentIndex + 1);
                    
                    // Set flag to true because we made a change
                    wasAnyElementSwapped = true;
                }
            }

            // If no elements were swapped during a full pass, the array is already sorted
            if (!wasAnyElementSwapped) {
                break;
            }
        }
    }

    /**
     * Utility method to print all elements in an array.
     */
    public static void printArray(int[] array) {
        for (int element : array) {
            System.out.print(element + " ");
        }
        System.out.println(); // New line for better formatting
    }

    /**
     * Main entry point of the program.
     */
    public static void main(String[] args) {
        Scanner inputScanner = new Scanner(System.in);

        System.out.print("Enter the size of the array: ");
        if (!inputScanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter an integer.");
            inputScanner.close();
            return;
        }

        int size = inputScanner.nextInt();
        int[] numbers = new int[size];

        System.out.println("Enter " + size + " integers:");
        for (int i = 0; i < size; i++) {
            if (inputScanner.hasNextInt()) {
                numbers[i] = inputScanner.nextInt();
            }
        }

        System.out.println("\nOriginal Array:");
        printArray(numbers);

        // Execute the sorting algorithm
        performBubbleSort(numbers);

        System.out.println("Sorted Array (Bubble Sort):");
        printArray(numbers);

        // Resource management: Close the scanner
        inputScanner.close();
    }
}