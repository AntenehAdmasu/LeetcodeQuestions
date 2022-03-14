class Solution {
    public int subarraysDivByK(int[] A, int K) {
        int n = A.length;
        HashMap<Integer, Integer> freq = new HashMap<>(){{put(0,1);}};
        int sum = 0;
        int result = 0;
     
        for(int i = 0; i < n; i++){
            sum += A[i];
            int value = sum % K;
            result += freq.getOrDefault(value, 0);
            
            // Finding the negative counterpart
            if(value < 0){
                result += freq.getOrDefault((K - Math.abs(value)), 0); 
            }else{
                result += freq.getOrDefault(-1 * (K - value), 0); 
            }
            
            freq.put(value, freq.getOrDefault(value, 0) + 1);

        }
        return result;
    }
}