#include <string>

using namespace std;

class Solution {
 public:
  int strStr(string haystack, string needle) {
    if (needle.size() > haystack.size()) {
      return -1;
    }

    for (int i = 0, j = 0; i <= haystack.size() - needle.size(); i++) {
      for (j = 0; j < needle.size(); j++) {
        if (haystack[i + j] != needle[j]) {
          break;
        }
      }
      if (j == needle.size()) {
        return i;
      }
    }
    return -1;
  }
};
int main() {
  auto s = Solution();
  printf("%d\n", s.strStr("sadbutsad", "sad"));
  printf("%d\n", s.strStr("leetcode", "leeto"));
  printf("%d\n", s.strStr("a", "a"));
  printf("%d\n", s.strStr("aaa", "aaaa"));
  return 0;
}