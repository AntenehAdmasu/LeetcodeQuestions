class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        int i = 0;
        int n = heights.length;
        PriorityQueue<Integer> heap = new PriorityQueue<>((a,b)-> b-a);
        
        while(i < n-1){
            int delta = heights[i+1] - heights[i];

            // If jump is needed
            if(delta > 0){
                // If there are enough bricks
                if(bricks >= delta){
                    heap.add(delta);
                    bricks -= delta;
                }else {
                    // If we have ladders
                    if(ladders > 0){
                        ladders--;
                        // Replace ladder with most used bricks
                        if(!heap.isEmpty() && delta <= heap.peek()){
                            int replace = heap.isEmpty() ? 0 : heap.poll();
                            bricks += replace;
                            continue;
                        }
                    // If heaps or ladders can't reach the next building
                    }else{
                        return i;
                    }
                }
            }
            i++;
        }
        return i;
    }
}
