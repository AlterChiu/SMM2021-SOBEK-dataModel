package SobekDataModel.writer.crossSection.profileDef.properties.pipeType;

import java.util.List;

import SobekDataModel.KeyValuePair;

public interface PipeProfileType {
	public List<KeyValuePair<String, Double>> getKeyValues() throws Exception;
}
