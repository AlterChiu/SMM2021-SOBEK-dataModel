package dataModel.Adaptor.test;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

import com.opencsv.exceptions.CsvException;

import dataModel.Adaptor.ProfileDat.AdaptorProfileDat;
import dataModel.Adaptor.ProfileDef.AdaptorProfileDef;
import h2beaver.smm.model.crossSection.AbstractCrossSection;
import h2beaver.sobek.lit.CrossSectionProfile;
import h2beaver.sobek.lit.FileLoader;
import h2beaver.sobek.lit.LitDataType;
import h2beaver.sobek.lit.Network;
import h2beaver.sobek.tools.utils.SobekLitUtils;

public class test {

	public static void main(String[] args) throws IOException, CsvException, URISyntaxException {
		// TODO Auto-generated method stub

		WriteSobekCrossSection writer = new WriteSobekCrossSection();

		List<AbstractCrossSection> crossSections = writer.getCrossSectionList();
		List<String> profileDat = new ArrayList<>();
		List<String> profileDef = new ArrayList<>();

		crossSections.forEach(crossSection -> {
			String id = crossSection.getProperties().get("sobek_id").toString();
			System.out.print(id + "\t");

			try {
				profileDat.add(AdaptorProfileDat.getModel(crossSection).toString());
				System.out.print("datOK\t");
			} catch (Exception e) {
				System.out.print("datFaild\t");
			}

			try {
				profileDef.add(AdaptorProfileDef.getModel(crossSection).toString());
				System.out.print("defOK\t");
			} catch (Exception e) {
				e.printStackTrace();
				System.out.print("defFaild\t");
			}
			System.out.println();
		});

		writer.saveProfileDat(profileDat);
		writer.saveProfileDef(profileDef);

	}

}
