import java.util.*;

class Solution {
    private List<Integer>[] adj;
    private int[] newParent;
    private int[] lastSeen;
    private int[] ans;
    private String s;

    public int[] findSubtreeSizes(int[] parent, String s) {
        int n = parent.length;
        this.s = s;
        this.newParent = Arrays.copyOf(parent, n);
        this.lastSeen = new int[26];
        Arrays.fill(this.lastSeen, -1);

        // Build adjacency list for the original tree
        adj = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int i = 1; i < n; i++) {
            adj[parent[i]].add(i);
        }

        // Step 1: Find the closest ancestor with the same character for every node
        findNewParents(0);

        // Step 2: Rebuild the tree using the updated parents
        for (int i = 0; i < n; i++) {
            adj[i].clear();
        }
        for (int i = 1; i < n; i++) {
            adj[newParent[i]].add(i);
        }

        // Step 3: Calculate subtree sizes on the modified tree
        ans = new int[n];
        computeSizes(0);

        return ans;
    }

    private void findNewParents(int u) {
        int charIdx = s.charAt(u) - 'a';
        int prevAncestor = lastSeen[charIdx];

        // If an ancestor with the same character exists, update u's parent
        if (prevAncestor != -1) {
            newParent[u] = prevAncestor;
        }

        // Mark u as the closest ancestor for this character for its descendants
        lastSeen[charIdx] = u;

        for (int v : adj[u]) {
            findNewParents(v);
        }

        // Backtrack: restore the previous closest ancestor
        lastSeen[charIdx] = prevAncestor;
    }

    private int computeSizes(int u) {
        int size = 1;
        for (int v : adj[u]) {
            size += computeSizes(v);
        }
        ans[u] = size;
        return size;
    }
}