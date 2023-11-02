import java.util.Arrays;

public class Main {
    final static int INF = Integer.MAX_VALUE;

    public static void floydWarshall(int graph[][], int source, int destination) {
        int V = graph.length;
        int[][] dist = new int[V][V];

        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                dist[i][j] = graph[i][j];
            }
        }

        for (int k = 0; k < V; k++) {
            for (int i = 0; i < V; i++) {
                for (int j = 0; j < V; j++) {
                    if (dist[i][k] != INF && dist[k][j] != INF) {
                        dist[i][j] = Math.min(dist[i][j], Math.max(dist[i][k], dist[k][j]));
                    }
                }
            }
        }

        int minNoise = dist[source - 1][destination - 1];
        System.out.println("To travel from city " + source + " to city " + destination + ", the maximum noise pollution is " + minNoise + " decibels.");
    }

    public static void main(String[] args) {
        int V = 7; // Number of cities
        int graph[][] = {
                {0, 100, INF, INF, 40, INF, INF},
                {100, 0, 50, 75, INF, INF, INF},
                {INF, 50, 0, INF, INF, 125, INF},
                {INF, 75, INF, 0, 70, 95, 175},
                {40, INF, INF, 70, 0, INF, 110},
                {INF, INF, 125, 95, INF, 0, INF},
                {INF, INF, INF, 175, 110, INF, 0}
        };

        int source = 1; // Source city
        int destination = 7; // Destination city

        floydWarshall(graph, source, destination);
    }
}
