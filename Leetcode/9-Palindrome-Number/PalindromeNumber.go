import (
	"strconv"
)

func isPalindrome(x int) bool {
	s := strconv.Itoa(x)
	i := 0
	j := len(s) - 1
	for i < j {
		if s[i] != s[j] {
			return false
		}
		i++
		j--
	}
	return true
}
