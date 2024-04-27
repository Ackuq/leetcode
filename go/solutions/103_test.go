package solutions

func zigzagLevelOrder(root *TreeNode) [][]int {
	if root == nil {
		return [][]int{}
	}

	queue := []*TreeNode{root}

	result := [][]int{}
	level := 0
	for len(queue) > 0 {
		level_result := []int{}

		if level%2 == 0 {
			for _, node := range queue {
				level_result = append(level_result, node.Val)
			}
		} else {
			for i := len(queue) - 1; i >= 0; i-- {
				level_result = append(level_result, queue[i].Val)
			}
		}
		result = append(result, level_result)
		next_queue := []*TreeNode{}
		for _, node := range queue {
			if node.Left != nil {
				next_queue = append(next_queue, node.Left)
			}
			if node.Right != nil {
				next_queue = append(next_queue, node.Right)
			}
		}
		queue = next_queue
		level++
	}
	return result
}
