
import java.util.Arrays;

public class BubbleSort {

    // Method 
	
    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // Bubble sort 
	
    public void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
        }
    }

    // Main method
	
    public static void main(String[] args) {
        int[] numbers = {8, 3, 1, 4, 5, 11, 7, 2, 17, 13};
        System.out.println("Original array:");
        printArray(numbers);

        BubbleSort sorter = new BubbleSort();
        sorter.bubbleSort(numbers);

        System.out.println("Sorted Array:");
        printArray(numbers);
    }

    // print array elements
	
    public static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
