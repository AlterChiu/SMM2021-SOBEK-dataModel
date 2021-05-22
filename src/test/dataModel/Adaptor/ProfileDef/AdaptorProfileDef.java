package dataModel.Adaptor.ProfileDef;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import SobekDataModel.writer.crossSection.CrossSectionType;
import SobekDataModel.writer.crossSection.profileDef.ProfileDefModel;
import SobekDataModel.writer.crossSection.profileDef.properties.ProfileDefProperties;
import SobekDataModel.writer.crossSection.profileDef.properties.ProfileDefProperties.pipeCrossSection;
import SobekDataModel.writer.crossSection.profileDef.properties.pipeType.PipeProfileTypeRec;
import h2beaver.smm.model.crossSection.AbstractCrossSection;

public class AdaptorProfileDef {

	public static ProfileDefModel getModel(AbstractCrossSection crossSection) throws Exception {

		ProfileDefModel model;
		Map<String, Object> properties = crossSection.getProperties();

		// yz-CrossSection
		if (properties.containsKey("profile")) {

			// get yz-Profile
			List<Double[]> yzValues = new ArrayList<>();

			for (Number[] array : (Number[][]) properties.get("profile")) {
				yzValues.add(new Double[] { array[0].doubleValue(), array[1].doubleValue() });
			}

			model = CrossSectionType.YZ.getProfileDef();
			model.setId(properties.get("sobek_id").toString());
			model.setYzCrossSection(yzValues);
			return model;

		} else {
			throw new Exception(
					"*ERROR* not available type for cossSection, while adpating from AbstractCrossSection to ProfileDefModel");
		}

//			// pipe crossSection
//		} else if (properties.containsKey("wm")) {

//			model = CrossSectionType.PIPE.getProfileDef();
//			model.setId(properties.get("sobek_id").toString());
//			model.setMainChannelWidth(Double.parseDouble(properties.get("wm").toString()));
//
//			PipeProfileTypeRec recPipe = (PipeProfileTypeRec) pipeCrossSection.Rectangle.getProfileType();
//			recPipe.setWidth(Double.parseDouble(properties.get("wm").toString()));
//			model.setPipeProfileType(457);
//
//			return model;
//		}

	}

}
