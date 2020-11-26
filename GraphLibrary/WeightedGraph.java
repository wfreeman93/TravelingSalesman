import java.util.*;

//Suppressions to remove annoying Java warnings for generics and raw types
@SuppressWarnings({"unchecked", "rawtypes"})

public class WeightedGraph<E> {

    //our main hashmap. E represents our vertices, the arraylist represents our list of edges.
    //The arraylist takes an edge object, which will in turn have vertices representing edges, as well as costs if the graph is weighted.
private Map<E, ArrayList<Edge>> map = new HashMap<>();


//Our edge, which was needed to be able to keep track of weighted costs
public static class Edge<G> {
    G data;
    int cost;

    //constructor for our edge object
    //FIXED!: unsure of how else to switch between weighted and unweighted without using a seperate edge object, to store both the edge data and the cost
    public Edge(G data, int cost) {
        this.data = data;
        this.cost = cost;
    }

    //edge node for weighted graph
    public Edge(G data) {
        this.data = data;
    }
 
    //toString for our Edge object
    public String toString() {
        return "[" + data + " , " + cost + "]";
    }
}


//Adds a vertex to our hashmap graph, creates a new arraylist of type Edge for edges
public void addVertex(E vertex) {
    map.put(vertex, new ArrayList<Edge>());
}


//Adds an edge. If either the source edge(from) or the destination(to) vertex is not found in the hashmap, it is created using addVertex with the required one
//Once that step is done or not needed, we add the specific edge to the specific vertex(from).
//IMPORTANT: Since we will deal with EITHER weighted or unweighted, this method is for unweighted. In turn, the edge will be declared a 0 weight. (Possible change for future, make it take -1? in case a 0 cost is an actual measurement)
//FIXED!: no longer need this method as I have now split it into two classes
//  public void addEdge(E from, E to, boolean directed) {
//      if(!map.containsKey(from)) {
//          addVertex(from);
//      }
//      if(!map.containsKey(to)) {
//         addVertex(to);
//      }
//      map.get(from).add(new Edge(to));
//     if(directed == false) {
//         map.get(to).add(new Edge(from));
//      }
//  }

//Exact same addEdge method from before, but we take a cost this time, making the graph weighted.
//The cost will be of type int
public void addEdge(E from, E to, boolean directed, int cost) {
    if(!map.containsKey(from)) {
        addVertex(from);
    }
    if(!map.containsKey(to)) {
        addVertex(to);
    }
    //map.get(from).add(new Edge(to, cost));
    map.get(from).add(new Edge(to, cost));
    if(directed == false) {
        map.get(to).add(new Edge(from, cost));
    }
}


//Returns our list of edges for the given vertice
public ArrayList<Edge> getEdges(E vertice) {
    ArrayList<Edge> edgeList = new ArrayList<Edge>();
    edgeList.addAll(map.get(vertice));

    return edgeList;
}

//Returns a list of all the vertices inside the map
public ArrayList<E> getVertices() {
    ArrayList<E> verticeList = new ArrayList<E>();
    verticeList.addAll(map.keySet());
    return verticeList;
}

//toString method for our map
public String toString() {
    String s = "";
    s = map.toString();
    return s;
}




    public static void main(String[] args) throws Exception {
        WeightedGraph<String> test = new WeightedGraph<>();
        test.addEdge("TestFrom1", "Test1End", true, 5);
        test.addEdge("TestFrom2", "Test2End", true, 7) ;
        System.out.println(test.getEdges("TestFrom1"));
        System.out.println(test.getVertices());
        System.out.println(test);
    }



}

