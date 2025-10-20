#include <bitset>
#include <string>
#include <vector>

using namespace std;

class Solution {
 public:
  string addBinary(string a, string b) {
    int i = a.size() - 1, j = b.size() - 1, carry = 0;
    vector<char> resVec;

    while (i >= 0 || j >= 0 || carry) {
      int left = 0, right = 0;
      if (i >= 0) {
        left = a[i--] - '0';
      }
      if (j >= 0) {
        right = b[j--] - '0';
      }
      int sum = left + right + carry;
      resVec.push_back((sum % 2) + '0');
      carry = sum / 2;
    }

    reverse(resVec.begin(), resVec.end());
    return string(resVec.begin(), resVec.end());
  }
};

int main() {
  auto a =
      "101000001001001101100100000101011110110110011011101111111111010000001011"
      "11001110001111100001101";
  auto b =
      "110101001011101110001111100110001010100001101011101010000011011011001011"
      "101111001100000011011110011";
  Solution s;

  s.addBinary(a, b);
}