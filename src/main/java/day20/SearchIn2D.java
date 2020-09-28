package day20;

public class SearchIn2D {

    public boolean searchMatrix(int[][] matrix, int target) {
        int l=matrix.length-1;
        int w=matrix[0].length-1;
        int i=l;
        int j=0;

        while(i>=0 && j<=w){
            if(target < matrix[i][j]){
                i--;
            }else if(target > matrix[i][j]){
                j++;
            }else{
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix= {
                {1, 4,  7, 11, 15},
                {2, 5,  8, 12, 19},
                {3, 6,  9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}};
        System.out.println(new SearchIn2D().searchMatrix(matrix,5));
    }
}
