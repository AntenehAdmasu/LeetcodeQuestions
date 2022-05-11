class Solution {
    public int countVowelStrings(int n) {
        int[] combs = new int[]{1, 1, 1, 1, 1};
        int sum = 5;
        for(int i = 1; i < n; i++){
            sum = 0;
            for(int j = 4; j >= 0; j--){
                // Update combinations array
                int right = j == 4 ? 0 : combs[j+1];
                combs[j] += right;
                sum += combs[j];
            }
        }
        return sum;
    }
}