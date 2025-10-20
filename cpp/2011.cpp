#include <vector>
#include <string>

using namespace std;

class Solution {
public:
  int finalValueAfterOperations(vector<string> &operations) {
    int x = 0;

    for (const auto &op: operations) {
      if (op.contains("++")) {
        x++;
      } else if (op.contains("--")) {
        x--;
      }
    }
    return x;
  }
};
