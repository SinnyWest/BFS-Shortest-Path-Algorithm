/**
 * 
 */
package graphs;

import java.util.ArrayList;

/**
 * @author Dionysios Athanasopoulos
 *
 */
public class AdjacencyList {

	//Attributes.
	ArrayList<Integer>[] graph;

	

	//Constructor.
	@SuppressWarnings("unchecked")
	AdjacencyList( int size ){

		graph = new ArrayList[ size ];
	}


	//Getters.
	ArrayList<Integer>[] getGraph(){

		return graph;
	}


	//Methods.
	void addEdgeInternally( int node, int neighbor ){

		ArrayList<Integer> neighbors = graph[ node ];

		if( neighbors == null ) neighbors = new ArrayList<Integer>();

		neighbors.add( neighbor );

		graph[ node ] = neighbors; 
	}

	void addEdge( int node, int neighbor ){

		addEdgeInternally( node, neighbor );
		addEdgeInternally( neighbor, node );
	}

	void print(){

		for( int i = 0; i < graph.length; ++i ){

			ArrayList<Integer> neighbors = graph[ i ];

			System.out.print( i + ": " );

			for( int j = 0; j < neighbors.size(); ++j ) System.out.print( neighbors.get( j ) + " " );
		
			System.out.println();
		}
	}
	
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {

		AdjacencyList obj = new AdjacencyList( 5 );

		obj.addEdge( 0, 1 );
		obj.addEdge( 0, 4 );

		obj.addEdge( 1, 2 );
		obj.addEdge( 1, 3 );
		obj.addEdge( 1, 4 );

		obj.addEdge( 2, 3 );
	
		obj.addEdge( 3, 4 );

		obj.print();
	}
}
