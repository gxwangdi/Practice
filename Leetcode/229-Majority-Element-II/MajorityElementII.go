import "math"

func majorityElement(nums []int) []int {
	var res []int
	if nums == nil || len(nums) == 0 {
		return res
	}
	if len(nums) < 3 {
		for _, value := range nums {
			if !contains(res, value) {
				res = append(res, value)
			}
		}
		return res
	}
	number1 := math.MaxInt32
	number2 := math.MaxInt32
	count1 := 0
	count2 := 0
	for _, value := range nums {
		if number1 == value {
			count1++
		} else if number2 == value {
			count2++
		} else if count1 == 0 {
			number1 = value
			count1 = 1
		} else if count2 == 0 {
			number2 = value
			count2 = 1
		} else {
			count1--
			count2--
		}
	}

	count1 = 0
	count2 = 0
	for _, value := range nums {
		if number1 == value {
			count1++
		}
		if number2 == value {
			count2++
		}
	}
	if count1 > len(nums)/3 {
		res = append(res, number1)
	}
	if count2 > len(nums)/3 {
		res = append(res, number2)
	}
	return res
}

func contains(src []int, target int) bool {
	for _, value := range src {
		if target == value {
			return true
		}
	}
	return false
}
