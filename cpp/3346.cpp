#include <algorithm>
#include <map>
#include <vector>

using namespace std;

class Solution {
 public:
  int maxFrequency(vector<int>& nums, int k, int numOperations) {
    if (nums.size() < 2) {
      return nums.size();
    }
    sort(nums.begin(), nums.end());

    map<int, int> counted;

    for (auto num : nums) {
      if (counted.contains(num)) {
        counted[num]++;
        continue;
      }
      counted[num] = 1;
    }

    int result = 0;

    for (int i = nums.front(); i <= nums.back(); i++) {
      auto left = leftBound(nums, i - k);
      auto right = rightBound(nums, i + k);
      result = max(result, min(right - left + 1, counted[i] + numOperations));
    }

    return result;
  }

 private:
  int leftBound(vector<int>& nums, int value) {
    int left = 0;
    int right = nums.size() - 1;

    while (left < right) {
      int mid = (left + right) / 2;
      if (nums[mid] < value) {
        left = mid + 1;
      } else {
        right = mid;
      }
    }
    return left;
  }

  int rightBound(vector<int>& nums, int value) {
    int left = 0;
    int right = nums.size() - 1;

    while (left < right) {
      int mid = (left + right + 1) / 2;
      if (nums[mid] > value) {
        right = mid - 1;
      } else {
        left = mid;
      }
    }
    return right;
  }
};