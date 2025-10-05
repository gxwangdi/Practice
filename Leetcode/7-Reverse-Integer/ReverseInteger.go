import "math"

func reverse(x int) int {
	upper := int(math.Pow(2, 31) - 1)
	m := int(math.Abs(float64(x)))
	if m > upper {
		return 0
	}
	total := 0
	for m > 0 {
		mod := m % 10
		total = total*10 + mod
		m = m / 10
	}
	if total > upper {
		return 0
	}
	if x < 0 {
		total *= -1
	}
	return total
}
