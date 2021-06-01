package SobekDataModel.writer.crossSection.profileDef;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import SobekDataModel.Global;

public class ProfileDefTable {
	private Map<String, Set<String>> tableValue = new TreeMap<>();

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

		Set<String> zList = Optional.ofNullable(this.tableValue.get(yString)).orElse(new LinkedHashSet<>());
		zList.add(zString);

		this.tableValue.put(yString, multipleZDetection(zList));
	}

	public void addValue(double height, double width, double floodWodth) {
		String heightString = new BigDecimal(height).setScale(Global.dataDecimale, RoundingMode.HALF_UP).toString();
		String widthString = new BigDecimal(width).setScale(Global.dataDecimale, RoundingMode.HALF_UP).toString();
		String floodString = new BigDecimal(floodWodth).setScale(Global.dataDecimale, RoundingMode.HALF_UP).toString();

		Set<String> temptList = Optional.ofNullable(this.tableValue.get(heightString)).orElse(new LinkedHashSet<>());
		temptList.add(widthString + " " + floodString);

		this.tableValue.put(heightString, temptList);
	}

	public String toString() {
		StringBuilder outString = new StringBuilder();
		outString.append("TBLE\r\n");

		this.tableValue.keySet().forEach(y -> {
			this.tableValue.get(y).forEach(z -> {
				outString.append(y + " " + z + " <\r\n");
			});
		});
		outString.append("tble");
		return outString.toString();
	}

	public Set<String> multipleZDetection(Set<String> zValues) {

		if (zValues.size() <= 2) {
			return zValues;
		} else {
			Set<String> outSet = new LinkedHashSet<>();

			List<String> zList = new ArrayList<>(zValues);
			double firstZ = Double.parseDouble(zList.get(0));
			double secondZ = Double.parseDouble(zList.get(1));
			double thirdZ = Double.parseDouble(zList.get(2));

			if (firstZ > secondZ) {

				if (thirdZ > firstZ && thirdZ > secondZ) {
					outSet.add(zList.get(1));
					outSet.add(zList.get(2));

				} else if (thirdZ < firstZ && thirdZ > secondZ) {
					outSet.add(zList.get(0));
					outSet.add(zList.get(1));

				} else if (thirdZ < firstZ && thirdZ < secondZ) {
					outSet.add(zList.get(0));
					outSet.add(zList.get(2));
				}
			} else {

				if (thirdZ > firstZ && thirdZ > secondZ) {
					outSet.add(zList.get(0));
					outSet.add(zList.get(2));

				} else if (thirdZ > firstZ && thirdZ < secondZ) {
					outSet.add(zList.get(0));
					outSet.add(zList.get(1));

				} else if (thirdZ < firstZ && thirdZ < secondZ) {
					outSet.add(zList.get(1));
					outSet.add(zList.get(2));
				}
			}
			return outSet;
		}

	}
}
