import utils.ListNode

class Solution2 {
    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        val head = ListNode()
        var node1 = l1
        var node2 = l2
        var curr = head
        var carry = 0
        while (node1 != null || node2 != null) {
            val x = node1?.`val` ?: 0
            val y = node2?.`val` ?: 0
            val sum = carry + x + y
            carry = sum / 10
            curr.next = ListNode(sum % 10)
            curr = curr.next!!
            if (node1 != null) node1 = node1.next
            if (node2 != null) node2 = node2.next
        }
        if (carry > 0) {
            curr.next = ListNode(carry)
        }
        return head.next
    }
}