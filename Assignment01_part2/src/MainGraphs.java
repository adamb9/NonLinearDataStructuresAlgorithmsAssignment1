 import java.util.LinkedList;
import java.util.Scanner;

public class MainGraphs {

	
	//-------------------------------------
	//	select_option function
	//-------------------------------------		
	public static int select_option(){
		Scanner sc = new Scanner(System.in);
		int option = 0;
			
		System.out.println("--------------------------------------------------");
		System.out.println("	Select Concrete ADT myGraph Implementation");
		System.out.println("--------------------------------------------------");
		System.out.println("1. Adjacency Matrix - directed graph");
		System.out.println("2. Adjacency Matrix - undirected graph");
		System.out.println("3. Adjacency List - directed graph");
		System.out.println("4. Adjacency List - undirected graph");
		
		boolean selected = false;
		
		while (selected == false){
			System.out.println("Please enter an option");
			try {
				option = sc.nextInt();
				sc.nextLine();
				if ((option >= 1) && (option <= 4))
					selected = true;
				else
					System.out.println("Sorry but the option must be 1..4");
			}
			catch (Exception e) {
				System.out.println("Sorry you did not enter a valid option");
				sc.next();
			}		
		}
		sc.close();
		System.out.println("");
		return option;
	}
	
     	//-------------------------------------
		//	MAIN method 
		//-------------------------------------	
		public static void main(String[] args) {
			int mode = select_option();
			int V= 5; // number of vertices 
			
			//-------------------------------------
			//	1. We create a Graph 
			//-------------------------------------
			System.out.println("TEST 1: We create a graph");
			
			Graph m = null;
			
			switch(mode){
			case 1: 
				m = new GraphAdjMatrix(V, true); //--> we choose to follow the implementation Adjacency Matrix - directed Graph
				break;
			case 2: 	
				m = new GraphAdjMatrix(V, false);  // ->  we choose to follow the implementation Adjacency Matrix - undirected Graph
				break;
			case 3: 
				m = new GraphAdjList(V, true); //--> we choose to follow the implementation Adjacency List - directed Graph
				break;
			case 4: 	
				m = new GraphAdjList(V, false);  // ->  we choose to follow the implementation Adjacency List  - undirected Graph
				break;
			}
			
			System.out.println("Graph:\n" + m.toString()); //--> The current graph created initially empty
			
			//-------------------------------------
			//	2. Add edges
			//-------------------------------------
			System.out.println("TEST 2: We add edges to the graph");
			m.addEdge(1,3,1);
			m.addEdge(1,4,2);
			m.addEdge(2,3,7);
			m.addEdge(1,3,4);
			m.addEdge(4,0,8);
			m.addEdge(2,2,1); 
			//m.addEdge(5,5,5); // -> Fails
			System.out.println("Graph:\n" + m.toString()); //--> The current graph created initially empty

			//-------------------------------------
			//	3. Get details of the graph 
			//-------------------------------------		
			System.out.println("TEST 3: We get the details of the graph");
			System.out.println("Graph Vertices: " + m.numVerts()); 
			System.out.println("Graph Edges: " + m.numEdges()); 
			System.out.println(" ");
			
			//-------------------------------------
			//	4. has_edge & get_Weight
			//-------------------------------------		
			System.out.println("TEST 4: Testing has_edge & get_Weight");
			System.out.println("Is there an edge from vertex 1 to vertex 4? " + m.hasEdge(1,4)); 
			System.out.println("What is the weight of the Edge from 2 to 3? " + m.getWeightEdge(2,3)); 
			System.out.println("Is there an edge from vertex 4 to vertex 1? " + m.hasEdge(4,1)); 
			System.out.println("What is the weight of the Edge from 0 to 3? " + m.getWeightEdge(0,3)); 
			System.out.println(" ");	
		
			//-------------------------------------
			//	5. Get degree & neighbours
			//-------------------------------------		
			System.out.println("TEST 5: Testing the degree and neighbours of a vertex");
		    System.out.print("Neighbors of vertex 4:["); 
			LinkedList  neighbors = (LinkedList) m.getNeighbors(4);
			for (int i=0; i<neighbors.size(); i++)
				System.out.print(neighbors.get(i).toString() + ", "); 
			System.out.println(" ]");	
			System.out.println("Degree of vertex 4: " + m.getDegree(4)); 
			System.out.println("Degree of vertex 3: " + m.getDegree(3)); 
			System.out.println(" ");	
			
			//-------------------------------------
			//	7. Remove edges 
			//-------------------------------------	
			System.out.println("TEST 6: Remove edges:");
			m.removeEdge(1,3); 
			m.removeEdge(2,3); 
			//m.removeEdge(5,5); // -> Fails
			System.out.println("Graph:\n" + m.toString());
			
			//-------------------------------------
			//	8. Get details of the graph 
			//-------------------------------------		
			System.out.println("TEST 7: We get the details of the graph");
			System.out.println("Graph Vertices: " + m.numVerts()); 
			System.out.println("Graph Edges: " + m.numEdges()); 
			System.out.println(" ");
		}
			
	}



