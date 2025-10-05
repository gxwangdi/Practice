func maxRotateFunction(A []int) int {
	F := 0
	sum := 0
	n := len(A)
	if n <= 1 {
		return 0
	}
	for idx, val := range A {
		F += idx * val
		sum += val
	}
	res := F
	for k := 1; k < n; k++ {
		F += sum
		F -= n * A[n-k]
		if F > res {
			res = F
		}
	}
	return res
}
