package chapter15.border;

import java.awt.*;

public class Solid<T extends Dimension&HasColor&Weight> {
    T item;

    public Solid(T item) {
        this.item = item;
    }
    Color color(){
        return item.getColor();
    }
    public int getX(){
        return item.x;
    }
    public int getY(){
        return item.y;
    }
    public int getZ(){
        return item.z;
    }
    public int weight(){
        return item.weight();
    }

}
