import java.io.*;
import java.lang.*;
import java.util.*;

class Main {
    final static int INF = 99999;
    static int Vertex = 0;
    static int[][] path;
    void floydWarshall(int graph[][],ArrayList<int[]> pathlist) {
        int matrix[][] = new int[Vertex][Vertex];

        int i, j, k;

        for (i = 0; i < Vertex; i++) {
            for (j = 0; j < Vertex; j++) {
                matrix[i][j] = graph[i][j];
            }
        }

        // Adding vertices individually
        for (k = 0; k < Vertex; k++) {
            for (i = 0; i < Vertex; i++) {
                for (j = 0; j < Vertex; j++) {
                    matrix[i][j]=Math.min(matrix[i][j],Math.max(matrix[i][k],matrix[k][j]));
                }
            }
        }
        printMatrix(matrix, pathlist);

    }

    void floydWarshallpath(int graph[][],ArrayList<int[]> pathlist) {
        int matrix[][] = new int[Vertex][Vertex];

        int i, j, k;

        for (i = 0; i < Vertex; i++) {
            for (j = 0; j < Vertex; j++) {
                matrix[i][j] = graph[i][j];
            }
        }

        // Adding vertices individually
        for (k = 0; k < Vertex; k++) {
            for (i = 0; i < Vertex; i++) {
                for (j = 0; j < Vertex; j++) {
                    if(matrix[i][j] > Math.max(matrix[i][k],matrix[k][j]))
                    {
                        path[i][j] = path[k][j];
                    }
                }
            }
        }
            for(i =0 ; i < path.length ; i++) {
                for (j = 0; j < path.length; j++) {
                    System.out.print(path[i][j] + " ");
                }
                System.out.println();
            }
        }



    void floydWarshallMax(int graph[][],ArrayList<int[]> pathlist) {
        int matrix[][] = new int[Vertex][Vertex];

        int i, j, k;

        for (i = 0; i < Vertex; i++) {
            for (j = 0; j < Vertex; j++) {
                matrix[i][j] = graph[i][j];
            }
        }
        // Adding vertices individually
        for (k = 0; k < Vertex; k++) {
            for (i = 0; i < Vertex; i++) {
                for (j = 0; j < Vertex; j++) {
                    matrix[i][j]=Math.max(matrix[i][j],Math.max(matrix[i][k],matrix[k][j]));
                }
            }
        }
        printMatrix(matrix, pathlist);

    }



    void printMatrix(int matrix[][],ArrayList<int[]> pathlist) {
       for(int i = 0 ; i < pathlist.size() ; i++)
       {
           System.out.println(matrix[pathlist.get(i)[0]-1][pathlist.get(i)[1]-1]);
       }

    }

    public int[][] graph() throws IOException {
        int sink,source;
        ArrayList<int[]> pathlist = new ArrayList<>();


        BufferedReader reader = new BufferedReader(new FileReader("D:\\CSCU29\\3.1\\Algor\\LAB7\\Floyd\\src\\test.txt"));
        String firstLine = reader.readLine();
        String[] parts = firstLine.split(" ");
        int V = Integer.parseInt(parts[0]);
        int E = Integer.parseInt(parts[1]);
        int ans = Integer.parseInt(parts[2]);


        Vertex = V;
       int[][] testCases = new int[Vertex][Vertex];
       int[][] testCasesMax = new int[Vertex][Vertex];
       path= new int[Vertex][Vertex];

        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                path[i][j] = -1;
            }
        }

        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                if(i != j) testCases[i][j] = INF;
            }
        }

        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                if(i != j) testCasesMax[i][j] = -INF;
            }
        }

        for(int i = 1; i <= E ; i++)
        {
            String line = reader.readLine();
            String[] node = line.split(" ");
            int e = Integer.parseInt(node[0]);
            int v = Integer.parseInt(node[1]);
            int w = Integer.parseInt(node[2]);
            testCases[e-1][v-1] = w;
            testCases[v-1][e-1] = w;

            testCasesMax[e-1][v-1] = w;
            testCasesMax[v-1][e-1] = w;

            path[e-1][v-1] = e;
            path[v-1][e-1] = v;
        }
        int k = 0;
        for(int i = E+1;i<E+ans+1;i++)
        {
            String line = reader.readLine();
            String[] node = line.split(" ");
            sink = Integer.parseInt(node[0]);
            source = Integer.parseInt(node[1]);
            int[] path = new int[]{sink, source};
            pathlist.add(path);
        }
        reader.close();
        floydWarshall(testCases,pathlist);
        //floydWarshallMax(testCasesMax,pathlist);
        floydWarshallpath(testCases,pathlist);
       return testCases;
    }




    public static void main(String[] args) throws IOException {
        Main find = new Main();
        find.graph();
    }
}