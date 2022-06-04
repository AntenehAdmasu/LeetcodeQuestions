class Solution {
    private Set<Integer> columns = new HashSet<Integer>();
    private Set<Integer> diagonal1 = new HashSet<Integer>();
    private Set<Integer> diagonal2 = new HashSet<Integer>();
    
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<List<String>>();
        dfs(res,new ArrayList<String>(), 0, n);
        return res;
    }
    private void dfs(List<List<String>> res, List<String> list, int row, int n){
        if (row == n){
            res.add(new ArrayList<String>(list));
            return;
        }
        for (int i = 0; i < n; i++){
            if (columns.contains(i) || diagonal1.contains(row + i) || diagonal2.contains(row - i)) continue;
            
            char[] charArray = new char[n];
            Arrays.fill(charArray, '.');
            charArray[i] = 'Q';
            String rowString = new String(charArray);
            
            list.add(rowString);
            columns.add(i);
            diagonal1.add(row + i);
            diagonal2.add(row - i);
            
            dfs(res, list, row + 1, n);
            
            list.remove(list.size() - 1);
            columns.remove(i);
            diagonal1.remove(row + i);
            diagonal2.remove(row - i);
        }
    }
}