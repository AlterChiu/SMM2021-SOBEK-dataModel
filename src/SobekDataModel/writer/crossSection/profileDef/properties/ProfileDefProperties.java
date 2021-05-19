package SobekDataModel.writer.crossSection.profileDef.properties;

import java.util.List;

import SobekDataModel.writer.crossSection.profileDef.ProfileDefTable;
import SobekDataModel.writer.crossSection.profileDef.properties.pipeType.PipeProfileType;
import SobekDataModel.writer.crossSection.profileDef.properties.pipeType.PipeProfileTypeArch;
import SobekDataModel.writer.crossSection.profileDef.properties.pipeType.PipeProfileTypeCircle;
import SobekDataModel.writer.crossSection.profileDef.properties.pipeType.PipeProfileTypeCunettle;
import SobekDataModel.writer.crossSection.profileDef.properties.pipeType.PipeProfileTypeEllip;
import SobekDataModel.writer.crossSection.profileDef.properties.pipeType.PipeProfileTypeRec;

public class ProfileDefProperties {

	/*
	 * @Parameter : lu
	 * 
	 * @Description : calculation of conveyance, default 0
	 * 
	 * 0 : open vertically segmented
	 * 
	 * 1 : open lumped
	 * 
	 * 2 : closed lumped
	 */
	public static enum conveyance {
		verticalSeg(0), openLump(1), closeLump(2);

		public int value;

		conveyance(int value) {
			this.value = value;
		}

	}

	public static conveyance getConveyance(int index) throws Exception {
		switch (index) {
		case 0:
			return conveyance.verticalSeg;
		case 1:
			return conveyance.openLump;
		case 2:
			return conveyance.closeLump;
		default:
			throw new Exception("*ERROR* not allowable value for Conveyance");
		}
	}

	/*
	 * @Parameter : st
	 * 
	 * @Description : storage type, default 0
	 * 
	 * 0 : reservoir
	 * 
	 * 1 : loss water above the highest point
	 * 
	 */
	public static enum storageType {
		reservoir(0), loosWater(1);

		public int value;

		storageType(int value) {
			this.value = value;
		}
	}

	public static storageType getStorageType(int index) throws Exception {
		switch (index) {
		case 0:
			return storageType.reservoir;
		case 1:
			return storageType.loosWater;
		default:
			throw new Exception("*ERROR* not allowable value for StorageType");
		}
	}

	/*
	 * @Parameter : lt sw
	 * 
	 * @Description : storage width, default 0
	 * 
	 * 0 : reservoir
	 * 
	 * 1 : loss water above the highest point
	 * 
	 */
	public static enum storageWidth {
		meters("lt sw 0"), define("lt sw");

		private String key;

		storageWidth(String key) {
			this.key = key;
		}

		public String getValue() throws Exception {
			switch (this.key) {
			case "lt sw 0":
				return "0";
			default:
				throw new Exception(
						"*WRAN* storageWidth type 1, userDefine, needs to setting YZvalues\r\nreturn storage type 0, meters 0");
			}
		}

		// yzValues = [[y1,z1] , [y2,z2]....]
		public String getValue(List<Double[]> yzValues) {
			if (this.key.equals("lt sw 0")) {
				ProfileDefTable table = new ProfileDefTable();
				yzValues.forEach(values -> table.addValue(values[0], values[1]));
				return table.toString();
			} else {
				new Exception("*ERROR* storageWidth type 0, meters, don't needs to setting values");
				return "0";
			}
		}

		public String getKey() {
			return this.key;
		}
	}

	public static storageType getStorageWidth(String key) throws Exception {
		switch (key) {
		case "lt sw 0":
			return storageType.reservoir;
		case "lt sw":
			return storageType.loosWater;
		default:
			throw new Exception("*ERROR* not allowable value for StorageType");
		}
	}

	/*
	 * @ Parameter : a lot
	 * 
	 * @ Description : type to pipe crossSection
	 * 
	 */

	public static enum pipeCrossSection {
		Arch(0), Circle(1), Cunettle(2), Ellipse(3), Rectangle(4);

		private int index;

		pipeCrossSection(int index) {
			this.index = index;
		}

		public PipeProfileType getProfileType() throws Exception {
			switch (this.index) {
			case 0:
				return new PipeProfileTypeArch();
			case 1:
				return new PipeProfileTypeCircle();
			case 2:
				return new PipeProfileTypeCunettle();
			case 3:
				return new PipeProfileTypeEllip();
			case 4:
				return new PipeProfileTypeRec();
			default:
				throw new Exception("*ERROR* not allowable type of pipeCrossSection, " + this.index);
			}
		}

	}

}
