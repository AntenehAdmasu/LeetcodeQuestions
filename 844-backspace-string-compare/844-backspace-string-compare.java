class Solution {
    public boolean backspaceCompare(String s, String t) {
        return getProcessedString(s).equals(getProcessedString(t));
    }
    public String getProcessedString (String s) {
        Stack<Character> stack = new Stack<>();
        for(char c: s.toCharArray()){
            if(c == '#'){
                if(!stack.isEmpty()){
                    stack.pop();
                }
            }else{
                stack.push(c);
            }
        }
        return stack.toString();
    }
}