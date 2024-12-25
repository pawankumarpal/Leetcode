class Solution {
    public int findMaxLength(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int maxLen = 0;
        int sum = 0;

        // Add initial sum=0 at index -1 for edge cases
        map.put(0, -1);

        for (int i = 0; i < nums.length; i++) {
            // Convert 0 to -1 to handle cumulative sum
            sum += (nums[i] == 0) ? -1 : 1;

            // If this sum has been seen before, calculate subarray length
            if (map.containsKey(sum)) {
                maxLen = Math.max(maxLen, i - map.get(sum));
            } else {
                // Store the first occurrence of this sum
                map.put(sum, i);
            }
        }

        return maxLen;
    }
}