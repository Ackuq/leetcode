#include <algorithm>
#include <vector>

#include "./treenode.cpp"

using namespace std;

class Solution {
 public:
  TreeNode* lowestCommonAncestor(TreeNode* root, TreeNode* p, TreeNode* q) {
    vector<TreeNode*> pPath, qPath;
    findPath(root, p, &pPath);
    findPath(root, q, &qPath);
    reverse(pPath.begin(), pPath.end());
    reverse(qPath.begin(), qPath.end());
    int i = 0;

    while (i < qPath.size() && i < pPath.size() && qPath[i] == pPath[i]) {
      i++;
    }

    return qPath[i - 1];
  }

 private:
  bool findPath(TreeNode* curr, TreeNode* goal, vector<TreeNode*>* result) {
    if (curr == nullptr) {
      return false;
    }

    if (curr->val == goal->val) {
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