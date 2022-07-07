class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        return constructS3(s1, s2, s3, 0, 0, 0, new HashMap<String, Boolean>());
    }
    
    private boolean constructS3(String s1, String s2, String s3, int p1, int p2, int curr, HashMap<String, Boolean> dp){
        String key = p1 + "|" + p2 + "|" + "|" + curr;
        if(dp.containsKey(key)){
            return dp.get(key);
        }
        // If s3 is constructed with all characters from s1 and s2
        if(curr == s3.length() && p1 == s1.length() && p2 == s2.length()){
            return true;
        }
        // If s3 is constructed but there are characters from s1 or s2 not used
        if(curr >= s3.length()){
            return false;
        }
        char currentChar = s3.charAt(curr);
        boolean works = false;
        if(p1 < s1.length() && s1.charAt(p1) == currentChar){
            works |= constructS3(s1, s2, s3, p1+1, p2, curr+1, dp);
        }
        if(!works && p2 < s2.length() && s2.charAt(p2) == currentChar){
            works |= constructS3(s1, s2, s3, p1, p2+1, curr+1, dp);
        }

        dp.put(key, works);
        return works;        
    }
}
