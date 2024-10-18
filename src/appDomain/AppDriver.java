package appDomain;

import shapes.*;
import java.util.Comparator;
import java.util.List;
import java.io.IOException;
import java.time.Duration;
import java.time.Instant;

public class AppDriver {

	public static void main(String[] args) {
		Instant start = Instant.now();

		// Process command-line arguments
		String filePath = getArgValue(args, "-f");
		String sortType = getArgValue(args, "-t");
		String sortMethod = getArgValue(args, "-s");

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

	// Get the appropriate comparator based on the type
	private static Comparator<Shape> getComparator(String type) {
		switch (type) {
		case "v":
			return new VolumeCompare();
		case "a":
			return new BaseAreaCompare();
		default:
			return null;
		}
	}

	// Sort shapes based on the method and comparator
	private static void sortShapes(Shape[] shapes, Comparator<Shape> comparator, String method) {
		Instant start = Instant.now();
		switch (method) {
		case "b":
			bubbleSort(shapes, comparator);
			break;
		case "s":
			selectionSort(shapes, comparator);
			break;
		case "i":
			insertionSort(shapes, comparator);
			break;
		case "q":
			quickSort(shapes, comparator);
			break;
		}
		logTime(method + " sort", start);
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

	// Sorting algorithms
	public static void bubbleSort(Shape[] shapes, Comparator<Shape> comparator) {
		boolean swapped;
		do {
			swapped = false;
			for (int i = 0; i < shapes.length - 1; i++) {
				if (comparator.compare(shapes[i], shapes[i + 1]) > 0) {
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
				if (comparator.compare(shapes[j], shapes[minIdx]) < 0) {
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
			while (j >= 0 && comparator.compare(shapes[j], key) > 0) {
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
			if (comparator.compare(shapes[j], pivot) <= 0) {
				i++;
				swap(shapes, i, j);
			}
		}
		swap(shapes, i + 1, high);
		return i + 1;
	}

	// Helper to swap two shapes
	private static void swap(Shape[] shapes, int i, int j) {
		Shape temp = shapes[i];
		shapes[i] = shapes[j];
		shapes[j] = temp;
	}
	//sorts for height
    public static void bubbleSort(Comparable[] shapes) {
        boolean swapped;
        do {
            swapped = false;
            for (int i = 0; i < shapes.length - 1; i++) {
                if (shapes[i].compareTo(shapes[i + 1] )> 0) {
                    Comparable temp = shapes[i];
                    shapes[i] = shapes[i + 1];
                    shapes[i + 1] = temp;
                    swapped = true;
                }
            }
        } while (swapped);
    }

    public static void selectionSort(Comparable[] shapes) {
        int n = shapes.length;
        for (int i = 0; i < n - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (shapes[i].compareTo(shapes[j]) < 0) {
                    minIdx = j;
                }
            }
            Comparable temp = shapes[minIdx];
            shapes[minIdx] = shapes[i];
            shapes[i] = temp;
        }
    }

    public static void insertionSort(Comparable[] shapes) {
        int n = shapes.length;
        for (int i = 1; i < n; ++i) {
            Comparable key = shapes[i];
            int j = i - 1;

            while (j >= 0 && shapes[j].compareTo(key) > 0) {
                shapes[j + 1] = shapes[j];
                j = j - 1;
            }
            shapes[j + 1] = key;
        }
    }

    public static void quickSort(Comparable[] shapes) {
        quickSortHelper(shapes, 0, shapes.length - 1);
    }

    private static void quickSortHelper(Comparable[] shapes, int low, int high) {
        if (low < high) {
            int pi = partition(shapes, low, high);
            quickSortHelper(shapes, low, pi - 1);
            quickSortHelper(shapes, pi + 1, high);
        }
    }

    private static int partition(Comparable[] shapes, int low, int high) {
        Comparable pivot = shapes[high];
        int i = (low - 1);

        for (int j = low; j < high; j++) {
            if (shapes[j].compareTo(pivot) <= 0) {
                i++;
                swap(shapes, i, j);
            }
        }
        swap(shapes, i + 1, high);
        return i + 1;
    }

    private static void swap(Comparable[] shapes, int i, int j) {
        Comparable temp = shapes[i];
        shapes[i] = shapes[j];
        shapes[j] = temp;
    }
}