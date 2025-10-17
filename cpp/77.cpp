#include <set>
#include <vector>
using namespace std;

class Solution {
 public:
  vector<vector<int>> combine(int n, int k) {
    this->k = k;
    this->n = n;
    vector<vector<int>> result;
    vector<int> curr;
    combineRec(curr, 1, result);
    return result;
  }

 private:
  int n;
  int k;
  void combineRec(vector<int>& curr, int beginning, vector<vector<int>>& res) {
    if (curr.size() == k) {
      res.push_back(curr);
      return;
    }

    int need = k - curr.size();
    int remaining = n - beginning + 1;
    int available = remaining - need;

    for (int num = beginning; num <= beginning + available; num++) {
      curr.push_back(num);
      combineRec(curr, num + 1, res);
      curr.pop_back();
    }
  }
};