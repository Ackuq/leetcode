#include <algorithm>
#include <string>
#include <vector>

using namespace std;

class Solution {
 public:
  vector<vector<int>> diagonalSort(vector<vector<int>>& mat) {
    if (mat.size() == 0) {
      return {};
    }
    for (int y = 0; y < mat.size(); y++) {
      diagonalSortInner(mat, pair(y, 0));
    }
    for (int x = 1; x < mat[0].size(); x++) {
      diagonalSortInner(mat, pair(0, x));
    }
    return mat;
  }

 private:
  void diagonalSortInner(vector<vector<int>>& mat, pair<int, int> start) {
    vector<int> sorted = {};
    for (int i = 0;
         i + start.first < mat.size() && i + start.second < mat[0].size();
         i++) {
      sorted.push_back(mat[start.first + i][start.second + i]);
    }

    sort(sorted.begin(), sorted.end());

    for (int i = 0;
         i + start.first < mat.size() && i + start.second < mat[0].size();
         i++) {
      mat[start.first + i][start.second + i] = sorted[i];
    }
  }
};