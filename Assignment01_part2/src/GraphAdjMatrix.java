//NAME: ADAM BALDWIN
//STUDENT NUMBER: R00176025


import java.util.LinkedList;

/*
 *  Implementation of the interface Graph with adjacency matrix.
*/

 
public class GraphAdjMatrix implements Graph{

	// ATTRIBUTES: 
	private int numVertices;
	private int numOfEdges;
    private boolean directed;
    private int adjMatrix[][];
    private int weightMatrix[][];
    private LinkedList<Integer> neighbours = new LinkedList<Integer>();
 
    
    // CONSTRUCTOR: Creates a directed/undirected graph with V vertices and no edges
    public GraphAdjMatrix(int numVertices, boolean directed) {
    	this.numVertices = numVertices;
    	this.directed = directed;
        adjMatrix = new int[numVertices][numVertices];
        weightMatrix = new int[numVertices][numVertices];
    }


    // 1. IMPLEMENTATION METHOD numVerts: 
	  //Returns the numVerts counter variable
    public int numVerts() { 
    	return numVertices;
    }
    
   
    // 2. IMPLEMENTATION METHOD numEdges:
	  //Returns the numOfEdges counter variable
    public int numEdges() { 
    	return numOfEdges;
    }


   //  3. IMPLEMENTATION METHOD addEdge:
    //Checks if the edge exists and a boolean to control the creation of a new edge
    //If it does not exist, create the new edge and add it to the adjacency matrix. Add the correct weight to the weightMatrix at the same position
    public void addEdge(int v1, int v2, int w) {
    	if(hasEdge(v1,v2) == false) {
    		adjMatrix[v1][v2] = 1;
        	weightMatrix[v1][v2] = w;
            if(directed == false) {
            	adjMatrix[v2][v1] = 1;
            	weightMatrix[v2][v1] = w;
            }
        numOfEdges++;
    	}
    	
        
    }
    
   // 4. IMPLEMENTATION METHOD removeEdge:
    //Sets the value of the adjMatrix and weightMatrix at the specified edge to 0, effectively removing the edge.
    //Reduces the counter by 1
   public void removeEdge (int v1, int v2)
   {
	    adjMatrix[v1][v2] = 0;
   		weightMatrix[v1][v2] = 0;
   		if(directed == false) {
        	adjMatrix[v2][v1] = 0;
        	weightMatrix[v2][v1] = 0;
        }
   		numOfEdges--;
   }

    // 5. IMPLEMENTATION METHOD hasEdge:
    //Checks to see if the value in the adjMatrix is 1.
    //If it is, this means the edge exists
    //If the graph is directed, it also checks the opposite direction for that edge
    public boolean hasEdge(int v1, int v2) {
        boolean ans = false;
        if(adjMatrix[v1][v2] == 1) {
        	ans = true;
        }
        if(directed == false) {
        	if(adjMatrix[v2][v1] == 1) {
            	ans = true;
            	}
        }
        
        return ans;
    }
    
    // 6. IMPLEMENTATION METHOD getWeightEdge:
    //Checks to see if the edge exists and if it does, gets the weight at that index
	public int getWeightEdge(int v1, int v2) {
		int edge = 0;
		if(hasEdge(v1,v2) == true) {
			edge = weightMatrix[v1][v2];
		}
		return edge;
	}

    
	// 7. IMPLEMENTATION METHOD getNeighbors:
	//loops through the adjMatrix for a specific vertex v and gets adds all positions where it equals to 1 (i.e where an edge exists)
	public LinkedList<Integer> getNeighbors(int v)
	{
    	for(int i=0;i<numVertices;i++) {
    		if(adjMatrix[v][i] == 1) {
    			neighbours.add(i);
    		}
    	}
    	return neighbours;
	}
   	
	// 8. IMPLEMENTATION METHOD getDegree:
	public int getDegree(int v) 
	{
	   int degree = getNeighbors(v).size();
	   
	   return degree;
	}
	

	// 9. IMPLEMENTATION METHOD toString:
   	public String toString()
    {
   		String output = "";
        for (int i = 0; i < numVertices; i++) {
        	output += "\n";
            for (int j = 0; j <numVertices ; j++) {
                output += (adjMatrix[i][j]+ " ");
            }
        }
        
        
        return output;

    }    
}