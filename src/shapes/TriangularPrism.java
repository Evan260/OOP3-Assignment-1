package shapes;

public class TriangularPrism extends Prism {
	// Properties
	private double triangleBase;
	private double triangleHeight;

	// Init.
	public TriangularPrism(double height, double triangleBase, double triangleHeight) {
		super(height);
		this.triangleBase = triangleBase;
		this.triangleHeight = triangleHeight;
	}

	// Getters and setters
	public double getBase() {
		return triangleBase;
	}

	public void setBase(double triangleBase) {
		this.triangleBase = triangleBase;
	}

	public double getHeight() {
		return triangleHeight;
	}

	public void seteight(double triangleHeight) {
		this.triangleHeight = triangleHeight;
	}

	// Methods
	@Override
	public double calcVolume() {
		return calcBaseArea() * getHeight();
	}

	@Override
	public double calcBaseArea() {
		return 0.5 * triangleBase * triangleHeight;
	}
}