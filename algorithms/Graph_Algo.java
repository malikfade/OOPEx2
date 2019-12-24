package algorithms;

import java.util.List;

import dataStructure.graph;
import dataStructure.node_data;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.ArrayBlockingQueue;
import dataStructure.edge_data;
import dataStructure.nodeData;
/**
 * This empty class represents the set of graph-theory algorithms
 * which should be implemented as part of Ex2 - Do edit this class.
 * @author 
 *
 */
public class Graph_Algo implements graph_algorithms{

	
	private graph g1;
	private String file_name1;
	
	@Override
	public void init(graph g) {
		this.g1 = g;
		
		
	}

	@Override
	public void init(String file_name) {

		this.file_name1 = file_name;
	}

	@Override
	public void save(String file_name) {
		
	}

	@Override
	public boolean isConnected() {
		return false;
	}
		

	@Override
	public double shortestPathDist(int src, int dest) {
		return 0;
	}

	@Override
	public List<node_data> shortestPath(int src, int dest) {
		return null;
	}

	@Override
	public List<node_data> TSP(List<Integer> targets) {
		return null;
	}

	@Override
	public graph copy() {
		return null;
	}

}
