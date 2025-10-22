using namespace std;

#include <algorithm>
#include <climits>

#include "treenode.h"

class Solution {
 public:
  int maxPathSum(TreeNode* root) {
    maxSum = INT_MIN;
    maxPathRec(root);
    return maxSum;
  }

 private:
  int maxSum;
  int maxPathRec(TreeNode* curr) {
    if (curr == nullptr) return 0;

    int maxFromLeft = max(maxPathRec(curr->left), 0);
    int maxFromRight = max(maxPathRec(curr->right), 0);

    maxSum = max(maxSum, curr->val + maxFromLeft + maxFromRight);

    return curr->val + max(maxFromLeft, maxFromRight);
  }
};