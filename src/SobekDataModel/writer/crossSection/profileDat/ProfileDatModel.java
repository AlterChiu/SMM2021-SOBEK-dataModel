package SobekDataModel.writer.crossSection.profileDat;

import SobekDataModel.Global;

public abstract class ProfileDatModel {

	/*
	 * @ Parameter : rl
	 * 
	 * @ Necessary
	 * 
	 * @ Description :
	 * 
	 * CrossSection : the bedLevel , default to 0
	 * 
	 * 
	 * Pipe object : it's the end level of the pipe(lowest level)
	 * 
	 */
	protected double bedLevel = Global.doubleNull;

	public double getBebLevel() {
		return this.bedLevel;
	}

	public void setBedLevel(double bedLevel) {
		this.bedLevel = bedLevel;
	}

	public boolean isBedLevelNull() {
		return this.bedLevel == Global.doubleNull;
	}

	/*
	 * @ Parameter : ll
	 * 
	 * @ Necessary in pipe object
	 * 
	 * @ Description :
	 * 
	 * Pipe object : it's the top level of the pipe(highest level) , default to 0
	 */
	protected double pipeTopLevel = Global.doubleNull;

	public double getPipeTopLevel() {
		return this.pipeTopLevel;
	}

	public void setPipeTopLevel(double pipeTopLevel) {
		this.pipeTopLevel = pipeTopLevel;
	}

	public boolean isPipeTopLevelNull() {
		return this.pipeTopLevel == Global.doubleNull;
	}

	/*
	 * @ Parameter : rs
	 * 
	 * @ Necessary in crossSection object
	 * 
	 * @ Description :
	 * 
	 * which the bedLevel reference to the first(left) point of crossSection
	 * 
	 */
	protected double levelLeft = Global.doubleNull;

	public double getLevelLeft() {
		return this.levelLeft;
	}

	public void setLevelLeft(double levelLeft) {
		this.levelLeft = levelLeft;
	}

	public boolean isLevelLeftNull() {
		return this.levelLeft == Global.doubleNull;
	}

	/*
	 * @ Parameter : ls
	 * 
	 * @ Optional, only use in crossSection
	 * 
	 * @ Description :
	 * 
	 * which the bedLevel reference to the last(right) point of crossSection
	 * 
	 */
	protected double levelRight = 0;

	public double getLevelRight() {
		return this.levelRight;
	}

	public void setLevelRight(double levelRight) {
		this.levelRight = levelRight;
	}

	/*
	 * @ Parameter : di
	 * 
	 * @ Necessary
	 * 
	 * @ Description : id of reference crossSection(profile.def)
	 */
	protected String referenceProfile = Global.stringNull;

	public String getReferenceProfile() {
		return this.referenceProfile;
	}

	public void setReferenceProfile(String referenceProfile) {
		this.referenceProfile = referenceProfile;
	}

	public boolean isReferenceProfileNull() {
		return this.referenceProfile.equals(Global.stringNull);
	}

	/*
	 * @ Parameter : id
	 * 
	 * @ Necessary
	 * 
	 * @ Description : id of this object(profile.dat)
	 */
	protected String id = Global.stringNull;

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public boolean isIdNull() {
		return this.id.equals(Global.stringNull);
	}

	/*
	 * @ Description : check for all property in necessary properties
	 */
	public Boolean checkNecessaryProperty() throws Exception {
		return null;
	}
}
