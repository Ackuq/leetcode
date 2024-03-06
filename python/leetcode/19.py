import unittest
from typing import Optional


# Definition for singly-linked list.
class ListNode:
    def __init__(self, val: int = 0, next: Optional["ListNode"] = None):
        self.val = val
        self.next = next

    def __eq__(self, other: object) -> bool:
        if not isinstance(other, ListNode):
            return False
        return self.val == other.val and self.next == other.next

    def __repr__(self) -> str:
        if self.next is None:
            return f"{self.val}"
        return f"{self.val} -> {self.next}"


class Solution:
    def removeNthFromEnd(self, head: Optional[ListNode], n: int) -> Optional[ListNode]:
        dummy = ListNode(0, head)
        right = dummy
        left = dummy
        for _ in range(n + 1):
            right = right.next
        while right is not None:
            right = right.next
            left = left.next
        left.next = left.next.next
        return dummy.next


class SolutionTest(unittest.TestCase):
    subject = Solution()

    def test_example1(self) -> None:
        head = ListNode(1, ListNode(2, ListNode(3, ListNode(4, ListNode(5)))))
        actual = self.subject.removeNthFromEnd(head, 2)
        expected = ListNode(1, ListNode(2, ListNode(3, ListNode(5))))
        self.assertEqual(actual, expected)

    def test_example2(self) -> None:
        head = ListNode(1)
        actual = self.subject.removeNthFromEnd(head, 1)
        expected = None
        self.assertEqual(actual, expected)


if __name__ == "__main__":
    unittest.main()
