import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import shapes.*;

public class ShapeFileReader 
{
    public static void main(String[] args) 
    {
        String fileName = "shapes.txt";
        try {
            List<Shape> shapes = loadShapesFromFile(fileName);
            for (Shape shape : shapes) {
                System.out.println(shape);
            }
        } catch (IOException e) {
            System.err.println("Error reading shapes file: " + e.getMessage());
        }
    }
    
    // Method to load shapes from a file
    public static List<Shape> loadShapesFromFile(String fileName) throws IOException {
        List<Shape> shapes = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] tokens = line.split(" ");
                Shape shape = createShapeFromTokens(tokens);
                if (shape != null) {
                    shapes.add(shape);
                }
            }
        }
        return shapes;
    }

    // Helper method to create shape instances from file tokens
    private static Shape createShapeFromTokens(String[] tokens)
    {
        String shapeType = tokens[0];
        double height = Double.parseDouble(tokens[1]);
        double size = Double.parseDouble(tokens[2]);

        switch (shapeType) {
            case "Cylinder":
                return new Cylinder(height, size);
            case "Cone":
                return new Cone(height, size);
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
    }
}