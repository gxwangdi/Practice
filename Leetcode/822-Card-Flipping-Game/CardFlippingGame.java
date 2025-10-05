

class CardFlippingGame {
    // with size 1 maxHeap. 
    public int flipgame(int[] fronts, int[] backs) {
        var set = new HashSet<Integer>();
        var maxHeap = new PriorityQueue<Integer>(3, Collections.reverseOrder());

        for(int i=0; i<fronts.length; i++) {
            if (fronts[i] == backs[i]) {
                set.add(fronts[i]);
            }
        }

        for(int i=0; i<fronts.length; i++) {
            if (!set.contains(fronts[i])) {
                maxHeap.add(fronts[i]);
            }
            if (!set.contains(backs[i])) {
                maxHeap.add(backs[i]);
            }
            while(maxHeap.size() >1) {
                maxHeap.poll();
            }
        }
        if (maxHeap.isEmpty()) {
            return 0;
        }
        return maxHeap.peek();
    }

    // with minHeap
    // public int flipgame(int[] fronts, int[] backs) {
    //     var set = new HashSet<Integer>();
    //     var minHeap = new PriorityQueue<Integer>();
    //
    //     for(int i=0; i<fronts.length; i++) {
    //         if (fronts[i] == backs[i]) {
    //             set.add(fronts[i]);
    //             continue;
    //         }
    //         if (!set.contains(fronts[i])) {
    //             minHeap.add(fronts[i]);
    //         }
    //         if (!set.contains(backs[i])) {
    //             minHeap.add(backs[i]);
    //         }
    //     }
    //     while (!minHeap.isEmpty() && set.contains(minHeap.peek())) {
    //         minHeap.poll();
    //     }
    //     if (minHeap.isEmpty()) {
    //         return 0;
    //     }
    //     return minHeap.peek();
    // }
}
