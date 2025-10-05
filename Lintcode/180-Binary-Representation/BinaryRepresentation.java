import java.util.HashSet;
import java.util.Set;

public class BinaryRepresentation {
	/**
	 * @param n: Given a decimal number that is passed in as a string
	 * @return: A string
	 */
	private String parseInteger(String str) {
		int n = Integer.parseInt(str);
		if (str.length() == 0 || "0".equals(str)) {
			return "0";
		}

		StringBuilder sb = new StringBuilder();
		while (n != 0) {
			sb.append(n % 2);
			n = n / 2;
		}
		return sb.reverse().toString();
	}// end of parseInteger

	private String parseFloat(String str) {
		double d = Double.parseDouble("0." + str);
		StringBuilder sb = new StringBuilder(bound + 1);
		Set<Double> set = new HashSet<>();

		while (d > 0) {
			if (sb.length() > bound || set.contains(d)) {
				return err;
			}
			set.add(d);
			d = d * 2;
			if (d >= 1) {
				sb.append("1");
				d--;
			} else {
				sb.append("0");
			}
		}
		return sb.toString();
	}// end of parseFloat

	private final int bound = 32;
	private final String err = "ERROR";

	public String binaryRepresentation(String n) {
		// write your code here
		if (n.indexOf('.') == -1) {
			return parseInteger(n);
		}
		String[] params = n.split("\\.");
		String flt = parseFloat(params[1]);
		if (err.equals(flt)) {
			return flt;
		}
		if ("0".equals(flt) || flt.length() == 0) {
			return parseInteger(params[0]);
		}
		return parseInteger(params[0]) + "." + flt;
	}// end of binaryRepresentation
}
