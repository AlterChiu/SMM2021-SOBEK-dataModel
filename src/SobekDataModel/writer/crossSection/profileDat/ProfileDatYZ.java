package SobekDataModel.writer.crossSection.profileDat;

import SobekDataModel.KeyValuePair;

public class ProfileDatYZ extends ProfileDatModel {

	public Boolean checkNecessaryProperty() throws Exception {
		if (this.isIdNull())
			throw new Exception("*ERROR* no id (key:id) for crossSection");

		if (this.isReferenceProfileNull())
			throw new Exception("*ERROR* no referenceProfile (key:di) for crossSection");

		if (this.isLevelLeftNull())
			throw new Exception("*ERROR* no leftLevel (key:rs) for crossSection");

		if (this.isBedLevelNull())
			throw new Exception("*ERROR* no bedLevel (key:rl) for crossSection");

		return true;
	}

	@Override
	public String toString() {
		try {
			// check for all properties is not null
			this.checkNecessaryProperty();

			StringBuilder outString = new StringBuilder();

			// start tag
			outString.append("CRSN");

			// set id
			KeyValuePair id = this.getIdKeyValue();
			outString.append(" " + id.getKey() + " '" + id.getValue() + "'");

			// set reference profile id (id in profile.def)
			KeyValuePair referenceProfile = this.getReferenceProfileKeyValue();
			outString.append(" " + referenceProfile.getKey() + " '" + referenceProfile.getValue() + "'");

			// set bedLevel
			KeyValuePair bedLevel = this.getBedLevelKeyValue();
			outString.append(" " + bedLevel.getKey() + " " + bedLevel.getValue());

			// set left level of crossSection
			KeyValuePair leftLevel = this.getLevelLeftKeyValue();
			outString.append(" " + leftLevel.getKey() + " " + leftLevel.getValue());
			
//			// OPTIONAL
//			// ======================================================
//
//			// rightLevel
//			if (this.levelRight != Global.doubleNull) {
//				KeyValuePair rightLevel = this.getLevelRightKeyValue();
//				outString.append(" " + rightLevel.getKey() + " " + rightLevel.getValue());
//			}

			// end tag
			outString.append(" crsn");
			return outString.toString();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
