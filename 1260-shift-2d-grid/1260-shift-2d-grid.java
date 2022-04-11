class Solution {
    // UA
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length; 
        int start = m * n - k % (m * n);
        LinkedList<List<Integer>> ans = new LinkedList<>();
        for (int i = start; i < m * n + start; ++i) {
            int j = i % (m * n);
            int r = j / n;
            int c = j % n;
            if ((i - start) % n == 0){
                ans.add(new ArrayList<>());
            }
            ans.peekLast().add(grid[r][c]);
        }
        return ans;
    }
}