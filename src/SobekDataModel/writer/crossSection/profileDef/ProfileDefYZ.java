package SobekDataModel.writer.crossSection.profileDef;

import SobekDataModel.KeyValuePair;

public class ProfileDefYZ extends ProfileDefModel {

	public ProfileDefYZ() {
		this.type = "10";
	}

	public Boolean checkNecessaryProperty() throws Exception {
		// TODO Auto-generated method stub
		if (this.isIdNull())
			throw new Exception("*ERROR* no id (key:id) for crossSection");

		if (this.isYzCrossSectionIsNull())
			throw new Exception("*ERROR* no yz-CrossSection (lt yz) for crossSection");

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

			// set storage type
			KeyValuePair storageType = this.getStorageTypeKeyValue();
			outString.append(" " + storageType.getKey() + " " + storageType.getValue());

			// set pipeTopLevel
			KeyValuePair storageWidth = this.getStorageWidthKeyValue();
			outString.append(" " + storageWidth.getKey() + " " + storageWidth.getValue());

			// set ground layer depth
			KeyValuePair groundDepth = this.getGroundDepthKeyValue();
			outString.append(" " + groundDepth.getKey() + " " + groundDepth.getValue());

			// set ground layer using or not
			KeyValuePair groundLayerUse = this.getGroundLayerUseKeyValue();
			outString.append(" " + groundLayerUse.getKey() + " " + groundLayerUse.getValue());

			// set yz-CrossSection profile table
			KeyValuePair yzTable = this.getYzCrossSectionKeyValue();
			outString.append(" " + yzTable.getKey() + "\r\n" + yzTable.getValue());

			// end tag
			outString.append("\r\ncrds");

			return outString.toString();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
