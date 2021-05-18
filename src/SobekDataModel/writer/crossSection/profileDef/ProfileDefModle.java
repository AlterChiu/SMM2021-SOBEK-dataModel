package SobekDataModel.writer.crossSection.profileDef;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Map;
import java.util.TreeMap;

import AlterChiu.Global;

public class ProfileDefModle {

	public class Table {
		private Map<String, String> tableValue = new TreeMap<>();

		public void addValue(double y, double z) {
			String yString = new BigDecimal(y).setScale(Global.dataDecimale, RoundingMode.HALF_UP).toString();
			String zString = new BigDecimal(z).setScale(Global.dataDecimale, RoundingMode.HALF_UP).toString();
			this.tableValue.put(yString, zString);
		}

		public String toString() {
			StringBuilder outString  = new StringBuilder();
			outString.append("TBLE")
		}
	}
}
