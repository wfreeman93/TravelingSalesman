import java.io.*;
import java.util.*;


public class ParseGL {

public static WeightedGraph main() throws Exception {
    System.out.println("Please type in the exact path of the file that you wish to parse");
    Scanner scanner = new Scanner(System.in);
    String filePath = scanner.nextLine();
    File file = new File(filePath);
    Scanner scannerFile = new Scanner(file);
    String headerString = scannerFile.nextLine();
    String[] header = headerString.split("\\s+"); //based on our files, 0 position is directed or undirected, 1 position is weighted or unweighted int i = 0;
    boolean isDirected = false;
    boolean isWeighted = false;

    //statements that will declare what type of graph we have
    if(header[0].equals("directed")) {
        isDirected = true;
    }
    if(header[1].equals("weighted")) {
        isWeighted = true;
    }
    //variables for either graph type, will only work with the one that is selected in the header
    WeightedGraph<String> WeightedGraph = new WeightedGraph<>();
   // UnweightedGraph<String> UnweightedGraph = new UnweightedGraph<>();

    if(isWeighted) {
        while(scannerFile.hasNextLine()) {
            String s = scannerFile.nextLine();
            String[] array = s.split("=");
            WeightedGraph.addEdge(array[0], array[1], isDirected, Integer.parseInt(array[2]));
    }
}
//     if(!isWeighted) {
//     while(scannerFile.hasNextLine()) {
//         String s = scannerFile.nextLine();
//         String[] array = s.split("=");
//         UnweightedGraph.addEdge(array[0], array[1], isDirected);
//     }
// }


    //Printing out our headers, and then our graph, confirmed working and tested with each file given for assignment
  System.out.println(header[0] + " " + header[1]);
//   if(!isWeighted) {
//       System.out.println(UnweightedGraph);
//   } else 
    if(isWeighted) {
      System.out.println(WeightedGraph);
      
  }

    scanner.close();
    scannerFile.close();
    return WeightedGraph;
    }
    
    }


