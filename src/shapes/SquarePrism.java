package shapes;

public class SquarePrism extends Shape 
{
	// Properties
	private double side;

	// Init.
	public SquarePrism(double height, double side) {
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
		return Math.pow(side, 2);
	}
}