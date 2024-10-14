package shapes;

public class Cylinder extends Shape {
	// Properties
	private double radius;

	// Init.
	public Cylinder(double height, double radius) {
		super(height);
		this.radius = radius;
	}

	// Getters and setters
	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}

	// Methods
	@Override
	public double calcVolume() {
		return calcBaseArea() * height;
	}

	@Override
	public double calcBaseArea() {
		return Math.PI * Math.pow(radius, 2);
	}
}