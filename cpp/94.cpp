#include <vector>

#include "./treenode.cpp"

using namespace std;

class Solution {
 public:
  vector<int> inorderTraversal(TreeNode* root) {
    vector<int> result;
    traverseRecursive(root, result);
    return result;
  }

 private:
  void traverseRecursive(TreeNode* node, vector<int>& result) {
    if (node == nullptr) {
      return;
    }
    traverseRecursive(node->left, result);
    result.push_back(node->val);
    traverseRecursive(node->right, result);
  }
};