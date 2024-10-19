package appDomain;

import shapes.*;
import java.util.Comparator;
import java.util.List;
import java.io.IOException;
import java.time.Duration;
import java.time.Instant;
/**
 * AppDriver.java
 *
 * @author Team Riju
 * @version 1.2
 * 
 * Class Definition: This is the main method of all the code. everything is brought here. it first gets all the arguements the user
 * put in using java java -jar Sort.jar -tV -sS -f"res\shapes1.txt" and sorts them out for what the file wants(-t, -s -f). once the
 *  main knows what the user wants it will read the entire file that the user specified, sort it and display certain parts of the file
 */
public class AppDriver {

	public static void main(String[] args) {
		Instant start = Instant.now();

		// Process command-line arguments
		String filePath = getArgValue(args, "-f");
		String sortType = getArgValue(args, "-t").toLowerCase();
		String sortMethod = getArgValue(args, "-s").toLowerCase();

		if (filePath == null || sortType == null || sortMethod == null) {
			System.out.println("Invalid arguments. Usage: -f <filepath> -t <type> -s <sort>");
			return;
		}

		try {
			// Load shapes from file
			List<Shape> allShapes = ShapeFileReader.loadShapesFromFile(filePath);
			System.out.println("Loaded " + allShapes.size() + " shapes from: " + filePath);
			logTime("Loading shapes", start);

			Shape[] shapesArray = allShapes.toArray(new Shape[0]);

			// null means use compareTo()
			Comparator<Shape> comparator = getComparator(sortType);
			sortShapes(shapesArray, comparator, sortMethod);
		
			Display(shapesArray);
			
		} catch (IOException e) {
			System.err.println("Error reading shapes file: " + e.getMessage());
		}
	}

	// Get argument value by its key
	private static String getArgValue(String[] args, String key) {
		for (String arg : args) {
			if (arg.startsWith(key)) {
				return arg.substring(2);
			}
		}
		return null;
	}

	// Get the appropriate comparator based on the type or null for using
	// compareTo()
	private static Comparator<Shape> getComparator(String type) {
		switch (type) {
		case "v":
			return new VolumeCompare();
		case "a":
			return new BaseAreaCompare();
		case "h":
			return null; // Use compareTo for height comparison
		default:
			return null;
		}
	}

	private static void sortShapes(Shape[] shapes, Comparator<Shape> comparator, String method) {
	    Instant start = Instant.now();
	    String sortName = "";
	    
	    switch (method) {
	        case "b":
	            SortAlgorithms.bubbleSort(shapes, comparator);
	            sortName = "Bubble";
	            break;
	        case "s":
	            SortAlgorithms.selectionSort(shapes, comparator);
	            sortName = "Selection";
	            break;
	        case "i":
	            SortAlgorithms.insertionSort(shapes, comparator);
	            sortName = "Insertion";
	            break;
	        case "q":
	            SortAlgorithms.quickSort(shapes, comparator);
	            sortName = "Quick";
	            break;
	        case "m":
	            SortAlgorithms.mergeSort(shapes, comparator);
	            sortName = "Merge";
	            break;
	        case "h":
	            SortAlgorithms.heapSort(shapes, comparator);
	            sortName = "Heap";
	            break;
	        default:
	            System.out.println("Error: unknown sort type. Failed to sort shapes.");
	            return;
	    }

	    logTime(sortName + " sort", start);
	}

	// Log the time taken for operations
	private static void logTime(String task, Instant start) {
		long timeElapsed = Duration.between(start, Instant.now()).toMillis();
		System.out.println(task + " completed in: " + timeElapsed + " ms");
	}

	// Display shape information
	public static void Display(Shape[] shapes) {
		System.out.println(
				"First Element: " + shapes[0].getClass().getSimpleName() + " Volume: " + shapes[0].calcVolume());
		for (int i = 1000; i < shapes.length; i += 1000) {
			System.out.println(
					i + "th Element: " + shapes[i].getClass().getSimpleName() + " Volume: " + shapes[i].calcVolume());
		}
		if (shapes.length > 1) {
			System.out.println("Second last Element: " + shapes[shapes.length - 2].getClass().getSimpleName()
					+ " Volume: " + shapes[shapes.length - 2].calcVolume());
		}
		System.out.println("Last Element: " + shapes[shapes.length - 1].getClass().getSimpleName() + " Volume: "
				+ shapes[shapes.length - 1].calcVolume());
	}
}