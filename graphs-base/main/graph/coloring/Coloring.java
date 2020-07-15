package graph.coloring;

public class Coloring {
	
	private int colors;
	private int[] colorAssignment;
	
	public int getColors() {
		return colors;
	}
	
	public int[] getColorAssignment() {
		return colorAssignment;
	}
	
	public int getColor(int node) {
		return colorAssignment[node];
	}

}
