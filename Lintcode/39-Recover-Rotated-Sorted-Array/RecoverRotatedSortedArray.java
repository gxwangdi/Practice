import java.util.ArrayList;
import java.util.List;


public class RecoverRotatedSortedArray {
	/**
     * @param nums: The rotated sorted array
     * @return: void
     */
	public void recoverRotatedSortedArray(ArrayList<Integer> nums) {
		if (nums == null || nums.size() < 2) {
			return;
		}

		int index = getMiniIndex(nums);
		if (index == 0) {
			return;
		}
		reverse(nums, 0, index - 1);
		reverse(nums, index, nums.size() - 1);
		reverse(nums, 0, nums.size() - 1);
	}

	private int getMiniIndex(List<Integer> list) {
		int min = Integer.MAX_VALUE;
		int index = -1;
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i) < min) {
				min = list.get(i);
				index = i;
			}
		}
		return index;
	}
    /*
    private int getMiniIndex(List<Integer> list) {
        int target = list.get(list.size()-1);
        int start = 0;     
        int end = list.size()-1;     
        while (start + 1< end) {
            int mid = start + (end-start)/2;
            if (list.get(mid)<=target) {
                end = mid;
            } else {
                start = mid;
            }
        }
        if (list.get(start)<=target) {
            return start;
        }
        if (list.get(end)<=target) {
            return end;
        }
        return -1;
    }*/
    
	private void reverse(List<Integer> nums, int i, int j) {
		while (i < j) {
			int temp = nums.get(i);
			nums.set(i, nums.get(j));
			nums.set(j, temp);
			i++;
			j--;
		}
	}
}
