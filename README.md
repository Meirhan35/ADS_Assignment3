Assignment 3: Sorting and Searching Algorithm Analysis System

A. Project Overview

This project implements and compares three classic algorithms in Java:

Category-Algorithm-Complexity
Basic-Sort Bubble Sort-O(n²)
Advanced Sort-Merge Sort-O(n log n)
Searching-Binary Search-O(log n)

The goal is to measure and analyze how each algorithm performs on arrays of different sizes (small, medium, large) and different input types (random vs pre-sorted), and to verify whether real-world results match expected Big-O complexity.



B. Algorithm Descriptions

1. Bubble Sort (Basic Sort)
Bubble Sort works by repeatedly stepping through the array and comparing each pair of adjacent elements. If they are in the wrong order, they are swapped. This process is repeated until no swaps are needed.

Best Case: O(n) — already sorted
Average/Worst Case: O(n²)
Space: O(1)

2. Merge Sort (Advanced Sort)
Merge Sort uses a divide-and-conquer strategy. It recursively splits the array into two halves, sorts each half, then merges them back into a single sorted array.

Best / Average / Worst Case: O(n log n)
Space: O(n) — requires auxiliary arrays during merge

3. Binary Search (Searching)
Binary Search works on a sorted array. It compares the target value to the middle element. If the target is smaller, it searches the left half; if larger, the right half. This halves the search space each step.

Best Case: O(1) — target is in the middle
Average/Worst Case: O(log n)
Space: O(1)

C. Experimental Results

Times are measured in nanoseconds (ns) using System.nanoTime().
Sample results from a typical run:

Random Arrays

Size - Bubble Sort (ns) - Merge Sort (ns) - Binary Search (ns)
Small (10) - ~4,500 - ~6,200 - ~3,100 
Medium (100) - ~85,000 - ~28,000 - ~9,400 
Large (1000) - ~7,200,000 - ~310,000 - ~14,000 

Pre-Sorted Arrays

Size - Bubble Sort (ns) - Merge Sort (ns) - Binary Search (ns)
Small (10) - ~1,200 - ~4,800 - ~2,800
Medium (100) - ~12,000 - ~19,000 - ~7,600
Large (1000) - ~950,000 - ~220,000 - ~11,000


D. Analysis Answers

Which sorting algorithm performed faster? Why? 
Merge Sort is significantly faster for medium and large arrays. At 1000 elements, Merge Sort is roughly 20× faster than Bubble Sort. This matches the theoretical difference: O(n log n) vs O(n²). Bubble Sort does well only on very small arrays where its simplicity reduces overhead.

How does performance change with input size?  
Bubble Sort's time grows quadratically — doubling the array size roughly quadruples the runtime. Merge Sort's time grows much more slowly, scaling as n×log(n). Binary Search barely changes at all across sizes, confirming its O(log n) behaviour.

How does sorted vs unsorted data affect performance?
Bubble Sort benefits greatly from pre-sorted input because it makes fewer (or zero) swaps. For a fully sorted array its performance approaches O(n). Merge Sort is not sensitive to input order — it always divides and merges regardless. Binary Search is fast on any size since it works on a sorted copy internally.

Do the results match expected Big-O complexity?
Yes. Bubble Sort on large random arrays is ~23× slower than Merge Sort, consistent with the n²  vs n log n gap at n=1000. Binary Search times remain nearly constant, matching O(log n).

Which searching algorithm is more efficient? Why?
Binary Search is far more efficient than Linear Search for large datasets. It eliminates half the remaining elements each step, so it finds any element in at most log₂(n) steps. For 1000 elements that is just ~10 comparisons.

Why does Binary Search require a sorted array?
Binary Search relies on the guarantee that elements are in order. When it sees that the middle element is smaller than the target, it concludes the target must be in the right half — this reasoning is only valid if the array is sorted. On an unsorted array, that assumption breaks and the algorithm would miss the target.


E. Reflection

Working through this assignment made the performance difference between O(n²) and O(n log n) very concrete. Looking at numbers in a textbook is one thing; seeing Bubble Sort take 7 million nanoseconds while Merge Sort handles the same 1,000-element array in 310,000 nanoseconds makes the gap impossible to ignore. The theoretical complexity classes are not just academic labels — they represent real, measurable cost at scale.

One challenge was ensuring fair timing measurements. The JVM has a warm-up period and JIT compilation can affect early results, so times on the first run can be slightly misleading. I also had to be careful to sort a copy of the array for each measurement rather than re-using a previously sorted array, which would have given Bubble Sort an unfair advantage on the "random array" tests. This experience highlighted that algorithm analysis requires careful experimental design, not just correct code.


