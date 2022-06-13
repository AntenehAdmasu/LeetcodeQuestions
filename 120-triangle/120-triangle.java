class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
          for (int i = triangle.size() - 2; i >= 0; i--) {
            for (int j = 0; j < triangle.get(i).size() ; j++) {
                int temp = triangle.get(i).get(j);
                int minBelow = Math.min(triangle.get(i+1).get(j),triangle.get(i+1).get(j+1));
                triangle.get(i).remove(j);
                triangle.get(i).add(j,minBelow + temp);
            }
        }
        return triangle.get(0).get(0);   
    }
}