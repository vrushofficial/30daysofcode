package day5;

public class ValidSudoku {
    public static void main(String[] args) {
        int[][] sudoku = {
                {5, 3, 4, 6, 7, 8, 9, 1, 2},
                {6, 7, 2, 1, 9, 5, 3, 4, 8},
                {1, 9, 8, 3, 4, 2, 5, 6, 7},
                {8, 5, 9, 7, 6, 1, 4, 2, 3},
                {4, 2, 6, 8, 5, 3, 7, 9, 1},
                {7, 1, 3, 9, 2, 4, 8, 5, 6},
                {9, 6, 1, 5, 3, 7, 2, 8, 4},
                {2, 8, 7, 4, 1, 9, 6, 3, 5},
                {3, 4, 5, 2, 8, 6, 1, 7, 9}
        };

        boolean result = validate(sudoku);
        System.out.println(result);
    }

    static boolean validate(int[][] sudoku) {

        // validate row
        for (int row = 0; row < 9; row++)
            for (int col = 0; col < 8; col++)
                for (int col2 = col + 1; col2 < 9; col2++)
                    if (sudoku[row][col] == sudoku[row][col2])
                        return false;

        // validate col
        for (int col = 0; col < 9; col++)
            for (int row = 0; row < 8; row++)
                for (int row2 = row + 1; row2 < 9; row2++)
                    if (sudoku[row][col] == sudoku[row2][col])
                        return false;

        // validate 3*3 matrix
        //set starting row
        for (int row = 0; row < 9; row += 3)
            //set starting col
            for (int col = 0; col < 9; col += 3)
                //iterate through row
                for (int i = 0; i < 8; i++)
                    //iterate through col
                    for (int j = i + 1; j < 9; j++)
                        if (sudoku[row + i % 3][col + i / 3] == sudoku[row + j % 3][col + j / 3])
                            return false;

        return true;
    }

}

