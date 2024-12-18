class Solution {
    public String repeatLimitedString(String s, int repeatLimit) {
                int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        StringBuilder result = new StringBuilder();
        // Priority Queue for lexicographical order (max-heap)
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < 26; i++) {
            if (freq[i] > 0) pq.add(i);
        }

        while (!pq.isEmpty()) {
            int current = pq.poll(); // Largest character
            char currentChar = (char) (current + 'a');
            int count = Math.min(freq[current], repeatLimit);

            // Append currentChar up to repeatLimit
            for (int i = 0; i < count; i++) {
                result.append(currentChar);
            }
            freq[current] -= count;

            // Check if there are more occurrences of the current character
            if (freq[current] > 0) {
                if (pq.isEmpty()) break; // No other characters available

                // Use the next largest character temporarily
                int next = pq.poll();
                char nextChar = (char) (next + 'a');
                result.append(nextChar);
                freq[next]--;

                // Re-add next to the queue if still available
                if (freq[next] > 0) {
                    pq.add(next);
                }
                // Re-add current to the queue for further use
                pq.add(current);
            }
        }

        return result.toString();
    }
}