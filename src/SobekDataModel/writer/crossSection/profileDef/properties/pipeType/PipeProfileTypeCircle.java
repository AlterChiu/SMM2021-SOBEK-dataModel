package SobekDataModel.writer.crossSection.profileDef.properties.pipeType;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

import SobekDataModel.Global;
import SobekDataModel.KeyValuePair;

public class PipeProfileTypeCircle implements PipeProfileType {
	private double width = Global.doubleNull;

	public double getWidth() throws Exception {
		if (this.width == Global.doubleNull)
			throw new Exception("*ERROR* width PipeProfile-Circle wasn't initial yet");
		return width;
	}

	public void setWidth(double width) {
		// TODO Auto-generated method stub
		this.width = new BigDecimal(width).setScale(Global.dataDecimale, RoundingMode.HALF_UP).doubleValue();
	}

	@Override
	public List<KeyValuePair<String, Double>> getKeyValues() throws Exception {
		List<KeyValuePair<String, Double>> outList = new ArrayList<>();

		outList.add(new KeyValuePair<String, Double>("cw", this.getWidth()));

		return outList;
	}

}
