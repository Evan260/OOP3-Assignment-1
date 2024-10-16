package shapes;

public class TriangularPrism extends Shape {
	// Properties
	private double side; // The side length of the equilateral triangle

	// Init.
	public TriangularPrism(double height, double side) {
		super(height);
		this.side = side;
	}

	// Getters and setters
	public double getSide() {
		return side;
	}

	public void setSide(double side) {
		this.side = side;
	}

	// Methods
	@Override
	public double calcVolume() {
		return calcBaseArea() * getHeight();
	}

	@Override
	public double calcBaseArea() {
		return (Math.pow(side, 2) * Math.sqrt(3)) / 4;
	}
}