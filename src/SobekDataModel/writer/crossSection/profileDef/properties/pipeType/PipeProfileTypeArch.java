package SobekDataModel.writer.crossSection.profileDef.properties.pipeType;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

import SobekDataModel.Global;
import SobekDataModel.KeyValuePair;

public class PipeProfileTypeArch implements PipeProfileType {

	private double width = Global.doubleNull;
	private double height1 = Global.doubleNull;
	private double height2 = Global.doubleNull;

	public double getWidth() throws Exception {
		if (this.width == Global.doubleNull)
			throw new Exception("*ERROR* width PipeProfile-Arch wasn't initial yet");
		return width;
	}

	public void setWidth(double width) {
		// TODO Auto-generated method stub
		this.width = new BigDecimal(width).setScale(Global.dataDecimale, RoundingMode.HALF_UP).doubleValue();
	}

	public double getHeight1() throws Exception {
		if (this.height1 == Global.doubleNull)
			throw new Exception("*ERROR* height1 PipeProfile-Arch wasn't initial yet");
		return height1;
	}

	public void setHeight1(double height) {
		this.height1 = new BigDecimal(height).setScale(Global.dataDecimale, RoundingMode.HALF_UP).doubleValue();
	}

	public double getHeight2() throws Exception {
		if (this.height2 == Global.doubleNull)
			throw new Exception("*ERROR* height2 PipeProfile-Arch wasn't initial yet");
		return height2;
	}

	public void setHeight2(double height) {
		this.height2 = new BigDecimal(height).setScale(Global.dataDecimale, RoundingMode.HALF_UP).doubleValue();
	}

	@Override
	public List<KeyValuePair<String, Double>> getKeyValues() throws Exception {
		List<KeyValuePair<String, Double>> outList = new ArrayList<>();

		outList.add(new KeyValuePair<String, Double>("aw", this.getWidth()));
		outList.add(new KeyValuePair<String, Double>("ah", this.getHeight1()));
		outList.add(new KeyValuePair<String, Double>("aa", this.getHeight2()));

		return outList;
	}
}
