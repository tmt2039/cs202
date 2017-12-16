package dataStructure;

class Underflow extends Exception {
	public Underflow() {
		super();
	}

	public Underflow(String msg) {
		super(msg);
	}
}

class Overflow extends Exception {
	public Overflow() {
		super();
	}

	public Overflow(String msg) {
		super(msg);
	}
}

interface UnboundedStackInterface<data> {

	String push(String startVertex) throws Overflow;

	String top(String vertex) throws Underflow;

	void pop() throws Underflow;

	boolean isEmpty();

}

class QueueNode<data> {

	protected QueueNode<data> front;
	protected QueueNode<data> rear;
	private QueueNode link;
	private data info;

	public QueueNode(data info) {
		this.info = info;
		link = null;
		front = null;
		rear = null;
	}

	public QueueNode<data> getFront() {
		return front;
	}

	public void setFront(QueueNode<data> front) {
		this.front = front;
	}

	public QueueNode<data> getRear() {
		return rear;
	}

	public void setRear(QueueNode<data> rear) {
		this.rear = rear;
	}

	public data getInfo() {
		return info;
	}

	public void setInfo(data info) {
		this.info = info;
	}

	public QueueNode getLink() {
		return link;
	}

	public void setLink(QueueNode link) {
		this.link = link;
	}
}

class LinkedUnboundQueue<data> implements UnboundedQueueInterface<data> {
	int numElements;
	QueueNode<data> front, rear;
	data element;

	@Override
	public boolean isEmpty() {
		return (numElements == 0);
	}

	/** Returns true if the queue is full, otherwise returns false */
	public boolean isFull() {
		System.out.println("numElements == 7");
		return (numElements == 7);
	}

	@Override
	public String dequeue() throws Underflow {
		if (isEmpty())
			throw new Underflow("Dequeue attempted on empty queue.");

		else {
			element = front.getInfo();
			front = front.getLink();
			if (front == null)
				rear = null;
		}

		return (String) element;
	}

	@Override
	public void enqueue(data element) {
		System.out.println("vertex in Linked Unbound Queue ");
		QueueNode<data> newNode = new QueueNode<data>(element);

		if (rear == null)
			front = newNode;

		else
			rear.setLink(newNode);

		rear = newNode;
	}
}

class LinkedStack<data> implements UnboundedStackInterface<data> {
	private int length = 7;
	private int topIndex = -1;
	private String[] stack = new String[length];

	/** Returns true if this stack is empty, otherwise returns false */
	@Override
	public boolean isEmpty() {
		if (topIndex == -1) {
			System.out.println("Linked stack is empty.");
			return true;
		} else
			System.out.println("Linked stack is empty.");
		return false;
	}

	/** Returns true if this stack is full, otherwise returns false. */
	public boolean isFull() {
		if (topIndex == (stack.length - 1)) {
			System.out.println("Stack is full. ");
			return true;
		} else
			System.out.println("Stack is not full. ");
		return false;
	}

	@Override
	public String push(String element) throws Overflow {
		if (!isFull()) {
			topIndex++;
			stack[topIndex] = element;
			System.out.println("stack[topindex]= " + stack[topIndex]);
		} else
			System.out.println("Push attempted on a full stack.");
		return element;
	}

	@Override
	public String top(String vertex) throws Underflow {
		data topOfStack = null;

		if (!isEmpty()) {
			topOfStack = (data) stack[topIndex];
		} else
			System.out.println("Top attempted on a empty stack.");
		return (String) topOfStack;
	}

	@Override
	public void pop() throws Underflow {
		if (!isEmpty()) {
			System.out.println(stack[topIndex] + " is now removed. ");
			String temp = stack[topIndex];
			stack[topIndex] = null;
			topIndex--;
		} else
			System.out.println("Pop attempted on an empty stack.");
	}
}

