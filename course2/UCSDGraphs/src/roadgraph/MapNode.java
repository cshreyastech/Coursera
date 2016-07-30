package roadgraph;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import geography.GeographicPoint;

public class MapNode implements Comparable<MapNode> {

	private GeographicPoint location;
	private List<MapNode> neighbors;
	private double distanceFromOrigin;
	private double estimatedDistanceFromGoal;

	public MapNode(GeographicPoint location) {
		this.location = location;
		neighbors = new LinkedList<MapNode>();
		distanceFromOrigin = Double.POSITIVE_INFINITY;
		estimatedDistanceFromGoal = 0.0;
	}

	public GeographicPoint getLocation() {
		return this.location;
	}

	public void setLocation(GeographicPoint location) {
		this.location = location;
	}

	public void setNeighbors(Set<MapEdge> edges) {

		for (MapEdge edge : edges) {

			if (this.getLocation().equals(edge.getStart().getLocation())) {
				neighbors.add(edge.getEnd());
				// } else if
				// (this.getLocation().equals(edge.getEnd().getLocation())) {
				// neighbors.add(edge.getStart());
			}
		}
	}

	public void setDistanceFromOrigin(Double distanceFromOrigin) {
		this.distanceFromOrigin = distanceFromOrigin;
	}

	public void setEstimatedDistanceFromGoal(Double estimatedDistanceFromGoal) {
		this.estimatedDistanceFromGoal = estimatedDistanceFromGoal;
	}

	public List<MapNode> getNeighbors(Set<MapEdge> edges) {// Set<MapEdge> edges
		this.setNeighbors(edges);
		return this.neighbors;
	}

	public double getDistanceFromOrigin() {
		return this.distanceFromOrigin;
	}

	public double getEstimatedDistanceFromGoal() {
		return this.estimatedDistanceFromGoal;
	}

	public boolean equals(MapNode other) {
		return this.getDistanceFromOrigin() == other.getDistanceFromOrigin();
	}


	@Override
	public int compareTo(MapNode other) {
		// TODO Auto-generated method stub
		
		if (this.equals(other)) {
			return 0;
		} else if ((this.getDistanceFromOrigin() + this.getEstimatedDistanceFromGoal()) > (other.getDistanceFromOrigin()
				+ other.getEstimatedDistanceFromGoal())) {
			return 1;
		}
		return -1;
	}

	public String toString() {
		return ("location: " + getLocation() + ", distanceFromOrgin: " + getDistanceFromOrigin()
				+ ", estimatedDistanceFromGoal: " + getEstimatedDistanceFromGoal());
	}
}