package com.example.earthquakeexplorer.modelUtils;

import java.util.ArrayList;
import java.util.List;




public class ParsingUtils {

	/*
	 * Collect all the server feedback, get features in a list
	 * */
	public static List<Feature> parseFeatures(final String src) {
		List<Feature> result = new ArrayList<Feature>();
		return result;
	}
	
	
	/*
	 * parse one single Properties object, sample:
	 * {"place":"263km SE of Lambasa, Fiji","time":1412257859180,"updated":1412259088000}
	 * */
	public static Properties parseProperty(final String src) {
		Properties p = new Properties();
		return p;
	}
	
	/*
	 * parse one single Geometry object, sample:
	 * {"type":"Point","coordinates":[120.7549,15.1438,201.54]}
	 * */
	public static Geometry parseGeometry(final String src) {
		Geometry g = new Geometry();
		return g;
	}
	
}// end of ParsingUtils class         






