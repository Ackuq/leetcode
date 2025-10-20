#include <string>
#include <vector>

using namespace std;

class Solution {
 public:
  int finalValueAfterOperations(vector<string>& operations) {
    int x = 0;

    for (const auto& op : operations) {
      if (op == "X++" || op == "++X") {
        x++;
      } else {
        x--;
      }
    }
    return x;
  }
};
