class Solution {
    public int scheduleCourse(int[][] courses) {
        // Sort by end date
        Arrays.sort(courses,(a,b)->a[1]-b[1]);
        // Construct a max heap
        PriorityQueue<Integer> heap = new PriorityQueue<>((a,b)->b-a);
        int timeElapsed = 0;
        for (int[] course : courses) {
            // add current course and increment timeElapsed
            timeElapsed += course[0]; 
            heap.add(course[0]);
            // If timeElapsed exceeds this one's deadline, drop the course with the longest duration 
            if (timeElapsed > course[1]){
                timeElapsed -= heap.poll();
            }
        }        
        return heap.size();
    }
}