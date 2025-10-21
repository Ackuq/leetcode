
#include <algorithm>
#include <vector>

#include "./treenode.cpp"

using namespace std;

class Solution {
 public:
  int findDistance(TreeNode* root, int p, int q) {
    // Find LCA and the p - lca + q - lca
    vector<TreeNode*> pPath, qPath;
    findPath(root, p, &pPath);
    findPath(root, q, &qPath);
    reverse(pPath.begin(), pPath.end());
    reverse(qPath.begin(), qPath.end());
    int i = 0;

    while (i < qPath.size() && i < pPath.size() && qPath[i] == pPath[i]) {
      i++;
    }

    return (qPath.size() - i) + (pPath.size() - i);
  }

 private:
  bool findPath(TreeNode* curr, int goal, vector<TreeNode*>* result) {
    if (curr == nullptr) {
      return false;
    }

    if (curr->val == goal) {
      result->push_back(curr);
      return true;
    }

    if (findPath(curr->left, goal, result)) {
      result->push_back(curr);
      return true;
    }
    if (findPath(curr->right, goal, result)) {
      result->push_back(curr);
      return true;
    }
    return false;
  }
};