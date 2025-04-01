import unittest
from typing import List


class Solution:
    def mostPoints(self, questions: List[List[int]]) -> int:
        max_points = [0] * len(questions)

        for i in range(len(questions) - 1, -1, -1):
            points, brain_power = questions[i]
            next_i = i + brain_power + 1
            take_max = max_points[next_i] if next_i < len(questions) else 0
            skip_max = max_points[i + 1] if i < len(questions) - 1 else 0
            max_points[i] = max(take_max + points, skip_max)

        return max(max_points)


class SolutionTest(unittest.TestCase):
    subject = Solution()

    def test_example1(self) -> None:
        actual = self.subject.mostPoints([[3, 2], [4, 3], [4, 4], [2, 5]])
        expected = 5
        self.assertEqual(actual, expected)

    def test_example2(self) -> None:
        actual = self.subject.mostPoints(
            [[21, 5], [92, 3], [74, 2], [39, 4], [58, 2], [5, 5], [49, 4], [65, 3]]
        )
        expected = 157
        self.assertEqual(actual, expected)


if __name__ == "__main__":
    unittest.main()
