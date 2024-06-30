class Solution {
    // Union-Find class
    class UnionFind {
        private int[] parent;
        private int[] rank;
        private int count;

        public UnionFind(int n) {
            parent = new int[n];
            rank = new int[n];
            count = n; // initially, there are n disjoint sets
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public int find(int u) {
            if (parent[u] != u) {
                parent[u] = find(parent[u]); // path compression
            }
            return parent[u];
        }

        public boolean union(int u, int v) {
            int rootU = find(u);
            int rootV = find(v);
            if (rootU == rootV) {
                return false; // u and v are already in the same set
            }
            // union by rank
            if (rank[rootU] > rank[rootV]) {
                parent[rootV] = rootU;
            } else if (rank[rootU] < rank[rootV]) {
                parent[rootU] = rootV;
            } else {
                parent[rootV] = rootU;
                rank[rootU]++;
            }
            count--; // one less disjoint set now
            return true;
        }

        public int getCount() {
            return count;
        }
    }

    public int maxNumEdgesToRemove(int n, int[][] edges) {
        UnionFind ufAlice = new UnionFind(n);
        UnionFind ufBob = new UnionFind(n);

        int usedEdges = 0;

        // Process type 3 edges first
        for (int[] edge : edges) {
            if (edge[0] == 3) {
                boolean aliceConnected = ufAlice.union(edge[1] - 1, edge[2] - 1);
                boolean bobConnected = ufBob.union(edge[1] - 1, edge[2] - 1);
                if (aliceConnected || bobConnected) {
                    usedEdges++;
                }
            }
        }

        // Process type 1 edges for Alice
        for (int[] edge : edges) {
            if (edge[0] == 1) {
                if (ufAlice.union(edge[1] - 1, edge[2] - 1)) {
                    usedEdges++;
                }
            }
        }

        // Process type 2 edges for Bob
        for (int[] edge : edges) {
            if (edge[0] == 2) {
                if (ufBob.union(edge[1] - 1, edge[2] - 1)) {
                    usedEdges++;
                }
            }
        }

        // Check if both graphs are fully traversable
        if (ufAlice.getCount() != 1 || ufBob.getCount() != 1) {
            return -1;
        }

        return edges.length - usedEdges;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int n = 4;
        int[][] edges = {
            {3, 1, 2}, {3, 2, 3}, {1, 1, 3}, {1, 3, 4}, {1, 1, 2}, {2, 3, 4}
        };
        System.out.println(solution.maxNumEdgesToRemove(n, edges)); // Output: 2
    }
}
