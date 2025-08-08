
import java.util.*;

class Pair {
    char city;
    int cost;
    char parent;

    Pair(char city, int cost, char parent) {
        this.city = city;
        this.cost = cost;
        this.parent = parent;
    }
}

public class PrimMST {

    public static void primsMST(Map<Character, List<Pair>> graph, char start) {
        Set<Character> visited = new HashSet<>();
        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingInt(p -> p.cost));
        pq.offer(new Pair(start, 0, '-'));  // Start from any city (e.g., A)

        int totalCost = 0;
        System.out.println("MST Edges:");

        while (!pq.isEmpty()) {
            Pair current = pq.poll();

            if (visited.contains(current.city)) continue;

            visited.add(current.city);

            if (current.parent != '-') {
                System.out.println(current.parent + " - " + current.city + ": " + current.cost);
                totalCost += current.cost;
            }

            for (Pair neighbor : graph.get(current.city)) {
                if (!visited.contains(neighbor.city)) {
                    pq.offer(new Pair(neighbor.city, neighbor.cost, current.city));
                }
            }
        }

        System.out.println("Total Minimum Cost: " + totalCost);
    }

    public static void main(String[] args) {
        Map<Character, List<Pair>> graph = new HashMap<>();

        // Create graph
        for (char city : List.of('A', 'B', 'C', 'D', 'E')) {
            graph.put(city, new ArrayList<>());
        }

        // Undirected edges
        addEdge(graph, 'A', 'B', 2);
        addEdge(graph, 'A', 'C', 3);
        addEdge(graph, 'B', 'C', 1);
        addEdge(graph, 'B', 'D', 4);
        addEdge(graph, 'C', 'D', 5);
        addEdge(graph, 'C', 'E', 6);
        addEdge(graph, 'D', 'E', 7);

        primsMST(graph, 'A'); // Start from city A
    }

    static void addEdge(Map<Character, List<Pair>> graph, char u, char v, int cost) {
        graph.get(u).add(new Pair(v, cost, u));
        graph.get(v).add(new Pair(u, cost, v));
    }
}
