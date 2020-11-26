import java.util.*;

import java.io.*;

public class App {

int minCost = 0;
static ArrayList<String> minimumPath = new ArrayList<>();


  public static ArrayList<String> TSP(WeightedGraph<String> graph, String currentVertice, ArrayList<String> currentPath, int pathCost, boolean visited) {
    //if we have a path that contains every vertice exactly once
    if(currentPath.containsAll(graph.getVertices())) {
      return currentPath;
    } else {
      //need to get arraylist of the edges of specific vertice, using getEdges,
      ArrayList currentVerticeEdges =  graph.getEdges(currentVertice); //this is our arraylist of all edges attached to currentVertice
      for(int i = 0; i < currentVerticeEdges.size(); i++) {
        if(!visited) {
          //currentPath.add(currentVerticeEdges.get(i))
        }
      }
    }
    return currentPath;
  }

    public static void main(String[] args) throws Exception {
        WeightedGraph<String> graph = ParseGL.main();
        ArrayList<String> test = new ArrayList<>();
        ArrayList<String> path = new ArrayList<>();
        String vertice = graph.getVertices().get(0);
        test.add("B");
        test.add("C");
        test.add("A");
        test.add("D");
        System.out.println(graph.getEdges("A").get(0).data);
    }
}
