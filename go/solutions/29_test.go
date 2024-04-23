package solutions

import (
	"math"
	"testing"
)

func divide(dividend int, divisor int) int {
	if divisor == 1 {
		return dividend
	}
	// Align most significant dividend
	sign := 1
	// divided < 0 XOR divisor < 0
	if (dividend < 0) != (divisor < 0) {
		sign = -1
	}

	dividend = int(math.Abs(float64(dividend)))
	divisor = int(math.Abs(float64(divisor)))

	result := 0
	for dividend >= divisor {
		quotient := 0
		for dividend > (divisor << (quotient + 1)) {
			quotient++
		}
		result += (1 << quotient)
		dividend -= divisor << quotient
	}
	if result > math.MaxInt32 {
		result = math.MaxInt32
	}
	if sign == -1 {
		return -result
	}
	return result
}

func TestDivide1(t *testing.T) {
	dividend := 10
	divisor := 3
	actual := divide(dividend, divisor)
	expected := 3
	if actual != expected {
		t.Fail()
	}
}

func TestDivide2(t *testing.T) {
	dividend := 7
	divisor := -3
	actual := divide(dividend, divisor)
	expected := -2
	if actual != expected {
		t.Fail()
	}
}

func TestDivide3(t *testing.T) {
	dividend := -7
	divisor := 3
	actual := divide(dividend, divisor)
	expected := -2
	if actual != expected {
		t.Fail()
	}
}

func TestDivide4(t *testing.T) {
	dividend := -2147483648
	divisor := 1
	actual := divide(dividend, divisor)
	expected := -2147483648
	if actual != expected {
		t.Fail()
	}
}
