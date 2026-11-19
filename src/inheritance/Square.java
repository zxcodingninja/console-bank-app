package inheritance;

import objects.Rectangle;

public class Square extends Rectangle {

    @Override
    public double calculatePerimeter() {
        return sides * length;
    }


}
