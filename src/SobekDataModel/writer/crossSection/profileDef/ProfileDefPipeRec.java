package SobekDataModel.writer.crossSection.profileDef;

import java.util.List;

import SobekDataModel.KeyValuePair;

public class ProfileDefPipeRec extends ProfileDefModel {

	public ProfileDefPipeRec() {
		this.type = "0";
	}

	public Boolean checkNecessaryProperty() throws Exception {
		// TODO Auto-generated method stub

		if (this.isIdNull())
			throw new Exception("*ERROR* no id (key:id) for crossSection");

		if (this.isMainChannelWidthNull())
			throw new Exception("*ERROR* no main channel width (key:wm) for crossSection");
		
		if(this.isPipeCrossSectionNull()) {
			throw new Exception("*ERROR* no pipe crossSection (key:lt lw)");
		}
		
		// ======================================================
		// there is another property, pipeCrossSection type need to be check,
		// but it will be auto check while getting keyvaluePair,
		// so there is no needed hear
		// ======================================================

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

			// set main channel width
			KeyValuePair mainChannelWidth = this.getMainChannelWidthKeyValue();
			outString.append(" " + mainChannelWidth.getKey() + " " + mainChannelWidth.getValue());

			// setting pipe crossSection type
			try {
				List<KeyValuePair<String, Double>> recPipeTypeValues = this.getRecPipeProfileType().getKeyValues();
				recPipeTypeValues.forEach(keyValue -> {
					outString.append(" " + keyValue.getKey() + " " + keyValue.getValue());
				});
			} catch (Exception e) {
				new Exception("*WRAN* no RecPipe type in, sobek id " + id.getValue());
			}

			// set flood plain 1
			KeyValuePair floodPlain1 = this.getFloodplainWidth1KeyValue();
			outString.append(" " + floodPlain1.getKey() + " " + floodPlain1.getValue());

			// set flood plain 2
			KeyValuePair floodPlain2 = this.getFloodplainWidth1KeyValue();
			outString.append(" " + floodPlain2.getKey() + " " + floodPlain2.getValue());

			// set ground layer depth
			KeyValuePair groundDepth = this.getGroundDepthKeyValue();
			outString.append(" " + groundDepth.getKey() + " " + groundDepth.getValue());

			// set ground layer using or not
			KeyValuePair groundLayerUse = this.getGroundLayerUseKeyValue();
			outString.append(" " + groundLayerUse.getKey() + " " + groundLayerUse.getValue());

			// set ground layer using or not
			KeyValuePair pipeCrossSection = this.getPipeCrossSectionKeyValue();
			outString.append(" " + pipeCrossSection.getKey() + "\r\n" + pipeCrossSection.getValue() + "\r\n");

			// end tag
			outString.append("crds");

			return outString.toString();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
