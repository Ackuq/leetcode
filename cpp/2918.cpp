#include <vector>

using namespace std;

class Solution {
 public:
  long long minSum(vector<int>& nums1, vector<int>& nums2) {
    long long sum1 = 0, sum2 = 0;
    int zeroes1 = 0, zeroes2 = 0;
    for (auto n : nums1) {
      sum1 += n;
      if (n == 0) {
        sum1++;
        zeroes1++;
      }
    }
    for (auto n : nums2) {
      sum2 += n;
      if (n == 0) {
        sum2++;
        zeroes2++;
      }
    }

    if (zeroes1 == 0 && sum2 > sum1 || zeroes2 == 0 && sum1 > sum2) {
      return -1;
    }

    return max(sum1, sum2);
  }
};