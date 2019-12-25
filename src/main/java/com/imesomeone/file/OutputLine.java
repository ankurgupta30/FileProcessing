package com.imesomeone.file;

import java.io.Serializable;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.List;
import java.util.Map.Entry;
import java.util.OptionalDouble;

public class OutputLine implements Serializable {

	private String cityOrCountryName;
	private String Gender;
	private OptionalDouble averageIncome;
	 private static DecimalFormat df2 = new DecimalFormat("#.##");

	public OutputLine(String cityOrCountryName, String Gender, OptionalDouble averageIncome) {
		this.cityOrCountryName = cityOrCountryName;
		this.Gender = Gender;
		this.averageIncome = averageIncome;
	}

	public OutputLine(Entry<String, List<Double>> entry) {
		String[] key = entry.getKey().split("-");
		this.cityOrCountryName = key[0];
		this.Gender = key[1];
		this.averageIncome = entry.getValue().stream().mapToDouble(a -> a).average();
		// this.averageIncome = entry.getValue().stream().mapToDouble(a -> a).average();
		// //Get it from List
	}

	public String getCityOrCountryName() {
		return cityOrCountryName;
	}

	public void setCityOrCountryName(String cityOrCountryName) {
		this.cityOrCountryName = cityOrCountryName;
	}

	public String getGender() {
		return Gender;
	}

	public void setGender(String gender) {
		Gender = gender;
	}

	public OptionalDouble getAverageIncome() {
		return averageIncome;
	}

	public void setAverageIncome(OptionalDouble averageIncome) {
		this.averageIncome = averageIncome;
	}

	public String toString() {
		StringBuilder builder = new StringBuilder(getCityOrCountryName());
		builder.append(",");
		builder.append(getGender());
		builder.append(",");
		df2.setRoundingMode(RoundingMode.UP);
		builder.append(df2.format(getAverageIncome().getAsDouble()));
		//builder.append(String.format("%.2f", getAverageIncome().getAsDouble()));
		return builder.toString();
	}
}
