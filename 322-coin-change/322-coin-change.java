class Solution {
    public int coinChange(int[] coins, int amount) {

        boolean[] seen = new boolean[amount];
        CoinStep initial = new CoinStep(amount,0);
        Queue<CoinStep> queue = new ArrayDeque<>();
        queue.add(initial);
        
        while(!queue.isEmpty()){
            CoinStep current = queue.poll();
            if(current.coin == 0){
                return current.step;
            }
            for(int coin: coins){
                if(current.coin - coin >= 0){
                    if(!seen[current.coin - coin]){
                        queue.add(new CoinStep(current.coin - coin, current.step + 1));
                        seen[current.coin - coin] = true;
                    }
                }
            }
        }
        return -1;       
    }
}

class CoinStep{
    int coin;
    int step;
    public CoinStep(int _coin, int _step){
        coin = _coin;
        step = _step;
    }
    
}