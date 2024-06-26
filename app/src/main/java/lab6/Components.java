/*
 * This Java source file was generated by the Gradle 'init' task.
 * Augustus DeGrandis
 * Lab6 
 * 5/28/2024
 * 
 * I think I made this Lab Assignement much more complicated then It had to be
 * But I had a lot of fun learning about different kinds of Matrixs, In hindsight 
 * just creating a simple adjacency list would have made this much simpiler.
 */
package lab6;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Components {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File(args[0]);
        Scanner sc = new Scanner(file);
        //Takes the first line of the file and converts it into a Intiger of the #vertecis
        int vertecis = sc.nextInt();
        matrixGraph mGraph = new matrixGraph(vertecis);

        while(sc.hasNextLine()) {
            int i = sc.nextInt();
            int j = sc.nextInt();
            mGraph.addConnection(i,j);
            //Consume the remainder of the Line
            sc.nextLine(); 
        }
        sc.close();
    } 
    public class matrixGraph {
        private int[][] adjacencyMatrix;
        private int vertecis;
        private int connections;
    
        public matrixGraph(int numVertecis) {
            this.vertecis = numVertecis;
            adjacencyMatrix = new int[numVertecis][numVertecis];
        }
        public void addConnection(int i, int j) {
            adjacencyMatrix[i][j] = 1;
            //Since the connections dont have direction we set bolth to true
            adjacencyMatrix[j][i] = 1;
            connections++;
            
        }
        public void removeConnection(int i, int j) {
            if(adjacencyMatrix[i][j] == 1) {
                adjacencyMatrix[i][j] = 0;
                adjacencyMatrix[j][i] = 0;
                connections--;
            }
        }
        public boolean hasConnection(int i, int j) {
            return adjacencyMatrix[i][j] == 1;
        } 

        public void printMatrix(int[][] matrix) {
            for(int i=0; i<vertecis; i++) {
                for(int j=0; j<vertecis; j++) {
                    System.out.print(matrix[i][j]);
                }
                System.out.println();
            }
        }
        public int findComponents() {
          //TODO 
          //Can do a BFS and a Boolean[] visited to find the unique components
        }
    }     
}


