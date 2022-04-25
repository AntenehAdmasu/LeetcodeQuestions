class Trie {
    private TrieNode root;
    public Trie() {
        root = new TrieNode();
    }
    
    public void insert(String word) {
        TrieNode current = root;
        for(char c: word.toCharArray()){
            int index = c - 'a';
            if(current.children[index] == null){
                current.children[index] = new TrieNode();
            }
            current = current.children[index];
        }
        current.end = true;
    }
    
    public boolean search(String word) {
        TrieNode current = root;
        for(char c: word.toCharArray()){
            int index = c - 'a';
            if(current.children[index] == null){
                return false;
            }
            current = current.children[index];
        }
        return current.end;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode current = root;
        for(char c: prefix.toCharArray()){
            int index = c - 'a';
            if(current.children[index] == null){
                return false;
            }
            current = current.children[index];
        }
        return true;
        
    }
}

class TrieNode {
    public boolean end;
    public TrieNode[] children;
    
    public TrieNode(){
        end = false;
        children = new TrieNode[26];
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */