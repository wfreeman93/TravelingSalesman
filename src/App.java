import java.util.*;

import java.io.*;

public class App {

int minCost = 0;
static ArrayList<String> minimumPath = new ArrayList<>();


  public static ArrayList<String> TSP(WeightedGraph<String> graph, String currentVertice, ArrayList<String> currentPath, int cost, boolean visited) {
    //if we have a path that contains every vertice exactly once
    if(currentPath.containsAll(graph.getVertices())) {
      return currentPath;
    } else {
      //need to get arraylist of the edges of specific vertice, using getEdges,
      ArrayList<WeightedGraph.Edge> currentVerticeEdges =  graph.getEdges(currentVertice); //this is our arraylist of all edges attached to currentVertice
      for(int i = 0; i < currentVerticeEdges.size(); i++) {
        if(!visited) {
          currentPath.add((String)currentVerticeEdges.get(i).data);
          TSP(graph, (String)currentVerticeEdges.get(i).data, currentPath, cost + currentVerticeEdges.get(i).cost, true);
          graph.removeEdge(currentVertice, i);
        }
      }
    }
    return currentPath;
  } 

    public static void main(String[] args) throws Exception {
        WeightedGraph<String> graph = ParseGL.main();
        ArrayList<String> test = new ArrayList<>();
        minimumPath.clear();
        String vertice = graph.getVertices().get(0);
        test.add("B");
        test.add("C");
        test.add("A");
        test.add("D");
        System.out.println(graph.getEdges("A").get(0).data);
        graph.removeVertex("B");
        System.out.println(graph);
        graph.removeEdge("A", 0);
        System.out.println(graph);
    }
}
