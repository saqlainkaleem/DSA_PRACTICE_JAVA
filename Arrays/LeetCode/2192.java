public class Solution {
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        int[] inDegree = new int[n];
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            inDegree[edge[1]]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }
        List<Integer> topoOrder = new ArrayList<>();
        while (!queue.isEmpty()) {
            int node = queue.poll();
            topoOrder.add(node);
            for (int neighbor : graph.get(node)) {
                inDegree[neighbor]--;
                if (inDegree[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }
        List<Set<Integer>> dp = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            dp.add(new HashSet<>());
        }

        for (int node : topoOrder) {
            for (int neighbor : graph.get(node)) {
                dp.get(neighbor).add(node);
                dp.get(neighbor).addAll(dp.get(node));
            }
        }
        List<List<Integer>> ancestors = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            List<Integer> ancestorList = new ArrayList<>(dp.get(i));
            Collections.sort(ancestorList);
            ancestors.add(ancestorList);
        }

        return ancestors;
    }
}
