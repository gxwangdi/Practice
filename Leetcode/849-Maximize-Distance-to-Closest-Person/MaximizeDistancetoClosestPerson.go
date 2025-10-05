func maxDistToClosest(seats []int) int {
	res := maxZeroDistance(seats)
	if res%2 == 1 {
		return res/2 + 1
	}
	return res / 2
}

func maxZeroDistance(seats []int) int {
	isB := true
	res := 0
	count := 0
	for i := 0; i < len(seats); i++ {
		if seats[i] == 0 {
			count++
		} else {
			if isB {
				res = max(res, count*2)
			} else {
				res = max(res, count)
			}
			isB = false
			count = 0
		}
	}
	if count != 0 {
		res = max(res, count*2)
	}
	return res
}

func max(a, b int) int {
	if a > b {
		return a
	}
	return b
}
