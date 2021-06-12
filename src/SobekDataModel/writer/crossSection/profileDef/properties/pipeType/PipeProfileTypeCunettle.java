package SobekDataModel.writer.crossSection.profileDef.properties.pipeType;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

import SobekDataModel.Global;
import SobekDataModel.KeyValuePair;

public class PipeProfileTypeCunettle implements PipeProfileType {

	private double height = Global.doubleNull;
	private double radiosR = Global.doubleNull;
	private double radiosR1 = Global.doubleNull;
	private double radiosR2 = Global.doubleNull;
	private double radiosR3 = Global.doubleNull;
	private double amgleA = Global.doubleNull;
	private double amgleA1 = Global.doubleNull;

	public double getHeight() throws Exception {
		if (this.height == Global.doubleNull)
			throw new Exception("*ERROR* height PipeProfile-Cunettle wasn't initial yet");
		return height;
	}

	public void setHeight(double height) {
		// TODO Auto-generated method stub
		this.height = new BigDecimal(height).setScale(Global.dataDecimale, RoundingMode.HALF_UP).doubleValue();
	}

	public double getRadiosR() throws Exception {
		if (this.radiosR == Global.doubleNull)
			throw new Exception("*ERROR* radiosR PipeProfile-Cunettle wasn't initial yet");
		return radiosR;
	}

	public void setRadiosR(double radiosR) {
		// TODO Auto-generated method stub
		this.radiosR = new BigDecimal(radiosR).setScale(Global.dataDecimale, RoundingMode.HALF_UP).doubleValue();
	}

	public double getRadiosR1() throws Exception {
		if (this.radiosR1 == Global.doubleNull)
			throw new Exception("*ERROR* radiosR1 PipeProfile-Cunettle wasn't initial yet");
		return radiosR1;
	}

	public void setRadiosR1(double radiosR1) {
		// TODO Auto-generated method stub
		this.radiosR1 = new BigDecimal(radiosR1).setScale(Global.dataDecimale, RoundingMode.HALF_UP).doubleValue();
	}

	public double getRadiosR2() throws Exception {
		if (this.radiosR2 == Global.doubleNull)
			throw new Exception("*ERROR* radiosR2 PipeProfile-Cunettle wasn't initial yet");
		return radiosR2;
	}

	public void setRadiosR2(double radiosR2) {
		// TODO Auto-generated method stub
		this.radiosR2 = new BigDecimal(radiosR2).setScale(Global.dataDecimale, RoundingMode.HALF_UP).doubleValue();
	}

	public double getRadiosR3() throws Exception {
		if (this.radiosR3 == Global.doubleNull)
			throw new Exception("*ERROR* radiosR3 PipeProfile-Cunettle wasn't initial yet");
		return radiosR3;
	}

	public void setRadiosR3(double radiosR3) {
		// TODO Auto-generated method stub
		this.radiosR3 = new BigDecimal(radiosR3).setScale(Global.dataDecimale, RoundingMode.HALF_UP).doubleValue();
	}

	public double getAmgleA() throws Exception {
		if (this.amgleA == Global.doubleNull)
			throw new Exception("*ERROR* amgleA PipeProfile-Cunettle wasn't initial yet");
		return amgleA;
	}

	public void setAmgleA(double amgleA) {
		// TODO Auto-generated method stub
		this.amgleA = new BigDecimal(amgleA).setScale(Global.dataDecimale, RoundingMode.HALF_UP).doubleValue();
	}

	public double getamgleA1() throws Exception {
		if (this.amgleA1 == Global.doubleNull)
			throw new Exception("*ERROR* amgleA1 PipeProfile-Cunettle wasn't initial yet");
		return amgleA1;
	}

	public void setamgleA1(double amgleA1) {
		// TODO Auto-generated method stub
		this.amgleA1 = new BigDecimal(amgleA1).setScale(Global.dataDecimale, RoundingMode.HALF_UP).doubleValue();
	}


	@Override
	public List<KeyValuePair<String, Double>> getKeyValues() throws Exception {
		List<KeyValuePair<String, Double>> outList = new ArrayList<>();

		outList.add(new KeyValuePair<String, Double>("sh", this.getHeight()));
		outList.add(new KeyValuePair<String, Double>("sr", this.getRadiosR()));
		outList.add(new KeyValuePair<String, Double>("sr1", this.getRadiosR1()));
		outList.add(new KeyValuePair<String, Double>("sr2", this.getRadiosR2()));
		outList.add(new KeyValuePair<String, Double>("sr3", this.getRadiosR3()));
		outList.add(new KeyValuePair<String, Double>("sa", this.getAmgleA()));
		outList.add(new KeyValuePair<String, Double>("sa", this.getamgleA1()));

		return outList;
	}

}
