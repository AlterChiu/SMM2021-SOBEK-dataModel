package dataModel.Adaptor.ProfileDat;

import java.util.Map;

import SobekDataModel.writer.crossSection.CrossSectionType;
import SobekDataModel.writer.crossSection.profileDat.ProfileDatModel;
import h2beaver.smm.model.crossSection.AbstractCrossSection;

public class AdaptorProfileDat {

	public static ProfileDatModel getModel(AbstractCrossSection crossSection) throws Exception {

		ProfileDatModel model;
		Map<String, Object> properties = crossSection.getProperties();

		// yzProfile
		if (properties.containsKey("rs")) {
			model = CrossSectionType.YZ.getProfileDat();
			model.setId(properties.get("sobek_id").toString());
			model.setReferenceProfile(properties.get("referent_id").toString());
			model.setLevelLeft(Double.parseDouble(properties.get("rs").toString()));
			model.setBedLevel(Double.parseDouble(properties.get("rl").toString()));
			return model;

			// pipe profile
		} else if (properties.containsKey("ll")) {
			model = CrossSectionType.PIPE.getProfileDat();
			model.setId(properties.get("sobek_id").toString());
			model.setReferenceProfile(properties.get("di").toString());
			model.setPipeTopLevel(Double.parseDouble(properties.get("ll").toString()));
			model.setBedLevel(Double.parseDouble(properties.get("rl").toString()));
			return model;
		} else {
			throw new Exception(
					"*ERROR* not available type for crossSection, while adpating from AbstractCrossSection to ProfileDatModel");
		}
	}

}
