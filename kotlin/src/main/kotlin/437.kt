import utils.TreeNode

class Solution437 {
    fun pathSum(root: TreeNode?, targetSum: Int, acc: List<Long> = listOf()): Int {
        if (root == null) {
            return 0
        }
        var res = 0

        val newAcc = acc.map { it + root.`val`.toLong() } + root.`val`.toLong()
        res += newAcc.count { it == targetSum.toLong() }
        res += pathSum(root.left, targetSum, newAcc)
        res += pathSum(root.right, targetSum, newAcc)

        return res
    }
}

