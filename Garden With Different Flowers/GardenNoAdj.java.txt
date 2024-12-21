package matrix;

import java.util.ArrayList;
import java.util.List;
/**
You have n gardens, labeled from 1 to n, and an array paths where paths[i] = [xi, yi] describes a bidirectional path between garden xi to garden yi. In each garden, you want to plant one of 4 types of flowers.
All gardens have at most 3 paths coming into or leaving it.
Your task is to choose a flower type for each garden such that, for any two gardens connected by a path, they have different types of flowers.
Return any such a choice as an array answer, where answer[i] is the type of flower planted in the (i+1)th garden. 
The flower types are denoted 1, 2, 3, or 4. It is guaranteed an answer exists.*/

public class GardenNoAdj {
    public int[] gardenNoAdj(int n, int[][] paths) {
        // Step 1: Build adjacency list
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] path : paths) {
            graph.get(path[0] - 1).add(path[1] - 1);
            graph.get(path[1] - 1).add(path[0] - 1);
        }

        // Step 2: Initialize result array
        int[] result = new int[n];

        // Step 3: Assign flowers to each garden
        for (int garden = 0; garden < n; garden++) {
            boolean[] used = new boolean[5]; // Tracks flower types used by neighbors

            // Mark neighbors' flower types as used
            for (int neighbor : graph.get(garden)) {
                if (result[neighbor] != 0) {
                    used[result[neighbor]] = true;
                }
            }

            // Assign the first available flower type
            for (int flower = 1; flower <= 4; flower++) {
                if (!used[flower]) {
                    result[garden] = flower;
                    break;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        GardenNoAdj solver = new GardenNoAdj();

        // Example 1
        int n1 = 3;
        int[][] paths1 = {{1, 2}, {2, 3}, {3, 1}};
        int[] result1 = solver.gardenNoAdj(n1, paths1);
        System.out.println("Output for Example 1: ");
        for (int flower : result1) {
            System.out.print(flower + " ");
        }
        System.out.println();

        // Example 2
        int n2 = 4;
        int[][] paths2 = {{1, 2}, {3, 4}};
        int[] result2 = solver.gardenNoAdj(n2, paths2);
        System.out.println("Output for Example 2: ");
        for (int flower : result2) {
            System.out.print(flower + " ");
        }
        System.out.println();
    }
}
