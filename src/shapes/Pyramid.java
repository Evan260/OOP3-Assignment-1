package shapes;
/**
 * Pyrimid.java
 *
 * @author Team Riju
 * @version 1.2
 * 
 * Class Definition: This Pyrimid extends Shape, taking in Side and Height. 
 * It overrides calcVolume and calcBaseArea to provide specific implementations 
 * for a Pyrimid's volume and base area calculations.
 */
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
		return 1.0 / 3.0 * calcBaseArea() * getHeight();
	}
}