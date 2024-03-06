import unittest
from collections import Counter
from typing import List, Set, Tuple, cast


class Solution:
    def fourSum(self, nums: List[int], target: int) -> List[List[int]]:
        seen: Set[
            Tuple[
                int,
                int,
                int,
                int,
            ]
        ] = set()

        def recursive(
            a: int,
            b: int,
            c: int,
            d: int,
        ) -> Set[Tuple[int, int, int, int]]:
            quadruplet = (a, b, c, d)
            if quadruplet in seen:
                return set()
            seen.add(quadruplet)

            if a == b or b == c or c == d:
                return set()

            quad_nums = cast(
                Tuple[int, int, int, int], tuple(nums[i] for i in quadruplet)
            )
            quad_sum = sum(quad_nums)
            if quad_sum == target:
                return (
                    set([quad_nums])
                    .union(recursive(a + 1, b, c, d))
                    .union(recursive(a, b + 1, c, d))
                    .union(recursive(a, b, c + 1, d))
                    .union(recursive(a, b, c, d - 1))
                    .union(recursive(a, b, c - 1, d))
                    .union(recursive(a, b - 1, c, d))
                )

            if quad_sum < target:
                return (
                    recursive(a + 1, b, c, d)
                    .union(recursive(a, b + 1, c, d))
                    .union(recursive(a, b, c + 1, d))
                )
            if quad_sum > target:
                return (
                    recursive(a, b, c, d - 1)
                    .union(recursive(a, b, c - 1, d))
                    .union(recursive(a, b - 1, c, d))
                )

            raise ValueError("This should never happen")

        # Sort the array
        nums.sort()
        # Reduce numbers so they can only appear at most 4 times
        d = Counter(nums)

        for key, value in d.items():
            if value > 4:
                first_index = nums.index(key)
                last_index = first_index + value - 4
                nums = nums[:first_index] + nums[last_index:]
        result = recursive(0, 1, len(nums) // 2, len(nums) - 1)
        return [list(r) for r in result]


class SolutionTest(unittest.TestCase):
    subject = Solution()

    def test_example1(self) -> None:
        actual = self.subject.fourSum([1, 0, -1, 0, -2, 2], 0)
        expected = [[-2, -1, 1, 2], [-2, 0, 0, 2], [-1, 0, 0, 1]]
        actual.sort()
        expected.sort()
        self.assertListEqual(actual, expected)

    def test_example2(self) -> None:
        actual = self.subject.fourSum([2, 2, 2, 2, 2], 8)
        expected = [[2, 2, 2, 2]]
        actual.sort()
        expected.sort()
        self.assertListEqual(actual, expected)

    def test_example3(self) -> None:
        actual = self.subject.fourSum([1, -2, -5, -4, -3, 3, 3, 5], -11)
        expected = [[-5, -4, -3, 1]]
        actual.sort()
        expected.sort()
        self.assertListEqual(actual, expected)

    def test_example4(self) -> None:
        actual = self.subject.fourSum(
            [
                1,
                1,
                1,
                1,
                1,
                1,
                1,
                1,
                1,
                1,
                1,
                1,
                1,
                1,
                1,
                1,
                1,
                1,
                1,
                1,
                1,
                1,
                1,
                1,
                1,
                1,
                1,
                1,
                1,
                1,
                1,
            ],
            4,
        )
        expected = [[1, 1, 1, 1]]
        actual.sort()
        expected.sort()
        self.assertListEqual(actual, expected)


if __name__ == "__main__":
    unittest.main()
