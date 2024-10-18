package appDomain;

import shapes.*;
import java.util.Comparator;
import java.util.List;
import java.io.IOException;
import java.util.ArrayList;
import java.time.Duration;
import java.time.Instant;

public class AppDriver {

    public static void main(String[] args) {
        Instant start = Instant.now();

        String[] fileNames = { "res/shapes1.txt", "res/shapes2.txt", "res/shapes3.txt" };

        try {
            // Collect all shapes from the files
            List<Shape> allShapes = new ArrayList<>();
            for (String fileName : fileNames) {

                // Print the filepath
                System.out.println("Loading shapes from file: " + fileName);

                List<Shape> shapesFromFile = ShapeFileReader.loadShapesFromFile(fileName);
                allShapes.addAll(shapesFromFile);
            }

            // Print the number of shapes loaded
            System.out.println("DONE: Number of shapes loaded: " + allShapes.size());
            Instant finish1 = Instant.now();
            long timeElapsed = Duration.between(start, finish1).toMillis();
            System.out.println("Time taken to load: " + timeElapsed + "ms");

            // Convert the List to an array for sorting
            Shape[] shapesArray = allShapes.toArray(new Shape[0]);
            Instant finish2 = Instant.now();
            long timeElapsed2 = Duration.between(finish1, finish2).toMillis();
            System.out.println("Time taken to convert list to array: " + timeElapsed2 + "ms");

            // Comparator to compare shapes by volume
            Comparator<Shape> volumeComparator = new VolumeCompare();
            Instant finish3 = Instant.now();
            long timeElapsed3 = Duration.between(finish2, finish3).toMillis();
            System.out.println("Time taken to create comparator: " + timeElapsed3 + "ms");

            // Sort shapes by volume using bubble sort
            bubbleSort(shapesArray, volumeComparator);
            Display(shapesArray);
            Instant finish4 = Instant.now();
            long timeElapsed4 = Duration.between(finish3, finish4).toMillis();
            System.out.println("Time taken to sort using Bubble Sort: " + timeElapsed4 + "ms");

            // Reset the array to unsorted state
            shapesArray = allShapes.toArray(new Shape[0]);

            // Sort shapes by volume using Selection Sort
            Instant selectionStart = Instant.now();
            selectionSort(shapesArray, volumeComparator);
            Display(shapesArray);
            Instant selectionEnd = Instant.now();
            long selectionTime = Duration.between(selectionStart, selectionEnd).toMillis();
            System.out.println("\nTime taken to sort using Selection Sort: " + selectionTime + "ms");

            // Reset the array to unsorted state
            shapesArray = allShapes.toArray(new Shape[0]);

            // Sort shapes by volume using Insertion Sort
            Instant insertionStart = Instant.now();
            insertionSort(shapesArray, volumeComparator);
            Display(shapesArray);
            Instant insertionEnd = Instant.now();
            long insertionTime = Duration.between(insertionStart, insertionEnd).toMillis();
            System.out.println("\nTime taken to sort using Insertion Sort: " + insertionTime + "ms");

            // Reset the array to unsorted state
            shapesArray = allShapes.toArray(new Shape[0]);

            // Sort shapes by volume using Quick Sort
            Instant quickStart = Instant.now();
            quickSort(shapesArray, volumeComparator);
            Display(shapesArray);
            Instant quickEnd = Instant.now();
            long quickTime = Duration.between(quickStart, quickEnd).toMillis();
            System.out.println("\nTime taken to sort using Quick Sort: " + quickTime + "ms");

        } catch (IOException e) {
            System.err.println("Error reading shapes file: " + e.getMessage());
        }
    }

    // Bubble sort algorithm using Comparator
    public static void bubbleSort(Shape[] shapes, Comparator<Shape> comparator) {
        boolean swapped;
        do {
            swapped = false;
            for (int i = 0; i < shapes.length - 1; i++) {
                if (comparator.compare(shapes[i], shapes[i + 1]) > 0) {
                    Shape temp = shapes[i];
                    shapes[i] = shapes[i + 1];
                    shapes[i + 1] = temp;
                    swapped = true;
                }
            }
        } while (swapped);
    }

    // Selection sort algorithm using Comparator
    public static void selectionSort(Shape[] shapes, Comparator<Shape> comparator) {
        int n = shapes.length;
        for (int i = 0; i < n - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (comparator.compare(shapes[j], shapes[minIdx]) < 0) {
                    minIdx = j;
                }
            }
            Shape temp = shapes[minIdx];
            shapes[minIdx] = shapes[i];
            shapes[i] = temp;
        }
    }

    // Insertion sort algorithm using Comparator
    public static void insertionSort(Shape[] shapes, Comparator<Shape> comparator) {
        int n = shapes.length;
        for (int i = 1; i < n; ++i) {
            Shape key = shapes[i];
            int j = i - 1;

            while (j >= 0 && comparator.compare(shapes[j], key) > 0) {
                shapes[j + 1] = shapes[j];
                j = j - 1;
            }
            shapes[j + 1] = key;
        }
    }

    // Quick sort algorithm using Comparator
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
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (comparator.compare(shapes[j], pivot) <= 0) {
                i++;
                Shape temp = shapes[i];
                shapes[i] = shapes[j];
                shapes[j] = temp;
            }
        }
       
        Shape temp = shapes[i + 1];
        shapes[i + 1] = shapes[high];
        shapes[high] = temp;

        return i + 1;
    }

	    	public static void Display(Shape[] shapes) {
	    	    // First element
	    	    System.out.println("First Element is: " + shapes[0].getClass().getSimpleName() + " Volume: " + shapes[0].calcVolume());
	    	    
	    	    // Every 1000th element
	    	    for (int i = 1000; i < shapes.length; i += 1000) {
	    	        System.out.println(i + "th element is: " + shapes[i].getClass().getSimpleName() + " Volume: " + shapes[i].calcVolume());
	    	    }
	    	    
	    	    // Second last element
	    	    if (shapes.length > 1) {
	    	        System.out.println("Second last element is: " + shapes[shapes.length - 2].getClass().getSimpleName() + " Volume: " + shapes[shapes.length - 2].calcVolume());
	    	    }
	    	    
	    	    // Last element
	    	    System.out.println("Last element is: " + shapes[shapes.length - 1].getClass().getSimpleName() + " Volume: " + shapes[shapes.length - 1].calcVolume());
	    		
	    	}
}
