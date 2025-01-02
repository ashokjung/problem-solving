import java.util.HashSet;
import java.util.Set;

public class ValidSudoku{

    public static void main(String[] args){
      
        ValidSudoku solution = new ValidSudoku();
        boolean isValid;
        char[][] board = {
            {'1','2','.','.','3','.','.','.','.'},
            {'4','.','.','5','.','.','.','.','.'},
            {'.','9','8','.','.','.','.','.','3'},
            {'5','.','.','.','6','.','.','.','4'},
            {'.','.','.','8','.','3','.','.','5'},
            {'7','.','.','.','2','.','.','.','6'},
            {'.','.','.','.','.','.','2','.','.'},
            {'.','.','.','4','1','9','.','.','8'},
            {'.','.','.','.','8','.','.','7','9'}
        };

        char[][] board1 = {
            {'1','2','.','.','3','.','.','.','.'},
            {'4','.','.','5','.','.','.','.','.'},
            {'.','9','1','.','.','.','.','.','3'},
            {'5','.','.','.','6','.','.','.','4'},
            {'.','.','.','8','.','3','.','.','5'},
            {'7','.','.','.','2','.','.','.','6'},
            {'.','.','.','.','.','.','2','.','.'},
            {'.','.','.','4','1','9','.','.','8'},
            {'.','.','.','.','8','.','.','7','9'}};


        
        isValid = solution.isValidSudoku(board);
        System.out.println("Is the given sudoku valid? : "+ isValid );

        isValid = solution.isValidSudoku(board1);
        System.out.println("Is the given sudoku valid? : "+ isValid );

    }

    public boolean isValidSudoku(char[][] board) {
        
        for (int row = 0; row < 9; row++) {
            Set<Character> seen = new HashSet<>();
            for (int i = 0; i < 9; i++) {
                if (board[row][i] == '.') continue;
                if (seen.contains(board[row][i])) return false;
                seen.add(board[row][i]);
            }
        }

        for (int col = 0; col < 9; col++) {
            Set<Character> seen = new HashSet<>();
            for (int i = 0; i < 9; i++) {
                if (board[i][col] == '.') continue;
                if (seen.contains(board[i][col])) return false;
                seen.add(board[i][col]);
            }
        }


        for (int square = 0; square < 9; square++) {
                    Set<Character> seen = new HashSet<>();
                    for (int i = 0; i < 3; i++) {
                        for (int j = 0; j < 3; j++) {
                            int row = (square / 3) * 3 + i;
                            int col = (square % 3) * 3 + j;
                            if (board[row][col] == '.') continue;
                            if (seen.contains(board[row][col])) return false;
                            seen.add(board[row][col]);
                        }
                    }
                }
                
                return true;
            }
    }


