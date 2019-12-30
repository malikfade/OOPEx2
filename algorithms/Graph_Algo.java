package algorithms;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

import dataStructure.edgeData;
import dataStructure.edge_data;
import dataStructure.graph;
import dataStructure.nodeData;
import dataStructure.node_data;

public class Graph_Algo implements graph_algorithms {

	public graph g;
	
	
	@Override
	public void init(graph g) {
		this.g=g;
	}

	@Override
	public graph copy() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void init(String file_name) {
		try
        {    
            FileInputStream file = new FileInputStream(file_name); 
            ObjectInputStream in = new ObjectInputStream(file); 
              
            g = (graph)in.readObject(); 
              
            in.close(); 
            file.close(); 
              
            System.out.println("Object has been deserialized"); 
          
        } 
          
        catch(IOException ex) 
        { 
            System.out.println("IOException is caught"); 
        } 
          
        catch(ClassNotFoundException ex) 
        { 
            System.out.println("ClassNotFoundException is caught"); 
        } 

	}

	@Override
	public void save(String file_name) {
		try
        {    
            FileOutputStream file = new FileOutputStream(file_name); 
            ObjectOutputStream out = new ObjectOutputStream(file); 
              
            out.writeObject(g); 
              
            out.close(); 
            file.close(); 
              
            System.out.println("Object has been serialized"); 
        }   
        catch(IOException ex) 
        { 
            System.out.println("IOException is caught"); 
        } 
	}
	
	private void clear() {
		for (node_data nodes : g.getV()) {
			nodes.setTag(0);
			nodes.setWeight(Double.MAX_VALUE);
		}
	}

	@Override
	public boolean isConnected() {
		if(g.nodeSize() == 1)
			return true;
		
		Queue<nodeData> q=new ArrayBlockingQueue<nodeData>(g.nodeSize());
		clear();
		
		for (node_data nodes : g.getV()) {
			nodes.setTag(0);

		}
		for (node_data node : g.getV() ) {
			nodeData n = (nodeData) node;
			if (g.getE(n.getKey())== null) 
				return false;
			q.add(n);
			n.setTag(1);
			while (!q.isEmpty()) {
				for (edge_data edge : g.getE(q.peek().getKey())  ) {
					nodeData dest=(nodeData) g.getNode(edge.getDest());
					if(dest.getTag()==0) {
						dest.setTag(1);
						q.add(dest);}
				}
				q.remove();
			}
			for (node_data nodes : g.getV()) {
				if (nodes.getTag()==0) 
					return false;
				else nodes.setTag(0);
			}
		}
		return true;
		
	}

	@Override
	public double shortestPathDist(int src, int dest) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<node_data> shortestPath(int src, int dest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<node_data> TSP(List<Integer> targets) {
		// TODO Auto-generated method stub
		return null;
	}

}
