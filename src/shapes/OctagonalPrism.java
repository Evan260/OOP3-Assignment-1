package shapes;

public class OctagonalPrism extends Shape
{
	// Properties
	private double side;

	// Init.
	public OctagonalPrism(double height, double side) {
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
		return calcBaseArea() * height;
	}

	@Override
	public double calcBaseArea() {
		return 2 * (1 + Math.sqrt(2)) * Math.pow(side, 2);
	}
}