
public class SortColorsII {
	/**
	 * @param colors: A list of integer
	 * @param k: An integer
	 * @return: nothing
	 */
	public void sortColors2(int[] colors, int k) {
		if (colors == null || colors.length < k) {
			return;
		}
		int cur = 0;
		int left = 0;
		int right = colors.length - 1;
		while (left < colors.length) {
			while (left < colors.length && colors[left] == cur) {
				left++;
			}
			while (right >= 0 && colors[right] != cur) {
				right--;
			}
			if (left < right) {
				swap(colors, left, right);
				left++;
				right--;
			} else {
				right = colors.length - 1;
				cur++;
			}
		}
	}

	private void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
