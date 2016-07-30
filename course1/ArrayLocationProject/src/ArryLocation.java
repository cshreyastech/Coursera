
public class ArryLocation {
	private double coords[];
	
	public ArryLocation(double[] coords) {
		this.coords = coords;
	}
	
	public static void main(String[] args) {
		double[] coords = { 5.0, 0.0 };
		ArryLocation accra1 = new ArryLocation(coords);
		
		coords[0] = 32.9;
		coords[1] = -117.2;

		System.out.println(accra1.coords[0]);
	}
}
