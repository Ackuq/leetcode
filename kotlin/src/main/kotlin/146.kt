class LRUCache(val capacity: Int) {
    private var dummy = Node(-1, -1)
    private var tail = dummy
    private val nodeMap = mutableMapOf<Int, Node>()

    fun get(key: Int): Int {
        val node = nodeMap[key] ?: return -1
        delete(node)
        append(node)
        return node.value
    }

    fun put(key: Int, value: Int) {
        if (key in nodeMap) {
            delete(nodeMap[key]!!)
        } else if (nodeMap.size == capacity) {
            delete(dummy.next!!)
        }

        append(Node(key, value))
    }

    private fun delete(node: Node) {
        node.prev?.next = node.next
        node.next?.prev = node.prev
        nodeMap -= node.key

        if (node == tail) {
            tail = node.prev!!
        }

        node.prev = null
        node.next = null
    }

    private fun append(node: Node) {
        tail.next = node
        node.prev = tail
        tail = node
        nodeMap[node.key] = node
    }

    data class Node(
        val key: Int,
        val value: Int,
        var prev: Node? = null,
        var next: Node? = null,
    )
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * var obj = LRUCache(capacity)
 * var param_1 = obj.get(key)
 * obj.put(key,value)
 */