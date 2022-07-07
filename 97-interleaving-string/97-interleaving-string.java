// Non dp solution
class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        return constructS3(s1, s2, s3, 0, 0, 0, new HashMap<String, Boolean>());
    }
    
    private boolean constructS3(String s1, String s2, String s3, int pos1, int pos2, int curr, HashMap<String, Boolean> dp){
        String key = pos1 + " " + pos2 + " " + " " + curr;
        if(dp.containsKey(key)){
            return dp.get(key);
        }
        // If s3 is constructed with all elements from s1 and s2 consumed
        if(curr == s3.length() && pos1 == s1.length() && pos2 == s2.length()){
            return true;
        }
        // If s3 is constructed but there are characters from s1 or s2 not used
        if(curr >= s3.length()){
            return false;
        }
        boolean works = false;
        if(pos1 < s1.length() && s1.charAt(pos1) == s3.charAt(curr)){
            works |= constructS3(s1, s2, s3, pos1+1, pos2, curr+1, dp);
        }
        if(pos2 < s2.length() && s2.charAt(pos2) == s3.charAt(curr)){
            works |= constructS3(s1, s2, s3, pos1, pos2+1, curr+1, dp);
        }
        dp.put(key, works);
        return works;        
    }
}
