#include <iostream>
#include <map>
#include <vector>

using namespace std;

class Solution {
 public:
  vector<vector<string>> groupAnagrams(vector<string>& strs) {
    map<string, vector<string>> anagrams;
    for (auto& s : strs) {
      auto sortedString = s;
      sort(sortedString.begin(), sortedString.end());

      if (anagrams.find(sortedString) == anagrams.end()) {
        anagrams[sortedString] = {s};
        continue;
      }
      anagrams[sortedString].push_back(s);
    }
    vector<vector<string>> result;
    for (auto& anagram : anagrams) {
      result.push_back(anagram.second);
    }
    return result;
  }
};

int main() {
  Solution s;
  vector<string> strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
  auto result = s.groupAnagrams(strs);
}