package shapes;
/**
 * Shape.java
 *
 * @author Team Riju
 * @version 1.2
 * 
 * Class Definition: Represents an abstract geometric shape with a height.
 * This class provides the foundation for specific shape types,
 * allowing them to calculate their volume and base area.
 * It also implements Comparable to allow sorting shapes by height
 */
public abstract class Shape implements Comparable<Shape> {
	// Properties
	protected double height;

	public Shape(double height) {
		this.height = height;
	}

	// Getters
	public double getHeight() {
		return height;
	}

	public abstract double calcVolume();

	public abstract double calcBaseArea();

	// Compare by height
	@Override
	public int compareTo(Shape other) {
		return Double.compare(this.height, other.height);
	}
}