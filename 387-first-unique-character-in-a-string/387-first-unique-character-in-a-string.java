class Solution {
    public int firstUniqChar(String s) {
        int[] occurence = new int[26];
        for (char c: s.toCharArray()) {
            occurence[c -'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(occurence[c-'a'] == 1){
                return i;
            }
        }
        return -1;
    }
}