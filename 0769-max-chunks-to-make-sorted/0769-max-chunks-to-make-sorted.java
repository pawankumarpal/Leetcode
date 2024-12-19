class Solution {
    public int maxChunksToSorted(int[] arr) {
                int n = arr.length;
        int[] sortedArr = arr.clone();
        Arrays.sort(sortedArr);

        // Maps to track frequency of elements in original and sorted arrays
        Map<Integer, Integer> freqOriginal = new HashMap<>();
        Map<Integer, Integer> freqSorted = new HashMap<>();

        int chunks = 0;

        for (int i = 0; i < n; i++) {
            // Update frequency in original array
            freqOriginal.put(arr[i], freqOriginal.getOrDefault(arr[i], 0) + 1);

            // Update frequency in sorted array
            freqSorted.put(sortedArr[i], freqSorted.getOrDefault(sortedArr[i], 0) + 1);

            // If the two maps are equal, we found a valid chunk
            if (freqOriginal.equals(freqSorted)) {
                chunks++;
            }
        }

        return chunks;
        /**
		int chunks=0;
		int max=0;
		
		for(int i=0;i<arr.length;i++) {
			max=Math.max(max,arr[i]);
			if(max==i) {
				chunks++;
			}
		}
        return chunks;*/
    }
}