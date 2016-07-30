package roadgraph;

import java.util.HashMap;
import java.util.Map;

import geography.GeographicPoint;

public class DisjointSet {

	private Map<GeographicPoint, Node> map = new HashMap<>();

	class Node {
		GeographicPoint location;
		Node parent;
		int rank;
	}

	// set with single node
	public void makeSet(GeographicPoint location) {
		Node node = new Node();
		node.location = location;
		node.parent = node;
		node.rank = 0;
		map.put(location, node);
	}

	/**
	 * Combines two sets together
	 * 
	 * @return true if location1 and location2 were in different sets before
	 *         union else false
	 */
	public boolean union(GeographicPoint location1, GeographicPoint location2) {
		Node node1 = map.get(location1);
		Node node2 = map.get(location2);

		Node parent1 = findSet(node1);
		Node parent2 = findSet(node2);

		// if same parent do nothing
		if (parent1.location == parent2.location) {
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
	public GeographicPoint findSet(GeographicPoint location) {
		return findSet(map.get(location)).location;
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
}