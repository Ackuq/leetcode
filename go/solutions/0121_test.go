package solutions

func maxProfit(prices []int) int {
	profit := 0
	buy := prices[0]

	for i := 1; i < len(prices); i++ {
		if prices[i] < buy {
			buy = prices[i]
			continue
		}
		tempProfit := prices[i] - buy
		if tempProfit > profit {
			profit = tempProfit
		}
	}
	return profit
}
