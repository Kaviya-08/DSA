

import java.util.*;

class Edge {
    int src, dest, weight;

    Edge(int src, int dest, int weight) {
        this.src = src;
        this.dest = dest;
        this.weight = weight;
    }
}

class DisjointSet {
    int[] parent;

    DisjointSet(int n) {
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;  // Initially, each node is its own parent
        }
    }

    // Find with path compression
    int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);  // path compression
        }
        return parent[x];
    }

    // Union by root
    boolean union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);

        if (rootA == rootB) return false; // Already in same component

        parent[rootA] = rootB;  // Connect the components
        return true;
    }
}

public class kruskal {
    public static void main(String[] args) {
        int V = 5;

        List<Edge> edges = new ArrayList<>();
        edges.add(new Edge(0, 1, 2));
        edges.add(new Edge(0, 3, 6));
        edges.add(new Edge(3, 1, 8));
        edges.add(new Edge(1, 2, 3));
        edges.add(new Edge(4, 2, 7));
        edges.add(new Edge(1, 4, 5));

        // Sort edges based on weight (ascending)
        edges.sort(Comparator.comparingInt(e -> e.weight));

        DisjointSet ds = new DisjointSet(V);
        int sum = 0;

        System.out.println("MST Edges:");

        
        for (Edge e : edges) {
            if (ds.union(e.src, e.dest)) {
                // If the edge connects two different components
                System.out.println(e.src + " - " + e.dest + " weight " + e.weight);
                sum += e.weight;
            }
        }

        System.out.println("Total weight of MST: " + sum);
    }
}
