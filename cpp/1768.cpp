#include <string>

using namespace std;

class Solution {
 public:
  string mergeAlternately(string word1, string word2) {
    int x = 0, y = 0;
    string res = "";
    while (x < word1.size() || y < word1.size()) {
      if (x < word1.size()) res += word1[x++];
      if (y < word2.size()) res += word2[y++];
    }
    return res;
  }
};

int main() {
  auto s = Solution();
  printf("%s\n", s.mergeAlternately("abc", "pqr").c_str());
  return 0;
}