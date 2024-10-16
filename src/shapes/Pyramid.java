package shapes;

public class Pyramid extends Shape {
	// Properties
	private double side;

	// Init.
	public Pyramid(double height, double side) {
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
	public double calcBaseArea() {
		return Math.pow(side, 2);
	}

	@Override
	public double calcVolume() {
		return 1 / 3 * calcBaseArea() * getHeight();
	}
}