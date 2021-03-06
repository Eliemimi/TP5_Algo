import java.io.IOException;
import java.util.PriorityQueue;


public class Main {

	public static void main(String[] args) throws IOException {
		EdgeWeightedGraph wdGraph = new EdgeWeightedGraph("documents/WG-MST.txt");
		PriorityQueue priorityQueue = new PriorityQueue();
		priorityQueue.add(new Edge(1, 3, 0.20));
		priorityQueue.add(new Edge(1, 4, 0.30));
		priorityQueue.add(new Edge(3, 4, 0.56));
		Edge e = (Edge) priorityQueue.poll();
		do {
			System.out.println(wdGraph.getAdj()[0]);
			e = (Edge) priorityQueue.poll();
		} while (e != null);
	}

}
