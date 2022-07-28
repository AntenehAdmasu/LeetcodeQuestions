class Solution {
    public boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> smap = new HashMap<>();
        HashMap<Character, Integer> tmap = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            smap.put(c, smap.getOrDefault(c, 0) + 1);
        }

        for (int j = 0; j < t.length(); j++) {
            char c = t.charAt(j);
            tmap.put(c, tmap.getOrDefault(c, 0) + 1);
        }
        
        if(smap.values().size() != tmap.values().size()) return false;

        for (Character c: smap.keySet() ) {
            if(!(smap.get(c).equals((tmap.get(c))))) return false;
        }
        return true;
    }
}