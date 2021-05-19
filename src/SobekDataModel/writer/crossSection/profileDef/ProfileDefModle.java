package SobekDataModel.writer.crossSection.profileDef;

import java.util.List;

import SobekDataModel.Global;
import SobekDataModel.KeyValuePair;
import SobekDataModel.writer.crossSection.profileDef.properties.ProgileDefProperties;

public class ProfileDefModle {

	/*
	 * @ Parameter : id
	 * 
	 * @ Necessary
	 * 
	 * @ Description : id for profile.def object(CRDS)
	 * 
	 */
	protected String id = Global.stringNull;

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
		this.name = id;
	}

	public boolean isIdNull() {
		return this.id == Global.stringNull;
	}

	public KeyValuePair<String, String> getIdKeyValue() {
		return new KeyValuePair<String, String>("id", this.id);
	}

	/*
	 * @ Parameter : nm
	 * 
	 * @ Necessary
	 * 
	 * @ Description : name for profile.defObject(CRDS), default same as id
	 * 
	 */
	protected String name = Global.stringNull;

	public String getName() {
		if (!this.name.equals(Global.stringNull)) {
			return this.name;
		} else {
			return this.id;
		}
	}

	public void setName(String name) {
		if (this.name.equals(this.id) && !this.name.equals(Global.stringNull))
			new Exception("*WARN* name of the object in profile.def(CRDS) was modified");
		this.name = name;
	}

	public KeyValuePair<String, String> getNameKeyValue() {
		return new KeyValuePair<String, String>("nm", this.name);
	}

	/*
	 * @ Parameter : lu
	 * 
	 * @ Necessary in ty10, default 0
	 * 
	 * @ Description : calculation of conveyance, 這邊我也看不懂
	 * 
	 * 0 : Open vertically segmented
	 * 
	 * 1 : Open lumped
	 * 
	 * 2 : Closed lumped
	 * 
	 */
	protected ProgileDefProperties.conveyance conveyance = ProgileDefProperties.conveyance.verticalSeg;

	public ProgileDefProperties.conveyance getConveyance() {
		return this.conveyance;
	}

	public void setConveyance(ProgileDefProperties.conveyance conveyance) {
		this.conveyance = conveyance;
	}

	public KeyValuePair<String, Integer> getConveyanceKeyValue() {
		return new KeyValuePair<String, Integer>("lu", this.conveyance.value);
	}

	/*
	 * @ Parameter : st
	 * 
	 * @ Necessary in ty10, default 0
	 * 
	 * @ Description : storage type
	 * 
	 * 0 : reservoir
	 * 
	 * 1 : loss water above the highest point in crossSection profile
	 * 
	 */
	protected ProgileDefProperties.storageType storageType = ProgileDefProperties.storageType.reservoir;

	public ProgileDefProperties.storageType getStorageType() {
		return this.storageType;
	}

	public void setStorageType(ProgileDefProperties.storageType storageType) {
		this.storageType = storageType;
	}

	public KeyValuePair<String, Integer> getStorageTypeKeyValue() {
		return new KeyValuePair<String, Integer>("st", this.storageType.value);
	}

	/*
	 * @ Parameter : lt sw
	 * 
	 * @ Necessary in ty10
	 * 
	 * @ Description : storage width on surface
	 * 
	 * while key = "lt sw 0" that means, width parameter in meters
	 * 
	 * while key = "lt sw" this means, width was described by a y-z table
	 * 
	 */
	protected ProgileDefProperties.storageWidth storageWidth = ProgileDefProperties.storageWidth.meters;

	private String storageWidthKey = this.storageWidth.getKey();
	private String storageWidthValue = "0";

	public KeyValuePair<String, String> getStorageWidthKeyValue() {
		return new KeyValuePair<String, String>(this.storageWidthKey, this.storageWidthValue);
	}

	// yzList = [[y1,z1],[y2,z2]]
	public void setStorageWidth(List<Double[]> yzValues) {
		this.storageWidth = ProgileDefProperties.storageWidth.define;
		this.storageWidthValue = this.storageWidth.getValue(yzValues);
		this.storageWidthKey = this.storageWidth.getKey();
	}

	public void setStorageWidth(double widthMeters) throws Exception {
		this.storageWidth = ProgileDefProperties.storageWidth.meters;
		this.storageWidthValue = this.storageWidth.getValue();
		this.storageWidthKey = this.storageWidth.getKey();
	}

	/*
	 * @ Parameter : wm
	 * 
	 * @ Necessary in ty0
	 * 
	 * @ Description : the width of the main channel
	 * 
	 */
	protected double mainChannelWidth = Global.doubleNull;

	public double getMainChannelWidth() {
		return this.mainChannelWidth;
	}

	public void setMainChannelWidth(double mainChannelWidth) {
		this.mainChannelWidth = mainChannelWidth;
	}

	public boolean isMainChannelWidthNull() {
		return this.mainChannelWidth == Global.doubleNull;
	}

	public KeyValuePair<String, Double> getMainChannelWidthKeyValue() {
		return new KeyValuePair<String, Double>("wm", this.mainChannelWidth);
	}

	/*
	 * @ Parameter : w1
	 * 
	 * @ Optional default 0
	 * 
	 * @ Description : the width of first flood plain(岸旁兩側的高灘地, manual中並未說明左右岸的先後順序)
	 * 
	 */
	protected double floodplainWidth1 = 0;

	public double getFloodplainWidth1() {
		return this.floodplainWidth1;
	}

	public void setFloodplainWidth1(double floodplainWidth1) {
		this.floodplainWidth1 = floodplainWidth1;
	}

	public KeyValuePair<String, Double> getFloodplainWidth1KeyValue() {
		return new KeyValuePair<String, Double>("w1", this.floodplainWidth1);
	}

	/*
	 * @ Parameter : w2
	 * 
	 * @ Optional default 0
	 * 
	 * @ Description : the width of second flood plain(岸旁兩側的高灘地,
	 * manual中並未說明左右岸的先後順序)
	 * 
	 */
	protected double floodplainWidth2 = 0;

	public double getFloodplainWidth2() {
		return this.floodplainWidth2;
	}

	public void setFloodplainWidth2(double floodplainWidth2) {
		this.floodplainWidth2 = floodplainWidth2;
	}

	public KeyValuePair<String, Double> getFloodplainWidth2KeyValue() {
		return new KeyValuePair<String, Double>("w2", this.floodplainWidth2);
	}
}
