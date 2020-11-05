package day29;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class MinHeightTree {

    public static void main(String[] args) {
        int[][] tree=new int[][] {{3,0},{3,1},{3,2},{3,4},{5,4}};
        new MinHeightTree().findMinHeightTrees(6,tree);
    }
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {

        if (n < 2) {
            ArrayList<Integer> centroids = new ArrayList<>();
            for (int i = 0; i < n; i++)
                centroids.add(i);
            return centroids;
        }

        ArrayList<Set<Integer>> neighbors = new ArrayList<>();
        for (int i = 0; i < n; i++)
            neighbors.add(new HashSet<Integer>());

        for (int[] edge : edges) {
            Integer start = edge[0], end = edge[1];
            neighbors.get(start).add(end);
            neighbors.get(end).add(start);
        }

        ArrayList<Integer> leaves = new ArrayList<>();
        for (int i = 0; i < n; i++)
            if (neighbors.get(i).size() == 1)
                leaves.add(i);

        int remainingNodes = n;
        while (remainingNodes > 2) {
            remainingNodes -= leaves.size();
            ArrayList<Integer> newLeaves = new ArrayList<>();

            for (Integer leaf : leaves) {
                for (Integer neighbor : neighbors.get(leaf)) {
                    neighbors.get(neighbor).remove(leaf);
                    if (neighbors.get(neighbor).size() == 1)
                        newLeaves.add(neighbor);
                }
            }

            leaves = newLeaves;
        }

         return leaves;
    }
}