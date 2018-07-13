import java.util.Arrays;

/**
 * Created by qinshuxiao on 2018/7/12.
 */
public class GasStation {

    public static void main(String[] args){
        GasStation gs = new GasStation();

        int[] gas = new int[]{1,2,3,4,5}, costs = new int[]{3,4,5,1,2};
        System.out.println("Gas: "+ Arrays.toString(gas)+"  Costs: "+ Arrays.toString(costs));
        System.out.println("Result: "+gs.canCompleteCircuit(gas, costs));
        System.out.println("==================================");

        gas = new int[]{2,3,4}; costs = new int[]{3,4,3};
        System.out.println("Gas: "+ Arrays.toString(gas)+"  Costs: "+ Arrays.toString(costs));
        System.out.println("Result: "+gs.canCompleteCircuit(gas, costs));
        System.out.println("==================================");

        gas = new int[]{1,2,4,3,5,3}; costs = new int[]{3,4,2,6,1,1};
        System.out.println("Gas: "+ Arrays.toString(gas)+"  Costs: "+ Arrays.toString(costs));
        System.out.println("Result: "+gs.canCompleteCircuit(gas, costs));
        System.out.println("==================================");

        gas = new int[]{3,1,1}; costs = new int[]{1,2,2};
        System.out.println("Gas: "+ Arrays.toString(gas)+"  Costs: "+ Arrays.toString(costs));
        System.out.println("Result: "+gs.canCompleteCircuit(gas, costs));
        System.out.println("==================================");

        gas = new int[]{2}; costs = new int[]{2};
        System.out.println("Gas: "+ Arrays.toString(gas)+"  Costs: "+ Arrays.toString(costs));
        System.out.println("Result: "+gs.canCompleteCircuit(gas, costs));
        System.out.println("==================================");

        gas = new int[]{1,2}; costs = new int[]{2,1};
        System.out.println("Gas: "+ Arrays.toString(gas)+"  Costs: "+ Arrays.toString(costs));
        System.out.println("Result: "+gs.canCompleteCircuit(gas, costs));
        System.out.println("==================================");
    }

    /**
     *
     * Greedy.
     * We need to find the peak of fuel "need" (the need of i is cost[i]-gas[i])
     *
     * If we can run around a circuit successfully, the start point should be the next index of "need" peek.
     * But if at the end the accumulated need is larger than 0, we cannot complete a circuit.
     *
     */
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int need = 0, maxNeed = 0, idx = -1;

        // edge case 1: gas=[3,1,1], cost=[1,2,2]
        // edge case 2: gas=[2], cost=[2]
        need = cost[0] - gas[0];
        if(need <= 0) idx = 0;
            // edge case 3: gas=[1,2], cost=[2,1]
        else{
            maxNeed = need;
            idx = 1;
        }

        for(int i = 1; i < gas.length; ++i){
            need += cost[i]-gas[i];

            if(need > maxNeed) {
                maxNeed = need;
                idx = i+1;
            }
        }

        if(need > 0) return -1;
        else return idx;
    }
}
