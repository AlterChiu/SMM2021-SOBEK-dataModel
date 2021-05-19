package SobekDataModel.writer.crossSection;

import SobekDataModel.writer.crossSection.profileDat.ProfileDatModel;
import SobekDataModel.writer.crossSection.profileDat.ProfileDatPipe;
import SobekDataModel.writer.crossSection.profileDat.ProfileDatYZ;
import SobekDataModel.writer.crossSection.profileDef.ProfileDefModel;
import SobekDataModel.writer.crossSection.profileDef.ProfileDefPipe;
import SobekDataModel.writer.crossSection.profileDef.ProfileDefYZ;

/*
 * @ Parameter : type for crossSection
 * 
 * @ Necessary
 * 
 * @ Description :
 * 
 * currently there are only "yz-Profile" and "pipe-Profile"
 */
public enum CrossSectionType {
	PIPE("pipe"), YZ("yz");

	private String type;

	CrossSectionType(String type) {
		this.type = type;
	}

	public ProfileDatModel getProfileDat() throws Exception {
		switch (this.type) {

		case "yz":
			return new ProfileDatYZ();

		case "pipe":
			return new ProfileDatPipe();

		default:
			throw new Exception("*ERROR* not avaliable type, " + this.type);
		}
	}

	public ProfileDefModel getProfileDef() throws Exception {
		switch (this.type) {

		// ty 10
		case "yz":
			return new ProfileDefYZ();

		// ty0
		case "pipe":
			return new ProfileDefPipe();

		default:
			throw new Exception("*ERROR* not avaliable type, " + this.type);
		}
	}
}
