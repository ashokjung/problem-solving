using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;



public class ValidSudoku
{
    public static void Main(string[] str){
         ValidSudoku validSudoku = new ValidSudoku();
         bool isValid;

        char[][] board = new char[][]{
            new char[]{'1','2','.','.','3','.','.','.','.'},
            new char[]{'4','.','.','5','.','.','.','.','.'},
            new char[]{'.','9','8','.','.','.','.','.','3'},
            new char[]{'5','.','.','.','6','.','.','.','4'},
            new char[]{'.','.','.','8','.','3','.','.','5'},
            new char[]{'7','.','.','.','2','.','.','.','6'},
            new char[]{'.','.','.','.','.','.','2','.','.'},
            new char[]{'.','.','.','4','1','9','.','.','8'},
            new char[]{'.','.','.','.','8','.','.','7','9'}
        };

          char[][] board1 = new char[][]{
            new char[]{'1','2','.','.','3','.','.','.','.'},
            new char[]{'4','.','.','5','.','.','.','.','.'},
            new char[]{'.','9','1','.','.','.','.','.','3'},
            new char[]{'5','.','.','.','6','.','.','.','4'},
            new char[]{'.','.','.','8','.','3','.','.','5'},
            new char[]{'7','.','.','.','2','.','.','.','6'},
            new char[]{'.','.','.','.','.','.','2','.','.'},
            new char[]{'.','.','.','4','1','9','.','.','8'},
            new char[]{'.','.','.','.','8','.','.','7','9'}
        };
     
         isValid = validSudoku.IsValidSudoku(board);
         Console.WriteLine("Is Valid Sudoku : " + isValid);
         isValid = validSudoku.IsValidSudoku(board1);   
         Console.WriteLine("Is Valid Sudoku : " + isValid);

    }

    public bool IsValidSudoku(char[][] board) {
        for (int row = 0; row < 9; row++) {
            HashSet<char> seen = new HashSet<char>();
            for (int i = 0; i < 9; i++) {
                if (board[row][i] == '.') continue;
                if (seen.Contains(board[row][i])) return false;
                seen.Add(board[row][i]);
            }
        }
        
        for (int col = 0; col < 9; col++) {
            HashSet<char> seen = new HashSet<char>();
            for (int i = 0; i < 9; i++) {
                if (board[i][col] == '.') continue;
                if (seen.Contains(board[i][col])) return false;
                seen.Add(board[i][col]);
            }
        }
        
        for (int square = 0; square < 9; square++) {
            HashSet<char> seen = new HashSet<char>();
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    int row = (square / 3) * 3 + i;
                    int col = (square % 3) * 3 + j;
                    if (board[row][col] == '.') continue;
                    if (seen.Contains(board[row][col])) return false;
                    seen.Add(board[row][col]);
                }
            }
        }
        
        return true;
    }
}
        

