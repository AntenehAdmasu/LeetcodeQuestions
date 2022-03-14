class Solution {
    public double champagneTower(int poured, int query_row, int query_glass) {
        // We only need two arrays to keep track of the previous row
        double[] prev = new double[query_row+1];
        double[] current = new double[query_row+1];
        prev[0] = poured;
        current[0] = poured; // Will be overriden if row > 1 but if the input has only 1 row this will handle it

        for(int i = 1; i <= query_row; i++){
            for(int j = 0; j <= i; j++){
                // Getting the extra pours from the upper row
                // Math.max because it doesn't pour if the cup is not full
                double left = j == 0 ? 0 : Math.max(0, (prev[j-1] - 1) / 2); 
                double right = j >= i ? 0 : Math.max(0, (prev[j] - 1) / 2);
                current[j] = left + right;
            }

            prev = Arrays.copyOf(current, current.length);
        }
        // Math.min because the cup can hold 1 max even if there's an overflow
        return Math.min(1, current[query_glass]);
    }
}