public class weightedGraph<data> implements weightedGraphInterface<data> {
	public static final int NULL_EDGE = 0;
	private static final int maxSize = 50;
	static public String endVertex;
	public int count = 0;
	public int maxVertices, numVertices;
	public data[] vertices;

	weightedGraph<String> graph;
	private data node;
	private int[][] edges;
	private boolean[] marks;

	/** Instantiates a graph with capacity maxSize vertices */
	@SuppressWarnings("unchecked")
	public weightedGraph() {
		numVertices = 0;
		maxVertices = maxSize;
		vertices = (data[]) new Object[maxSize];
		marks = new boolean[maxSize];
		edges = new int[maxSize][maxSize];
	}

	/** Instantiates a graph with defined capacity */
	@SuppressWarnings("unchecked")
	public weightedGraph(int size) {
		numVertices = 0;
		maxVertices = size;
		vertices = (data[]) new Object[size];
		marks = new boolean[size];
		edges = new int[size][size];
	}

	public data getVertex() {
		return node;
	}

	private void setVertex(data vertex) {
		this.node = vertex;
	}

	private data[] getVertices() {
		return vertices;
	}

	private void setVertices(data[] vertices) {
		this.vertices = vertices;
	}

	/**
	 * Precondition: Graph is not Full, Vertex not in yet, vertex is not null; Adds
	 * vertex to graph.
	 */
	public void addVertex(data vertex) {
		System.out.println();
		System.out.println();
		System.out.println("Adding vertex: addVertex(data " + vertex + ")");
		vertices[numVertices] = vertex;

		System.out.println("vertices[" + numVertices + "]= " + vertices[numVertices] + " vertex " + vertex);
		for (int index = 0; index < numVertices; index++) {
			edges[numVertices][index] = NULL_EDGE;
			System.out.println("edges =" + NULL_EDGE);
			edges[index][numVertices] = NULL_EDGE;
			System.out.println("edges =" + NULL_EDGE);
		}
		numVertices++;
		setVertex(vertex);
	}

	/**
	 * Adds new edges/tracts between vertex/nodes with weight values calculated
	 * 
	 * @param startVertex
	 * @param endVertex
	 * @param weight
	 */
	@Override
	public void addEdge(String startVertex, String endVertex, double weight) {
		System.out.println();
		System.out.println("Adding new Edge between start and end Vertex: addEdge()");
		int row;
		int column;

		row = indexIs((data) startVertex);
		column = indexIs((data) endVertex);
		edges[row][column] = (int) weight;

		if (row < 7 && column < 7) {
			System.out.println("startVertex = " + startVertex + " endVertex = " + endVertex);
			System.out.println("row = " + row + " column = " + column);
			System.out.println("weight = " + weight);
		}
	}

	/** Get index value of starting vertex in graph */
	@SuppressWarnings("unused")
	private int indexIs(data startVertex) {
		count = 0;
		vertices = getVertices();
		System.out.println("indexIs method for starting vertex: ");
		System.out.println("startVertex = " + startVertex);
		setVertices(vertices);
		return count;

	}

	/**
	 * Looks at current weighted graph and finds best path from start to end vertex
	 * in argument Returns true if a path exists.
	 */
	@SuppressWarnings("unused")
	public boolean isPath(weightedGraph<String> graph, String startVertex, String endVertex)
			throws Overflow, Underflow {
		System.out.println();
		UnboundedStackInterface<String> stack = new LinkedStack<String>();
		UnboundedQueueInterface<String> vertexQueue = new LinkedUnboundQueue<>();
		boolean found = false;
		String Vertex = null;
		String item;
		graph.clearMarks();
		stack.push(startVertex);
		do {
			System.out.println("START of do statement");
			Vertex = stack.top(Vertex);
			stack.pop();
			if (Vertex.contains(endVertex)) {
				System.out.println(Vertex + " vertex == endvertex" + endVertex);
				System.out.println("just traveled from " + Vertex + " to " + endVertex);
				System.out.println("distance is: " + graph);
				found = true;
			} else {
				System.out.println(Vertex + " vertex != endvertex " + endVertex);
				if (!graph.isMarked(Vertex)) {
					System.out.println("!graph.isMarked(vertex)");
					graph.markVertex(Vertex);
					vertexQueue = graph.getToVertices(Vertex);
					while (!vertexQueue.isEmpty()) {
						System.out.println("!vertexQueue.isEmpty()");
						item = vertexQueue.dequeue();
						if (!graph.isMarked(item))
							stack.push(item);
					}
				}
				System.out.println("unable to find other town/node.");
			}
		} while (!stack.isEmpty() && !found);

		return found;
	}

