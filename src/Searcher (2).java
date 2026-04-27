import java.util.Arrays;

class Searcher {

    public int search(int[] arr, int target) {
        int[] sorted = Arrays.copyOf(arr, arr.length);
        Arrays.sort(sorted);

        int left  = 0;
        int right = sorted.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (sorted[mid] == target) {
                return mid;
            } else if (sorted[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}
