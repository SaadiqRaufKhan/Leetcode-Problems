// class Solution {
//     // classic Dijkstra
//     int findMinVertex(int[] distance, int n, boolean[] visited) {
//         int minVertex = -1;
//         for(int i=0; i<n; i++) {
//             if(!visited[i] && (minVertex == -1 || distance[i] < distance[minVertex])) {
//                 minVertex = i;
//             }
//         }
//         return minVertex;
//     }
//     public int networkDelayTime(int[][] times, int n, int k) {
//         int[][] graph = new int[n][n];

//         for(int i=0; i<n; i++) {
//             graph[i] = new int[n];
//             Arrays.fill(graph[i], -1);
//         }

//         for(int[] t: times) {
//             graph[t[0]-1][t[1]-1] = t[2];
//         }

//         // apply dijkstra
//         int[] distance = new int[n];
//         boolean[] visited = new boolean[n];

//         // equivalent to CLRS's 'initialize-single-source'
//         for(int i = 0; i < n; i++){
//             visited[i] = false;
//             distance[i] = Integer.MAX_VALUE;
//         }
//         // select source and set properties for it
//         distance[k-1] = 0;
        
//         // run for each vertex except the last => n-1 times
//         for(int i=0; i<n-1; i++) {
//             // extract min from unvisited
//             int minVertex = findMinVertex(distance, n, visited);
//             visited[minVertex] = true;
//             // Relax the unfinished neighbours of minVertex
//             for(int j=0; j<n; j++) {
//                 if(graph[minVertex][j] != -1 && !visited[j]) {  
//                     int dist = distance[minVertex] + graph[minVertex][j];
//                     distance[j] = Math.min(dist, distance[j]);
//                 }
//             }
//         }
//         int ans = Integer.MIN_VALUE;
//         for(int d: distance) {
//             if(d == Integer.MAX_VALUE) return -1;
//             ans = Math.max(ans, d);
//         }
//         return ans;
//     }
// }

class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        // Step 1: Build adjacency list
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            graph.put(i, new ArrayList<>());
        }

        for (int[] edge : times) {
            int u = edge[0], v = edge[1], w = edge[2];
            graph.get(u).add(new int[]{v, w});
        }

        // Step 2: Dijkstra with PriorityQueue
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.offer(new int[]{k, 0});

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int node = current[0], time = current[1];

            // If we already found a shorter path, skip
            if (time > dist[node]) continue;

            for (int[] neighbor : graph.get(node)) {
                int next = neighbor[0], weight = neighbor[1];
                if (dist[next] > time + weight) {
                    dist[next] = time + weight;
                    pq.offer(new int[]{next, dist[next]});
                }
            }
        }

        // Step 3: Compute the result
        int maxTime = 0;
        for (int i = 1; i <= n; i++) {
            if (dist[i] == Integer.MAX_VALUE) return -1;
            maxTime = Math.max(maxTime, dist[i]);
        }

        return maxTime;
    }
}
