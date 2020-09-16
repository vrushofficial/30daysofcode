package day14;

public class BurstIt {

		public int maximizeProfit(int[] b, int length) {

        int[] balloon = new int[length + 2];
        balloon[0] = balloon[length + 1] = 1;
        int[][] maxProfit = new int[length + 2][length + 2];

        for (int i = 1; i <= length; i++)
            balloon[i] = b[i - 1];

        for (int i = 1; i < length + 1; i++) {
            for (int left = 1; left < length - i + 2; left++) {
                int right = left + i - 1;
/*
              last balloon burst case
			  balloon[left-1]*balloon[last]*balloon[right+1]
              for each value from start to just before left(from left to right in this case) chose each value increasingly
*/
                for (int last = left; last < right + 1; last++) {
                    maxProfit[left][right] = Math.max(maxProfit[left][right],
							maxProfit[left][last - 1] + balloon[left - 1] * balloon[last] *maxProfit[last + 1][right]);
                }
            }
        }
        return maxProfit[1][length];
    }

    public static void main(String[] args) {
     	BurstIt burstIt= new BurstIt();
        int[] balloons = {1, 2, 3, 4, 5};
        System.out.println(burstIt.maximizeProfit(balloons, balloons.length));
    }
} 
