package lifeexpectencypackage;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import de.fhpotsdam.unfolding.UnfoldingMap;
import de.fhpotsdam.unfolding.data.Feature;
import de.fhpotsdam.unfolding.data.GeoJSONReader;
import de.fhpotsdam.unfolding.marker.Marker;
import de.fhpotsdam.unfolding.providers.Google;
import de.fhpotsdam.unfolding.utils.MapUtils;
import processing.core.PApplet;

public class LifeExpectancy extends PApplet {
	UnfoldingMap map;
	Map<String, Float> lifeExpByCountry;
	List<Feature> countries;
	List<Marker> countryMarkers;

	public void setup() {
		size(800, 600, OPENGL);
		map = new UnfoldingMap(this, 50, 50, 700, 500, new Google.GoogleMapProvider());
		MapUtils.createDefaultEventDispatcher(this, map);

		lifeExpByCountry = loadLifeExpectancyFromCSV(
				"/home/cs/cs-files/Codes/Java/Coursera/course1/UCSDUnfoldingMaps/data/LifeExpectancyWorldBank.csv");
		
		countries = GeoJSONReader.loadData(this,
				"/home/cs/cs-files/Codes/Java/Coursera/course1/UCSDUnfoldingMaps/data/countries.geo.json");
		countryMarkers = MapUtils.createSimpleMarkers(countries);

		map.addMarkers(countryMarkers);
		shadeCountries(lifeExpByCountry);
	}

	public void draw() {
		map.draw();
	}

	private Map<String, Float> loadLifeExpectancyFromCSV(String fileName) {
		Map<String, Float> lifeExpMap = new HashMap<String, Float>();

		String[] rows = loadStrings(fileName);
//		 System.out.println("rows: " + rows);

		for (String row : rows) {
			String[] columns = row.split(",");
//			 System.out.println("row: " + row  + ", columns.length: " + columns.length + ", columns[4]: " + columns[4] + ", columns[5]: " + columns[5]);

			if (columns.length == 18 && !columns[5].equals("..")) {
				float value = Float.parseFloat(columns[5]);
				lifeExpMap.put(columns[4], value);
			}
		}
		
		return lifeExpMap;
	}

	private void shadeCountries(Map<String, Float> lifeExpMap) {
		// Map<String, Float> lifeExpMap = new HashMap<String, Float>();


		
		for (Marker marker : countryMarkers) {
			String countryId = marker.getId();

			if (lifeExpMap.containsKey(countryId)) {
				float lifeExp = lifeExpMap.get(countryId);
				int colorLevel = (int) map(lifeExp, 40, 90, 10, 255);
				marker.setColor(color(255 - colorLevel, 100, colorLevel));

			} else {
//				 System.out.println("countryId: " + countryId);
				marker.setColor(color(150, 150, 150));
			}
		}
	}
}
