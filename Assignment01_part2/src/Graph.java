import java.util.LinkedList;

/*
 * A common interface for the Graph ADT, encompassing directed and undirected weighted graphs with integer weights. 
 * The vertex are represented by natural numbers (e.g. 0,1,2,3...), and remain the same after the creation 
 * of an instance of a Graph. Therefore, no vertex can be added or removed after the creation of the graph instance.  
 * The same occurs with the characteristic of being directed or not. A graph can not change this characteristic 
 * after its creation. 
 * Self-loops are allowed.
 * Any method that takes one or more vertex IDs as arguments must throw an IndexOutOfBoundsException
 *  if any input ID is out of bounds. An error message explaining that the vertex does not exist must appear in the screen. 
 */

public interface Graph {
	
  	
    // 1. ABSTRACT METHOD numVerts: Returns the number of vertices in the graph. 
     public int numVerts();
    
     
    /*
     * 2. ABSTRACT METHOD numEdges: Returns the number of edges in the graph.
     *    The result does *not* double-count edges in undirected graphs.
     */
    public int numEdges();
	

    /*
     *  3. ABSTRACT METHOD addEdge: Adds and Edge between vertex v1 and v2 with weight w. 
     *     First parameter: v1, second parameter: v2 and third parameter: w. 
     *     If the edge v1 and v2 already exists with a different weight, it modifies the weight to w.
     *     In undirected graphs both directions of the edge must be represented.  
     */
    public void addEdge(int v1, int v2, int w);
    
    /*
     * 4. ABSTRACT METHOD removeEdge: Removes an edge between vertex v1 and v2.
     *    First parameter: v1, second parameter: v2.
     *    Remember that in undirected graphs both directions of the edge must be removed.
     */    
    public void removeEdge(int v1, int v2);
   
    
	/*
	 * 5. ABSTRACT METHOD hasEdge: Checks whether an edge exists between two vertices. 
	 *    First parameter: v1, second parameter: v2 and third parameter: w. 
	 *    In directed graphs returns true if there is a vertex from a vertex v1 to a vertex v2.
     *    In an undirected graph, this method returns the same as hasEdge from vertex v2 to v1 (opposite order).
     */
    public boolean hasEdge(int v1, int v2);
    
    
    /*
	 * 6. ABSTRACT METHOD getWeightEdge: Returns the weight an edge (if exists) between two vertices.
	 *    If it does not exist, it prints an error message in the screen. 
	 *    First parameter: v1, second parameter: v2
	 *    In directed graphs returns the weight of the edge from the vertex v1 to a vertex v2.
     *    In an undirected graph, this method returns the same as getWeightEdge from vertex v2 to v1 (opposite order).
     */
    public int getWeightEdge(int v1, int v2) ;
    
    
    /*
     * 7. ABSTRACT METHOD getNeighbors: Returns a List of the neighbors of
     *    the specified vertex v (equivalent to the out-degree/out-edges of the vertex v.
     *    In particular, the vertex u is included in the list if and only if there is an edge from v to u in the graph.
     */
     public LinkedList getNeighbors(int v);
    
     /*
 	  * 8. ABSTRACT METHOD getDegree: Returns the degree of the specified vertex v.
      *    In undirected graphs the degree is equal to the sum of the in-degree and the out-degree
      *    The result does *not* double-count edges in undirected graphs.
      */
     public int getDegree(int v);
    
     
     // 9. ABSTRACT METHOD toString: The method is used to get a String object representing the graph.
     //You have freedom for representing the string that describes the graph, but it should contain:
     // all its vertices, all its edges and their weights.
     public String toString();
    
}