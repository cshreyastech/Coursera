package module4;

import de.fhpotsdam.unfolding.data.PointFeature;
import de.fhpotsdam.unfolding.geo.Location;
import de.fhpotsdam.unfolding.marker.Marker;
import de.fhpotsdam.unfolding.marker.SimplePointMarker;
public class TestClass {
	PointFeature feature;
//	Marker m = new OceanQuakeMarker(feature);
	Location loc;
//	PointFeature feature1;
//	EarthquakeMarker em = (EarthquakeMarker) new SimplePointMarker(loc);
//	
//	SimplePointMarker pm = new OceanQuakeMarker(feature1);
//	EarthquakeMarker em1 = pm;
	
//	EarthquakeMarker em = new OceanQuakeMarker(feature);
//	SimplePointMarker m = new Marker();
	
	Object o = new SimplePointMarker(loc);
}
