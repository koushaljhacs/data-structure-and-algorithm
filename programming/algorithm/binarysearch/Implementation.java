/* Author: OctNov Team
 * contact: koushaljha.cs@gmail.com
 * whatsapp: +91 8298163299
 * Member: Hitanshu Dhakrey | Shivanshu Dhakrey | Chandrashekhar Bansal
 * University: GLA UNIVERSITY, MATHURA
 
* util: 
 * Arrays: A utility class that contains static methods for manipulating arrays (like sorting and searching).
 * Scanner: A text scanner class used to parse primitive types and strings from input streams (like System.in).
 * List: An ordered collection (sequence) interface that allows precise control over where elements are inserted.
 * Collectors: A utility class that provides implementations for the Stream API's .collect() operation.
 * Collector: An interface describing a reduction operation (like grouping elements into a List).
 * Integer: The wrapper class for the primitive type int, allowing it to be used in generic collections like List<Integer>.
 * int: A primitive data type that stores a 32-bit signed two's complement integer.
 */

package programming.algorithm.binarysearch;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * Algorithm Steps:
 * 1. Define the search space by setting two pointers: 'low' at index 0 and 'high' at the last index.
 * 2. Enter a loop that continues as long as the search space is valid (low <= high).
 * 3. Calculate the middle index using the overflow-safe formula: low + (high - low) / 2.
 * 4. Check the middle element:
 *      - If it matches the target, return the index immediately.
 *      - If it is smaller than the target, discard the left half by moving 'low' to 'mid + 1'.
 *      - If it is larger than the target, discard the right half by moving 'high' to 'mid - 1'.
 * 5. If the loop ends without finding the target, return a distinct value (e.g., -1) to indicate failure.
 */
class Implementation {

    public static int binarySearch(List<Integer> arr, int target) {
        int low = 0;
        int high = arr.size() - 1;

        while (low <= high) {
            // Calculating mid this way prevents integer overflow for large arrays
            int mid = low + (high - low) / 2;

            // Case 1: Target found
            if (arr.get(mid) == target) {
                return mid;
            }

            // Case 2: Target is in the right half
            if (arr.get(mid) < target) {
                low = mid + 1;
            } 
            // Case 3: Target is in the left half
            else {
                high = mid - 1;
            }
        }
        // Return -1 to indicate element not found (0 is a valid index, so avoiding it for failure)
        return -1; 
    }

    // Helper method to split input string into a list of words safely
    public static List<String> splitWords(String s) {
        return s.isEmpty() ? List.of() : Arrays.asList(s.split(" "));
    }

    public static void main(String[] args) {
        Scanner obj = new Scanner(System.in);
        
        System.out.println("Enter sorted numbers separated by space:");
        // Converts input line -> String Array -> Stream -> Integer List
        List<Integer> arr = splitWords(obj.nextLine())
                                .stream()
                                .map(Integer::parseInt)
                                .collect(Collectors.toList());

        System.out.print("Enter target element: ");
        int target = Integer.parseInt(obj.nextLine());
        
        obj.close();

        int res = binarySearch(arr, target);
        
        if (res != -1) {
            System.out.println("Element found at index: " + res);
        } else {
            System.out.println("Element not found.");
        }
    }
}

/*
 * Time Complexity: 
 * O(log N) - Because in every step, we divide the search space by half.
 * * Space Complexity:
 * O(1) - We only use a few variables (low, high, mid) regardless of array size.
 * * What is the difference between Linear Search and Binary Search:
 * Linear Search checks every element sequentially (O(N)), making it slow for large data but works on unsorted lists.
 * Binary Search divides the list in half repeatedly (O(log N)), making it extremely fast but requires sorted data.
 * * Recurrence Relation of Linear Search: 
 * T(n) = T(n-1) + 1  
 * (Process one item, then solve for the remaining n-1 items).
 * * Recurrence Relation of Binary Search: 
 * T(n) = T(n/2) + 1  
 * (Process one comparison, then solve for only half the remaining items).
 * * What is the relation between Linear Search and Binary Search in terms of recurrence relation:
 * The complexity of Binary Search is the logarithm of Linear Search. 
 * T_binary(n) ≈ log( T_linear(n) ). 
 * This means Binary Search reduces the work exponentially faster than Linear Search.
 * * Why mid = low + (high - low) / 2 not mid = (low + high) / 2:
 * In programming, if 'low' and 'high' are both very large integers (near 2 billion), 
 * adding them (low + high) can exceed the maximum limit of an integer (2^31 - 1), causing a crash or negative result (overflow).
 * The formula 'low + (high - low) / 2' gives the same result mathematically but keeps the values small during calculation, 
 * ensuring the code is safe and robust for large datasets.
 */