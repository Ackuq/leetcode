#include <unordered_map>
#include <vector>

using namespace std;

class Solution {
 public:
  vector<int> findAnagrams(string s, string p) {
    if (s.size() < p.size()) {
      return {};
    }

    unordered_map<char, int> pCount;
    for (auto c : p) {
      if (!pCount.contains(c)) {
        pCount[c] = 1;
        continue;
      }
      pCount[c]++;
    }

    unordered_map<char, int> currentCount;
    for (int i = 0; i < p.size(); i++) {
      if (!currentCount.contains(s[i])) {
        currentCount[s[i]] = 1;
        continue;
      }
      currentCount[s[i]]++;
    }

    vector<int> result;
    for (int i = p.size(); i <= s.size(); i++) {
      if (currentCount == pCount) {
        result.push_back(i - p.size());
      }
      if (i == s.size()) {
        break;
      }
      auto toRemove = s[i - p.size()];
      auto toAdd = s[i];
      currentCount[toRemove]--;
      if (currentCount[toRemove] == 0) {
        currentCount.erase(toRemove);
      }
      if (!currentCount.contains(toAdd)) {
        currentCount[toAdd] = 1;
        continue;
      }
      currentCount[toAdd]++;
    }

    return result;
  }
};

int main() {
  Solution s;
  s.findAnagrams("cbaebabacd", "abc");

  return 0;
}
