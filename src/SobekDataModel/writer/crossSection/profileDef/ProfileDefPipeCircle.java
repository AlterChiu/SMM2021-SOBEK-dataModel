package SobekDataModel.writer.crossSection.profileDef;

import java.util.List;

import SobekDataModel.KeyValuePair;

public class ProfileDefPipeCircle extends ProfileDefModel {

	public ProfileDefPipeCircle() {
		this.type = "4";
	}

	public Boolean checkNecessaryProperty() throws Exception {
		// TODO Auto-generated method stub

		if (this.isIdNull())
			throw new Exception("*ERROR* no id (key:id) for crossSection");

		if (this.isBedLevelNull())
			throw new Exception("*ERROR* no bed level  (key:bl) for crossSection");

		if (this.isRadiusNull())
			throw new Exception("*ERROR* no radius  (key:rd) for crossSection");

		return true;
	}

	@Override
	public String toString() {
		try {
			// check for all properties is not null
			this.checkNecessaryProperty();

			StringBuilder outString = new StringBuilder();

			// start tag
			outString.append("CRDS");

			// set id
			KeyValuePair id = this.getIdKeyValue();
			outString.append(" " + id.getKey() + " '" + id.getValue() + "'");

			// set name(default same as id)
			KeyValuePair name = this.getNameKeyValue();
			outString.append(" " + name.getKey() + " '" + name.getValue() + "'");

			// set type
			outString.append(" ty " + this.getType());

			// set flood plain 1
			KeyValuePair bedLevel = this.getBedLevelKeyValue();
			outString.append(" " + bedLevel.getKey() + " " + bedLevel.getValue());

			// set flood plain 2
			KeyValuePair radius = this.getRadiusKeyValue();
			outString.append(" " + radius.getKey() + " " + radius.getValue());

			// end tag
			outString.append("crds");

			return outString.toString();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
