// consider it like a full connected graph with edge wts being the Manhattan distance
// now we need to create an MST in this graph
// can either use Prims or kruskal
record Edge(int u, int v, int w) implements Comparable<Edge>{
    @Override
    public int compareTo(Edge other) {
        return Integer.compare(this.w, other.w);
    }
}

class Solution {
    int findParent(int vertex, int[] parent) {
        while(parent[vertex] != vertex) {
            vertex = parent[vertex];
        }
        return vertex;
    }
    int kruskal(Edge[] edges, int n, int e) {
        Arrays.sort(edges);
        // for(Edge ed: edges) System.out.println(ed);
        int[] parent = new int[n];
        for(int i=0; i<n; i++) {
            parent[i] = i;
        }
        int count = 0;  // edges of MST
        int ans = 0;    // total wt of MST
        int i = 0;      // edges counter
        while(count != n-1) {
            Edge currEdge = edges[i];

            int p1 = findParent(currEdge.u(), parent);
            int p2 = findParent(currEdge.v(), parent);

            if(p1 != p2) {
                // System.out.println("u = " + currEdge.u() + " v = " + currEdge.v() + " w = " + currEdge.w());
                ans += currEdge.w();
                parent[p1] = p2;
                count++;
            }
            i++;
        }
        return ans;
    } 
    public int minCostConnectPoints(int[][] points) {
        int n = points.length; 
        int e = (n * (n-1)) / 2; 
        Edge[] edges = new Edge[e];

        int idx = 0;
        for(int i=0; i<n; i++) {
            for(int j=i+1; j<n; j++) {
                int dist = Math.abs(points[i][0] - points[j][0]) 
                         + Math.abs(points[i][1] - points[j][1]);
                edges[idx++] = new Edge(i, j, dist);
            }
        }

        return kruskal(edges, n, e);
    }
}