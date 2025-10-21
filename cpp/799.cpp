#include <vector>

using namespace std;

class Solution {
 public:
  double champagneTower(int poured, int query_row, int query_glass) {
    vector<double> current = {(double)poured};

    for (int y = 1; y <= query_row; y++) {
      vector<double> nextRow(y + 1);
      for (int x = 0; x < y; x++) {
        auto val = (current[x] - 1.0) / 2.0;
        if (val > 0) {
          nextRow[x] += val;
          nextRow[x + 1] += val;
        }
      }
      current = nextRow;
    }

    return min(1.0, current[query_glass]);
  }
};

int main() {
  Solution s;

  s.champagneTower(1, 1, 1);
}