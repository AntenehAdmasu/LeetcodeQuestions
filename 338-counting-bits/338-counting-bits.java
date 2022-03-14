class Solution {
    public int[] countBits(int n) {
        int[] bits = new int[n+1];
        
        for(int i = 0; i <= n; i++){
            
            // For even numbers - num of bits == bits at the half the number
            // For odd numbers - num of bits at half + 1 because of the last bit with val 1
            bits[i] = bits[i/2] + (i % 2 == 0 ? 0 : 1);
        }
        return bits;
        
        
    }
}