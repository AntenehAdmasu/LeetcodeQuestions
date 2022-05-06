class Solution {
    public String removeDuplicates(String s, int k) {
       
        Stack<MyMap> stack = new Stack<>();
        
        for (int i = 0; i < s.length(); i++) {
            if (!stack.isEmpty() && stack.peek().c == s.charAt(i)) {
                MyMap top = stack.peek();
                top.occ = top.occ + 1;
                if (top.occ == k) {
                    stack.pop();
                }
            } else {
                MyMap elt = new MyMap(s.charAt(i), 1);
                stack.push(elt);
            }

        }

        // Build the new string from the stack of maps
        StringBuilder ans = new StringBuilder();
        while (!stack.isEmpty()){
            MyMap element = stack.pop();
            for (int i = 0; i < element.occ; i++){
                ans.append(element.c);
            }
        }
        return ans.reverse().toString();
    }

}


class MyMap {
    public Character c;
    public int occ;

    public MyMap(Character character, int occurence) {
        c = character;
        occ = occurence;
    }
}