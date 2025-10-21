#include <iostream>

using namespace std;

class Solution {
 public:
  int hammingWeight(int n) {
    int count = 0;
    int i = 0;
    while (n > 0) {
      if (n & 1) count++;
      n >>= 1;
    }
    return count;
  }
};

int main(int argc, char const* argv[]) {
  Solution s;

  cout << s.hammingWeight(2147483645) << endl;

  return 0;
}
