package shapes;

public abstract class Prism implements Comparable<Prism> {
	// Properties
	private double side;
	private double height;

	// Init.
	public Prism(double side) {
		super();
		this.side = side;
	}

	// Getters and setters
	public double getSide() {
		return side;
	}

	public void setSide(double side) {
		this.side = side;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	// Methods
	public int compareTo(Prism other) {
		if (this.height > other.height) {
			return 1;
		}
		if (this.height < other.height) {
			return -1;
		} else {
			return 0;
		}
	}

	public abstract double calcBaseArea();

	public abstract double calcVolume();

	@Override
	public String toString() {
		return "Prism [getHeight()=" + getHeight() + ", calcBaseArea()=" + calcBaseArea() + ", calcVolume()="
				+ calcVolume() + "]";
	}
}