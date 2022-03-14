class Solution {
    public static boolean isValid(String s) {
        Stack<String> parentheses = new Stack<>();
        if(s.length() % 2 == 1){
            return false;
        }
        for (int i = 0; i < s.length(); i++) {
            String symbol = Character.toString(s.charAt(i));
            switch (symbol){
                case (")"):
                    if (parentheses.isEmpty() || !parentheses.peek().equals("(")){
                        return false;
                    }
                    parentheses.pop();
                    break;
                case ("}"):
                    if (parentheses.isEmpty() || !parentheses.peek().equals("{")){
                        return false;
                    }
                    parentheses.pop();
                    break;
                   
                case ("]"):
                     if (parentheses.isEmpty() || !parentheses.peek().equals("[")){
                        return false;
                    }
                    parentheses.pop();
                    break;
                default:
                    parentheses.push(symbol);
            }

        }
        return parentheses.isEmpty();
    }
}
