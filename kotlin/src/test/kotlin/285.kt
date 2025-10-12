import utils.TreeNode
import kotlin.test.Test
import kotlin.test.assertEquals

class Solution285Test {
    private val subject = Solution285()

    @Test
    fun example1() {
        val root = TreeNode(2)
        root.right = TreeNode(3)

        val expected = 3
        val actual = subject.inorderSuccessor(root, root)
        assertEquals(expected, actual!!.`val`)
    }
}