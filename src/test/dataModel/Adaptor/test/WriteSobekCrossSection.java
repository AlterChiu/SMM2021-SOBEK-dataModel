package dataModel.Adaptor.test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

import com.opencsv.exceptions.CsvException;

import h2beaver.smm.model.crossSection.AbstractCrossSection;
import h2beaver.sobek.lit.CrossSectionProfile;
import h2beaver.sobek.lit.FileLoader;
import h2beaver.sobek.lit.LitDataType;
import h2beaver.sobek.lit.Network;
import h2beaver.sobek.tools.utils.SobekLitUtils;

public class WriteSobekCrossSection {
	public List<AbstractCrossSection> getCrossSectionList() throws IOException, CsvException, URISyntaxException {

		// Loading all lit files from test/resources/HsinchuLit/1.
		URI uri = Objects.requireNonNull(getClass().getClassLoader().getResource("sobekLit/HsinchuLit/1")).toURI();
		Path standardPath = Paths.get(uri);
		FileLoader fileLoader = new FileLoader(standardPath);

		// process-Middleware for network
		Network network = Network.load(fileLoader);
		// process-Middleware for cross section
		Map<String, CrossSectionProfile> profiles = CrossSectionProfile.load(fileLoader);

		// generate crossSections list
		List<AbstractCrossSection> abstractCrossSections = profiles.values().stream()
				.filter(csp -> csp.getType() != LitDataType.CROSS_SECTION.STON).map(p -> p.resolveNetwork(network))
				.map(SobekLitUtils::toCrossSection).filter(Objects::nonNull).collect(Collectors.toList());

		return abstractCrossSections;
	}

	public void saveProfileDef(List<String> profileDef) throws URISyntaxException, IOException {
		this.save(profileDef, "profile.def");
	}

	public void saveProfileDat(List<String> profileDat) throws URISyntaxException, IOException {
		this.save(profileDat, "profile.dat");
	}

	public void save(List<String> content, String saveName) throws URISyntaxException, IOException {
		String saveFolder = "C:\\Users\\alterChiu-Home\\Downloads\\model-tools-new\\";
		BufferedWriter writer = new BufferedWriter(
				new OutputStreamWriter(new FileOutputStream(saveFolder + saveName), "UTF-8"));

		writer.write(String.join("\r\n", content));
		writer.close();
	}
}