package SobekDataModel.writer.crossSection.profileDat;

import SobekDataModel.KeyValuePair;

public class ProfileDatPipe extends ProfileDatModel {

	public Boolean checkNecessaryProperty() throws Exception {
		// TODO Auto-generated method stub

		if (this.isIdNull())
			throw new Exception("*ERROR* no id (key:id) for crossSection");

		if (this.isReferenceProfileNull())
			throw new Exception("*ERROR* no referenceProfile (key:di) for crossSection");

		if (this.isPipeTopLevelNull())
			throw new Exception("*ERROR* no pipeLevel (key:ll) for crossSection");

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

			// set pipeTopLevel
			KeyValuePair pipeTopLevel = this.getPipeTopLevelKeyValue();
			outString.append(" " + pipeTopLevel.getKey() + " " + pipeTopLevel.getValue());
			
			// end tag
			outString.append(" crsn");
			return outString.toString();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
