import java.util.Arrays;

// BinaryIndexedTree class for range queries and updates
class BinaryIndexedTree {
    // A large number representing `infinity`
    private static final int INFINITY = 1 << 30;
    // The size of the tree
    private int size;
    // Internal storage of the Binary Indexed Tree
    private int[] tree;

    // BinaryIndexedTree constructor
    public BinaryIndexedTree(int size) {
        this.size = size;
        // Initialize the internal storage with 'infinity' values
        tree = new int[size + 1];
        Arrays.fill(tree, INFINITY);
    }

    // Update the tree with value 'v' at the index 'x'
    public void update(int x, int v) {
        while (x <= size) {
            tree[x] = Math.min(tree[x], v);
            // Move to the next index to update
            x += x & -x;
        }
    }

    // Query the tree for the minimum value until index 'x'
    public int query(int x) {
        int minimum = INFINITY;
        while (x > 0) {
            minimum = Math.min(minimum, tree[x]);
            // Move to the previous index to query
            x -= x & -x;
        }
        // If the minimum is INFINITY, return -1, as it implies no update was made
        return minimum == INFINITY ? -1 : minimum;
    }
}

class Solution {
    // Process leftmost building queries
    public int[] leftmostBuildingQueries(int[] heights, int[][] queries) {
        int buildingsLength = heights.length;
        int queriesLength = queries.length;
      
        // Ensure the start of the range is less than the end of the range
        for (int i = 0; i < queriesLength; ++i) {
            if (queries[i][0] > queries[i][1]) {
                queries[i] = new int[] {queries[i][1], queries[i][0]};
            }
        }
      
        // Array of query indices for sorting
        Integer[] indices = new Integer[queriesLength];
        for (int i = 0; i < queriesLength; ++i) {
            indices[i] = i;
        }
      
        // Sort query indices based on the right bound of queries in descending order
        Arrays.sort(indices, (i, j) -> queries[j][1] - queries[i][1]);
      
        // Copy and sort building heights
        int[] sortedHeights = heights.clone();
        Arrays.sort(sortedHeights);
      
        // Initialize result array
        int[] results = new int[queriesLength];
      
        // Initialize Binary Indexed Tree
        BinaryIndexedTree tree = new BinaryIndexedTree(buildingsLength);
      
        // Iterator from right to left on buildings
        int j = buildingsLength - 1;
      
        // Process queries based on sorted indices
        for (int index : indices) {
            int leftBound = queries[index][0], rightBound = queries[index][1];
            // Updating tree
            while (j > rightBound) {
                // Find position in sorted array for the height of building 'j'
                int position = buildingsLength - Arrays.binarySearch(sortedHeights, heights[j]) + 1;
                // Update the tree at position with building index 'j'
                tree.update(position, j);
                --j;
            }
            // Check for direct visibility or use the Binary Indexed Tree to find leftmost building
            if (leftBound == rightBound || heights[leftBound] < heights[rightBound]) {
                results[index] = rightBound;
            } else {
                int k = buildingsLength - Arrays.binarySearch(sortedHeights, heights[leftBound]);
                results[index] = tree.query(k);
            }
        }
        return results;
    }
}