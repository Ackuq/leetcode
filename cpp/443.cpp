#include <unordered_map>
#include <vector>

using namespace std;

class Solution {
 public:
  int compress(vector<char>& chars) {
    if (chars.size() == 0) {
      return 0;
    }
    int j = 0;

    int prev = chars[0];
    int prevCount = 1;

    auto mutateArray = [&]() {
      if (prevCount == 1) {
        chars[j++] = prev;
      } else {
        chars[j++] = prev;
        string numStr = to_string(prevCount);
        for (auto c : numStr) {
          chars[j++] = c;
        }
      }
    };

    for (int i = 1; i < chars.size(); i++) {
      if (chars[i] != prev) {
        mutateArray();
        prev = chars[i];
        prevCount = 1;
      } else {
        prevCount++;
      }
    }
    mutateArray();

    return j;
  }
};
