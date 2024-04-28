package solutions

func zigzagLevelOrder(root *TreeNode) [][]int {
	if root == nil {
		return [][]int{}
	}

	queue := []*TreeNode{root}

	result := [][]int{}
	level := 0
	for len(queue) > 0 {
		levelResult := []int{}

		if level%2 == 0 {
			for _, node := range queue {
				levelResult = append(levelResult, node.Val)
			}
		} else {
			for i := len(queue) - 1; i >= 0; i-- {
				levelResult = append(levelResult, queue[i].Val)
			}
		}
		result = append(result, levelResult)
		nextQueue := []*TreeNode{}
		for _, node := range queue {
			if node.Left != nil {
				nextQueue = append(nextQueue, node.Left)
			}
			if node.Right != nil {
				nextQueue = append(nextQueue, node.Right)
			}
		}
		queue = nextQueue
		level++
	}
	return result
}
