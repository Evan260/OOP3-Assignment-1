package appDomain;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import shapes.*;
/**
 * AppDriver.java
 *
 * @author Team Riju
 * @version 1.2
 * 
 * Class Definition: This is the method that will read the file that the user input from AppDriver
 */
public class ShapeFileReader {
	// Method to load shapes from a file and return them as a List of Shape objects
	public static List<Shape> loadShapesFromFile(String fileName) throws IOException {
		List<Shape> shapes = new ArrayList<>();
		
		// Use BufferedReader to read the file line by line
		try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
			// Skip the first line because it's not a shape
            reader.readLine();
            
			String line;
			while ((line = reader.readLine()) != null) {
				// Split the line into tokens (shape type and dimensions)
				String[] tokens = line.split(" ");

				// Skip lines that don't have the required number of tokens
				if (tokens.length < 3) {
					System.err.println("Error: incomplete shape data. Skipping line: " + line);
					continue;
				}

				// Create a Shape object from the tokens and add it to the list
				Shape shape = createShapeFromTokens(tokens);
				if (shape != null) {
					shapes.add(shape);
				}
			}
		}
		return shapes;
	}

	// Helper method to create shape instances from file tokens
	private static Shape createShapeFromTokens(String[] tokens) {
		try {
			// Extract the shape type, height, and size from the tokens
			String shapeType = tokens[0];
			double height = Double.parseDouble(tokens[1]);
			double size = Double.parseDouble(tokens[2]);

			// Create the appropriate shape based on the shape type
			switch (shapeType) {
			case "Cylinder":
				return new Cylinder(height, radius);
			case "Cone":
				return new Cone(height, radius);
			case "Pyramid":
				return new Pyramid(height, size);
			case "SquarePrism":
				return new SquarePrism(height, size);
			case "TriangularPrism":
				return new TriangularPrism(height, size);
			case "PentagonalPrism":
				return new PentagonalPrism(height, size);
			case "OctagonalPrism":
				return new OctagonalPrism(height, size);
			default:
				System.out.println("Unknown shape type: " + shapeType);
				return null;
			}
		} catch (NumberFormatException e) {
			System.err.println("Error parsing shape dimensions: " + e.getMessage());
			return null;
		} catch (ArrayIndexOutOfBoundsException e) {
			System.err.println("Error: incomplete shape data.");
			return null;
		}
	}
}