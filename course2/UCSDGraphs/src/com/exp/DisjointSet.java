//https://github.com/mission-peace/interview/blob/master/src/com/interview/graph/DisjointSet.java

package com.exp;

import java.util.HashMap;
import java.util.Map;

public class DisjointSet {

	private Map<Long, Node> map = new HashMap<>();

	class Node {
		long data;
		Node parent;
		int rank;
	}

	// set with single node
	public void makeSet(long data) {
		Node node = new Node();
		node.data = data;
		node.parent = node;
		node.rank = 0;
		map.put(data, node);
	}

	/**
	 * Combines two sets together
	 * 
	 * @return true if data1 and data2 were in different sets before union else
	 *         false
	 */
	public boolean union(long data1, long data2) {
		Node node1 = map.get(data1);
		Node node2 = map.get(data2);

		Node parent1 = findSet(node1);
		Node parent2 = findSet(node2);

		// if same parent do nothing
		if (parent1.data == parent2.data) {
			return false;
		}
		
		//else whoever's rank is higher becomes parent of other
		if(parent1.rank >= parent2.rank) {
			//increment ran only if both sets have same rank
			parent1.rank = (parent1.rank == parent2.rank) ? parent1.rank + 1 : parent1.rank;
			parent2.parent = parent1;
		} else {
			parent1.parent = parent2;
		}
		return true;
	}

	/**
	 * Finds the representative of this set
	 */
	public long findSet(long data) {
		return findSet(map.get(data)).data;
	}

	/**
	 * Find representative recursively and does path compression
	 */
	private Node findSet(Node node) {
		Node parent = node.parent;

		if (parent == node) {
			return parent;
		}
		node.parent = findSet(node.parent);
        return node.parent;
	}

	public static void main(String[] args) {
		DisjointSet ds = new DisjointSet();
		ds.makeSet(1);
		ds.makeSet(2);
		ds.makeSet(3);
		ds.makeSet(4);
		ds.makeSet(5);
		ds.makeSet(6);
		ds.makeSet(7);
		
        ds.union(1, 2);
        ds.union(2, 3);
        ds.union(4, 5);
        ds.union(6, 7);
        ds.union(5, 6);
        ds.union(3, 7);
        
		System.out.println("Set 1 found under parent: " + ds.findSet(1));
		System.out.println("Set 2 found under parent: " + ds.findSet(2));
		System.out.println("Set 3 found under parent: " + ds.findSet(3));
		System.out.println("Set 4 found under parent: " + ds.findSet(4));
		System.out.println("Set 5 found under parent: " + ds.findSet(5));
		System.out.println("Set 6 found under parent: " + ds.findSet(6));
		System.out.println("Set 7 found under parent: " + ds.findSet(7));
	}
}
