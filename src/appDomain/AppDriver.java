import shapes.*;

import java.util.Comparator;

public class AppDriver {

    public static void main(String[] args) {
        // Define an array with various shapes,including all shapes listed in the project folder
        Shape[] shapes = {
            new Cylinder(10, 4),
            new Cone(7, 3),
            new SquarePrism(5, 6),
            new TriangularPrism(8, 5, 3),
            new OctagonalPrism(9, 4),   
            new PentagonalPrism(6, 7),  
            new Pyramid(10, 5)          
        };

        // Sort shapes by volume using bubble sort
        bubbleSort(shapes, volumeComparator);

        // Display sorted shapes
        for (Shape shape : shapes) {
            System.out.println(shape.getClass().getSimpleName() + " Volume: " + shape.calcVolume());
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
