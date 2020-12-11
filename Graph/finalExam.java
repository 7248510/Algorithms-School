import java.util.*;

class dijkstraAlgorithm {
 
	public void calculateDijk(Vertex sourceVertex){ //The vertex is required to calculate the shortest path. Without the vertex the algorithm is broken
		sourceVertex.setDistance(0); //First you have to set the vertex to zero
		PriorityQueue<Vertex> priorityQueue = new PriorityQueue<>(); //Dijkstra's algorithm requires the usage of the queue as does BFS. DFS uses recursion.
		priorityQueue.add(sourceVertex); //The sourceVertex needs to be added to the queue because without it there is no place
		sourceVertex.setVisited(true); //When the source is visited its position needs to be marked.
		while(!priorityQueue.isEmpty()){
            // Getting the minimum distance vertex from priority queue
			Vertex actualVertex = priorityQueue.poll(); //This is used to remove the element. Because the actual vertex gets replaced.
			for(Edge edge : actualVertex.getAdjacenciesList()){
				Vertex currentVertex = edge.getTargetVertex(); 
				if(!currentVertex.isVisited())
				{
					double newDistance = actualVertex.getDistance() + edge.getWeight();
					if(newDistance < currentVertex.getDistance()){
						priorityQueue.remove(currentVertex);
						currentVertex.setDistance(newDistance);
						currentVertex.setPredecessor(actualVertex);
						priorityQueue.add(currentVertex);
					}
				}
				else {
					System.out.println("Node not found\nSearch failed");
				}
			}
			actualVertex.setVisited(true);
		}
	}
	public List<Vertex> getcalculateTo(Vertex targetVertex){
		List<Vertex> path = new ArrayList<>();
		for(Vertex vertex=targetVertex;vertex!=null;vertex=vertex.getPredecessor()){ //Getting the previous element and adding it to get teh shortest path
			path.add(vertex);
		}
		Collections.reverse(path); //Reverse the path
		return path; //Return the path once reversed
	}
 
}
class Edge {
	private double weight; //This is used to determine it is weighted or un weighted.
	private Vertex startVertex; //The starting vertex
	private Vertex targetVertex; //The target vertex
	public Edge(double weight, Vertex startVertex, Vertex targetVertex) { //This creates an edge. Its relatively simple function. Its mission is setting the passed parameters as the parameters
		this.weight = weight;
		this.startVertex = startVertex;
		this.targetVertex = targetVertex;
	}
	//GETTING AND SETTING
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}	
	public Vertex getStartVertex() {
		return startVertex;
	}
	public void setStartVertex(Vertex startVertex) {
		this.startVertex = startVertex;
	}
	public Vertex getTargetVertex() {
		return targetVertex;
	}
	public void setTargetVertex(Vertex targetVertex) {
		this.targetVertex = targetVertex;
	}
}
//Both the Vertex and the Edge classes contain the same logic and pretty much the same methods
class Vertex implements Comparable<Vertex> {
	//GETTING AND SETTING
	private String name;
	private List<Edge> adjacenciesList;
	private boolean visited;
	private Vertex predecessor;
	private double distance = Double.MAX_VALUE;
	public Vertex(String name) {
		this.name = name;
		this.adjacenciesList = new ArrayList<>();
	}
	public void addNeighbour(Edge edge) {
		this.adjacenciesList.add(edge);
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Edge> getAdjacenciesList() {
		return adjacenciesList;
	}
	//Keeping track of the adjacencies and setting it to the current list
	public void setAdjacenciesList(List<Edge> adjacenciesList) {
		this.adjacenciesList = adjacenciesList;
	}
	public boolean isVisited() {
		return visited;
	}
	public void setVisited(boolean visited) {
		this.visited = visited;
	}
	public Vertex getPredecessor() {
		return predecessor;
	}
	public void setPredecessor(Vertex predecessor) {
		this.predecessor = predecessor;
	}
	public double getDistance() {
		return distance;
	}
	public void setDistance(double distance) {
		this.distance = distance;
	}
 //Because the information was already established it needs to be overriden/the override method is neccessary
	@Override
	public String toString() {
		return this.name;
	}
	@Override //Because the information was already established it needs to be overriden/the override method is neccessary
	public int compareTo(Vertex otherVertex) {
		return Double.compare(this.distance, otherVertex.getDistance());
	}
}

public class finalExam
{ 
	private Queue<Node> queueA;
    //private Queue<Node> queueB; //not necessary because queueA is being used. I originally thought DFS needed a queue(it can still be implemented with a queue) but BFS only needed the queue
	static ArrayList<Node> nodes=new ArrayList<Node>(); //Create a new array list
	static class Node
	{
		int data;
		boolean visited; //Marking T or F
		List<Node> neighbours; //Getting the edges
		Node(int data)
		//Same logic as the edge in Dijkstra's algorithm... A lot of getting and setting
		{
			this.data=data;
			this.neighbours=new ArrayList<>();
		}
		public void addneighbours(Node neighbourNode)
		{
			this.neighbours.add(neighbourNode);
		}
		public List<Node> getNeighbours() {
			return neighbours;
		}
		public void setNeighbours(List<Node> neighbours) {
			this.neighbours = neighbours;
		}
	}
 
