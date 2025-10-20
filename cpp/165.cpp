#include <sstream>
#include <string>
#include <vector>

using namespace std;

class Solution {
 public:
  int compareVersion(string version1, string version2) {
    istringstream ss1(version1), ss2(version2);
    vector<int> result1, result2;
    string token;

    while (true) {
      auto& read1 = getline(ss1, token, '.');
      int val1 = read1 ? stoi(token) : 0;
      auto& read2 = getline(ss2, token, '.');
      int val2 = read2 ? stoi(token) : 0;
      if (!read1 && !read2) {
        return 0;
      }
      if (val1 == val2) {
        continue;
      }

      return val1 > val2 ? 1 : -1;
    }
  }
};

int main(int argc, char const* argv[]) {
  Solution s;

  s.compareVersion("1.2", "1.10");

  return 0;
}
