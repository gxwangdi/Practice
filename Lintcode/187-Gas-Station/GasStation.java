public class GasStation {
	/**
	 * @param gas
	 *            : an array of integers
	 * @param cost
	 *            : an array of integers
	 * @return: an integer
	 */
	public int canCompleteCircuit(int[] gas, int[] cost) {
		if (gas == null || cost == null || gas.length != cost.length) {
			return -1;
		}
		for (int i = 0; i < gas.length; i++) {
			if (gas[i] - cost[i] < 0) {
				continue;
			}
			int sum = gas[i] - cost[i];
			int cur = i + 1;
			while (cur % gas.length != i && sum >= 0) {
				sum += gas[cur % gas.length] - cost[cur % gas.length];
				cur++;
			}
			if (sum >= 0 && cur % gas.length == i) {
				return i;
			}
		}
		return -1;
	}
}
