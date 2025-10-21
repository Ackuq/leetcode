#include <map>
#include <vector>

#include "./treenode.cpp"

using namespace std;

class Solution {
 public:
  vector<int> plusOne(vector<int>& digits) {
    int carry = 1;
    int i = digits.size() - 1;
    while (carry) {
      if (i == -1) {
        digits.insert(digits.begin(), carry);
        break;
      }
      int current = carry + digits[i];
      carry = current / 10;
      digits[i] = current % 10;
      i--;
    }

    return digits;
  }
};