package utils

class ListNode (var `val`: Int = -1, var next: ListNode? = null) {
    override fun toString(): String {
        return "$`val` -> ${next.toString()}"
    }

    companion object {
        fun fromList(nodes: List<Int>): ListNode {
            val dummy = ListNode()
            nodes.reversed().forEach {
                val temp = ListNode(it)
                temp.next = dummy.next
                dummy.next = temp
            }
            return dummy.next!!
        }
    }
}