class Solution {
    public boolean[] isArraySpecial(int[] nums, int[][] queries){
          int n = nums.length;

        // Step 1: Precompute alternation status for adjacent elements
        boolean[] isAlternating = new boolean[n - 1];
        for (int i = 0; i < n - 1; i++) {
            isAlternating[i] = (nums[i] % 2 != nums[i + 1] % 2);
        }

        // Step 2: Precompute prefix sums for alternation
        int[] prefix = new int[n];
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] + (isAlternating[i - 1] ? 1 : 0);
        }

        // Step 3: Process queries in O(1) using precomputed prefix sums
        int qLen = queries.length;
        boolean[] results = new boolean[qLen];
        for (int q = 0; q < qLen; q++) {
            int start = queries[q][0];
            int end = queries[q][1];
            // Check if the range [start, end] is fully alternating
            results[q] = (prefix[end] - prefix[start] == (end - start));
        }

        return results;
    }
}