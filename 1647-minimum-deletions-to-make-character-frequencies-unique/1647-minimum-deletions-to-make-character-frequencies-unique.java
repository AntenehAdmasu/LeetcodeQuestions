class Solution {
    public int minDeletions(String s) {
        int deletions = 0;
        int[] freq = new int[26];
        for(char c: s.toCharArray()){
            freq[c - 'a']++;
        }
        
        Set<Integer> usedFreq = new HashSet<>();
        for(int i: freq){
            if(i != 0){
                boolean added = usedFreq.add(i);
                // If frequency is repeated
                if(!added){
                    // Find previous spot not taken or zero
                    int nextEmpty = i - 1;
                    while(usedFreq.contains(nextEmpty) && nextEmpty != 0){
                        nextEmpty--;
                    }
                    deletions += i - nextEmpty;
                    usedFreq.add(nextEmpty);
                }
            }
        }
        return deletions;
    }
}