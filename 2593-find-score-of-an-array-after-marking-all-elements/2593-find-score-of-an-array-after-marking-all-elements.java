class Solution {
    public long findScore(int[] nums) {
                int n = nums.length;
        boolean[] marked = new boolean[n];
        long score = 0; // Use long to handle large sums

        // PriorityQueue to store elements with their index, sorted by value and index
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            Comparator.<int[]>comparingInt(a -> a[0])
                .thenComparingInt(a -> a[1])
        );

        // Add all elements with their indices to the queue
        for (int i = 0; i < n; i++) {
            pq.offer(new int[]{nums[i], i});
        }

        // Process the elements from the queue
        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int value = current[0];
            int index = current[1];

            // Skip if already marked
            if (marked[index]) continue;

            // Add the value to the score
            score += value;

            // Mark the current and adjacent elements
            marked[index] = true;
            if (index > 0) marked[index - 1] = true;
            if (index < n - 1) marked[index + 1] = true;
        }

        return score;
    }
}