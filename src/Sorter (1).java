import java.util.Random;

/**
 * Sorter class handles all sorting operations.
 * Implements Bubble Sort (basic) and Merge Sort (advanced).
 */
public class Sorter {

    /**
     * Basic Sort: Bubble Sort
     * Repeatedly compares adjacent elements and swaps them if they are in the wrong order.
     * Time Complexity: O(n^2)
     */
    public void basicSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp   = arr[j];
                    arr[j]     = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    /**
     * Advanced Sort: Merge Sort
     * Recursively divides the array in half, sorts each half,
     * then merges the two sorted halves back together.
     * Time Complexity: O(n log n)
     */
    public void advancedSort(int[] arr) {
        if (arr == null || arr.length <= 1) return;
        mergeSort(arr, 0, arr.length - 1);
    }

    private void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    private void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] leftArr  = new int[n1];
        int[] rightArr = new int[n2];

        for (int i = 0; i < n1; i++) leftArr[i]  = arr[left + i];
        for (int j = 0; j < n2; j++) rightArr[j] = arr[mid + 1 + j];

        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (leftArr[i] <= rightArr[j]) arr[k++] = leftArr[i++];
            else                           arr[k++] = rightArr[j++];
        }
        while (i < n1) arr[k++] = leftArr[i++];
        while (j < n2) arr[k++] = rightArr[j++];
    }

    /** Prints all elements of an array on a single line. */
    public void printArray(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) System.out.print(", ");
        }
        System.out.println("]");
    }

    /** Generates an array of the given size filled with random integers (0-9999). */
    public int[] generateRandomArray(int size) {
        Random rand = new Random();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) arr[i] = rand.nextInt(10000);
        return arr;
    }
}
