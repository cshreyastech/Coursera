package roadgraph;

public class MapEdge implements Comparable<MapEdge>{
	private MapNode start;
	private MapNode end;
	
	private String roadName;
	private String roadType;
	private double distance;

	public MapEdge(MapNode start, MapNode end, String roadName, String roadType, double distance) {
		this.start = start;
		this.end = end;
		this.roadName = roadName;
		this.roadType = roadType;
		this.distance = distance;
	}

	public MapNode getStart() {
		return start;
	}

	public MapNode getEnd() {
		return end;
	}

	public String getRoadName() {
		return roadName;
	}

	public String getRoadType() {
		return roadType;
	}

	public double getDistance() {
		return distance;
	}

	
	@Override
	public int compareTo(MapEdge other) {
		// TODO Auto-generated method stub
		if (this.equals(other)) {
			return 0;
		} else if (this.getDistance() > other.getDistance()) {
			return 1;
		}
		return -1;
	}
}