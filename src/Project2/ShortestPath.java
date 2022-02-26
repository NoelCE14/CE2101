package Project2;

public class ShortestPath {

    
    public static void dijM(int graph[][], int src, int V)
    {
        int dist[] = new int[V]; 

        Boolean sptSet[] = new Boolean[V];
 

        for (int i = 0; i < V; i++) {
            dist[i] = Integer.MAX_VALUE;
            sptSet[i] = false;
        }  // O(V)
 
        dist[src] = 0;
 
        // Find shortest path for all vertices
        for (int count = 0; count < V - 1; count++) { // O(V-1)
            int u = minDistance(dist, sptSet); // O(V)
 
            
            sptSet[u] = true;
 
            // Update dist value of the adjacent vertices of the
            // picked vertex.
            for (int v = 0; v < V; v++) // O(V)
                if (!sptSet[v] && graph[u][v] != 0 && dist[u] != Integer.MAX_VALUE && dist[u] + graph[u][v] < dist[v])
                    dist[v] = dist[u] + graph[u][v];
        }

        // total time complexity = O(V + 2V(V-1)) = O(V^2)

        printSolution(dist);

    }

    private static int minDistance(int dist[], Boolean sptSet[]) // priority queue
    {
        // Initialize min value
        int min = Integer.MAX_VALUE, min_index = -1;
 
        for (int v = 0; v < dist.length; v++)
            if (sptSet[v] == false && dist[v] <= min) {
                min = dist[v];
                min_index = v;
            }
 
        return min_index;
    }

    private static void printSolution(int dist[])
    {
        System.out.println("Vertex \t\t Distance from Source");
        for (int i = 0; i < dist.length; i++)
            System.out.println(i + " \t\t " + dist[i]);
    }
}
