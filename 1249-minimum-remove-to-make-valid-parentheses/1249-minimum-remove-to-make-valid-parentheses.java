class Solution {
    public String minRemoveToMakeValid(String s) {
        Stack<Character> charStack = new Stack<>();
        Stack<Character> resStack = new Stack<>();
        int openerCount = 0;
        
        for(char c: s.toCharArray()){
            if(c == '('){
                charStack.push(c);
                openerCount++;
            }else if(c == ')'){
                if(charStack.isEmpty() || charStack.peek() == ')'){
                    continue;
                }
                charStack.pop();
            }
            resStack.push(c);  
        }
        
        
        int openers = 0;
        StringBuilder result = new StringBuilder("");
        for(char c: resStack){
            if(c == '('){
                openers++;
                if(openers > openerCount - charStack.size()){
                    continue;
                }
            }
            result.append(c);
        }

        return result.toString(); 
        
    }
}