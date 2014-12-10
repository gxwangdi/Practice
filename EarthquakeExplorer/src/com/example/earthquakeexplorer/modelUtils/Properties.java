package com.example.earthquakeexplorer.modelUtils;

public class Properties {
	// guess other fields not important here. 
	String place;
	String time;
	String updated;
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("{\"place\":\"")
			.append(place)
			.append("\",\"time\":\"")
			.append(time)
			.append("\",\"updated\":\"")
			.append(updated)
			.append("\"}");
		return sb.toString();
	}
}// end of Properties model 





