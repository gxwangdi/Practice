class LastStoneWeight {
    public int lastStoneWeight(int[] stones) {
        if(stones == null || stones.length == 0){
            return 0;
        }

        Comparator<Integer> comparator = (o1, o2) -> o2-o1;
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>(comparator);
        for(int stone : stones){
            queue.offer(stone);
        }

        while(queue.size() > 1){
            int num1 = queue.poll();
            int num2 = queue.poll();
            if(num1!= num2){
                queue.offer(num1-num2);
            }
        }

        return queue.isEmpty()?0: queue.poll();
    }
}
