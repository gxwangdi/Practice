package com.example.earthquakeexplorer.modelUtils;

public class Feature {

	String id;
	public Properties mProperty;
	public Geometry mGeometry;
	
	@Override 
	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append("{\"id\":\"")
			.append(id)
			.append("\", \"geometry\":")
			.append(mGeometry.toString())
			.append(", \"properties\":")
			.append(mProperty.toString())
			.append("}");
		return sb.toString();
	}
}// end of Feature model           




