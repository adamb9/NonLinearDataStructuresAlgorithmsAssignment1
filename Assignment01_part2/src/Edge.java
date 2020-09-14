
public class Edge {

	/**
	* This class implements the elements of the linked-lists in the adjacency
	* lists graph representation. Therefore, the class represents a weighted edge from 
	* the source vertex of an array of linked lists to the destination vertex. 
	*  
	*  										weight
	*  Remember concepts:   source vertex --------> destination vertex
	*/


		 //ATTRIBUTES

		 /*
		  * Destination Vertex 
		  */
		  private int vertex; 

		 /*
		  * The weight of the corresponding edge 
		  */
		 private int weight;

		 // CONSTRUCTOR
		 
		  public Edge (int vertex, int weight) {
		     this.vertex = vertex;
		     this.weight = weight;
		     
		 }
		  
		 public int getWeight(){
			 return this.weight;
		 }
		 
		 public int getVertex(){
			 return this.vertex;
		 }

		 public void setVertex(int vertex){
			 this.vertex= vertex;
			 return;
		 }
		 
		 public void setWeight(int weight){
			  this.weight= weight;
			  return;
		 }
		 
		 // Method toString: The method is used to get a String object representing the Edge
		 public String toString() {
		     return "(" + this.vertex+ ", " +this.weight + ")";
		 }
}
