package appDomain;

/**
 * VolumeCompare.java
 *
 * @author Team Riju
 * @version 1.2
 * 
 * Class Definition: This class implements the Comparator interface to compare two Shape objects 
 * based on their volume in descending order. It overrides the compare method to 
 * sort Shape objects, where shapes with larger volumes appear first.
 */
import shapes.Shape;
import java.util.Comparator;

public class VolumeCompare implements Comparator<Shape> {
	@Override
	public int compare(Shape s1, Shape s2) {
		// Descending order, so the larger volume comes first
		return Double.compare(s2.calcVolume(), s1.calcVolume());
	}
}