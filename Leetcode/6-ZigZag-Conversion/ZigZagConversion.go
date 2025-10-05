import "bytes"

func convert(s string, numRows int) string {
	if len(s) <= numRows || numRows < 2 {
		return s
	}

	var buffer bytes.Buffer
	size := 2*numRows - 2
	for i := 0; i < numRows; i++ {
		for j := i; j < len(s); j += size {
			buffer.WriteString(string(s[j]))
			if i != 0 && i != numRows-1 {
				temp := j + size - 2*i
				if temp < len(s) {
					buffer.WriteString(string(s[temp]))
				}
			}
		}
	}
	return buffer.String()
}
