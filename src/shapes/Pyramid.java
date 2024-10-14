package shapes;

public class Pyramid extends Prism
{
	private double side;

	/**
	 * @param height
	 * @param radius
	 */
	public Pyramid(double height, double side) {
		super(height);
		this.side = side;
	}

	/**
	 * @return the radius
	 */
	public double getSide() {
		return side;
	}

	/**
	 * @param radius the radius to set
	 */
	public void setSide(double side) {
		this.side = side;
	}
	
	
	@Override
	public double calcBaseArea() {
		return Math.pow(side, 2);
	}
	
	public double calcVolume() {
		return 1/3 * Math.pow(side, 2) * getHeight();
	}
}
