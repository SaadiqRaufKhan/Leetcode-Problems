// watch the neetcode solution if code doesn't make sense
class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        // bellman ford
        int e = flights.length; // no of edges
        int[] price = new int[n];
        Arrays.fill(price, Integer.MAX_VALUE);

        int[] price_temp = new int[n];
        Arrays.fill(price_temp, Integer.MAX_VALUE);

        price[src] = 0; price_temp[src] = 0;
        
        for(int i=0; i<=k; i++) {   // runs k+1 times
            // go through each edge
            for(int[] flight: flights) {
                int u = flight[0];
                int v = flight[1];
                int w = flight[2];
                // current vertex is reachable
                if(price[u] != Integer.MAX_VALUE) {
                    price_temp[v] = Math.min(price_temp[v], price[u] + w);
                }
            }
            for(int j=0; j<n; j++) {
                price[j] = price_temp[j];
            }   
        }

        return price[dst] == Integer.MAX_VALUE ? -1 : price[dst];

    }
}