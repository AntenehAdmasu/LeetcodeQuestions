class Solution {          
    
     public static int lastStoneWeight(int[] stones){
        PriorityQueue<Integer> heap = new PriorityQueue<>((a,b)-> b-a);
        for (int x: stones) {
            heap.add(x);
        }

        while (heap.size() > 1){
            int stone1 = heap.poll();
            int stone2 = heap.poll();
            int diff = Math.abs(stone1 - stone2);
            // If both stones don't have equal weight, the difference will be added
            if(diff > 0){
                heap.add(diff);
            }
        }
        return heap.isEmpty() ? 0 : heap.poll();
    }
}