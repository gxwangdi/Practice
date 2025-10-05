
public class ConcatenatedStringWithUncommonCharactersOfTwoStrings {
	/*
     * @param : the 1st string
     * @param : the 2nd string
     * @return: uncommon characters of given strings
     */
	public String concatenetedString(String s1, String s2) {
		// Assuming s1 and s2 are valid and all lower case.
		StringBuilder result = new StringBuilder();
		char[] arr1 = s1.toLowerCase().toCharArray();
		char[] arr2 = s2.toLowerCase().toCharArray();
		int[] count = new int[26];

		// Put s2 into count
		for (int i = 0; i < arr2.length; i++) {
			count[arr2[i] - 'a'] = 1;
		}
		// Put non-duplicate s1 chars into result
		for (int i = 0; i < arr1.length; i++) {
			if (count[arr1[i] - 'a'] >= 1) {
				count[arr1[i] - 'a'] = 2;
			} else {
				result.append(arr1[i]);
			}
		}

		// put non-duplicate s2 chars into result
		for (int i = 0; i < arr2.length; i++) {
			if (count[arr2[i] - 'a'] == 1) {
				result.append(arr2[i]);
			}
		}
		return result.toString();
	}
}
