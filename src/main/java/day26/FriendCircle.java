package day26;

public class FriendCircle {

    public static void main(String[] args) {
        FriendCircle friendCircle = new FriendCircle();
        int[][] friends = {
                {1, 1, 1, 0, 0},
                {1, 1, 0, 0, 0},
                {0, 0, 0, 1, 0},
                {0, 1, 0, 1, 1}
        };
        System.out.println(friendCircle.countCircle(friends));
    }

    int countCircle(int[][] friends) {
        int circle = 0;
        int h = friends.length;
        int w = friends[h - 1].length;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (friends[i][j] == 1) {
                    circle++;
                    performDFS(friends, i, j, h, w);
                }
            }
        }
        return circle;
    }

    void performDFS(int[][] friends, int h, int w, int maxH, int maxW) {
        //mark as inplace visited
        friends[h][w] = -1;
        //check for upper node
        if (h - 1 >= 0 && friends[h - 1][w] == 1)
            performDFS(friends, h - 1, w, maxH, maxW);
        //check for lower node
        if (h + 1 < maxH && friends[h + 1][w] == 1)
            performDFS(friends, h + 1, w, maxH, maxW);
        //check for left node
        if (w - 1 >= 0 && friends[h][w - 1] == 1)
            performDFS(friends, h, w - 1, maxH, maxW);
        //check for right node
        if (w + 1 < maxW && friends[h][w + 1] == 1)
            performDFS(friends, h, w + 1, maxH, maxW);
    }
}