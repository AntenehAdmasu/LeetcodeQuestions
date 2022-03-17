class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        

//        int poppedPointer = 0;
        int pushedPointer = 0;
        boolean nextX = false;
        boolean found = true;
        Stack<Integer> stack = new Stack<>();
        for (int x: popped) {
            if(!stack.empty() && stack.peek() == x){
                stack.pop();
                continue;
            }else{
                while (pushedPointer < pushed.length){

                    stack.push(pushed[pushedPointer]);
                    if(stack.peek() == x) {
                        stack.pop();
                        nextX = true;
                        pushedPointer++;
                        break;
                    }
                    pushedPointer++;
                }

                if(nextX){
                    nextX = false;
                    continue;
                }
                while (!stack.empty()){
                    int top = stack.pop();
                    if(top == x){
                        found = true;
                        break;
                    }
                }
                if (found){
                    found = false;
                    continue;
                }
                return false;

            }
        }
        return true;
    }
}