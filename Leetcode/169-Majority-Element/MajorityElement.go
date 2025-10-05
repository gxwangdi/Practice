func majorityElement(nums []int) int {
	res := 0
	count := 0
	for _, num := range nums {
		if count == 0 {
			res = num
			count++
		} else {
			if num == res {
				count++
			} else {
				count--
			}
		}
	}
	return res
}
