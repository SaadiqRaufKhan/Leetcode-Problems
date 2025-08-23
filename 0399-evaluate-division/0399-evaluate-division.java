class Solution {
    void dfs(String source, String dest, double value, Map<String, Map<String, Double>> graph,
            Set<String> visited, double[] ans) {

        if(source.equals(dest)) {
            ans[0] = value;
            return;
        }

        if(visited.contains(source)) return;
        visited.add(source);

        Map<String, Double> neighbours = graph.get(source);
        for(Map.Entry<String, Double> entry: neighbours.entrySet()) {
            String adj = entry.getKey();
            double factor = entry.getValue();

            dfs(adj, dest, value*factor, graph, new HashSet<>(visited), ans);
        }

    }
    public double[] calcEquation(List<List<String>> equations, 
    double[] values, List<List<String>> queries) {
        
        Map<String, Map<String, Double>> graph = new HashMap<>();

        for(int i=0; i<equations.size(); i++) {
            String s = equations.get(i).get(0);
            String d = equations.get(i).get(1);
            double factor = values[i];
            graph.computeIfAbsent(s, k -> new HashMap<>()).put(d, factor);
            graph.computeIfAbsent(d, k -> new HashMap<>()).put(s, 1.0/factor);
        }

        List<Double> res = new ArrayList<>();
        for(List<String> query: queries) {
            String s = query.get(0);
            String d = query.get(1);

            if(!graph.containsKey(s) || !graph.containsKey(d)) {
                res.add(-1.0);
            }
            else {
                double[] ans = {-1.0};
                dfs(s, d, 1.0, graph, new HashSet<>(), ans);
                res.add(ans[0]);
            }
        }

        return res.stream()
                .mapToDouble(Double::doubleValue)
                .toArray();
    }
}