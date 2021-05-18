package SobekDataModel.writer.crossSection.profileDat;

public class ProfileDatPipe extends ProfileDatModel {

	@Override
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
			outString.append("CRSN");
			outString.append(" id '" + this.id + "'");
			outString.append(" di '" + this.getReferenceProfile() + "'");
			outString.append(" rl " + this.bedLevel);
			outString.append(" ll " + this.pipeTopLevel);
			outString.append(" crsn");
			return outString.toString();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
