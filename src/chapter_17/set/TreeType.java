package chapter_17.set;

public class TreeType extends SetType implements Comparable<TreeType>{

    public TreeType(int i) {
        super(i);
    }

    @Override
    public int compareTo(TreeType o) {
        return Integer.compare(o.i, i);
    }


}
