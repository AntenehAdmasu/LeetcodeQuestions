class Solution {
    public int countSubstrings(String s) {
        var n = s.length();
        var dp = new boolean[n][n];
        for (var i = 0; i < n; i++)
            dp[i][i] = true;

        var count = n;
        for (var i = 0; i + 1 < n; i++){
            if (s.charAt(i) == s.charAt(i + 1)) {
                dp[i][i + 1] = true;
                count++;
            }
        }

        for (var len = 2; len < n; len++){
            for (var i = 0; i + len < n; i++) {
                var j = i + len; // end index
                if ((s.charAt(i) == s.charAt(j)) && dp[i + 1][j - 1]) {
                    dp[i][j] = true;
                    count++;
                }
            }
        } 
        return count;
    }
}