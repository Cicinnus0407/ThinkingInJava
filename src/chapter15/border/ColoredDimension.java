package chapter15.border;

import java.awt.*;

public class ColoredDimension<T extends Dimension &HasColor> {
    T item;

    public ColoredDimension(T item) {
        this.item = item;
    }
    T getItem(){
        return item;
    }
    Color color(){
        return item.getColor();
    }
    int getX(){
        return item.x;
    }
    int getY(){
        return item.y;
    }
    int getZ(){
        return item.z;
    }

}
