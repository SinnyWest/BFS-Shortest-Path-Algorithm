package graphs;

import java.util.ArrayList;

/**
 * 
 * @author westsere
 *
 */
public class Result {
	
	// Fields
	private ArrayList<Integer> path;
	
	private int length;
	
	// Constructor
	public Result(ArrayList<Integer> traversalPath, int pathLength) {
		
		path = traversalPath;
		
		length = pathLength;
	}
	
	/**
	 * prints node path and length of path through traversal of graph
	 */
	public void print() {
		
		System.out.println("Path from source to target node: " + path);
		System.out.println("Length of path: " + length);
	}

}
