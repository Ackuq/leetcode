
#include <unordered_set>
#include <vector>

using namespace std;

class Solution {
 public:
  bool containsDuplicate(vector<int>& nums) {
    unordered_set<int> seen;
    for (auto num : nums) {
      if (seen.contains(num)) {
        return true;
      }
      seen.insert(num);
    }

    return false;
  }
};