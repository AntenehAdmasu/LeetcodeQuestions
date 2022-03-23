class Solution {
    public int brokenCalc(int startValue, int target) {
        int ans = 0;
        while (target > startValue) {
            ans++;
            target = target % 2 == 0 ? target / 2 : target + 1;
        }

        return ans + startValue - target;
    
    }
}