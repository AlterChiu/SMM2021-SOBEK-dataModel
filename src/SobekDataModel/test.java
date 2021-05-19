package SobekDataModel;

import SobekDataModel.writer.crossSection.CrossSectionType;
import SobekDataModel.writer.crossSection.profileDat.ProfileDatModel;

public class test {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		/*
		 * @Title : profile.dat testing
		 */
		// <========================================================>
		// pipe object
		ProfileDatModel pipeProfileDat = CrossSectionType.PIPE.getProfileDat();
		pipeProfileDat.setId("l_TW-TP1_1");
		pipeProfileDat.setReferenceProfile("P02_P04_0000025");
		pipeProfileDat.setBedLevel(19.31);
		pipeProfileDat.setPipeTopLevel(19.52);
		System.out.println(pipeProfileDat.toString());

		// yz object
		ProfileDatModel yzProfileDat = CrossSectionType.YZ.getProfileDat();
		yzProfileDat.setId("1339");
		yzProfileDat.setReferenceProfile("P01_D75600-18194");
		yzProfileDat.setBedLevel(0);
		yzProfileDat.setLevelLeft(6.57);
		System.out.println(yzProfileDat.toString());
		// <========================================================>
	}

	public static String firstUpcase(String name) {
		String first = name.substring(0, 1).toUpperCase();
		String last = name.substring(1, name.length());
		return first + last;
	}

}
