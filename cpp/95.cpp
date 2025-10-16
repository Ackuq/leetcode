#include <map>
#include <vector>

#include "./treenode.cpp"

using namespace std;

class Solution {
 public:
  vector<TreeNode*> generateTrees(int n) {
    map<pair<int, int>, vector<TreeNode*>> cache;
    return generateSubTrees(1, n, cache);
  }

 private:
  vector<TreeNode*> generateSubTrees(
      int start, int end, map<pair<int, int>, vector<TreeNode*>> cache) {
    vector<TreeNode*> res;
    if (start > end) {
      res.push_back(nullptr);
      return res;
    }
    auto key = make_pair(start, end);
    if (cache.find(key) != cache.end()) {
      return cache[key];
    }

    for (int i = start; i <= end; i++) {
      auto leftSubTrees = generateSubTrees(start, i - 1, cache);
      auto rightSubTrees = generateSubTrees(i + 1, end, cache);
      for (const auto& lst : leftSubTrees) {
        for (const auto& rst : rightSubTrees) {
          TreeNode* root = new TreeNode(i, lst, rst);
          res.push_back(root);
        }
      }
    }
    cache[key] = res;
    return res;
  }
};