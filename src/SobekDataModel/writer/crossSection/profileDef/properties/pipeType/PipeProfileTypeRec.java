package SobekDataModel.writer.crossSection.profileDef.properties.pipeType;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

import SobekDataModel.Global;
import SobekDataModel.KeyValuePair;

public class PipeProfileTypeRec implements PipeProfileType {

	private double width = Global.doubleNull;
	private double height = Global.doubleNull;

	public double getWidth() throws Exception {
		if (this.width == Global.doubleNull)
			throw new Exception("*ERROR* width PipeProfile-Rectangle wasn't initial yet");
		return width;
	}

	public void setWidth(double width) {
		// TODO Auto-generated method stub
		this.width = new BigDecimal(width).setScale(Global.dataDecimale, RoundingMode.HALF_UP).doubleValue();
	}

	public double getHeight() throws Exception {
		if (this.height == Global.doubleNull)
			throw new Exception("*ERROR* height PipeProfile-Rectangle wasn't initial yet");
		return height;
	}

	public void setHeight(double height) {
		this.height = new BigDecimal(height).setScale(Global.dataDecimale, RoundingMode.HALF_UP).doubleValue();
	}

	@Override
	public List<KeyValuePair<String, Double>> getKeyValues() throws Exception {
		List<KeyValuePair<String, Double>> outList = new ArrayList<>();

		outList.add(new KeyValuePair<String, Double>("rw", this.getWidth()));
		outList.add(new KeyValuePair<String, Double>("rh", this.getHeight()));

		return outList;
	}

}
