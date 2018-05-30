import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by qinshuxiao on 2018/5/29.
 */
public class InsertDeleteGetRandomOone {

    public static void main(String[] args){
        InsertDeleteGetRandomOone randomSet = new InsertDeleteGetRandomOone();


        System.out.println("Insert 1 "+randomSet.insert(1));
        System.out.println("Remove 2 "+randomSet.remove(2));
        System.out.println("Insert 2 "+randomSet.insert(2));
        System.out.println("getRandom: "+randomSet.getRandom());
        System.out.println("remove 1 "+randomSet.remove(1));
        System.out.println("Insert 2 "+randomSet.insert(2));
        System.out.println("getRandom: "+randomSet.getRandom());
    }

    /**
     * It's a funny problem, really enjoy working on it.
     * We are asked to insert, remove and randomly retrieve elements in O(1).
     * Let's separate it in several parts:
     * 1. Retrieval and insertion in O(1) -> ArrayList
     * 2. Removal in O(1) -> ArrayList cannot remove element in O(1) if you want to remove middle element.
     *                       But, say you want to remove element at index i, we can swap list[i] with the last element in the list.
     *                       And we use an variable, num, to denote how many valid elements in the list.
     * 3. Check if element exists in array -> Using HashMap to store <element, index in the array> pair.
     *                                        So checking time is averagely O(1).
     *
     */

    Map<Integer, Integer> position;
    List<Integer> list;
    int num;

    /** Initialize your data structure here. */
    public InsertDeleteGetRandomOone() {
        list = new ArrayList<Integer>();
        position = new HashMap<Integer, Integer>();
        num = 0;
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(position.containsKey(val)) return false;

        list.add(num, val);
        position.put(val, num);
        ++num;
        return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(!position.containsKey(val)) return false;

        int pos = position.get(val);
        --num;
        int lastVal = list.get(num);
        list.set(pos, lastVal);
        position.put(lastVal, pos);
        position.remove(val);
        return true;

    }

    /** Get a random element from the set. */
    public int getRandom() {

        int randomPos = (int)(Math.random() * num);
        return list.get(randomPos);
    }
}
