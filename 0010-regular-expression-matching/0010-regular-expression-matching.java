class Solution {
public boolean isMatch(String s, String p) {
        // Create a DP table
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];

        // Base case: empty string matches with empty pattern
        dp[0][0] = true;

        // Handle patterns with '*'
        for (int j = 1; j <= p.length(); j++) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 2]; // '*' can eliminate the preceding element
            }
        }

        // Fill the DP table
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= p.length(); j++) {
                if (p.charAt(j - 1) == '.' || p.charAt(j - 1) == s.charAt(i - 1)) {
                    // Characters match, carry forward the result
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (p.charAt(j - 1) == '*') {
                    // '*' can represent zero or more of the preceding character
                    dp[i][j] = dp[i][j - 2] || (dp[i - 1][j] && 
                              (s.charAt(i - 1) == p.charAt(j - 2) || 
                              p.charAt(j - 2) == '.'));
                }
            }
        }
        return dp[s.length()][p.length()];
    }
}