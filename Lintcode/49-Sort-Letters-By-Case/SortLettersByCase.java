
public class SortLettersByCase {
	/**
	 * @param chars: The letter array you should sort by Case
	 * @return: void
	 */
	public void sortLetters(char[] chars) {
		if (chars == null || chars.length < 2) {
			return;
		}
		int left = 0;
		int right = chars.length - 1;
		while (left < right) {
			while (left < right && chars[right] >= 'A' && chars[right] <= 'Z') {
				right--;
			}
			while (left < right && chars[left] >= 'a' && chars[left] <= 'z') {
				left++;
			}
			if (left == right) {
				continue;
			}
			swap(chars, left, right);
			left++;
			right--;
		}
	}

	private void swap(char[] arr, int left, int right) {
		char c = arr[left];
		arr[left] = arr[right];
		arr[right] = c;
	}
}
