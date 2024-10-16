package appDomain;

import shapes.*;
import java.util.Comparator;
import java.util.List;
import java.io.IOException;
import java.util.ArrayList;

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
			System.out.println("Time taken to load: " + timeElapsed2);
			// Comparator to compare shapes by volume
			Comparator<Shape> volumeComparator = new VolumeCompare();
			Instant finish3 = Instant.now();
			long timeElapsed3 = Duration.between(finish2, finish3).toMillis();
			System.out.println("Time taken to load: " + timeElapsed3);
			// Sort shapes by volume using bubble sort
			bubbleSort(shapesArray, volumeComparator);
			Instant finish4 = Instant.now();
			long timeElapsed4 = Duration.between(finish3, finish4).toMillis();
			System.out.println("Time taken to load: " + timeElapsed4);

			// Display sorted shapes by volume
			for (Shape shape : shapesArray) {
				System.out.println(shape.getClass().getSimpleName() + " Volume: " + shape.calcVolume());
			}

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
}