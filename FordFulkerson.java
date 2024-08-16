import java.util.*;

public class FordFulkerson{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int vertices = input.nextInt();
        System.out.println("Give Adjacency matrix: ");
        int [][] graph = new int[vertices][vertices];
        for(int i=0;i<vertices;i++){
            for (int j=0;j<vertices;j++){
                graph[i][j] = input.nextInt();
            }
        }
        
        int source = 0;
        int sink = vertices-1;

        int maxFlow = fordFulkerson(graph, source, sink);
        System.out.println("Maximum flow from source to sink: " + maxFlow);
    }
    // Method to find augmenting paths using DFS
    public static boolean dfs(int[][] residualGraph, int source, int sink, boolean[] visited, int[] parent) {
        /*for(int i=0;i<residualGraph.length;i++){
            for(int j=0;j<residualGraph.length;j++){
                System.out.print(residualGraph[i][j] +" ");
            }
            System.out.println();
        }*/
        int vertices = residualGraph.length;
        Stack<Integer> stack = new Stack<>();
        
        stack.push(source);
        visited[source] = true;
        parent[source] = -1;
        int u=0;
        // Perform DFS traversal
        while (!stack.isEmpty()) {
            u = stack.pop();
            visited[u] = true;
            
            for (int v = vertices-1; v >= 0; v--) {
                if (!visited[v] && residualGraph[u][v] > 0) {
                    stack.push(v);
                    parent[v] = u;
                    
                }
            }
        }
        // Return true if sink is reachable from source in residual graph
        return visited[sink];
    }

    // Ford-Fulkerson algorithm using DFS
    public static int fordFulkerson(int[][] graph, int source, int sink) {
        int vertices = graph.length;
        int[][] residualGraph = new int[vertices][vertices];

        for (int i = 0; i < vertices; i++) {
            for (int j = 0; j < vertices; j++) {
                residualGraph[i][j] = graph[i][j];
            }
        }

        int maxFlow = 0;
        boolean[] visited = new boolean[vertices];
        int[] parent = new int[vertices];

        // Augment the flow while there is an augmenting path from source to sink
        while (dfs(residualGraph, source, sink, visited, parent)) {
            int pathFlow = Integer.MAX_VALUE;
            
            for (int v = sink; v != source; v = parent[v]) {
                int u = parent[v];
                pathFlow = Math.min(pathFlow, residualGraph[u][v]);
            }
            

            // Update residual capacities of the edges and reverse edges along the path
            for (int v = sink; v != source; v = parent[v]) {
                int u = parent[v];
                residualGraph[u][v] -= pathFlow;
                residualGraph[v][u] += pathFlow;
            }

            // Add path flow to overall flow
            maxFlow += pathFlow;

            System.out.print("Augumentating path: ");
            Stack<Integer> reslt = new Stack<>();
            for (int v = sink; v != source; v = parent[v]) {
                reslt.push(v);
            }
            reslt.push(0);
            while(!reslt.isEmpty()){
                System.out.print(reslt.pop()+" ");
            }
            System.out.print("= "+pathFlow);
            System.out.println();
            // Reset visited array and parent array for next DFS traversal
            Arrays.fill(visited, false);
            Arrays.fill(parent, -1);
        }
        return maxFlow;
    }

    
}
