package solutions

import "testing"

func isRowsValid(board [][]byte) bool {
	for _, row := range board {
		seen := map[byte]bool{}
		for _, cell := range row {
			if cell == '.' {
				continue
			}
			if seen[cell] {
				return false
			}
			seen[cell] = true
		}
	}
	return true
}

func isColumnsValid(board [][]byte) bool {
	for col := 0; col < 9; col++ {
		seen := map[byte]bool{}
		for row := 0; row < 9; row++ {
			cell := board[row][col]
			if cell == '.' {
				continue
			}
			if seen[cell] {
				return false
			}
			seen[cell] = true
		}
	}
	return true
}

func isBoxesValid(board [][]byte) bool {
	// There are 9 boxes in the grid, we identify them by x and y
	for y := 0; y < 3; y++ {
		for x := 0; x < 3; x++ {
			// The start of a box is (y*3+row) (x*3+col)
			seen := map[byte]bool{}
			for col := 0; col < 3; col++ {
				for row := 0; row < 3; row++ {
					cell := board[y*3+row][x*3+col]
					if cell == '.' {
						continue
					}
					if seen[cell] {
						return false
					}
					seen[cell] = true
				}
			}

		}
	}
	return true
}

func isValidSudoku(board [][]byte) bool {
	return isRowsValid(board) && isColumnsValid(board) && isBoxesValid((board))
}

func TestValidSudoku1(t *testing.T) {
	sudoku := [][]byte{
		{'.', '.', '.', '.', '5', '.', '.', '1', '.'},
		{'.', '4', '.', '3', '.', '.', '.', '.', '.'},
		{'.', '.', '.', '.', '.', '3', '.', '.', '1'},
		{'8', '.', '.', '.', '.', '.', '.', '2', '.'},
		{'.', '.', '2', '.', '7', '.', '.', '.', '.'},
		{'.', '1', '5', '.', '.', '.', '.', '.', '.'},
		{'.', '.', '.', '.', '.', '2', '.', '.', '.'},
		{'.', '2', '.', '9', '.', '.', '.', '.', '.'},
		{'.', '.', '4', '.', '.', '.', '.', '.', '.'},
	}
	expected := false
	actual := isValidSudoku(sudoku)
	if expected != actual {
		t.Fail()
	}
}
