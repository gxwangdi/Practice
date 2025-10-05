func myPow(x float64, n int) float64 {
	if x == 1.0 {
		return 1.0
	}
	if n < 0 {
		return 1 / power(x, -n)
	} else {
		return power(x, n)
	}
}

func power(x float64, n int) float64 {
	if n == 0 {
		return 1.0
	}
	v := power(x, n/2)
	if n%2 == 0 {
		return v * v
	} else {
		return v * v * x
	}
}
