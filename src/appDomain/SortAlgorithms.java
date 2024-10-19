package appDomain;

import shapes.*;
import java.util.Comparator;

public class SortAlgorithms {
	public static void bubbleSort(Shape[] shapes, Comparator<Shape> comparator) {
		boolean swapped;
		do {
			swapped = false;
			// Iterate through the array and compare adjacent shapes
			for (int i = 0; i < shapes.length - 1; i++) {
				// Swap shapes if they are in the wrong order
				if (compare(shapes[i], shapes[i + 1], comparator) > 0) {
					swap(shapes, i, i + 1);
					swapped = true;
				}
			}
		} while (swapped); // Continue until no swaps occur
	}

	public static void selectionSort(Shape[] shapes, Comparator<Shape> comparator) {
		for (int i = 0; i < shapes.length - 1; i++) {
			int minIdx = i;
			// Find the minimum element in the unsorted part of the array
			for (int j = i + 1; j < shapes.length; j++) {
				if (compare(shapes[j], shapes[minIdx], comparator) < 0) {
					minIdx = j;
				}
			}
			// Swap the found minimum element with the first element
			swap(shapes, i, minIdx);
		}
	}

	public static void insertionSort(Shape[] shapes, Comparator<Shape> comparator) {
		for (int i = 1; i < shapes.length; i++) {
			Shape key = shapes[i];
			int j = i - 1;
			// Move elements of shapes[0...i-1], that are greater than key, to one position
			// ahead
			while (j >= 0 && compare(shapes[j], key, comparator) > 0) {
				shapes[j + 1] = shapes[j];
				j--;
			}
			// Place the key at the correct position
			shapes[j + 1] = key;
		}
	}

	public static void quickSort(Shape[] shapes, Comparator<Shape> comparator) {
		quickSortHelper(shapes, 0, shapes.length - 1, comparator);
	}

	private static void quickSortHelper(Shape[] shapes, int low, int high, Comparator<Shape> comparator) {
		if (low < high) {
			// Find the partition index
			int pi = partition(shapes, low, high, comparator);
			// Recursively sort elements before and after partition
			quickSortHelper(shapes, low, pi - 1, comparator);
			quickSortHelper(shapes, pi + 1, high, comparator);
		}
	}

	private static int partition(Shape[] shapes, int low, int high, Comparator<Shape> comparator) {
		Shape pivot = shapes[high]; // Choose the last element as the pivot
		int i = low - 1;// Index of the smaller element
		for (int j = low; j < high; j++) {
			// If the current element is smaller or equal to the pivot, swap it
			if (compare(shapes[j], pivot, comparator) <= 0) {
				i++;
				swap(shapes, i, j);
			}
		}
		// Place the pivot element in its correct position
		swap(shapes, i + 1, high);
		return i + 1;
	}

	public static void mergeSort(Shape[] shapes, Comparator<Shape> comparator) {
		if (shapes.length < 2) {
			return;
		}
		int mid = shapes.length / 2; // Find the middle index
		Shape[] left = new Shape[mid];
		Shape[] right = new Shape[shapes.length - mid];

		// Divide the array into two halves
		System.arraycopy(shapes, 0, left, 0, mid);
		System.arraycopy(shapes, mid, right, 0, shapes.length - mid);

		// Recursively sort each half
		mergeSort(left, comparator);
		mergeSort(right, comparator);
		
		// Merge the sorted halves
		merge(shapes, left, right, comparator);
	}

	private static void merge(Shape[] shapes, Shape[] left, Shape[] right, Comparator<Shape> comparator) {
		int i = 0, j = 0, k = 0;

		// Merge the elements in sorted order
		while (i < left.length && j < right.length) {
			if (compare(left[i], right[j], comparator) <= 0) {
				shapes[k++] = left[i++];
			} else {
				shapes[k++] = right[j++];
			}
		}

		// Copy remaining elements of left[], if any
		while (i < left.length) {
			shapes[k++] = left[i++];
		}

		// Copy remaining elements of right[], if any
		while (j < right.length) {
			shapes[k++] = right[j++];
		}
	}

	// Helper to compare shapes using Comparator or compareTo
	private static int compare(Shape a, Shape b, Comparator<Shape> comparator) {
		return (comparator == null) ? a.compareTo(b) : comparator.compare(a, b);
	}

	// Helper to swap two shapes
	private static void swap(Shape[] shapes, int i, int j) {
		Shape temp = shapes[i];
		shapes[i] = shapes[j];
		shapes[j] = temp;
	}
}