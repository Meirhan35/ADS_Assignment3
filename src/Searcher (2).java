import java.util.Arrays;

/**
 * Searcher class handles searching operations.
 * Implements Binary Search.
 */
public class Searcher {

    /**
     * Binary Search
     * Requires a sorted array. Repeatedly halves the search space by comparing
     * the target to the middle element of the current range.
     * Time Complexity: O(log n)
     *
     * @param arr    the array to search (will be sorted internally if needed)
     * @param target the value to find
     * @return index of target if found, -1 otherwise
     */
    public int search(int[] arr, int target) {
        // Binary search needs a sorted array — sort a copy to preserve original
        int[] sorted = Arrays.copyOf(arr, arr.length);
        Arrays.sort(sorted);

        int left  = 0;
        int right = sorted.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2; // avoids integer overflow

            if (sorted[mid] == target) {
                return mid;         // Found
            } else if (sorted[mid] < target) {
                left = mid + 1;     // Target is in the right half
            } else {
                right = mid - 1;    // Target is in the left half
            }
        }
        return -1; // Not found
    }
}
