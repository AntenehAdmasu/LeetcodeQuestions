class Solution {
    public int minDeletions(String s) {
        int[] freq = new int[26];
        int deletions = 0;
        for(char c: s.toCharArray()){
            freq[c - 'a']++;
        }
        Set<Integer> usedFreq = new HashSet<>();
        for(int i: freq){
            if(i != 0){
                boolean added = usedFreq.add(i);
                if(!added){
                    // Find prev spot not taken
                    int next = i;
                    while(usedFreq.contains(next)){
                        next--;
                    }
                    deletions += i - next;
                    if(next != 0)
                        usedFreq.add(next);
                }
            }
        }
        return deletions;
    }
}