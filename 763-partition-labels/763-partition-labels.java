class Solution {
    public List<Integer> partitionLabels(String S) {
        List<Integer> answer = new ArrayList<>();
        int[] lastIndex = new int[26];
        Arrays.fill(lastIndex, -1);
        for(int i = 0; i < S.length(); i++){
            lastIndex[S.charAt(i) - 'a'] = i;
        }
        
        int partitionCount = 0;
        int finalIndex = lastIndex[S.charAt(0) - 'a']; 
            
        for(int i = 0; i < S.length(); i++){
            char c = S.charAt(i);
            partitionCount++;
            if(finalIndex == i){
                answer.add(partitionCount);
                partitionCount = 0;
                if(i < S.length() - 1){
                    finalIndex = lastIndex[S.charAt(i+1) - 'a'];
                }
            }
            finalIndex = Math.max(finalIndex, lastIndex[c-'a']);
        }
        return answer;
    }
}
