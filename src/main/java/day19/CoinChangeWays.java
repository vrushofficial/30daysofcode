package day19;

public class CoinChangeWays {

    static int changeIt(int total, int[] coins)
    {
        int n=coins.length;
        int[][] matrix= new int[n+1][total];
    //  fill matrix
        for (int i=1;i<n;i++)
            for (int j=0;j<total-1;j++)
            {
    //  can make 0 total amount with 1 coin pf 0
                if(i==0 &&j==0) matrix[i][j]=1;
                else {
                    //case when you can not use current coin to form total
                    if (i > j)
                        matrix[i][j] = matrix[i - 1][j];
                    //case when you can use current coin to form total
                    // matrix[i][j - i](previously calculated value for same coin  and last amount- memoization)+matrix[i-1][j] (previously calulated path)
                    else
                        matrix[i][j] = matrix[i - 1][j] + matrix[i][j - i];
                }
            }
         return matrix[n-1][total-1];
    }

    public static void main(String[] args) {
        System.out.println(changeIt(5,new int[]{2,5,1}));
    }
}
