#include <map>
#include <vector>

using namespace std;

class Solution {
 public:
  vector<int> partitionLabels(string s) {
    map<char, int> lastOccurrences;
    for (int i = 0; i < s.size(); i++) {
      lastOccurrences[s[i]] = i;
    }

    int start = 0, end = 0;
    vector<int> result;
    for (int i = 0; i < s.size(); i++) {
      end = max(end, lastOccurrences[s[i]]);
      if (i == end) {
        result.push_back(end - start);
        start = i + 1;
      }
    }
    return result;
  }
};

int main() {
  Solution s;

  s.partitionLabels("ababcbacadefegdehijhklij");
}