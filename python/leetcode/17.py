import unittest
from typing import List

PHONE_MAP = {
    "2": ["a", "b", "c"],
    "3": ["d", "e", "f"],
    "4": ["g", "h", "i"],
    "5": ["j", "k", "l"],
    "6": ["m", "n", "o"],
    "7": ["p", "q", "r", "s"],
    "8": ["t", "u", "v"],
    "9": ["w", "x", "y", "z"],
}


class Solution:
    def letterCombinations(self, digits: str) -> List[str]:
        numbers = list(digits)
        character_sets = [PHONE_MAP[number] for number in numbers]

        if len(character_sets) == 0:
            return []

        result = [character for character in character_sets[0]]
        for characters in character_sets[1:]:
            # Combine the current result with each character
            result = [
                current + character for current in result for character in characters
            ]
        return result


class SolutionTest(unittest.TestCase):
    subject = Solution()

    def test_example1(self) -> None:
        actual = self.subject.letterCombinations("23")
        expected = ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"]
        self.assertEqual(actual, expected)

    def test_example2(self) -> None:
        actual = self.subject.letterCombinations("")
        expected: List[str] = []
        self.assertEqual(actual, expected)

    def test_example3(self) -> None:
        actual = self.subject.letterCombinations("2")
        expected = ["a", "b", "c"]
        self.assertEqual(actual, expected)


if __name__ == "__main__":
    unittest.main()
