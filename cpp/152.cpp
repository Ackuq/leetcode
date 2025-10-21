#include <iostream>
#include <map>
#include <sstream>
#include <string>
#include <vector>

using namespace std;

class Solution {
 public:
  int maxProduct(vector<int>& nums) {
    if (nums.size() == 0) return 0;

    int prodMin = nums[0], prodMax = nums[0], result = nums[0];

    for (int i = 1; i < nums.size(); i++) {
      int current = nums[i];
      int newMax = max(current, max(prodMax * current, prodMin * current));
      prodMin = min(current, min(prodMin * current, prodMax * current));
      prodMax = newMax;

      result = max(result, prodMax);
    }

    return result;
  }
};

int main() {
  Solution s;

  vector<int> nums = {-3, -1, 3,  5,  -6, -6, -1, 6, -3, -5,
                      1,  0,  -6, -5, 0,  -2, 6,  1, 0,  5};
  s.maxProduct(nums);
}