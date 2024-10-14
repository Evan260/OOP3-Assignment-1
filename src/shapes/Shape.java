package shapes;

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