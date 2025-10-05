func countPrimes(n int) int {
	if n < 3 {
		return 0
	}
	primes := make([]bool, n)
	for idx, _ := range primes {
		primes[idx] = true
	}
	primes[0] = false
	primes[1] = false
	for i := 2; i*i < n; i++ {
		if primes[i] {
			for j := i + i; j < n; j += i {
				primes[j] = false
			}
		}
	}
	count := 0
	for _, val := range primes {
		if val {
			count++
		}
	}
	return count
}
