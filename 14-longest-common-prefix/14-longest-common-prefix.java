class Solution {
    public String longestCommonPrefix(String[] strs) {
        boolean nextIndex = true; 
        int index = 0;
        String result = "";
        while(nextIndex){
            if(strs[0].length() == index){
                return result;
            }
            char c = strs[0].charAt(index);
            for(String word: strs){
                if(word.length() == index || word.charAt(index) != c){
                    return result;
                }
            }
            index++;
            result += c;
        }
        return result;
    }
}