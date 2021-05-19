package SobekDataModel.writer.crossSection.profileDef;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Map;
import java.util.TreeMap;

import SobekDataModel.Global;

public class ProfileDefTable {
	private Map<String, String> tableValue = new TreeMap<>();

	/*
	 * @Description :
	 * 
	 * it will auto sorted the tableValue by "y"
	 * 
	 * if there are multiple values in same "y", it will only take the last one
	 * 
	 */
	public void addValue(double y, double z) {
		String yString = new BigDecimal(y).setScale(Global.dataDecimale, RoundingMode.HALF_UP).toString();
		String zString = new BigDecimal(z).setScale(Global.dataDecimale, RoundingMode.HALF_UP).toString();
		this.tableValue.put(yString, zString);
	}

	public String toString() {
		StringBuilder outString = new StringBuilder();
		outString.append("TBLE\r\n");
		this.tableValue.keySet().forEach(key -> {
			outString.append(key + " " + this.tableValue.get(key) + " <\r\n");
		});
		outString.append("tble");
		return outString.toString();
	}
}
