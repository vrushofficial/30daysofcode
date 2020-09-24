package day18;

public class UniquePath {

    static int sortIt(int m, int n) {
        int[][] op= new int[m][n];

        for (int i=0;i<m;i++)
            for (int j=0;j<n;j++)
                if (i==0||j==0)
                    op[i][j]=1;
                else
                    op[i][j]=op[i][j-1]+op[i-1][j];
        return op[m-1][n-1];
    }

    public static void main(String[] args) {
        System.out.println(sortIt(7,3));
    }
}
