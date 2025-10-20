#include <string>
#include <vector>

using namespace std;

class Solution {
public:
  int maxDistinctElements(vector<int> &nums, int k) {
    sort(nums.begin(), nums.end());
    int count = 0;
    int prev = INT_MIN;
    for (auto num: nums) {
      auto curr = min(
        max(num - k, prev + 1),
        num + k
      );
      if (curr > prev) {
        prev = curr;
        count++;
      }
    }

    return count;
  }
};

int main() {
  auto s = Solution();
  vector<int> nums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
  s.maxDistinctElements(nums, 10);
  return 0;
}
