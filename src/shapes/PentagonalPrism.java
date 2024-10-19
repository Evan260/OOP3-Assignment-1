package shapes;
/**
 * PentagonalPrism.java
 *
 * @author Team Riju
 * @version 1.2
 * 
 * Class Definition: This class extends Shape, taking in Side and Height. 
 * It overrides calcVolume and calcBaseArea to provide specific implementations 
 * for a PentagonalPrism's volume and base area calculations.
 */
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
		 return (5.0 * Math.pow(side, 2.0) * Math.tan(Math.toRadians(54.0))) / 4.0;
	}

	@Override
	public double calcVolume() {
		return calcBaseArea() * getHeight();
	}
}