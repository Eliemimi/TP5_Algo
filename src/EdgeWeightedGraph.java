import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class EdgeWeightedGraph {
	private int nodeCount;
	private int edgeCount;
	private ArrayList<Integer> nodes = new ArrayList<Integer>();
	private static ArrayList<ArrayList<Float>>[] adj;
	private static ArrayList<Double> listOfWeights = new ArrayList<Double>();
    
	@SuppressWarnings("unchecked")
	public EdgeWeightedGraph(String filePath) throws IOException {
		List<String> lines = new ArrayList<String>();
		try{	
	        BufferedReader buf = new BufferedReader(new FileReader(filePath));	
	        String line;
			while ((line=buf.readLine()) != null) {
				lines.add(line);
			}
			buf.close();
			setNodeCount(getNode(lines).size());
			System.out.println("Nombre de Noeuds : " + getNodeCount());
			setAdj(new ArrayList[getNodeCount()+1]);
			addEdgesToGraph(getAdj(), lines);
			print();
		}catch(IOException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public List<Integer> getNode(List<String> lines) {
		for (String line : lines) {	
			Pattern p = Pattern.compile("[0-9]* [0-9]* ");
			Matcher m = p.matcher(line);
			while(m.find()) {
				String subline = m.group();
				String[] nodesNumber = subline.split(" ");
				for (String nodeString : nodesNumber) {
					int node = Integer.parseInt(nodeString); 
					if(!nodes.contains(node)){
						nodes.add(node);
					}
		        }
			}
	    }
		return nodes;
	}
	
	private void addEdgesToGraph(ArrayList<ArrayList<Float>>[] arrayLists, List<String> lines) {
		for (String line : lines) {
			if(line != null) {
				String[] nodesNumber = line.split(" ");
				int node1Index = Integer.parseInt(nodesNumber[0]);
				int node2Index = Integer.parseInt(nodesNumber[1]);
				double weight = Double.parseDouble(nodesNumber[2]);
				Edge e = new Edge(node1Index, node2Index, weight);
				listOfWeights.add(e.weight());
				addEdge(e);
				edgeCount++;
			}
		}
		System.out.println("nombre d'arc : " + edgeCount);
	}
	
	public void addEdge(Edge e) {
        int node1 = e.either();
        int node2 = e.other();
        float weight = (float) e.weight();
        
        ArrayList<Float> node2AndWeight = new ArrayList<Float>();
        node2AndWeight.add((float) node2);
        node2AndWeight.add(weight); 
        
        ArrayList<Float> node1AndWeight = new ArrayList<Float>();
        node1AndWeight.add((float) node1);
        node1AndWeight.add(weight);
        
        ArrayList<ArrayList<Float>> edgesNode = getAdj()[node1];
		if (edgesNode == null) {
			edgesNode = new ArrayList<ArrayList<Float>>();
		}
		
		ArrayList<ArrayList<Float>> edgesNode2 = getAdj()[node2];
		if (edgesNode2 == null) {
			edgesNode2 = new ArrayList<ArrayList<Float>>();
		}
		
		edgesNode.add(node2AndWeight);
		edgesNode2.add(node1AndWeight);
		getAdj()[node1] = edgesNode;
		getAdj()[node2] = edgesNode2;
		
		
	}
	
	public ArrayList<Integer> getNodesList() {
		return nodes;
	}
	
	public void setNodeCount(int nodeCount) {
		this.nodeCount = nodeCount;
	}
	
	public int getNodeCount() {
		return nodeCount;
	}
	
	public static ArrayList<ArrayList<Float>>[] getAdj() {
		return adj;
	}

	public static void setAdj(ArrayList<ArrayList<Float>>[] adj) {
		EdgeWeightedGraph.adj = adj;
	}
	
	public static ArrayList<Double> getListOfWeight() {
		return listOfWeights;
	}
	
	public static void print() {
		System.out.println("Weight DiGraph : " + Arrays.toString(getAdj()));
	}
}
