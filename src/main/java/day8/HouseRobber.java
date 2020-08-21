package day8;

class HouseRobber {

    public static int rob(int[] nums) {
        if(nums==null||nums.length==0)
            return 0;

        if(nums.length==1)
            return nums[0];

        var dp = new int[nums.length];
        dp[0]=nums[0];
        dp[1]=Math.max(nums[0], nums[1]);

        for(int i=2; i<nums.length; i++){
            dp[i] = Math.max(dp[i-2]+nums[i], dp[i-1]);
        }

        return dp[nums.length-1];
    }

    public static void main(String[] args) {
        var a = new int[]{2, 7, 9, 1, 3};
        System.out.println(rob(a));
    }

}