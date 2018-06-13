/**
 * Created by qinshuxiao on 2018/6/13.
 */
public class CoinChange {


    /**
     *
     * DP[i]: shows how many ways we have to exchange i.
     * DP[i] = min(1+DP[i-coin]) for coin in coins
     *
     */
    public int coinChange(int[] coins, int amount) {
        if(coins.length == 0) return -1;

        int[] exchange = new int[amount+1];

        exchange[0] = 0;
        int cur = 1;
        while(cur <= amount){
            int fewest = Integer.MAX_VALUE;

            for(int coin : coins){
                if(cur >= coin){
                    if(exchange[cur-coin] != -1){
                        fewest = Math.min(fewest, exchange[cur-coin]+1);
                    }
                }
            }

            exchange[cur] = fewest == Integer.MAX_VALUE ? -1 : fewest;
            ++cur;
        }

        return exchange[amount];
    }
}
