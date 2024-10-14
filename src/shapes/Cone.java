package shapes;

public class Cone extends Shape 
{
	// Properties
	private double radius;

	// Init.
	public Cone(double height, double radius) {
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
		return (1.0 / 3) * calcBaseArea() * height;
	}

	@Override
	public double calcBaseArea() {
		return Math.PI * Math.pow(radius, 2);
	}
}