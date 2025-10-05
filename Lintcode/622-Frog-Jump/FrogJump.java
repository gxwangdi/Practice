import java.util.ArrayList;
import java.util.List;

public class FrogJump {
	/*
     * @param stones: a list of stones' positions in sorted ascending order
     * @return: true if the frog is able to cross the river or false
     */
	public boolean canCross(int[] stones) {
		if (stones == null || stones.length < 1) {
			return false;
		}
		if (stones.length <= 2) {
			return true;
		}
		if (stones[0] != 0 || stones[1] != 1) {
			return false;
		}
		List<List<Integer>> record = new ArrayList<>();
		for (int i = 0; i < stones.length; i++) {
			record.add(new ArrayList<Integer>());
		}
		record.get(1).add(1);
		for (int i = 1; i < stones.length; i++) {
			for (int j = i + 1; j < stones.length; j++) {
				if (canJump(record.get(i), stones[j] - stones[i])) {
					record.get(j).add(stones[j] - stones[i]);
				}
			}
		}
		if (record.get(stones.length - 1).size() == 0) {
			return false;
		} else {
			return true;
		}
	}

	private boolean canJump(List<Integer> jump, int target) {
		for (int i = 0; i < jump.size(); i++) {
			if (target <= jump.get(i) + 1 && target >= jump.get(i) - 1 && jump.get(i) - 1 >= 0) {
				return true;
			}
		}
		return false;
	}
}
