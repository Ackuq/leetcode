import unittest
from collections import Counter
from typing import List


class Solution:
    def permuteUniqueRec(
        self, counter: Counter[int], acc: List[List[int]] = []
    ) -> List[List[int]]:
        if counter.total() == 0:
            return acc
        res: List[List[int]] = []
        for num in counter.keys():
            new_c = Counter(counter)
            new_c.subtract({num: 1})
            if new_c.get(num) == 0:
                del new_c[num]
            res += self.permuteUniqueRec(
                new_c, [perm + [num] for perm in acc] if len(acc) > 0 else [[num]]
            )

        return res

    def permuteUnique(self, nums: List[int]) -> List[List[int]]:
        return self.permuteUniqueRec(Counter(nums))


class SolutionTest(unittest.TestCase):
    subject = Solution()

    def test_example1(self) -> None:
        actual = self.subject.permuteUnique([1, 1, 2])
        expected = [[1, 1, 2], [1, 2, 1], [2, 1, 1]]
        self.assertListEqual(actual, expected)

    def test_example2(self) -> None:
        actual = self.subject.permuteUnique([1, 2, 3])
        expected = [[1, 2, 3], [1, 3, 2], [2, 1, 3], [2, 3, 1], [3, 1, 2], [3, 2, 1]]
        self.assertListEqual(actual, expected)
