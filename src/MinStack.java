import java.util.Stack;

/**
 * Created by qinshuxiao on 2018/7/9.
 */
public class MinStack {
    public static void main(String[] args){
        MinStack ms = new MinStack();

        System.out.println("Push -2");
        ms.push(-2);
        System.out.println("Push 0");
        ms.push(0);
        System.out.println("Push -3");
        ms.push(-3);

        System.out.println("GetMin: "+ms.getMin());

        System.out.println("Pop");
        ms.pop();
        System.out.println("Top: "+ms.top());
        System.out.println("GetMin: "+ms.getMin());
    }

    private Stack<Integer> s = null;

    /**
     *
     * We need to organize the stack like this:
     *
     * | Min   |
     * | Item3 |
     * | Min   |
     * | Item2 |
     * | Min   |
     * | Item1 |
     * | Min   |
     * | Item0 |
     *  _______
     *
     */

    /** initialize your data structure here. */
    public MinStack() {
        s = new Stack<Integer>();

    }

    public void push(int x) {
        if(s.empty()){
            s.push(x);
            s.push(x);
        } else {
            int min = Math.min(x, s.peek().intValue());
            s.push(x);
            s.push(min);
        }
    }

    public void pop() {
        s.pop();
        s.pop();
    }

    public int top() {
        int min = s.peek();
        s.pop();
        int res = s.peek();
        s.push(min);
        return res;
    }

    public int getMin() {
        return s.peek();
    }
}
