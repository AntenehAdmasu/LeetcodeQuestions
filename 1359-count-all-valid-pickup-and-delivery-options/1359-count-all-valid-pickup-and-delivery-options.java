class Solution {
    public int countOrders(int n) {
        long total = 0;
        long prevCombinations = 1;
        long modNum = (long)1e9 + 7;
        
        for (int i = 1; i <= n; i++){
            int size = i * 2;
            int newPositions = (size * (size - 1) / 2);
            total = (newPositions * prevCombinations) % modNum;
            prevCombinations = total;
        }
        return (int)total;
    }
}