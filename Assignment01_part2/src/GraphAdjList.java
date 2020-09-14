//NAME: ADAM BALDWIN
//STUDENT NUMBER: R00176025


import java.util.LinkedList;
import java.util.Iterator;

	/**
	* Graph implementation that uses Adjacency Lists to store edges. It
	* contains one linked-list for every vertex i of the graph. The list for i
	* contains one instance of VertexAdjList for every vertex that is adjacent to i.
	* For directed graphs, if there is an edge from vertex i to vertex j then there is
	* a corresponding element in the adjacency list of node i (only). For
	* undirected graphs, if there is an edge between vertex i and vertex j, then there is a
	* corresponding element in the adjacency lists of *both* vertex i and vertex j. The
	* edges are not sorted; they contain the adjacent nodes in *order* of
	* edge insertion. In other words, for a graph, the node at the head of
	* the list of some vertex i corresponds to the edge involving i that was
	* added to the graph least recently (and has not been removed, yet). 
	*/

	public class GraphAdjList  implements Graph {

	// ATTRIBUTES: 
	    
		private int numVertices;
		private int numOfEdges;
		private boolean directed;
		LinkedList<Edge> adjacencyList[];
		
	 /*
	  * CONSTRUCTOR: Creates a directed/undirected graph with V vertices and no edges.
	  * It initializes the array of adjacency edges so that each list is empty.
	  */
	    
	 public GraphAdjList(int numVertices, boolean directed) {
		this.numVertices = numVertices;
	    this.directed = directed;
	    adjacencyList = new LinkedList[numVertices];
        //initialize adjacency lists for all the vertices
        for (int i = 0; i <numVertices ; i++) {
            adjacencyList[i] = new LinkedList<>();
        }

	 }

	 
	  // 1. IMPLEMENTATION METHOD numVerts: 
	  //Returns the numVertices counter variable
	  public int numVerts() { 
		  return numVertices;
     
     }

	  // 2. IMPLEMENTATION METHOD numEdges:
	  //Returns the numEdges counter variable
	  public int numEdges() { 
	    return numOfEdges;
	    
	 }

	    
	  //  3. IMPLEMENTATION METHOD addEdge:
	  //Checks if the edge exists and uses the "exists" boolean control the creation of a new edge
	  //If it exists, change the weight of the edge
	  //If it does not exist, create the new edge and add it to the appropriate adjacency list
	  public void addEdge(int v1, int v2, int w) {
		boolean exists = false;
		for(int i=0;i<numVertices;i++) {
			 LinkedList<Edge> list = adjacencyList[i];
			 for (int j = 0; j <list.size() ; j++) {
                 int vertex = list.get(j).getVertex();
                 if(i==v1 && vertex==v2) {
                	 exists = true;
                	 list.get(j).setWeight(w);
                 }
             }
		 }
		if(exists == false) {
			Edge edge = new Edge(v2, w);
			adjacencyList[v1].add(edge);
			if(directed == false) {
				Edge edge2 = new Edge(v1, w);
				adjacencyList[v2].add(edge2);
				numOfEdges++;
			}
			numOfEdges++;
		}
		
		
    }
	  
	 // 4. IMPLEMENTATION METHOD removeEdge: 
	  //Remove the edge from the adjacency list at position v1 and reduce the number of edges on the numOfEdges counter
	 public void removeEdge(int v1, int v2) {
		adjacencyList[v1].remove();
		numOfEdges--;
	 }
	 
	 // 5. IMPLEMENTATION METHOD hasEdge:
	 //Loops through the adjacency lists to see if the edge already exists
	 //If it does, return true
	 public boolean hasEdge(int v1, int v2) {
		 boolean ans = false;
		 for(int i=0;i<numVertices;i++) {
			 LinkedList<Edge> list = adjacencyList[i];
			 for (int j = 0; j <list.size() ; j++) {
                 int vertex = list.get(j).getVertex();
                 if(i==v1 && vertex==v2) {
                	 ans=true;
                 }
             }
		 }
		 
		 
		 
		 return ans;
	 }

	// 6. IMPLEMENTATION METHOD getWeightEdge:
	//Loops through the adjacency lists to find the correct edge and then return the weight of that edge
	 public int getWeightEdge(int v1, int v2) {
		 int weight = 0;
		 for(int i=0;i<numVertices;i++) {
			 LinkedList<Edge> list = adjacencyList[i];
			 for (int j = 0; j <list.size() ; j++) {
                 int vertex = list.get(j).getVertex();
                 if(i==v1 && vertex==v2) {
                	 weight = list.get(j).getWeight();
                 }
			 }
		}
		 return weight;
	 }

	// 7. IMPLEMENTATION METHOD getNeighbors:
	 //Returns the adjacency list connected to vector v in the larger adjacency list.
	 //This contains all of the other vectors connected to vector v
	 public LinkedList getNeighbors(int v) {
		 LinkedList<Edge> neighbours = adjacencyList[v];
		 
		 return neighbours;
	 }

    // 8. IMPLEMENTATION METHOD getDegree:
	public int getDegree(int v) {
		int degree = adjacencyList[v].size();
		return degree;
	}

	// 9. IMPLEMENTATION METHOD toString:
	 public String toString() {
		 String output = "";
		 for (int i = 0; i <numVertices ; i++) {
             LinkedList<Edge> list = adjacencyList[i];
             for (int j = 0; j <list.size() ; j++) {
                 output += ("vertex " + i + " --> " + list.get(j).getVertex() + "	weight: " +  list.get(j).getWeight() + "\n");
             }
         }
		 return output;
	 }

	}


