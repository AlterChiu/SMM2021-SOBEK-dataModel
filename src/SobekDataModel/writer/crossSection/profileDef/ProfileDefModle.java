package SobekDataModel.writer.crossSection.profileDef;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Map;
import java.util.TreeMap;

import SobekDataModel.Global;

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

	/*
	 * @ Parameter : lu
	 * 
	 * @ Necessary in ty10
	 * 
	 * @ Description :
	 * 
	 */
	protected ProgileDefProperties.conveyance conveyance = ProgileDefProperties.conveyance.verticalSeg;

	public ProgileDefProperties.conveyance getConveyance() {
		return this.conveyance;
	}

	public void setConveyance(ProgileDefProperties.conveyance conveyance) {
		this.conveyance = conveyance;
	}

	public boolean isConveyanceNull() {
		return this.conveyance == null;
	}

	/*
	 * @ Parameter : st
	 * 
	 * @ Necessary in ty10
	 * 
	 * @ Description :
	 * 
	 */
	protected ProgileDefProperties.storageType storageType = ProgileDefProperties.storageType.reservoir;

	public ProgileDefProperties.storageType getStorageType() {
		return this.storageType;
	}

	public void setStorageType(ProgileDefProperties.storageType storageType) {
		this.storageType = storageType;
	}

	public boolean isStorageTypeNull() {
		return this.storageType == null;
	}

	/*
	 * @ Parameter : lt sw
	 * 
	 * @ Necessary in ty10
	 * 
	 * @ Description :
	 * 
	 */
	protected ProgileDefProperties.storageWidth storageWidth = ProgileDefProperties.storageWidth.meters;

	public ProgileDefProperties.storageWidth getStorageWidth() {
		return this.storageWidth;
	}

	public void setStorageWidth(ProgileDefProperties.storageWidth storageWidth) {
		this.storageWidth = storageWidth;
	}

	public boolean isStorageWidthNull() {
		return this.storageWidth == Global.doubleNull;
	}

	/*
	 * @ Parameter : wm
	 * 
	 * @ Necessary in ty0
	 * 
	 * @ Description :
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

	/*
	 * @ Parameter : w1
	 * 
	 * @ Optional default 0
	 * 
	 * @ Description :
	 * 
	 */
	protected double floodplainWidth1 = Global.doubleNull;

	public double getFloodplainWidth1() {
		return this.floodplainWidth1;
	}

	public void setFloodplainWidth1(double floodplainWidth1) {
		this.floodplainWidth1 = floodplainWidth1;
	}

	public boolean isFloodplainWidth1Null() {
		return this.floodplainWidth1 == Global.doubleNull;
	}

	/*
	 * @ Parameter : w2
	 * 
	 * @ Optional default 0
	 * 
	 * @ Description :
	 * 
	 */
	protected double floodplainWidth2 = Global.doubleNull;

	public double getFloodplainWidth2() {
		return this.floodplainWidth2;
	}

	public void setFloodplainWidth2(double floodplainWidth2) {
		this.floodplainWidth2 = floodplainWidth2;
	}

	public boolean isFloodplainWidth2Null() {
		return this.floodplainWidth2 == Global.doubleNull;
	}

}
