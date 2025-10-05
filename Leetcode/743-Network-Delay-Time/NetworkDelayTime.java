

class NetworkDelayTime {
    public int networkDelayTime(int[][] times, int n, int K) {
        int[][] graph = new int[n][n];
        for(int i = 0; i < n ; i++) Arrays.fill(graph[i], Integer.MAX_VALUE);
        for( int[] rows : times) graph[rows[0] - 1][rows[1] - 1] =  rows[2];

        int[] distance = new int[n];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[K - 1] = 0;

        boolean[] visited = new boolean[n];
        for(int i = 0; i < n ; i++){
            int v = minIndex(distance, visited);
            if(v == -1)continue;
            visited[v] = true;
            for(int j = 0; j < n; j++){
                if(graph[v][j] != Integer.MAX_VALUE){
                    int newDist = graph[v][j] + distance[v];
                    if(newDist < distance[j]) distance[j] = newDist;
                }
            }
        }
        int result = 0;
        for(int dist : distance){
            if(dist == Integer.MAX_VALUE) return -1;
            result = Math.max(result, dist);
        }
        return result;
    }

    private int minIndex(int[] distance, boolean[] visited){
        int min = Integer.MAX_VALUE, minIndex = -1;
        for(int i = 0; i < distance.length; i++){
            if(!visited[i] && distance[i] < min){
                min = distance[i];
                minIndex = i;
            }
        }
        return minIndex;
    }
//     public int networkDelayTime(int[][] times, int n, int k) {
//         if (times.length < n-1) {
//             return -1;
//         }
//         var dis = new int[n+1];
//         var map = buildMap(times);
//         // BFS
//         var queue = new ArrayDeque<Integer>();
//         queue.offerLast(k);
//         var max = 0;
//         while(queue.peekFirst() != null) {
//             int cur = queue.removeFirst();
//             System.out.println("cur:"+cur);
//             var edges = map.get(cur);
//             if (edges == null) {
//                 System.out.println("edges null.");
//                 continue;
//             }
//             for (Map.Entry<Integer, Integer> entry : edges.entrySet()) {
//                 if (entry.getKey() == k) {
//                     continue;
//                 }
//                 var temp = dis[cur] + entry.getValue();
//                 System.out.println("temp:" + temp);
//                 // int key = entry.getKey();
//                 if (dis[entry.getKey()] == 0 || dis[entry.getKey()] > temp) {
//                     dis[entry.getKey()] = temp;
//                     queue.offerLast(entry.getKey());
//                 }
//             }
//         }
//         System.out.println("dis[]:");
//         for(int i = 1; i<dis.length; i++) {
//             System.out.println("i:" + i + " :" + dis[i]);
//             if (i!=k && dis[i] == 0) {
//                 return -1;
//             }
//             max = Math.max(max, dis[i]);
//         }
//         return max;
//     }

//     private Map<Integer, Map<Integer, Integer>> buildMap(int[][] times) {
//         var res = new HashMap<Integer, Map<Integer, Integer>>();
//         for (int[] arr : times) {
//             var map = res.getOrDefault(arr[0], new HashMap<Integer, Integer>());
//             map.put(arr[1], arr[2]);
//             res.put(arr[0], map);
//         }
//         return res;
//     }
}
