
public class Edge implements Comparable {
	public int v;
	public int w;
	public double weight;
	
	public Edge(int v, int w, double weight) {
		this.v = v;
		this.w = w;
		this.weight = weight;
	}

	public int either() {
		return v;
	}
	
	public int other() {
		return w;
	}
	
	public double weight() {
		return weight;
	}
	
	@Override
	public int compareTo(Object o) {
		if(o == null) return 1;
		Edge edge = (Edge) o;
		
		return edge.weight > this.weight ? 1 : -1;
	}

}
