import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

class DijkstraAlgorithm {

    public static void main(String[] args) {
        int[][] adjacencyMatrix = { { 0, 4, 0, 0, 7 }, { 4, 0, 1, 2, 0 }, { 0, 1, 0, 6, 0 }, { 0, 2, 6, 0, 0 },
                { 7, 0, 0, 0, 0 } };
        dijkstraAlgo(adjacencyMatrix, adjacencyMatrix.length);
    }

    static void dijkstraAlgo(int[][] adjacencyMatrix, int numberOfVertices) {
        int[] distanceFromSource = new int[numberOfVertices];
        boolean[] isVisited = new boolean[numberOfVertices];
        Arrays.fill(distanceFromSource, Integer.MAX_VALUE);
        Arrays.fill(isVisited, false);
        distanceFromSource[0] = 0;
        for (int i = 0; i < numberOfVertices; i++) {
            int minimumDistance = Integer.MAX_VALUE;
            int u = -1;
            for (int j = 0; j < numberOfVertices; j++) {
                if (!isVisited[j] && distanceFromSource[j] <= minimumDistance) {
                    minimumDistance = distanceFromSource[j];
                    u = j;
                }
            }
            isVisited[u] = true;
            for (int j = 0; j < numberOfVertices; j++) {
                if (!isVisited[j] && adjacencyMatrix[u][j] != 0 && distanceFromSource[u] != Integer.MAX_VALUE
                        && distanceFromSource[u] + adjacencyMatrix[u][j] < distanceFromSource[j]) {
                    distanceFromSource[j] = distanceFromSource[u] + adjacencyMatrix[u][j];
                }
            }
        }

        System.out.println("Distance from source to destination ->");
        for (int j = 0; j < numberOfVertices; j++) {
            System.out.println(j + " ---> " + distanceFromSource[j]);
        }
    }
}