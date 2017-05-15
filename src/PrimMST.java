import java.util.ArrayList;
import java.util.PriorityQueue;

public class PrimMST {
	private ArrayList<Edge> edgeTo;
	private static boolean[] marked;
	
	
	public void prim(EdgeWeightedGraph G, int s) {
		edges(G, s);
	}
	
	public void edges(EdgeWeightedGraph G, int S) {
		int nbvertices = 0;
		ArrayList<ArrayList<Integer>> visited;
		PriorityQueue priorityQueue = new PriorityQueue();
		priorityQueue.add(S);
		while (nbvertices < G.getNodeCount()){
			int noeud = (int) priorityQueue.poll();
			
			Float voisin = G.getAdj()[noeud].get(0).get(0);
			System.out.println(voisin);
			nbvertices = G.getNodeCount();
		}
		
		
	}
	
	public void weight() {
		
	}

	public ArrayList<Edge> getEdgeTo() {
		return edgeTo;
	}

	public void setEdgeTo(ArrayList<Edge> edgeTo) {
		this.edgeTo = edgeTo;
	}

}
