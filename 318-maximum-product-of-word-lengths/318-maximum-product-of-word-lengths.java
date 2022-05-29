class Solution {
    public int maxProduct(String[] words) {
        int len = words.length;
        int[] bitRepresentation = new int[len];
        // Represent words interms of bits(size 26),
        // Letters in the word will have the corresponding bits turned on
        for(int i = 0; i < len; i++){
            String word = words[i];
            int num = 0;
            for(char c: word.toCharArray()){
                num |= (1 << (c - 'a')); // Making a 1, b 2 ....etc
            }
            bitRepresentation[i] = num;
        }

        int max = 0;
        for(int i = 0; i < len; i++){
            for(int j = i+1; j < len; j++){
                // If the & value is 0, no parallel positions have 1 in common
                if((bitRepresentation[i] & bitRepresentation[j]) == 0){
                    max = Math.max(max, words[i].length() * words[j].length());
                }
            }
        }
        return max;
    }
}