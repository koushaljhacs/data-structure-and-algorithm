package programming.algorithm.bubblesort;
import java.util.Scanner;
public class Test {
    public static void printArray(int[] arr) {
        for(int ele: arr) {
            System.out.print(ele + " ");
        }
    }
    public static void swap(int[] arr, int left, int right) {
        // left = j
        // right = j + 1
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }
    public static void bubbleSort(int[] arr) {
        for(int i=0; i<arr.length-1; i++) {
            for(int j=0; j<arr.length-i-1; j++) {
                swap(arr, j, j+1);
            }
        }
    }
    public static void main(String[] args) {
        Scanner obj = new Scanner(System.in);
        System.out.print("enter size: ");
        int size = obj.nextInt();

        int[] arr = new int[size];
        for(int i=0; i<size; i++) {
            arr[i] = obj.nextInt();
        }

        bubbleSort(arr);
        printArray(arr);
    }
}
