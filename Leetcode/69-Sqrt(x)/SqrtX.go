func mySqrt(x int) int {
	left := 0
	right := x
	for left+1 < right {
		mid := left + (right-left)/2
		t := mid * mid
		if t == x {
			return mid
		}
		if t < x {
			left = mid
		} else {
			right = mid
		}
	}
	temp := right * right
	if temp > x {
		return left
	}
	return right
}
