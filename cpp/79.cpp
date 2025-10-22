#include <iostream>
#include <map>
#include <vector>

using namespace std;

vector<pair<int, int>> OFFSETS = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

class Solution {
 public:
  bool exist(vector<vector<char>>& board, string word) {
    for (int y = 0; y < board.size(); y++) {
      for (int x = 0; x < board[y].size(); x++) {
        if (dfs(board, word, 0, y, x)) {
          return true;
        }
      }
    }
    return false;
  }

 private:
  bool dfs(vector<vector<char>>& board, string word, int index, int row,
           int column) {
    if (index == word.size()) return true;
    if (row < 0 || row >= board.size() || column < 0 ||
        column >= board[row].size() || board[row][column] != word[index]) {
      return false;
    }
    auto temp = board[row][column];
    board[row][column] = '#';

    for (auto d : OFFSETS) {
      if (dfs(board, word, index + 1, row + d.first, column + d.second)) {
        return true;
      }
    }

    board[row][column] = temp;
    return false;
  }
};
