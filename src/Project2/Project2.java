package Project2;

import java.util.*;

import Project2.test.*;

public class Project2 {

    public static int edge = 0;
    public static void main(String[] args)
    {
        // int graph[][] = new int[][] { { 0, 4, 0, 0, 0, 0, 0, 8, 0 },
        //                               { 4, 0, 8, 0, 0, 0, 0, 11, 0 },
        //                               { 0, 8, 0, 7, 0, 4, 0, 0, 2 },
        //                               { 0, 0, 7, 0, 9, 14, 0, 0, 0 },
        //                               { 0, 0, 0, 9, 0, 10, 0, 0, 0 },
        //                               { 0, 0, 4, 14, 10, 0, 2, 0, 0 },
        //                               { 0, 0, 0, 0, 0, 2, 0, 1, 6 },
        //                               { 8, 11, 0, 0, 0, 0, 1, 0, 7 },
        //                               { 0, 0, 2, 0, 0, 0, 6, 7, 0 } };
        // ShortestPath.dijM(graph, 0, 9);
        int[][] g = CreateGraphMat(6);

        // matrix sort
        long startH = System.nanoTime();
        ShortestPath.dijM(g , 0, 6);
        long endH = System.nanoTime();
        long elapsedTimeH = (endH - startH)/1000; 
        System.out.println("Matrix sort excution time " + elapsedTimeH + " us");
        
        // list sort
        Graph gL = generateGraph(g, 6);
        
        long startM = System.nanoTime();
        gL.dijkstra_GetMinDistances(0);
        long endM = System.nanoTime();
        long elapsedTimeM = (endM - startM)/1000; 
        System.out.println("List sort excution time " + elapsedTimeM + " us");


        System.out.println("edge number is: " + edge);
        
    }

    private static int[][] CreateGraphMat (int v){
        Random rand =  new Random();
        List<Integer> randList = Arrays.asList(0, 0, 0, 0, 0 , 0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
        int[][] g = new int[v][v];
        for (int i=0; i<v ; i++){
            for (int j = i; j<v; j++){
                if (j==i)
                    g[i][j] = 0;
                else{
                    int r = randList.get(rand.nextInt(randList.size()));
                    g[i][j] = r;
                    g[j][i] = r;
                    if (r != 0 )
                        edge++;
                }
            }
        }

        return g;
    }

    private static Graph generateGraph(int[][] mat, int v){
        Graph gL = new Graph(v);
        for (int i=0; i<v ; i++){
            for (int j = i; j<v; j++){
                if (j!=i){
                    if (mat[i][j]!=0)
                    gL.addEdge(i, j, mat[i][j]);
                }
            }
        }
        return gL;
    }
}