	/** Resets marks in graph */
	@Override
	public void clearMarks() {
		if (isEmpty()) {
			for (int place = 0; place <= maxVertices - 1; place++) {
				if (marks[place]) {
					System.out.println("marks == true");
					marks[place] = false;
				}
				System.out.println("marks now " + marks[place]);
			}
		} else {
			System.out.println("clearMarks empty");
		}
	}

	/** Returns true if vertex is marked; otherwise, returns false. */
	@Override
	public boolean isMarked(String vertex) {
		if (vertex == null) {
			System.out.println("not marked");
			return false;
		}

		System.out.println("isMarked");
		return true;
	}

	/** Sets mark for vertex to true. */
	@Override
	public boolean markVertex(String vertex) {
		System.out.println("markVertex");
		if (vertex == null) {
			for (count = 0; count <= maxVertices - 1; count++)// maxVertices
			{
				System.out.println(vertex + " != " + vertices[count]);
				if (vertex == vertices[count] && vertices[count] == null) {
					System.out.println(vertex + " vertex = vertices[index] " + vertices[count]);
					vertex = (String) vertices[count];
					return true;
				}
			}
		}
		System.out.println("returns true");
		return true;
	}

	/**
	 * Returns a queue of the vertices that are adjacent from defined vertex in
	 * argument
	 */
	@SuppressWarnings("unchecked")
	@Override
	public UnboundedQueueInterface<String> getToVertices(String vertex) {
		System.out.println("vertex = " + vertex);
		UnboundedQueueInterface<data> adjVertices = new LinkedUnboundQueue<data>();
		int start;
		int end;
		start = indexIs((data) vertex);

		for (end = 0; end < numVertices; end++) {
			System.out.println("start = " + start + " end " + end);
			System.out.println("edges = " + edges[start][end] + " nulledge = " + NULL_EDGE);
			if (edges[start][end] != NULL_EDGE) // corrects start -1
			{
				System.out.println("start = " + start + " end " + end);
				System.out.println("edges = " + edges[start][end]);
				adjVertices.enqueue(vertices[end]);
			}
		}
		return (UnboundedQueueInterface<String>) adjVertices;
	}

	/** Returns true if graph is empty, otherwise false. */
	public boolean isEmpty(weightedGraph<String> graph) {
		if (graph == null) {
			System.out.println("isEmpty ");
			return true;
		}
		System.out.println("notEmpty ");
		return false;
	}

	/** Returns true if graph is full, otherwise false. */
	@Override
	public boolean isFull() {
		System.out.println("isFull ");
		return getVertices().length == 7;
	}

	/** Returns true if this graph contains vertex; otherwise, returns false */
	@Override
	public boolean hasVertex(data vertex) {
		System.out.println("hasVertex ");
		return false;
	}

	/** Returns current weight between 'from' and 'to' vertex */
	@Override
	public int weightIs(data fromVertex, data toVertex) {
		System.out.println("weightIs ");
		return 0;
	}

	@Override
	public data getUnmarked() {
		System.out.println("getUnMarked ");
		return null;
	}

	/** Returns true if graph has no vertices, otherwise false. */
	@Override
	public boolean isEmpty() {
		System.out.println("isEmpty() ");
		if (getVertices().length == -1) {
			return true;
		}
		return true;
	}
}