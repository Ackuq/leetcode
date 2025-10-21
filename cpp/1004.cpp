#include <map>
#include <vector>

using namespace std;

class Solution {
 public:
  int longestOnes(vector<int>& nums, int k) {
    int zeroes = 0, start = 0, res = 0;

    for (int end = 0; end < nums.size(); end++) {
      if (nums[end] == 0) {
        zeroes++;
      }
      while (zeroes > k) {
        if (nums[start] == 0) {
          zeroes--;
        }
        start++;
      }

      res = max(res, end - start + 1);
    }

    return res;
  }
};
