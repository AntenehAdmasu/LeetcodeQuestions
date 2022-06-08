class Solution {
    public int removePalindromeSub(String s) {
        int l = 0;
        int r = s.length() - 1;
        while(l < r){
            if(s.charAt(l++) != s.charAt(r--)){
                return 2;
            }
        }
        return 1;
    }
}