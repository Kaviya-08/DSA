
import java.util.*;

public class BFSGraph {
    int V; // Number of vertices
    List<List<Integer>> adjList; // Adjacency list

    // Constructor to initialize graph
    BFSGraph(int V) {
        this.V = V;
        adjList = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adjList.add(new ArrayList<>());
        }
    }

    // Method to add edges (undirected)
    void addEdge(int u, int v) {
        adjList.get(u).add(v); // Add v to u's list
        adjList.get(v).add(u); // Add u to v's list (undirected)
    }

    // Method to perform BFS starting from given source
    void bfs(int start) {
        boolean[] visited = new boolean[V]; // Track visited nodes
        Queue<Integer> q = new LinkedList<>(); // Queue for BFS

        q.offer(start); // Add starting node
        visited[start] = true;

        System.out.print("BFS Traversal: ");

        while (!q.isEmpty()) {
            int node = q.poll(); // Get front element
            System.out.print(node + " ");

            for (int neighbor : adjList.get(node)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    q.offer(neighbor); // Enqueue unvisited neighbor
                }
            }
        }
    }

    public static void main(String[] args) {
        BFSGraph g = new BFSGraph(5);

        g.addEdge(0, 1);
        g.addEdge(0, 4);
        g.addEdge(1, 2);
        g.addEdge(1, 3);
        g.addEdge(1, 4);
        g.addEdge(2, 3);
        g.addEdge(3, 4);

        g.bfs(0); // Start BFS from node 0
    }
}
