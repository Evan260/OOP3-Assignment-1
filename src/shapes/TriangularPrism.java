package shapes;

public class TriangularPrism extends Shape {
    private double triangleBase;
    private double triangleHeight;

    public TriangularPrism(double height, double triangleBase, double triangleHeight) {
        super(height);
        this.triangleBase = triangleBase;
        this.triangleHeight = triangleHeight;
    }

    @Override
    public double calcVolume() {
        return calcBaseArea() * height;  
    }

    @Override
    public double calcBaseArea() {
        return 0.5 * triangleBase * triangleHeight; 
    }
}
