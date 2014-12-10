package com.example.earthquakeexplorer.modelUtils;




public class Geometry {

	String Type;
	float coordinateX;
	float coordinateY;
	float coordinateZ;
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("{\"type\":\"")
			.append(Type)
			.append("\",\"coordinates\":[")
			.append(coordinateX)
			.append(",").append(coordinateY)
			.append(",").append(coordinateZ)
			.append("]}");
		return sb.toString();
	}
}// end of Geometry class    







