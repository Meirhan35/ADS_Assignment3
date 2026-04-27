import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        Sorter     sorter     = new Sorter();
        Searcher   searcher   = new Searcher();
        Experiment experiment = new Experiment(sorter, searcher);

        System.out.println("=".repeat(60));
        System.out.println("          ALGORITHM DEMO — Small Array (10 elements)");
        System.out.println("=".repeat(60));

        int[] small = sorter.generateRandomArray(10);

        System.out.print("\nOriginal array : ");
        sorter.printArray(small);

        int[] bubbleCopy = small.clone();
        sorter.basicSort(bubbleCopy);
        System.out.print("After Bubble Sort : ");
        sorter.printArray(bubbleCopy);

        int[] mergeCopy = small.clone();
        sorter.advancedSort(mergeCopy);
        System.out.print("After Merge Sort  : ");
        sorter.printArray(mergeCopy);

        int target = small[0];
        int resultIndex = searcher.search(small, target);
        System.out.println("\nBinary Search for value " + target + ":");
        if (resultIndex >= 0) {
            System.out.println("  Found at index " + resultIndex + " (in sorted copy).");
        } else {
            System.out.println("  Value not found.");
        }

        System.out.println("\n" + "=".repeat(60));
        System.out.println("          ALGORITHM DEMO — Medium Array (100 elements)");
        System.out.println("=".repeat(60));

        int[] medium = sorter.generateRandomArray(100);
        System.out.println("Generated 100-element random array.");

        int[] medBubble = medium.clone();
        long t1 = System.nanoTime();
        sorter.basicSort(medBubble);
        long t2 = System.nanoTime();
        System.out.println("Bubble Sort completed in " + (t2 - t1) + " ns.");

        int[] medMerge = medium.clone();
        long t3 = System.nanoTime();
        sorter.advancedSort(medMerge);
        long t4 = System.nanoTime();
        System.out.println("Merge Sort  completed in " + (t4 - t3) + " ns.");

        int medTarget = medium[50];
        long t5 = System.nanoTime();
        searcher.search(medium, medTarget);
        long t6 = System.nanoTime();
        System.out.println("Binary Search completed in " + (t6 - t5) + " ns.");

        System.out.println("\n" + "=".repeat(60));
        System.out.println("     ALGORITHM DEMO — Pre-Sorted Array (100 elements)");
        System.out.println("=".repeat(60));

        int[] sorted = sorter.generateRandomArray(100);
        Arrays.sort(sorted);
        System.out.println("Generated pre-sorted 100-element array.");

        int[] sortedBubble = sorted.clone();
        long s1 = System.nanoTime();
        sorter.basicSort(sortedBubble);
        long s2 = System.nanoTime();
        System.out.println("Bubble Sort on sorted array: " + (s2 - s1) + " ns.");

        int[] sortedMerge = sorted.clone();
        long s3 = System.nanoTime();
        sorter.advancedSort(sortedMerge);
        long s4 = System.nanoTime();
        System.out.println("Merge Sort  on sorted array: " + (s4 - s3) + " ns.");

        System.out.println();
        experiment.runAllExperiments();
    }
}
