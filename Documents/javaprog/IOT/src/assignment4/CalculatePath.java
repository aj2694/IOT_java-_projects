package assignment4;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

public class CalculatePath {

	 private List<Vertex> nodes;
	    private List<Edge> edges;
	    LinkedList<Vertex> path;
	    ArrayList<String>locations;

	    public  void testExcute(String source,String dest) {
	        nodes = new ArrayList<Vertex>();
	        edges = new ArrayList<Edge>();
	        locations=new ArrayList<>();
	    	String arr[] ={"Northborough, MA","Edison, NJ","Pittsburgh, PA","Allentown, PABD Strap Endlinksth","Martinsburg, WV","Charlotte, NC","Atlanta, GA","Orlando, FL","Memphis, TN",
        			"Grove City, OH","Indianapolis, IN","Detroit, MI","New Berlin, WI","Minneapolis, MN","St. Louis, MO","Kansas, KS","Dallas, TX","Houston, TX","Denver, CO","Salt Lake City, UT",
        			"Phoenix, AZ","Los Angeles, CA","Chino, CA","Sacramento, CA","Seattle, WA"}   ;     	
        	
	        for(String str:arr)
	        {
	        	locations.add(str);
	        }
	        int sourceinint=locations.indexOf(source);
	        int destinint=locations.indexOf(dest);
	        
	        for (int i = 0; i < 25; i++) {
	        
	            Vertex location = new Vertex("Node_" + i, arr[i]);
	            nodes.add(location);
	        }

	        addLane("Edge_0", 1, 2, 1);
	        addLane("Edge_1", 2, 1, 1);
	        addLane("Edge_2", 1, 3, 1);
	        addLane("Edge_3", 3, 1, 1);
	        addLane("Edge_4", 2, 3, 1);
	        addLane("Edge_5", 3, 2, 1);
	        addLane("Edge_6", 3, 4, 1);
	        addLane("Edge_7", 4, 3, 1);
	        addLane("Edge_8", 4, 5, 1);
	        addLane("Edge_9", 5, 4, 1);
	        addLane("Edge_10", 5, 6, 1);
	        addLane("Edge_11", 6, 5, 1);
	        addLane("Edge_12", 6, 7, 1);
	        addLane("Edge_13", 7, 6, 1);
	        addLane("Edge_14", 7, 8, 1);
	        addLane("Edge_15", 8, 7, 1);
	        addLane("Edge_16", 8, 9, 1);
	        addLane("Edge_17", 9, 8, 1);
	        addLane("Edge_18", 9, 10, 1);
	        addLane("Edge_19", 10, 9, 1);
	        addLane("Edge_20", 10, 11, 1);
	        addLane("Edge_21", 11, 10, 1);
	        addLane("Edge_22", 11, 12, 1);
	        addLane("Edge_23", 12, 11, 1);
	        addLane("Edge_24", 12, 13, 1);
	        addLane("Edge_25", 13, 12, 1);
	        addLane("Edge_26", 13, 14, 1);
	        addLane("Edge_27", 14, 13, 1);
	        addLane("Edge_28", 14, 15, 1);
	        addLane("Edge_29", 15, 14, 1);
	        addLane("Edge_30", 15, 16, 1);
	        addLane("Edge_31", 16, 15, 1);
	        addLane("Edge_32", 16, 17, 1);
	        addLane("Edge_33", 17, 16, 1);
	        addLane("Edge_34", 17, 18, 1);
	        addLane("Edge_35", 18, 17, 1);
	        addLane("Edge_36", 18, 19, 1);
	        addLane("Edge_37", 19, 18, 1);
	        addLane("Edge_38", 19, 20,1);
	        addLane("Edge_39", 20, 19, 1);
	        addLane("Edge_40", 20, 21, 1);
	        addLane("Edge_41", 21, 20, 1);
	        addLane("Edge_42", 21, 22, 1);
	        addLane("Edge_43", 22, 21, 1);
	        addLane("Edge_44", 22, 23, 1);
	        addLane("Edge_45", 23, 22, 1);
	        addLane("Edge_46", 23, 24, 1);
	        addLane("Edge_47", 24, 23, 1);
	        
	        // Lets check from location Loc_1 to Loc_10
	        Graph graph = new Graph(nodes, edges);
	        DijkstraAlgorithm dijkstra = new DijkstraAlgorithm(graph);
	        dijkstra.execute(nodes.get(sourceinint));
	      path = dijkstra.getPath(nodes.get(destinint));

	      
	 /*       for (Vertex vertex : path) {
	            System.out.println(vertex);
	        }*/

	    }

	    private void addLane(String laneId, int sourceLocNo, int destLocNo,
	            int duration) {
	        Edge lane = new Edge(laneId,nodes.get(sourceLocNo), nodes.get(destLocNo), duration );
	        edges.add(lane);
	    }
	    public LinkedList<Vertex> getpath() throws InterruptedException
	    {
	    	return path;
//	    	  for (Vertex vertex : path) {
//		            System.out.println(vertex);
//		            Thread.sleep(10000);
//		            
//		        }

	    }
}
