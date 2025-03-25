class Solution {
    // Time complexity O(V + E) and space O(V)
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        var graph = constructGraph(numCourses, prerequisites);
        var visited = new boolean[numCourses];
        var inStack = new boolean[numCourses];

        for (int v = 0; v < graph.size(); v++) {
            if (!visited[v] && hasCycle(v, graph, visited, inStack)) {
                return false;
            }
        }

        return true;
    }

    private boolean hasCycle(
            int v,
            ArrayList<ArrayList<Integer>> graph,
            boolean[] visited,
            boolean[] inStack) {
        if (inStack[v])
            return true;

        visited[v] = true;
        inStack[v] = true;

        for (int edge : graph.get(v)) {
            if (!visited[edge]
                    && hasCycle(edge, graph, visited, inStack)) {
                return true;
            } else if (inStack[edge]) {
                return true;
            }
        }

        // backtrack
        inStack[v] = false;
        return false;
    }

    public ArrayList<ArrayList<Integer>> constructGraph(int numCourses, int[][] prerequisites) {
        var graph = new ArrayList<ArrayList<Integer>>();

        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] p : prerequisites) {
            graph.get(p[0]).add(p[1]);
        }

        return graph;
    }
}