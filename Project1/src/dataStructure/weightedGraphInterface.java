package dataStructure;

class Underflow extends Exception {
	public Underflow() {
		super();
	}

	public Underflow(String msg) {
		super(msg);
	}
}

interface UnboundedQueueInterface<data> {

	boolean isEmpty();

	String dequeue() throws Underflow;

	void enqueue(data vertex);

}

public interface weightedGraphInterface<data> {
	void clearMarks();

	boolean isEmpty();

	boolean isFull();

	boolean isMarked(String vertex);

	void addVertex(data vertex);

	boolean hasVertex(data vertex);

	boolean markVertex(String vertex);

	UnboundedQueueInterface<String> getToVertices(String vertex);

	void addEdge(String startVertex, String endVertex, double weight);

	int weightIs(data fromVertex, data toVertex);

	data getUnmarked();
}