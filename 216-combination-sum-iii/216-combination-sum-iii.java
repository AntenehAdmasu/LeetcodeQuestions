class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        collectSet(new ArrayList<Integer>(), k, n, 1, result);
        return result;
    }
    
    public void collectSet(List<Integer> collected, int k, int remaining, int start, List<List<Integer>> result) {
        if(collected.size() == k && remaining == 0){
            List<Integer> ans = new ArrayList<Integer>(collected);
            result.add(ans);
            return;
        }

        for(int i = start; i <= 9; i++){
            collected.add(i);
            collectSet(collected, k, remaining - i, i + 1, result);
            collected.remove(collected.size() - 1);
        }
    }
}