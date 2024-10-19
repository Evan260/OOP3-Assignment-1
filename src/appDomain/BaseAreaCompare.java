package appDomain;

import shapes.Shape;
import java.util.Comparator;

public class BaseAreaCompare implements Comparator<Shape> {
    @Override
    public int compare(Shape s1, Shape s2) {
    	 // Descending order, so the larger volume comes first
        return Double.compare(s2.calcBaseArea(), s1.calcBaseArea());
    }
}