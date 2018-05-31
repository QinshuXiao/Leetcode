import java.util.*;

/**
 * Created by qinshuxiao on 2018/5/30.
 */
public class InsertDeleteGetRandomDuplicatesOone {

    public static void main(String[] args){
        InsertDeleteGetRandomDuplicatesOone randomSet = new InsertDeleteGetRandomDuplicatesOone();


        System.out.println("Insert 1 "+randomSet.insert(1));
        System.out.println("Remove 2 "+randomSet.remove(2));
        System.out.println("Insert 2 "+randomSet.insert(2));
        System.out.println("Insert 2 "+randomSet.insert(2));
        System.out.println("getRandom: "+randomSet.getRandom());
        System.out.println("getRandom: "+randomSet.getRandom());
        System.out.println("remove 1 "+randomSet.remove(1));
        System.out.println("Insert 2 "+randomSet.insert(2));
        System.out.println("getRandom: "+randomSet.getRandom());
    }

    /**
     * Well, duplicates are allowed in this problem.
     * But actually we don't need to modify some many codes.
     * All we need to do is to store all duplicates' indexes in a way that we can retrieve it in O(1)
     * So, we use a linkedlist as value of hashmap to store indexes, because we can do insertion and removal in O(1), and retrieve first and last element of list also consumes only O(1) time.
     *
     */


    List<Integer> list;
    Map<Integer, LinkedList<Integer>> positions;
    int num;

    /** Initialize your data structure here. */
    public InsertDeleteGetRandomDuplicatesOone() {
        list = new ArrayList<Integer>();
        positions = new HashMap<>();
        num = 0;
    }

    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        boolean ret = false;
        if(!positions.containsKey(val)){
            positions.put(val, new LinkedList<Integer>());
            ret = true;
        }

        if(num == list.size()) list.add(val);
        else list.set(num, val);

        positions.get(val).addLast(num);
        ++num;
        //System.out.println(list+"  num="+num);
        return ret;
    }

    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        if(!positions.containsKey(val)) return false;

        int removedPos = positions.get(val).removeFirst();
        if(positions.get(val).size() == 0){
            positions.remove(val);
        }

        // swap removedPos with list[num-1]
        --num;
        // obiviously, if num == 0 and removedPos == num, we don't need to do anything
        if(num > 0 && removedPos != num){
            list.set(removedPos,list.get(num));

            // adjust position of moved element.
            positions.get(list.get(removedPos)).removeLast();
            positions.get(list.get(removedPos)).addFirst(removedPos);
        }
        //list.remove(num);

        //System.out.println(list+"  num="+num);
        return true;
    }

    /** Get a random element from the collection. */
    public int getRandom() {
        int randomPos = (int)(Math.random() * num);
        return list.get(randomPos);
    }
}
