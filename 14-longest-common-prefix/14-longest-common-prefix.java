class Solution {
    public String longestCommonPrefix(String[] strs) {
        boolean nextIndex = true; 
        int index = 0;
        StringBuilder result = new StringBuilder();
        while(nextIndex){
            if(strs[0].length() == index){
                return result.toString();
            }
            char c = strs[0].charAt(index);
            for(String word: strs){
                if(word.length() == index || word.charAt(index) != c){
                    return result.toString();
                }
            }
            index++;
            result.append(c);
        }
        return result.toString();
    }
}