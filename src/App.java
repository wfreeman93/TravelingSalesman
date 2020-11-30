import java.util.*;

import java.io.*;

public class App {

static int minCost = 10000;
static WeightedGraph<String> minimumPath = new WeightedGraph<>();


  public static void TSP(WeightedGraph<String> graph, String currentVertice, WeightedGraph<String> currentPath, int cost, boolean visited) {
    //if we have a path that contains every vertice exactly once
    //this if statement just checks if graph and currentPath both contain the same veritces, which would essentially check if currentPath
    //has every vertice exactly once, as graph will only have every vertice exactly once
    if(graph.getVertices().containsAll(currentPath.getVertices()) && currentPath.getVertices().containsAll(graph.getVertices())){
      //this will add the last edge needed so we have a complete cycle
      currentPath.addEdge(currentVertice, (String)graph.getEdges(currentVertice).get(0).data, false, graph.getEdges(currentVertice).get(0).cost);
      //this will update the final cost with the final edge that completes the cycle
      cost += graph.getEdges(currentVertice).get(0).cost;
      if(cost < minCost) {
        minCost = cost;
        minimumPath = currentPath;
      }
    } else { 
      //need to get arraylist of the edges of specific vertice, using getEdges
      ArrayList<WeightedGraph.Edge> currentVerticeEdges =  graph.getEdges(currentVertice); //this is our arraylist of all edges attached to currentVertice
      //for loop that will check each edge attached to said vertice
      for(int i = 0; i < currentVerticeEdges.size(); i++) {
        //check if other end of edge has been visited
        if(currentPath.containsKey((String)currentVerticeEdges.get(i).data)){
          visited = true;
        } else {
          visited = false;
        }
        if(!visited) {
          //adding edge to path
          currentPath.addEdge(currentVertice, (String)currentVerticeEdges.get(i).data, true, currentVerticeEdges.get(i).cost);
          //for testing
          System.out.println(currentPath);
          //recursive call, using the main graph, the end node of the edge, the cost + the cost of the new path, and the visited boolean
          TSP(graph, (String)currentVerticeEdges.get(i).data, currentPath, cost + currentVerticeEdges.get(i).cost, visited);
          //removing that edge so as to try other vertices
          currentVerticeEdges.remove(i);
        }
      }
    } 
  } 

    public static void main(String[] args) throws Exception {
        WeightedGraph<String> graph = ParseGL.main();
        WeightedGraph<String> test = new WeightedGraph<>();
        String vertice = graph.getVertices().get(0);
        test.addVertex(graph.getVertices().get(0));
        TSP(graph, vertice, test, 0, false);
        System.out.println(minimumPath);
        System.out.println(minCost);
        
          File file = new File("answer.gl");
          BufferedWriter writer = new BufferedWriter(new FileWriter(file));
          writer.write(minimumPath.toString());
          writer.append("\r\n");
          writer.append("Cost: ");
          writer.append(Integer.toString(minCost));
          writer.close();

        
    }
}
