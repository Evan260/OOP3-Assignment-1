package shapes;
/**
 * SquarePrism.java
 *
 * @author Team Riju
 * @version 1.2
 * 
 * Class Definition: This class extends Shape, taking in Side and Height. 
 * It overrides calcVolume and calcBaseArea to provide specific implementations 
 * for a SquarePrism's volume and base area calculations.
 */
public class SquarePrism extends Shape {
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
		return calcBaseArea() * getHeight();
	}

	@Override
	public double calcBaseArea() {
		return Math.pow(side, 2.0);
	}
}