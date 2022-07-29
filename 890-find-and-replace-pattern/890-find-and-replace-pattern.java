class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> result = new ArrayList<>();
        for(String word: words){
            if(word.length() != pattern.length())
                break;
            HashMap<Character,Character> map = new HashMap<>();
            HashSet<Character> taken = new HashSet<>();
            int i = 0;
            boolean match = true;
            while(i < word.length()){
                char w = word.charAt(i);
                char p = pattern.charAt(i);
                if(!map.containsKey(w) && !taken.contains(p)){
                    map.put(w, p);
                    taken.add(p);
                }else{
                    if (map.getOrDefault(w, '0') != p){
                        match = false;
                        break;
                    }
                }
                i++;
            }
            if(match){
                result.add(word);
            }
        }
        return result;
    }
}