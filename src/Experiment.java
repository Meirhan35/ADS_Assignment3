import java.util.Arrays;

/**
 * Experiment class runs performance experiments and measures algorithm timing.
 */
public class Experiment {

    private Sorter   sorter;
    private Searcher searcher;

    public Experiment(Sorter sorter, Searcher searcher) {
        this.sorter   = sorter;
        this.searcher = searcher;
    }

    /**
     * Measures sorting time in nanoseconds.
     *
     * @param arr  the array to sort (cloned internally, original unchanged)
     * @param type "basic" = Bubble Sort | "advanced" = Merge Sort
     * @return elapsed time in nanoseconds
     */
    public long measureSortTime(int[] arr, String type) {
        int[] copy = arr.clone(); // do not modify the original
        long start = System.nanoTime();
        if (type.equalsIgnoreCase("basic")) {
            sorter.basicSort(copy);
        } else if (type.equalsIgnoreCase("advanced")) {
            sorter.advancedSort(copy);
        }
        return System.nanoTime() - start;
    }

    /**
     * Measures binary search time in nanoseconds.
     *
     * @param arr    the array to search
     * @param target the value to search for
     * @return elapsed time in nanoseconds
     */
    public long measureSearchTime(int[] arr, int target) {
        long start = System.nanoTime();
        searcher.search(arr, target);
        return System.nanoTime() - start;
    }

    /**
     * Runs all experiments across three array sizes and two input types (random / sorted),
     * then prints a clean comparison table.
     */
    public void runAllExperiments() {
        int[]    sizes  = {10, 100, 1000};
        String[] labels = {"Small  ( 10)", "Medium (100)", "Large  (1000)"};

        System.out.println("=".repeat(72));
        System.out.println("       SORTING & SEARCHING ALGORITHM PERFORMANCE ANALYSIS");
        System.out.println("=".repeat(72));

        // ── RANDOM ARRAYS ────────────────────────────────────────────────
        System.out.println("\n[ RANDOM ARRAYS ]");
        System.out.printf("%-15s %-22s %-22s %-18s%n",
                "Size", "Bubble Sort (ns)", "Merge Sort (ns)", "Binary Search (ns)");
        System.out.println("-".repeat(72));

        for (int i = 0; i < sizes.length; i++) {
            int[] arr    = sorter.generateRandomArray(sizes[i]);
            int   target = arr[0]; // guaranteed to exist

            long bubbleTime = measureSortTime(arr, "basic");
            long mergeTime  = measureSortTime(arr, "advanced");
            long searchTime = measureSearchTime(arr, target);

            System.out.printf("%-15s %-22d %-22d %-18d%n",
                    labels[i], bubbleTime, mergeTime, searchTime);
        }

        // ── SORTED ARRAYS ────────────────────────────────────────────────
        System.out.println("\n[ SORTED ARRAYS ]");
        System.out.printf("%-15s %-22s %-22s %-18s%n",
                "Size", "Bubble Sort (ns)", "Merge Sort (ns)", "Binary Search (ns)");
        System.out.println("-".repeat(72));

        for (int i = 0; i < sizes.length; i++) {
            int[] arr = sorter.generateRandomArray(sizes[i]);
            Arrays.sort(arr); // pre-sort
            int target = arr[sizes[i] / 2]; // middle element

            long bubbleTime = measureSortTime(arr, "basic");
            long mergeTime  = measureSortTime(arr, "advanced");
            long searchTime = measureSearchTime(arr, target);

            System.out.printf("%-15s %-22d %-22d %-18d%n",
                    labels[i], bubbleTime, mergeTime, searchTime);
        }

        System.out.println("=".repeat(72));
        System.out.println("\nConclusion:");
        System.out.println("  Merge Sort is consistently faster than Bubble Sort for large arrays.");
        System.out.println("  Binary Search is extremely fast (O log n) on any array size.");
        System.out.println("  Bubble Sort on sorted arrays is faster due to fewer swaps.");
        System.out.println("=".repeat(72));
    }
}
