
class PHR {
	String name;
	double height;
	double weight;
	int heartRate;

	PHR(final String name, final double height, final double weight, final int heartRate) {
		this.name = name;
		this.height = height;
		this.weight = weight;
		this.heartRate = heartRate;
	}

	/**
	 * Calculates the given PHR's BMI, given by the formula:
	 * 
	 * <code>weight / (height * height)</code>
	 */
	public double getBMI() {
		return weight / (height * height);
	}


}
