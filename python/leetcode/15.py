import unittest
from typing import List, Set, Tuple


class Solution:
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        nums.sort()
        result: Set[Tuple[int, int, int]] = set()
        for i in range(len(nums) - 2):
            if nums[i] > 0:
                break
            left = i + 1
            right = len(nums) - 1

            while left < right:
                triplet = nums[i] + nums[left] + nums[right]
                if triplet == 0:
                    result.add((nums[i], nums[left], nums[right]))

                if triplet < 0:
                    left += 1
                    continue
                right -= 1

        return [list(r) for r in result]


class SolutionTest(unittest.TestCase):
    subject = Solution()

    def test_example1(self) -> None:
        actual = self.subject.threeSum([-1, 0, 1, 2, -1, -4])
        expected = [[-1, -1, 2], [-1, 0, 1]]
        self.assertListEqual(actual, expected)

    def test_example2(self) -> None:
        actual = self.subject.threeSum([0, 1, 1])
        expected: List[int] = []
        self.assertListEqual(actual, expected)

    def test_example3(self) -> None:
        actual = self.subject.threeSum([0, 0, 0])
        expected = [[0, 0, 0]]
        self.assertListEqual(actual, expected)


if __name__ == "__main__":
    unittest.main()
