import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * Created by qinshuxiao on 2018/6/12.
 */
public class Flatten2DVector implements Iterator<Integer> {

    /**
     * Row: specifies row-th List we are at
     * Col: specifies col-th element in row-th List we are at
     *
     */
    private int row, col;
    private List<List<Integer>> vec;

    public static void main(String[] args){
        List<List<Integer>> vec2d = new ArrayList<>();
        vec2d.add(new ArrayList<Integer>());
        vec2d.add(Arrays.asList(1,2,3));
        vec2d.add(Arrays.asList(4));
        vec2d.add(new ArrayList<Integer>());
        vec2d.add(Arrays.asList(5));
        vec2d.add(Arrays.asList(6,7));
        vec2d.add(new ArrayList<Integer>());
        vec2d.add(new ArrayList<Integer>());

        Flatten2DVector vector = new Flatten2DVector(vec2d);

        System.out.println("Vec2D: "+vec2d.toString());
        System.out.print("Output: ");
        while (vector.hasNext()){
            System.out.print(vector.next()+" ");
        }
        System.out.print("\n");
    }

    public Flatten2DVector(List<List<Integer>> vec2d) {
        vec = vec2d;

        row = col = 0;
        while(row < vec.size() && col >= vec.get(row).size()) ++row;
    }

    /**
     * Remember, each time we retrieve a element, we need to move forward Col.
     * If Col reaches to the end of List, we need to increment Row, and set Col to 0.
     *
     * Note that there might be some empty List, we have to check if we meet an empty list when we move Row forward.
     *
     * @return
     */
    @Override
    public Integer next() {
        int res = vec.get(row).get(col);
        ++col;
        if(col == vec.get(row).size()){
            ++row;
            col = 0;
            while(row < vec.size() && col >= vec.get(row).size()) ++row;
        }
        return res;
    }

    @Override
    public boolean hasNext() {
        return row < vec.size() && col < vec.get(row).size();
    }
}
