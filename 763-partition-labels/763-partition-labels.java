class Solution {
    public List<Integer> partitionLabels(String S) {
        List<Integer> answer = new ArrayList<>();
        HashMap<Character, Integer> charMap = new HashMap<>();
        for(char c : S.toCharArray()){
            charMap.put(c, charMap.getOrDefault(c,0) + 1);
        }
        
        int partitionCount = 0;
        HashSet<Character> partitionElements = new HashSet<>();
        boolean newPartition = false;
        
        for(char c: S.toCharArray()){
            //Starting a new partition
            if(newPartition){
                answer.add(partitionCount);
                partitionCount = 0;
            }
            partitionCount++;
            partitionElements.add(c);
            int occ = charMap.get(c);
            // update the hashmap
            if(occ == 1){
                charMap.remove(c);
                partitionElements.remove(c);
            }else{
                charMap.put(c, occ - 1);
            }
            // If all duplicates of characters in the current partition are seen
            newPartition = partitionElements.isEmpty();
        }
        answer.add(partitionCount);
        return answer;
    }
}
