package appDomain;

import java.awt.Shape;
import java.util.Comparator;

public abstract class BaseAreaCompare implements Comparator<Shape>{
		
       Comparator<Shape> volumeComparator = new Comparator<Shape>() {
           @Override
           public int compare(Shape s1, Shape s2) {
               return Double.compare(s1.calcVolume(), s2.calcVolume());
            }
	    };
	}

