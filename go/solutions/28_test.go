package solutions

import (
	"testing"
)

func strStr(haystack string, needle string) int {
	for i, j := 0, 0; i <= len(haystack)-len(needle); i++ {
		for j = 0; j < len(needle); j++ {
			if haystack[i+j] != needle[j] {
				break
			}
		}
		if j == len(needle) {
			return i
		}
	}
	return -1
}

func TestStrStr1(t *testing.T) {
	haystack := "sadbutsad"
	needle := "sad"
	actual := strStr(haystack, needle)
	expected := 0
	if actual != expected {
		t.Fail()
	}
}

func TestStrStr2(t *testing.T) {
	haystack := "leetcode"
	needle := "leeto"
	actual := strStr(haystack, needle)
	expected := -1
	if actual != expected {
		t.Fail()
	}
}

func TestStrStr3(t *testing.T) {
	haystack := "a"
	needle := "a"
	actual := strStr(haystack, needle)
	expected := 0
	if actual != expected {
		t.Fail()
	}
}
