package day12;

public class NumberOfIsland {

    public static void main(String[] args) {
        NumberOfIsland numberOfIsland = new NumberOfIsland();
        int[][] island = {
                {1, 1, 0, 0, 0},
                {1, 1, 0, 0, 0},
                {0, 0, 1, 0, 0},
                {0, 0, 0, 1, 1}
        };
        System.out.println(numberOfIsland.getIsland(island));
    }

    int getIsland(int[][] allLand) {
        int island = 0;
        int h = allLand.length;
        int w = allLand[h - 1].length;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (allLand[i][j] == 1) {
                    island++;
                    performDFS(allLand, i, j, h, w);
                }
            }
        }
        return island;
    }

    void performDFS(int[][] allLand, int h, int w, int maxH, int maxW) {
        allLand[h][w] = -1;
        //check for upper node
        if (h - 1 >= 0 && allLand[h - 1][w] == 1)
            performDFS(allLand, h - 1, w, maxH, maxW);
        //check for lower node
        if (h + 1 < maxH && allLand[h + 1][w] == 1)
            performDFS(allLand, h + 1, w, maxH, maxW);
        //check for left node
        if (w - 1 >= 0 && allLand[h][w - 1] == 1)
            performDFS(allLand, h, w - 1, maxH, maxW);
        //check for right node
        if (w + 1 < maxW && allLand[h][w + 1] == 1)
            performDFS(allLand, h, w + 1, maxH, maxW);
    }
}