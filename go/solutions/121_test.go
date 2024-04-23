package solutions

func maxProfit(prices []int) int {
	profit := 0
	buy := prices[0]

	for i := 1; i < len(prices); i++ {
		if prices[i] < buy {
			buy = prices[i]
			continue
		}
		temp_profit := prices[i] - buy
		if temp_profit > profit {
			profit = temp_profit
		}
	}
	return profit
}
