#include <iostream>
#include <vector>
using namespace std;

class Solution {
 public:
  int climbStairs(int n) {
    vector<int> memo(n + 1, 0);
    return calculate(n, memo);
  }

 private:
  int calculate(int i, vector<int>& memo) {
    if (i < 0) {
      return 0;
    }
    if (i == 0) {
      return 1;
    }
    if (memo[i] > 0) {
      return memo[i];
    }
    memo[i] = calculate(i - 1, memo) + calculate(i - 2, memo);
    return memo[i];
  }
};
