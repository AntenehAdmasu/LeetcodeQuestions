class Solution {
    // Edge cases
    public boolean validPalindrome(String s) {
        return validPal(s, 0, s.length() - 1, false);
    }
    
    public boolean validPal(String s, int left, int right, boolean deleted){
        while(left < right){
            char leftChar = s.charAt(left);
            char rightChar = s.charAt(right);
            if(leftChar != rightChar){
                if(deleted){
                    return false;
                }
                boolean moveLeft = validPal(s, left + 1, right, true);
                if(moveLeft){
                    return moveLeft;
                }
                return validPal(s, left, right - 1, true);
            }
            left++;
            right--;            
        }
        return true;
    }
}