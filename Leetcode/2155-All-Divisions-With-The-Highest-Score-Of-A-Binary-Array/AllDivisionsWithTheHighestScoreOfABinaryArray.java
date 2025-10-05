

class AllDivisionsWithTheHighestScoreOfABinaryArray {
    public List<Integer> maxScoreIndices(int[] nums) {
        var oneCount = new int[nums.length + 1];
	var totalOneCount = 0;
	var maxScore = Integer.MIN_VALUE;
	var indices = new ArrayList<Integer>();

	for (int i=0; i<nums.length; i++) {
		oneCount[i] = totalOneCount;
		if (nums[i] == 1) {
			totalOneCount++;
		}
	}

	oneCount[oneCount.length-1] = totalOneCount;

	for (int i=0; i<oneCount.length; i++) {
		var score = ((i+1) - oneCount[i]) + (totalOneCount - oneCount[i]);
		if (score > maxScore) {
			maxScore = score;
			indices.clear();
			indices.add(i);
		} else if (score == maxScore) {
			indices.add(i);
		}
	}
	return indices;
    }
}
