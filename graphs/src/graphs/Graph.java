package graphs;

import java.util.ArrayList;

/**
 * @author Dionysios Athanasopoulos
 *
 */
public class Graph {

	Object graph;

	int getLength(){

		if( graph instanceof AdjacencyList) {

			
			return ((AdjacencyList) graph).graph.length;
		}


		return -1;
	}

	ArrayList<Integer> getNeigbors( int node ){

		if( graph instanceof AdjacencyList) {

			
			return ((AdjacencyList) graph).graph[node];
		}


		return null;
	}
}
