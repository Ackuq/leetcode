import utils.TreeNode

class Solution285 {
    fun inorderSuccessor(root: TreeNode?, p: TreeNode?): TreeNode? {
        if (root == null || p == null) {
            return null
        }
        if (root == p) {
            return inorderSuccessor(root.right, p)
        }
        if (root.`val` > p.`val`) {
            val leftMin = inorderSuccessor(root.left, p)
            if (leftMin != null) {
                return leftMin
            }
            return root
        }
        return inorderSuccessor(root.right, p)
    }
}