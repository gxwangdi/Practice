func canCompleteCircuit(gas []int, cost []int) int {
	if gas == nil || cost == nil || len(gas) != len(cost) {
		return -1
	}
	sum := 0
	total := 0
	last := -1
	for ind, val := range gas {
		sum += val - cost[ind]
		total += val - cost[ind]
		if sum < 0 {
			last = ind
			sum = 0
		}
	}
	if total < 0 {
		return -1
	}
	return last + 1
}
