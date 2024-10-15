package appDomain;

import java.awt.Shape;
import java.util.Comparator;

public abstract class VolumeCompare implements Comparator<Shape>{
	// compartor for base area
	Comparator<Shape> BaseAreaComparator = new Comparator<Shape>() {
        @Override
        public int compare(Shape s1, Shape s2) {
            return Double.compare(s1.calcBaseArea(), s2.calcBaseArea());
        }
    };
}
