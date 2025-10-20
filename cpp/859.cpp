#include <map>
#include <set>
#include <string>
#include <vector>

using namespace std;

class Solution {
 public:
  bool buddyStrings(string s, string goal) {
    if (s.size() != goal.size()) {
      return false;
    }
    if (s == goal) {
      // We can only swap if a character appears more than once
      set<char> seen;
      for (auto& c : s) {
        if (seen.count(c)) {
          return true;
        }
        seen.insert(c);
      }
      return false;
    }

    auto first = -1;
    auto second = -1;
    for (int i = 0; i < s.size(); i++) {
      if (s[i] != goal[i]) {
        if (first == -1) {
          first = i;
          continue;
        }
        if (second == -1) {
          second = i;
          continue;
        }
        return false;
      }
    }

    if (second == -1) {
      return false;
    }

    return s[first] == goal[second] && s[second] == goal[first];
  }
};

int main(int argc, char const* argv[]) {
  Solution s;

  s.buddyStrings("ab", "ba");
  return 0;
}
