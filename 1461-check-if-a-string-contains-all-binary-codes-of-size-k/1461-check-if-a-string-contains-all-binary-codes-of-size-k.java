class Solution {
    public boolean hasAllCodes(String s, int k) {
        int len = s.length();
        int lowerLimit = 0;
        int upperLimit = (int) Math.pow(2, k) - 1;
        Set<Integer> found = new HashSet<>();
        
        for(int i = 0; i <= len - k; i++){
            String binaryString = s.substring(i, i + k);
            int decimal = Integer.parseInt(binaryString,2);
            if(decimal <= upperLimit && decimal >= lowerLimit){
                found.add(decimal);
            }
            if(found.size() == upperLimit - lowerLimit + 1){
                return true;
            }
        }
        return found.size() == upperLimit - lowerLimit + 1;
    }
}