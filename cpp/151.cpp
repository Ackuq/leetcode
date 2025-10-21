#include <iostream>
#include <sstream>
#include <string>
#include <vector>

using namespace std;

class Solution {
 public:
  string reverseWords(string s) {
    trimSpaces(s);

    stringstream ss(s);

    string token;
    vector<string> words;

    while (getline(ss, token, ' ')) {
      trimSpaces(token);
      if (token == "") continue;
      words.push_back(token);
    }

    reverse(words.begin(), words.end());

    string result;
    for (auto& word : words) {
      result += word + " ";
    }
    result.pop_back();

    return result;
  }

 private:
  void trimSpaces(string s) {
    s.erase(0, s.find_first_not_of(' '));
    s.erase(s.find_last_not_of(' ') + 1);
  }
};

int main() {
  Solution s;

  s.reverseWords("  hello world  ");
  return 0;
}