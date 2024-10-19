package shapes;
/**
 * OctagonalPrism.java
 *
 * @author Team Riju
 * @version 1.2
 * 
 * Class Definition: This OctagonalPrism extends Shape, taking in side and height. 
 * It overrides calcVolume and calcBaseArea to provide specific implementations 
 * for a OctagonalPrism's volume and base area calculations.
 */
public class OctagonalPrism extends Shape {
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
		return calcBaseArea() * getHeight();
	}

	@Override
	public double calcBaseArea() {
		return 2.0 * (1.0 + Math.sqrt(2.0)) * Math.pow(side, 2.0);
	}
}