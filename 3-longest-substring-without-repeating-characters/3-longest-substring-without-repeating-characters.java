class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        Set<Character> elements = new HashSet<>();
        int start = 0;
        int end = 0;
        int maxLen = 0;
        while(end < s.length()){
            char chStart = s.charAt(start);
            char chEnd = s.charAt(end);

            if(!elements.contains(chEnd)){
                elements.add(chEnd);
                end++;
            }else{
                elements.remove(chStart);
                start++;
            }
            maxLen = Math.max(maxLen, end - start);
            
        }
        return maxLen;
    }
}