

class Ranktransformofanarray {
    public int[] arrayRankTransform(int[] arr) {
        Map<Integer, List<Integer>> map = new TreeMap<>();
        for (int i = 0; i < arr.length; i++) {
			map.computeIfAbsent(arr[i], k -> new ArrayList<>()).add(i);
        }
        int rank = 1;
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            List<Integer> currentList = entry.getValue();
            for(int i: currentList)  arr[i] = rank;
            rank++;
        }
        return arr;
    }
}
