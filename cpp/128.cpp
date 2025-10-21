#include <unordered_set>
#include <vector>

using namespace std;

class Solution {
 public:
  int longestConsecutive(vector<int>& nums) {
    unordered_set<int> num_set(nums.begin(), nums.end());
    unordered_set<int> seen;

    int result = 0;

    for (auto num : nums) {
      if (seen.count(num)) continue;
      seen.insert(num);
      int streak = 0;
      int i = num + 1;
      while (num_set.count(i)) {
        seen.insert(i++);
        streak++;
      }
      int i = num - 1;
      while (num_set.count(i)) {
        seen.insert(i--);
        streak++;
      }
      result = max(streak, result);
    }

    return result;
  }
};
