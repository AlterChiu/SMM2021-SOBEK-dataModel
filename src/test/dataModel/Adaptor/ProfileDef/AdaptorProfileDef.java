package test.dataModel.Adaptor.ProfileDef;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import SobekDataModel.writer.crossSection.CrossSectionType;
import SobekDataModel.writer.crossSection.profileDef.ProfileDefModel;
import SobekDataModel.writer.crossSection.profileDef.properties.ProfileDefProperties;
import SobekDataModel.writer.crossSection.profileDef.properties.pipeType.PipeProfileTypeRec;
import h2beaver.smm.model.crossSection.AbstractCrossSection;

public class AdaptorProfileDef {

	public static ProfileDefModel getModel(AbstractCrossSection crossSection) throws Exception {

		ProfileDefModel model;
		Map<String, Object> properties = crossSection.getProperties();

		// yz-CrossSection
		if (properties.containsKey("profile")) {
			model = CrossSectionType.YZ.getProfileDef();
			return setYzCrossSectionModel(model, properties);

			// rec-pipe crossSection
		} else if (properties.containsKey("wm")) {
			model = CrossSectionType.PIPEREC.getProfileDef();
			return setRecPipeCrossSectionModel(model, properties);

			// rec-pipe crossSection
		} else if (properties.containsKey("rd")) {
			model = CrossSectionType.PIPECIRCLE.getProfileDef();
			return setCirclePipeCrossSectionModel(model, properties);

		} else {
			throw new Exception(
					"*ERROR* not available type for cossSection, while adpating from AbstractCrossSection to ProfileDefModel");
		}

	}

	public static ProfileDefModel setYzCrossSectionModel(ProfileDefModel model, Map<String, Object> properties)
			throws Exception {
		// get yz-Profile
		List<Double[]> yzValues = new ArrayList<>();

		for (Number[] array : (Number[][]) properties.get("profile")) {
			yzValues.add(new Double[] { array[0].doubleValue(), array[1].doubleValue() });
		}

		model.setId(properties.get("sobek_id").toString());
		model.setYzCrossSection(yzValues);

		// ============OPTIONAL==========================
		Optional.ofNullable(properties.get("gl")).ifPresent(e -> {
			model.setGroundDepth(Double.parseDouble(e.toString()));
		});

		Optional.ofNullable(properties.get("gu")).ifPresent(e -> {
			model.setGroundLayerUse((int) Double.parseDouble(e.toString()));
		});
		return model;
	}

	public static ProfileDefModel setCirclePipeCrossSectionModel(ProfileDefModel model, Map<String, Object> properties)
			throws Exception {

		model.setId(properties.get("sobek_id").toString());
		model.setBedLevel(Double.parseDouble(properties.get("bl").toString()));
		model.setRadius(Double.parseDouble(properties.get("rd").toString()));

		return model;
	}

	public static ProfileDefModel setRecPipeCrossSectionModel(ProfileDefModel model, Map<String, Object> properties)
			throws Exception {

		model.setId(properties.get("sobek_id").toString());
		model.setMainChannelWidth(Double.parseDouble(properties.get("wm").toString()));

		// set table
		List<Double[]> tableValues = new ArrayList<>();
		((List<List<Double>>) properties.get("lt_lw")).forEach(values -> {
			tableValues.add(values.parallelStream().toArray(Double[]::new));
		});
		model.setPipeCrossSection(tableValues);

		// set edition properties
		if (properties.containsKey("rw") && properties.containsKey("rh")) {
			PipeProfileTypeRec recPipe = (PipeProfileTypeRec) ProfileDefProperties.RecPipeProfileType.Rectangle
					.getProfileType();
			recPipe.setWidth(Double.parseDouble(properties.get("rh").toString()));
			recPipe.setHeight(Double.parseDouble(properties.get("rw").toString()));
			model.setRecPipeProfileType(recPipe);
		}

		// ============OPTIONAL==========================
		Optional.ofNullable(properties.get("gl")).ifPresent(e -> {
			model.setGroundDepth(Double.parseDouble(e.toString()));
		});

		Optional.ofNullable(properties.get("gu")).ifPresent(e -> {
			model.setGroundLayerUse((int) Double.parseDouble(e.toString()));
		});

		Optional.ofNullable(properties.get("w1")).ifPresent(e -> {
			model.setFloodplainWidth1(Double.parseDouble(e.toString()));
		});

		Optional.ofNullable(properties.get("w2")).ifPresent(e -> {
			model.setFloodplainWidth1(Double.parseDouble(e.toString()));
		});

		Optional.ofNullable(properties.get("w2")).ifPresent(e -> {
			model.setFloodplainWidth1(Double.parseDouble(e.toString()));
		});

		return model;
	}

}
