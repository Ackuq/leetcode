import unittest
from typing import List

MAP = {"]": "[", ")": "(", "}": "{"}


class Solution:
    def isValid(self, s: str) -> bool:
        stack: List[str] = []

        for c in s:
            if c in MAP:
                if len(stack) == 0:
                    return False
                head = stack.pop()
                if MAP[c] != head:
                    return False
                continue
            stack.append(c)
        return len(stack) == 0


class SolutionTest(unittest.TestCase):
    subject = Solution()

    def test_example1(self) -> None:
        actual = self.subject.isValid("()")
        expected = True
        self.assertEqual(actual, expected)

    def test_example2(self) -> None:
        actual = self.subject.isValid("()[]{}")
        expected = True
        self.assertEqual(actual, expected)

    def test_example3(self) -> None:
        actual = self.subject.isValid("(]")
        expected = False
        self.assertEqual(actual, expected)


if __name__ == "__main__":
    unittest.main()
