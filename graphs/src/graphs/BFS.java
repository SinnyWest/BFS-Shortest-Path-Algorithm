/**
 * 
 */
package graphs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Dionysios Athanasopoulos
 * @author westsere
 *
 */
public class BFS {

	/**
	 * @param sourceNode source node that traversal starts from
	 * @param targetNode target node that traversal ends at
	 * @param obj adjacency list for nodes in graph
	 * @return result object containing the node traversal path, and length of path
	 */

	public static Result find( int sourceNode, int targetNode, AdjacencyList obj ){

		boolean[] visited = new boolean[ obj.getGraph().length ];

		int[] previousNodes = new int[ obj.getGraph().length ];

		Queue<Integer> queue = new LinkedList<Integer>();

		queue.add( sourceNode );

		while( ! queue.isEmpty() ){

			int currentNode = queue.remove();

			ArrayList<Integer>[] graph = obj.getGraph();

			ArrayList<Integer> neighbors = graph[ currentNode ];

			if( visited[ currentNode ] ) continue;

			visited[ currentNode ] = true;

			System.out.println( currentNode );

			if( currentNode == targetNode) break;

			try {
				for( int i = 0; i < neighbors.size(); i++ ){

					if( ! visited[ neighbors.get( i ) ] && ! queue.contains( neighbors.get( i ) ) ) {

						queue.add( neighbors.get( i ) );

						previousNodes[neighbors.get(i)] = currentNode;
					}
				}
			} catch (Exception e) {

				System.out.println("There are no nodes in the graph.");
			}
		}	
		ArrayList<Integer> path = new ArrayList<>(); // List of nodes that make up traversal path

		path.add(targetNode); // adds target node to path

		int pointer = targetNode; // pointer is variable that traverses "previousNodes" array, initialized as targetNode
		
		try {
			while(pointer != sourceNode) { // while pointer doesn't equal sourceNode, zig-zags up array to find traversal path.

				path.add(previousNodes[pointer]); // adds value at index pointer to path

				pointer = previousNodes[pointer]; // pointer becomes value at index pointer
			}
		} catch (Exception e) {
			
			System.out.println("Target node not in graph.");
		}
		Collections.reverse(path);

		int counter = path.size()-1;

		Result result = new Result(path, counter);

		return result;
	}
	
	public static void main(String[] args) {

		AdjacencyList obj = new AdjacencyList( 6 ); 

		System.out.println("---- Graph (START) ----" );

		obj.addEdge( 0, 1 );
		obj.addEdge( 0, 2 );
		obj.addEdge( 2, 3 );
		obj.addEdge( 2, 4 );
		obj.addEdge( 3, 5 );
		obj.addEdge( 4, 5 );
		obj.print();

		System.out.println("---- Graph (END) ----" );

		System.out.println("---- Traversal (START) ----" );
		
		Result r = find( 0 , 4, obj );

		System.out.println("---- Traversal (END) ----" );
		
		r.print();
	}

}
