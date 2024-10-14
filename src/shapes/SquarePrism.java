package shapes;

/
public class SquarePrism extends Shape {
    private double side;

    
    public SquarePrism(double height, double side) {
        super(height);
        this.side = side;
    }

    @Override
    public double calcVolume() {
        return calcBaseArea() * height;  
    }

    @Override
    public double calcBaseArea() {
        return Math.pow(side, 2); 
    }
}
