
public class ConvertPalindrome {
	/*
	 * @param : String
	 * 
	 * @return: String
	 */
	public String convertPalindrome(String s) {
		int i = 0;
		int end = s.length() - 1, j = end;
		char chs[] = s.toCharArray();
		while (i < j) {
			if (chs[i] == chs[j]) {
				i++;
				j--;
			} else {
				i = 0;
				end--;
				j = end;
			}
		}
		return new StringBuilder(s.substring(end + 1)).reverse().toString() + s;
	}

//	public String convertPalindrome(String str) {
//		if (str == null || str.length() < 2) {
//			return str;
//		}
//		int middle = str.length() / 2 - 1 + str.length() % 2;
//		Result maxPalindromeCenter = new Result();
//		for (int i = 1; i <= middle; i++) {
//			Result res = getPalindromeBeginningIndex(str, i);
//			if (res.index == 0) {
//				maxPalindromeCenter.isTwoCenter = res.isTwoCenter;
//				maxPalindromeCenter.index = i;
//			}
//		}
//		// TODO: check how full length is calculated.
//		int maxLen = (maxPalindromeCenter + 1) * 2;
//		if (maxLen >= str.length) {
//			// == for even index, > for odd index
//			return str;
//		}
//		String leftPart = str.substring(maxLen + 1);
//		return leftPart.reverse() + str;
//	}
//
//	private static class Result {
//		public boolean isTwoCenter;
//		public int Index;
//	}
//
//	/*
//	 * There two cases. Two elements as center or one element as center. For two
//	 * elements as center, take i-1, i.
//	 * 
//	 * @param : String
//	 * 
//	 * @param : Int
//	 * 
//	 * @return : The minimum index a valid palindrome can reach, starting from the
//	 * given index.
//	 */
//	private Result getPalindromeBeginningIndex(String str, int index) {
//		int result = str.length();
//		int left;
//		int right;
//		// Two elements as center.
//		if (str.charAt(index - 1) == str.charAt(index)) {
//			result = index - 1;
//			left = index - 2;
//			right = index + 1;
//			while (left >= 0) {
//				if (str.charAt(left) != str.charAt(right)) {
//					break;
//				}
//				result = Math.min(result, left);
//				left--;
//				right++;
//			}
//		}
//
//		if (result == 0) {
//			Result res = new Result();
//			res.isTwoCenter = true;
//			res.Index = 0;
//			return res;
//		}
//
//		left = index - 1;
//		right = index + 1;
//
//		return result;
//	}
}
