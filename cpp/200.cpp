#include <unordered_set>
#include <vector>
using namespace std;

vector<pair<int, int>> OFFSETS = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

class Solution {
 public:
  int numIslands(vector<vector<char>>& grid) {
    int m = grid.size(), n = grid[0].size();
    int res = 0;

    for (int row = 0; row < m; row++) {
      for (int col = 0; col < n; col++) {
        if (grid[row][col] == '0') {
          continue;
        }
        res++;
        bfs(grid, row, col);
      }
    }

    return res;
  }

 private:
  void bfs(vector<vector<char>>& grid, int row, int col) {
    vector<pair<int, int>> queue = {{row, col}};

    while (!queue.empty()) {
      auto curr = queue.back();
      queue.pop_back();
      grid[curr.first][curr.second] = '0';

      for (auto offset : OFFSETS) {
        int newRow = curr.first + offset.first,
            newCol = curr.second + offset.second;

        if (newRow < 0 || newRow >= grid.size() || newCol < 0 ||
            newCol >= grid[0].size() || grid[newRow][newCol] == '0') {
          continue;
        }
        queue.push_back({newRow, newCol});
      }
    }
  }
};

int main(int argc, char const* argv[]) {
  Solution s;
  vector<vector<char>> grid = {{'1', '1', '1', '1', '0'},
                               {'1', '1', '0', '1', '0'},
                               {'1', '1', '0', '0', '0'},
                               {'0', '0', '0', '0', '0'}};
  s.numIslands(grid);
  return 0;
}
