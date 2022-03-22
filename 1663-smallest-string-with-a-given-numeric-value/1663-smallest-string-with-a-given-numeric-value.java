class Solution {
    public String getSmallestString(int n, int k) {
        int used = 0;
        int rem = n;
        StringBuilder answer = new StringBuilder("");
        
        while(n > 0){
            int charCode = Math.max(1, k - ((n-1) * 26));
            k -= charCode;
            answer.append((char) (charCode + 96));
            n--;
        }
        
        return answer.toString();
    }
}