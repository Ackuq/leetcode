package solutions

func levelOrderDepth(node *TreeNode, level int, acc *[][]int) {
	if node == nil {
		return
	}
	if len(*acc) == level {
		*acc = append(*acc, []int{})
	}
	(*acc)[level] = append((*acc)[level], node.Val)
	levelOrderDepth(node.Left, level+1, acc)
	levelOrderDepth(node.Right, level+1, acc)
}

func levelOrder(root *TreeNode) [][]int {
	if root == nil {
		return [][]int{}
	}
	result := [][]int{{root.Val}}

	levelOrderDepth(root.Left, 1, &result)
	levelOrderDepth(root.Right, 1, &result)
	return result
}
