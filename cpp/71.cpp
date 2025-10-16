#include <sstream>
#include <string>
#include <vector>

using namespace std;

class Solution {
 public:
  string simplifyPath(string path) {
    vector<string> stack;

    stringstream ss(path);
    string temp;

    while (getline(ss, temp, '/')) {
      if (temp == "..") {
        if (!stack.empty()) {
          stack.pop_back();
        }
      } else if (temp != "." && !temp.empty()) {
        stack.push_back(temp);
      }
    }

    string res = "";

    for (auto s : stack) {
      res += "/" + s;
    }

    if (res.empty()) {
      return "/";
    }

    return res;
  }
};