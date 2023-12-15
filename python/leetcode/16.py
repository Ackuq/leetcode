import sys
import unittest
from typing import List


class Solution:
    def threeSumClosest(self, nums: List[int], target: int) -> int:
        nums.sort()
        closest_diff = sys.maxsize
        closest_sum = sys.maxsize

        for i in range(len(nums) - 2):
            left = i + 1
            right = len(nums) - 1

            while left < right:
                triplet = nums[i] + nums[left] + nums[right]
                diff = target - triplet
                diff_abs = abs(diff)
                if diff_abs < closest_diff:
                    closest_diff = diff_abs
                    closest_sum = triplet
                if diff > 0:
                    left += 1
                    continue
                right -= 1
        return closest_sum


class SolutionTest(unittest.TestCase):
    subject = Solution()

    def test_example1(self) -> None:
        actual = self.subject.threeSumClosest([-1, 2, 1, -4], 1)
        expected = 2
        self.assertEqual(actual, expected)

    def test_example2(self) -> None:
        actual = self.subject.threeSumClosest([0, 0, 0], 0)
        expected = 0
        self.assertEqual(actual, expected)

    def test_example3(self) -> None:
        actual = self.subject.threeSumClosest([4, 0, 5, -5, 3, 3, 0, -4, -5], -2)
        expected = -2
        self.assertEqual(actual, expected)


if __name__ == "__main__":
    unittest.main()
