package shapes;

public abstract class Prism implements Comparable<Prism>{
	
	private double side;
	private double height;

	/**
	 * @param side
	 */
	public Prism(double side) {
		super();
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
	
	/**
	 * @return the height
	 */
	public double getHeight() {
		return height;
	}

	/**
	 * @param height the height to set
	 */
	public void setHeight(double height) {
		this.height = height;
	}
	
	
	public int compareTo(Prism other) {
		if (this.height > other.height) {
			return 1;
		} if (this.height < other.height) {
			return -1;
		} else {
			return 0;
		}
	}
	
	/**
	 * 
	 * @return
	 */
	public abstract double calcBaseArea();
	public abstract double calcVolume();

	@Override
	public String toString() {
		return "Prism [getHeight()=" + getHeight() + ", calcBaseArea()=" + calcBaseArea() + ", calcVolume()="
				+ calcVolume() + "]";
	}
	
	
}
