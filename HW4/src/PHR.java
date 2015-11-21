
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

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + heartRate;
		long temp;
		temp = Double.doubleToLongBits(height);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		temp = Double.doubleToLongBits(weight);
		result = prime * result + (int) (temp ^ (temp >>> 32));


		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(final Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		final PHR other = (PHR) obj;
		if (heartRate != other.heartRate)
			return false;
		if (Double.doubleToLongBits(height) != Double
				.doubleToLongBits(other.height))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (Double.doubleToLongBits(weight) != Double
				.doubleToLongBits(other.weight))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "PHR [" + (name != null ? "name=" + name + ", " : "")
				+ "height=" + height + ", weight=" + weight + ", heartRate="
				+ heartRate + "]";
	}



}
