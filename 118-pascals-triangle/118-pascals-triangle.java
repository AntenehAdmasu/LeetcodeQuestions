class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(Arrays.asList(1));
        for(int i = 1; i < numRows; i++){
            List<Integer> prevRow = result.get(result.size()-1);
            List<Integer> newRow = new ArrayList<>();
            for(int index = 0; index < prevRow.size()+1; index++){
                int left = index == 0 ? 0 : prevRow.get(index-1);
                int right = index == prevRow.size() ? 0 : prevRow.get(index);
                newRow.add(left+right);
            }
            result.add(newRow);
        }
        return result;
    }
}