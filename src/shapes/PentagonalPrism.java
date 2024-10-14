package shapes;

public class PentagonalPrism extends Prism
{

	private double side;
	
	public PentagonalPrism(double height, double side) {
		super(height);
		this.side = side;
	}

	/**
	 * @return the side
	 */
	public double getSide() {
		return side;
	}

	/**
	 * @param side the side to set
	 */
	public void setSide(double side) {
		this.side = side;
	}

	public double CalcBaseArea() {
		return((Math.sqrt(3)/4) * Math.pow(side, 2));
	}
	
	public double CalcVolume() {
		return(CalcBaseArea() *  getHeight());
	}
}