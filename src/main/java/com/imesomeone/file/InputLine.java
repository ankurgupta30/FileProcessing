package com.imesomeone.file;

public class InputLine {
	private String city;
	private String country;
	private String gender;
	private String currency;
	private String amount;

	public static InputLine parse(String readLine) throws Exception {
		String[] parsedElements = readLine.split(",");
		if (parsedElements.length != 5) {
			throw new Exception("Unsupported File Format");
		} else {
			return new InputLine(parsedElements[0], parsedElements[1], parsedElements[2], parsedElements[3],
					parsedElements[4]);
		}
	}

	public InputLine(String city, String country, String gender, String currency, String amount) {
		this.city = city;
		this.country = country;
		this.gender = gender;
		this.currency = currency;
		this.amount = amount;
	}
	
	public boolean isValid() {
		try {
			getAmount();
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}


	public String getCityGenderKey() {
		return getCity() + "-" + getGender();
	}

	private Double getAmount() {
		return Double.valueOf(amount);
	}
	
	public Double getAmountInUSD() throws Exception { // Refactor this to use Math related Libraries; also this should
														// be extensible
		if (currency.equalsIgnoreCase("USD")) {
			return getAmount();
		} else if (currency.equalsIgnoreCase("HKD")) {
			return getAmount() / 8;
		} else if (currency.equalsIgnoreCase("GBP")) {
			return getAmount() / .67;
		} else if (currency.equalsIgnoreCase("SGP")) {
			return getAmount() / 1.5;
		} else if (currency.equalsIgnoreCase("INR")) {
			return getAmount() / 66;
		} else {
			throw new Exception("Currency is not supported : " + currency);
		}
	}

	public String toString() {
		StringBuilder builder =  new StringBuilder("Row Data [ ");
		builder.append(" City " + getCity());
		builder.append(" Country " + getCountry());
		builder.append(" Gender " + getGender());
		builder.append(" Currency " + getCurrency());
		builder.append(" amount " + amount);
		builder.append(" ]");
		return builder.toString();
	}
}
