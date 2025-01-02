class SudokuValidator:
    def __init__(self, board):
        self.board = board

    def is_valid_unit(self, unit):
        unit = [i for i in unit if i != '.']
        return len(unit) == len(set(unit))

    def is_valid_row(self):
        for row in self.board:
            if not self.is_valid_unit(row):
                return False
        return True

    def is_valid_col(self):
        for col in zip(*self.board):
            if not self.is_valid_unit(col):
                return False
        return True

    def is_valid_square(self):
        for i in (0, 3, 6):
            for j in (0, 3, 6):
                square = [self.board[x][y] for x in range(i, i + 3) for y in range(j, j + 3)]
                if not self.is_valid_unit(square):
                    return False
        return True

    def is_valid_sudoku(self):
        return self.is_valid_row() and self.is_valid_col() and self.is_valid_square()


def main():
    board = [
        ["5", "3", ".", ".", "7", ".", ".", ".", "."],
        ["6", ".", ".", "1", "9", "5", ".", ".", "."],
        [".", "9", "8", ".", ".", ".", ".", "6", "."],
        ["8", ".", ".", ".", "6", ".", ".", ".", "3"],
        ["4", ".", ".", "8", ".", "3", ".", ".", "1"],
        ["7", ".", ".", ".", "2", ".", ".", ".", "6"],
        [".", "6", ".", ".", ".", ".", "2", "8", "."],
        [".", ".", ".", "4", "1", "9", ".", ".", "5"],
        [".", ".", ".", ".", "8", ".", ".", "7", "9"]
    ]

    board1 = [
        ["1","2",".",".","3",".",".",".","."],
        ["4",".",".","5",".",".",".",".","."],
        [".","9","1",".",".",".",".",".","3"],
        ["5",".",".",".","6",".",".",".","4"],
        [".",".",".","8",".","3",".",".","5"],
        ["7",".",".",".","2",".",".",".","6"],
        [".",".",".",".",".",".","2",".","."],
        [".",".",".","4","1","9",".",".","8"],
        [".",".",".",".","8",".",".","7","9"]
    ]

    validator1 = SudokuValidator(board)
    validator2 = SudokuValidator(board1)

    print(validator1.is_valid_sudoku()) 
    print(validator2.is_valid_sudoku()) 


if __name__ == "__main__":
    main()