// To be redone
class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] env1, int[] env2) {
                if(env1[0] == env2[0]){
                    return env2[1] - env1[1];
                }
                return env1[0] - env2[0];
            }
        });

        int len = envelopes.length;
        int[] dp = new int[len];
        int result = 0;

        for (int[] env : envelopes) {
            int height = env[1];
            int left = Arrays.binarySearch(dp, 0, result, height);
            if (left < 0){
                left = - left - 1;
            }
            if (left == result){
                result++;
            }
            dp[left] = height;
        }
        return result;
    }
    
}