package SobekDataModel.writer.crossSection.profileDef;

import java.util.List;

import SobekDataModel.KeyValuePair;
import SobekDataModel.writer.crossSection.profileDef.properties.pipeType.PipeProfileTypeRec;

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

		// check for crossSection type in RecPipe (ty = 0)
		if (this.isRecPipeProfileTypeNull())
			throw new Exception("*ERROR* missing profile type for recPipe, in crossection ty=0");

		// if crossSection type not equals to square
		if (!(this.getRecPipeProfileType() instanceof PipeProfileTypeRec)) {

			// check for table value is exist or not
			if (this.isPipeCrossSectionNull()) {
				throw new Exception("*ERROR* no pipe crossSection (key:lt lw)");
			}
		}

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

			// Optional
			// ========================================================================

			// set crossSection table
			// auto create table
			if (this.getRecPipeProfileType() instanceof PipeProfileTypeRec) {
				double height = ((PipeProfileTypeRec) this.getRecPipeProfileType()).getHeight();
				double width = ((PipeProfileTypeRec) this.getRecPipeProfileType()).getWidth();

				ProfileDefTable table = new ProfileDefTable();
				table.addValue(0, width, width);
				table.addValue(height, width, width);
				table.addValue(height + 0.0001, 0.0001, 0.0001);
				outString.append(" " + table.toString());

				// using table value
			} else {
				KeyValuePair pipeCrossSection = this.getPipeCrossSectionKeyValue();
				outString.append(" " + pipeCrossSection.getKey() + "\r\n" + pipeCrossSection.getValue());
			}

			// END
			// ========================================================================
			// end tag
			outString.append(" crds");

			return outString.toString();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static void recTableCreate(double rw, double rh) {

	}

}
