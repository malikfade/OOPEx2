package dataStructure;

import java.util.Collection;
import java.util.HashMap;

public class DGraph implements graph{

	
	public HashMap <Integer , HashMap <Integer , edge_data>> edges  = new HashMap <Integer , HashMap <Integer , edge_data>>();
	public HashMap <Integer , node_data> nodes  = new HashMap <Integer , node_data>();
	
	
	@Override
	public node_data getNode(int key) {
		
		return nodes.get(key);
	}

	@Override
	public edge_data getEdge(int src, int dest) {
		return edges.get(src).get(dest);
	}

	@Override
	public void addNode(node_data n) {
		nodes.put(n.getKey(), n);
		
	}

	@Override
	public void connect(int src, int dest, double w) {
		if(nodes.containsKey(src) && nodes.containsKey(dest))
		{
			edgeData edge = new edgeData(src , dest , w);
			if(edges.containsKey(src))
			{
				edges.put(dest, edges.get(src));
			}
			else
			{
				HashMap<Integer , edge_data> edges1 = new HashMap<Integer , edge_data>();
				edges1.put(dest, edge);
			}
		}
		
	}

	@Override
	public Collection<node_data> getV() {
		return nodes.values();
	}

	@Override
	public Collection<edge_data> getE(int node_id) {
		return edges.get(node_id).values();
	}

	@Override
	public node_data removeNode(int key) {
		return nodes.remove(key);
	}

	@Override
	public edge_data removeEdge(int src, int dest) {
		return edges.get(src).remove(dest);
	}

	@Override
	public int nodeSize() {
		return nodes.size();
	}

	@Override
	public int edgeSize() {
		return edges.size();
	}

	@Override
	public int getMC() {
		// TODO Auto-generated method stub
		return 0;
	}

}
