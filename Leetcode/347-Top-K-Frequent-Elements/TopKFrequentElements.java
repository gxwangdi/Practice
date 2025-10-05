import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentElements {
    // minHeap approach.
    // public List<Integer> topKFrequent(int[] nums, int k) {
    //     List<Integer> res = new ArrayList<>();
    //     if (nums == null || nums.length == 0 || k<=0) {
    //         return res;
    //     }
    //
    //     Map<Integer, Integer> map = new HashMap<>();
    //     for (int i : nums) {
    //         if (map.containsKey(i)) {
    //             map.put(i, map.get(i)+1);
    //         } else {
    //             map.put(i, 1);
    //         }
    //     }
    //
    //     PriorityQueue<Pair> minHeap = new PriorityQueue<>(k+1, pairComparator);
    //     for (int key : map.keySet()) {
    //         Pair p = new Pair(key, map.get(key));
    //         minHeap.offer(p);
    //         if (minHeap.size()>k) {
    //             minHeap.poll();
    //         }
    //     }
    //
    //     while (!minHeap.isEmpty()) {
    //         res.add(minHeap.poll().key);
    //     }
    //     Collections.reverse(res);
    //     return res;
    // }// end of topKFrequent
    //
    // private Comparator<Pair> pairComparator = new Comparator<Pair>(){
    //    public int compare(Pair p1, Pair p2) {
    //        if (p1.frequency != p2.frequency) {
    //            return p1.frequency - p2.frequency;
    //        }
    //        return p1.key - p2.key;
    //    }
    // };
    //
    // private static class Pair {
    //     public int key;
    //     public int frequency;
    //     public Pair(int k, int f) {
    //         key = k;
    //         frequency = f;
    //     }
    // }

    public int[] topKFrequent(int[] nums, int k) {
        List<Integer>[] bucket = new List[nums.length + 1];
	Map<Integer, Integer> frequencyMap = new HashMap<Integer, Integer>();

	for (int n : nums) {
		frequencyMap.put(n, frequencyMap.getOrDefault(n, 0) + 1);
	}

	for (int key : frequencyMap.keySet()) {
		int frequency = frequencyMap.get(key);
		if (bucket[frequency] == null) {
			bucket[frequency] = new ArrayList<>();
		}
		bucket[frequency].add(key);
	}

	List<Integer> res = new ArrayList<>();

	for (int pos = bucket.length - 1; pos >= 0 && res.size() < k; pos--) {
		if (bucket[pos] != null) {
			res.addAll(bucket[pos]);
		}
	}
	return res.stream()
                    .filter(Objects::nonNull)
                    .mapToInt(Integer::intValue)
                    .toArray();
    }
}
