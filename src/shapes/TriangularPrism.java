package shapes;
/**
 * TriangularPrism.java
 *
 * @author Team Riju
 * @version 1.2
 * 
 * Class Definition: This TriangularPrism extends Shape, taking in Side and Height. 
 * It overrides calcVolume and calcBaseArea to provide specific implementations 
 * for a TriangularPrism's volume and base area calculations.
 */
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