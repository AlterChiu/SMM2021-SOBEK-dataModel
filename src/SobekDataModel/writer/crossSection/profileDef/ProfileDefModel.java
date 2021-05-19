package SobekDataModel.writer.crossSection.profileDef;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

import SobekDataModel.Global;
import SobekDataModel.KeyValuePair;
import SobekDataModel.writer.crossSection.profileDef.properties.ProfileDefProperties;
import SobekDataModel.writer.crossSection.profileDef.properties.pipeType.PipeProfileType;

public class ProfileDefModel {

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
	 * @ Parameter " ty
	 * 
	 * @ Necessary
	 * 
	 * @ Description : type for profile
	 */
	protected String type = Global.stringNull;

	public String getType() {
		return this.type;
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
	protected ProfileDefProperties.conveyance conveyance = ProfileDefProperties.conveyance.verticalSeg;

	public ProfileDefProperties.conveyance getConveyance() {
		return this.conveyance;
	}

	public void setConveyance(ProfileDefProperties.conveyance conveyance) {
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
	protected ProfileDefProperties.storageType storageType = ProfileDefProperties.storageType.reservoir;

	public ProfileDefProperties.storageType getStorageType() {
		return this.storageType;
	}

	public void setStorageType(ProfileDefProperties.storageType storageType) {
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
	protected ProfileDefProperties.storageWidth storageWidth = ProfileDefProperties.storageWidth.meters;

	private String storageWidthKey = this.storageWidth.getKey();
	private String storageWidthValue = "0";

	public KeyValuePair<String, String> getStorageWidthKeyValue() {
		return new KeyValuePair<String, String>(this.storageWidthKey, this.storageWidthValue);
	}

	// yzList = [[y1,z1],[y2,z2]]
	public void setStorageWidth(List<Double[]> yzValues) {
		this.storageWidth = ProfileDefProperties.storageWidth.define;
		this.storageWidthValue = this.storageWidth.getValue(yzValues);
		this.storageWidthKey = this.storageWidth.getKey();
	}

	public void setStorageWidth(double widthMeters) throws Exception {
		this.storageWidth = ProfileDefProperties.storageWidth.meters;
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
		this.mainChannelWidth = new BigDecimal(mainChannelWidth).setScale(Global.dataDecimale, RoundingMode.UP)
				.doubleValue();
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
		this.floodplainWidth1 = new BigDecimal(floodplainWidth1).setScale(Global.dataDecimale, RoundingMode.UP)
				.doubleValue();
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
		this.floodplainWidth2 = new BigDecimal(floodplainWidth2).setScale(Global.dataDecimale, RoundingMode.UP)
				.doubleValue();
	}

	public KeyValuePair<String, Double> getFloodplainWidth2KeyValue() {
		return new KeyValuePair<String, Double>("w2", this.floodplainWidth2);
	}

	/*
	 * @ Parameter : gl
	 * 
	 * @ Necessary in ty0, default to 0
	 * 
	 * @ Description : ground layer depth
	 * 
	 */
	protected double groundDepth = 0;

	public double getGroundDepth() {
		return this.mainChannelWidth;
	}

	public void setGroundDepth(double groundDepth) {
		this.groundDepth = new BigDecimal(groundDepth).setScale(Global.dataDecimale, RoundingMode.UP).doubleValue();
	}

	public KeyValuePair<String, Double> getGroundDepthKeyValue() {
		return new KeyValuePair<String, Double>("gl", this.groundDepth);
	}

	/*
	 * @ Parameter : gu
	 * 
	 * @ Necessary in ty0
	 * 
	 * @ Description : ground layer to be used or not, default to 0
	 * 
	 * 0 : not use
	 * 
	 * 1 : use
	 * 
	 */
	protected int groundLayerUse = 0;

	public int getGroundLayerUse() {
		return this.groundLayerUse;
	}

	public void setGroundLayerUse(boolean trueFalse) {
		if (trueFalse) {
			this.groundLayerUse = 1;
		} else {
			this.groundLayerUse = 0;
		}
	}

	public KeyValuePair<String, Integer> getGroundLayerUseKeyValue() {
		return new KeyValuePair<String, Integer>("gu", this.groundLayerUse);
	}

	/*
	 * @ Parameter : lt zy
	 * 
	 * @ Necessary in ty10
	 * 
	 * @ Description : table data for y-z crossSection
	 */
	protected String yzCrossSection = Global.stringNull;

	public String getYzCrossSection() {
		return this.yzCrossSection;
	}

	// yzList = [[y1,z1],[y2,z2]]
	public void setYzCrossSection(List<Double[]> yzValues) {
		ProfileDefTable table = new ProfileDefTable();
		yzValues.forEach(value -> {
			table.addValue(value[0], value[1]);
		});
		this.yzCrossSection = table.toString();
	}

	public KeyValuePair<String, String> getYzCrossSectionKeyValue() {
		return new KeyValuePair<String, String>("lt zy", this.yzCrossSection);
	}

	public boolean isYzCrossSectionIsNull() {
		return this.yzCrossSection.endsWith(Global.stringNull);
	}

	/*
	 * @ Parameter : lt lw
	 * 
	 * @ Necessary in ty00
	 * 
	 * @ Description : table data for pipe crossSection
	 */
	protected String pipeCrossSection = Global.stringNull;

	public String getPipeCrossSection() {
		return this.pipeCrossSection;
	}

	// yzList = [[y1,z1],[y2,z2]]
	public void setPipeCrossSection(List<Double[]> yzValues) {
		ProfileDefTable table = new ProfileDefTable();
		yzValues.forEach(value -> {
			table.addValue(value[0], value[1]);
		});
		this.pipeCrossSection = table.toString();
	}

	public KeyValuePair<String, String> getPipeCrossSectionKeyValue() {
		return new KeyValuePair<String, String>("lt lw", this.pipeCrossSection);
	}

	/*
	 * @ Parameter : a lot
	 * 
	 * @ Necessary in ty0
	 * 
	 * @ Description : profileType to pipe object
	 */
	protected PipeProfileType pipeProfileType;

	public void setPipeProfileType(ProfileDefProperties.pipeCrossSection type) throws Exception {
		this.pipeProfileType = type.getProfileType();
	}

	public PipeProfileType getPipeProfileType() {
		return this.pipeProfileType;
	}

}