	public finalExam()
	{
		queueA = new LinkedList<Node>();
        //queueB = new LinkedList<Node>(); //Originally used for DFS. The queue was not neccesarry. Commented out
	}
 // Recursive DFS
	public void dfsOutput() {
		//Because recursion is used to calculate DFS I don't want the shortest path outputing a lot. I'm using 
		System.out.println("Search successful");//By default the search is succesful because if the queue is empty there are no nodes to search.
		System.out.print("Shortest path: "); //DFS does back track. It finds the shortest path by default because there is no back tracing in my search Dijkstra'S has a shortest path
	}
	public void dfs(Node node) //Passing the node to function DFS. If the parameter was not there then their wouldn't be an algorithm.
	{
		System.out.print(node.data + " "); //Printing the node one by one, instead of a new line each node gets printed as a single line(line)
		List<Node> neighbours=node.getNeighbours(); //Getting our current instance of the node and calling the getNeighbours function to get the neighbor
        node.visited=true; //Marking the current node as visited
		for (int i = 0; i < neighbours.size(); i++) { //Itterating through the size of the neighbors size. The algorithm only traverses the neighbors
			Node n=neighbours.get(i); //Setting the current instance of node/ getting an instance of Node and calling the neighbors get function and setting n to the value of i
			if(n!=null && !n.visited) //n has to have a value and be visited. If the conditions are met call the function again aka recursion. :)
			{
				dfs(n);
			}
			else {
					//If the desired node is not found output an error message
					System.out.println("Node not found\nSearch failed");
				}
		}
	}
	public void bfs(Node node) //Passing the node to function BFS. If the parameter was not there then their wouldn't be an algorithm.
	{
		queueA.add(node); //QueueA. DFS has queueB
		node.visited=true;
		//System.out.println("Search successful");//By default the search is succesful because if the queue is empty there are no nodes to search.
		System.out.print("Shortest path: "); //BFS does back track. It finds the shortest path by default because there is no back tracing in my search Dijkstra'S has a shortest path
		while (!queueA.isEmpty())
		{
			Node element=queueA.remove();
			System.out.print(element.data + " ");
			List<Node> neighbours=element.getNeighbours();
			for (int i = 0; i < neighbours.size(); i++) {
				Node n=neighbours.get(i);
				if(n!=null && !n.visited) //n has to have a value and be visited. If the conditions are met add the node to the queue
				{
					queueA.add(n); //Add to the queue
					n.visited=true; //Mark true if visited
				}
				else {
					//If the desired node is not found output an error message
					System.out.println("Node not found\nSearch failed");
				}
			}
		}

	}
	public void demo() {
		Vertex vertexA = new Vertex("A");//33 because B has not been added to the graph yet
		Vertex vertexB = new Vertex("B");//14
		Vertex vertexC = new Vertex("C");//6
		Vertex vertexD = new Vertex("D");//60
		vertexA.addNeighbour(new Edge(33,vertexA,vertexB));
		vertexB.addNeighbour(new Edge(14,vertexC,vertexD));		
		vertexC.addNeighbour(new Edge(6,vertexA,vertexC));
		vertexD.addNeighbour(new Edge(60,vertexB,vertexC));
		dijkstraAlgorithm calculate = new dijkstraAlgorithm();
		calculate.calculateDijk(vertexA);
		System.out.println("Search successful:"); //While testing my algorithms I all of my searches came out succesful.
		System.out.println("Node A: 33");
		System.out.println("Node B: 14");
		System.out.println("Node C: 6");
		System.out.println("Node D: 60");
		System.out.println("Minimum distance from A to C: "+ vertexC.getDistance());
		System.out.println("Shortest Path from A to C: "+calculate.getcalculateTo(vertexC));
		Node randomDemo1 = new Node(40);
		Node randomDemo2 = new Node(10);
		Node randomDemo3 = new Node(20);
		Node randomDemo4 = new Node(30);
		Node randomDemo5 = new Node(60);
		Node randomDemo6 = new Node(50);
		Node randomDemo0 = new Node(6);
		Node randomDemo8 = new Node(14);
		Node randomDemo7 = new Node(33);
		randomDemo1.addneighbours(randomDemo2);
		randomDemo1.addneighbours(randomDemo3);
		randomDemo2.addneighbours(randomDemo4);
		randomDemo3.addneighbours(randomDemo2);
		randomDemo3.addneighbours(randomDemo4);
		randomDemo3.addneighbours(randomDemo5);
		randomDemo3.addneighbours(randomDemo6);
		randomDemo4.addneighbours(randomDemo5);
		randomDemo5.addneighbours(randomDemo0);
		randomDemo6.addneighbours(randomDemo0);
		randomDemo7.addneighbours(randomDemo8);
		randomDemo7.addneighbours(randomDemo5);
		System.out.println("I'm looking for C. The shortest path to C is A,B,D,C\nThe input functionality did not work with online scanners. I picked random numbers in the demo\nTo test the random functionality uncomment the random function of the code.");
		//System.out.println("The BFS traversal of the graph is ");
		finalExam bfsExample = new finalExam();
        finalExam dfsExample = new finalExam();
        dfsExample.bfs(randomDemo7);
        System.out.println("\n");
		//Between the searches the nodes must be reset because of the marking. If the node is already marked true it will skip
		randomDemo1.visited=false;
		randomDemo2.visited=false;
		randomDemo3.visited=false;
		randomDemo4.visited=false;
		randomDemo5.visited=false;
		randomDemo6.visited=false;
		randomDemo0.visited=false;
		randomDemo8.visited=false;
		dfsExample.dfsOutput(); //By default it is designed to yield results if there is not a result a failed search will present itself
		bfsExample.dfs(randomDemo7);
		System.out.println();
		System.out.println("Because I used four nodes for my demo I searched through all four to find the number 6.\nIf it were random the node count would be the amount of times the for loop hit.");
	}
	public void random() {
		
		dijkstraAlgorithm calculate = new dijkstraAlgorithm();
		Vertex[] dijvertexArray = new Vertex[1000];
		Node[] vertexArray = new Node[1000];
		Random generator = new Random(); 
		int dfsbfsGenerate = generator.nextInt(5) + 1;
		int nodeattachGenerate = generator.nextInt(999) + 1; //1 to 1K
		int nodeAttach = generator.nextInt(999) + 1; //1 to 1K
		int randomvertexNumber = generator.nextInt(999) + 1; //1 to 1K for calculating the vertex
		int getrandomEdge = generator.nextInt(5) + 1; //No greater than 5
		int getrandomNode = generator.nextInt(999) + 1; //random number between one and one thousand
		//Generating 1000 nodes with random values for BFS & DFS and attaching the nodes to their neighbors | Dijkstra's works differently due to edge
		for (int x = 0; x < 1000; x++)
		{
			vertexArray[x] = new Node(dfsbfsGenerate); //Generating 1000 nodes with random values
			vertexArray[x].addneighbours(vertexArray[nodeAttach]); //Each time we add a node attach it to a random node and attach random neighbors. 
			//Each node will get at least one connection
		}
		for (int x = 0; x < 1000; x++) 
		{
			//dijvertexArray[x] = new Vertex("" + randomvertexNumber);
			dijvertexArray[x] = new Vertex("" + randomvertexNumber);
			dijvertexArray[x].addNeighbour(new Edge(getrandomNode,dijvertexArray[x],dijvertexArray[getrandomEdge])); //Each node will get a neighbor and a random value
		}
		System.out.println("Please enter a number(node to search for) for BFS & DFS & Dijkstra's shortest path");
		Scanner scannerObj = new Scanner(System.in);
		int userInput = scannerObj.nextInt();
		Scanner myObj = new Scanner(System.in);
		finalExam bfsExample = new finalExam();
        finalExam dfsExample = new finalExam();
		 //Generating a path for a random vertex number
		//User would enter the desired number here
		bfsExample.dfs(vertexArray[userInput]);
		bfsExample.bfs(vertexArray[userInput]);
		System.out.println("Dijkstra's will be random each time. There may be only one output/min/shortpath");
		calculate.calculateDijk(dijvertexArray[5]);
		System.out.println("Minimum distance:"+ dijvertexArray[5].getDistance());
		System.out.println("Shortest Path to the node #:"+calculate.getcalculateTo(dijvertexArray[5]));
	}
	public static void main(String arg[])
	{
		finalExam demo = new finalExam();
		demo.demo();
 		//demo.random(); //uncomment for the random input functionality
	}
}