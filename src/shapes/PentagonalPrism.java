package shapes;

public class PentagonalPrism extends Shape {
	// Properties
	private double side;

	// Init.
	public PentagonalPrism(double height, double side) {
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
		 return (5 * Math.pow(side, 2) * Math.tan(Math.toRadians(54))) / 4;
	}

	@Override
	public double calcVolume() {
		return calcBaseArea() * getHeight();
	}
}