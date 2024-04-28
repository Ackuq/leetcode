package solutions

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func isSymmetricBranch(left *TreeNode, right *TreeNode) bool {
	if left == nil && right == nil {
		return true
	}
	if left == nil || right == nil {
		return false
	}
	if left.Val != right.Val {
		return false
	}
	return isSymmetricBranch(left.Left, right.Right) && isSymmetricBranch(left.Right, right.Left)

}

func isSymmetric(root *TreeNode) bool {
	return isSymmetricBranch(root.Left, root.Right)
}
