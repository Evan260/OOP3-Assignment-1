package appDomain;

import shapes.*;
import java.util.Comparator;

public class SortAlgorithms {
	public static void bubbleSort(Shape[] shapes, Comparator<Shape> comparator) {
		boolean swapped;
		do {
			swapped = false;
			for (int i = 0; i < shapes.length - 1; i++) {
				if (compare(shapes[i], shapes[i + 1], comparator) > 0) {
					swap(shapes, i, i + 1);
					swapped = true;
				}
			}
		} while (swapped);
	}

	public static void selectionSort(Shape[] shapes, Comparator<Shape> comparator) {
		for (int i = 0; i < shapes.length - 1; i++) {
			int minIdx = i;
			for (int j = i + 1; j < shapes.length; j++) {
				if (compare(shapes[j], shapes[minIdx], comparator) < 0) {
					minIdx = j;
				}
			}
			swap(shapes, i, minIdx);
		}
	}

	public static void insertionSort(Shape[] shapes, Comparator<Shape> comparator) {
		for (int i = 1; i < shapes.length; i++) {
			Shape key = shapes[i];
			int j = i - 1;
			while (j >= 0 && compare(shapes[j], key, comparator) > 0) {
				shapes[j + 1] = shapes[j];
				j--;
			}
			shapes[j + 1] = key;
		}
	}

	public static void quickSort(Shape[] shapes, Comparator<Shape> comparator) {
		quickSortHelper(shapes, 0, shapes.length - 1, comparator);
	}

	private static void quickSortHelper(Shape[] shapes, int low, int high, Comparator<Shape> comparator) {
		if (low < high) {
			int pi = partition(shapes, low, high, comparator);
			quickSortHelper(shapes, low, pi - 1, comparator);
			quickSortHelper(shapes, pi + 1, high, comparator);
		}
	}

	private static int partition(Shape[] shapes, int low, int high, Comparator<Shape> comparator) {
		Shape pivot = shapes[high];
		int i = low - 1;
		for (int j = low; j < high; j++) {
			if (compare(shapes[j], pivot, comparator) <= 0) {
				i++;
				swap(shapes, i, j);
			}
		}
		swap(shapes, i + 1, high);
		return i + 1;
	}
	
	public static void mergeSort(Shape[] shapes, Comparator<Shape> comparator) {
	    if (shapes.length < 2) {
	        return;
	    }
	    int mid = shapes.length / 2;
	    Shape[] left = new Shape[mid];
	    Shape[] right = new Shape[shapes.length - mid];

	    System.arraycopy(shapes, 0, left, 0, mid);
	    System.arraycopy(shapes, mid, right, 0, shapes.length - mid);

	    mergeSort(left, comparator);
	    mergeSort(right, comparator);
	    merge(shapes, left, right, comparator);
	}

	private static void merge(Shape[] shapes, Shape[] left, Shape[] right, Comparator<Shape> comparator) {
	    int i = 0, j = 0, k = 0;

	    while (i < left.length && j < right.length) {
	        if (compare(left[i], right[j], comparator) <= 0) {
	            shapes[k++] = left[i++];
	        } else {
	            shapes[k++] = right[j++];
	        }
	    }

	    while (i < left.length) {
	        shapes[k++] = left[i++];
	    }

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