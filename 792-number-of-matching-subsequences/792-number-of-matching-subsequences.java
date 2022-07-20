class Solution {

    public int numMatchingSubseq(String s, String[] words) {
        HashMap<Character, List<Integer>> map = new HashMap<>();
        int count = 0;
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            List<Integer> indices = map.getOrDefault(c, new ArrayList<>());
            indices.add(i);
            map.put(c, indices);
        }
        
        for(String word: words){
            int leastI = -1;
            boolean subsequence = true;
            for(char c: word.toCharArray()){
                if(map.containsKey(c)){
                    List<Integer> indices = map.get(c);
                    boolean indexFound = false;
                    for(int index: indices){
                        if(index > leastI){
                            leastI = index;
                            indexFound = true;
                            break;
                        }
                    }
                    if(!indexFound){
                        subsequence = false;
                        break;
                    }
                }else{
                    subsequence = false;
                    break;
                }
            }
            
            count += subsequence ? 1 : 0;
        }
        return count;
    }
}