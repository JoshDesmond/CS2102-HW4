import java.util.LinkedList;

class BMISummary {
	LinkedList<String> under;
	LinkedList<String> healthy;
	LinkedList<String> over;
	LinkedList<String> obese;

	/**
	 * Build BMI summary in the given order: under, healthy, over, obese
	 */
	BMISummary(final LinkedList<String> under, final LinkedList<String> healthy,
			final LinkedList<String> over, final LinkedList<String> obese) {
		this.under = under;
		this.healthy = healthy;
		this.over = over;
		this.obese = obese;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((healthy == null) ? 0 : healthy.hashCode());
		result = prime * result + ((obese == null) ? 0 : obese.hashCode());
		result = prime * result + ((over == null) ? 0 : over.hashCode());
		result = prime * result + ((under == null) ? 0 : under.hashCode());
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
		final BMISummary other = (BMISummary) obj;
		if (healthy == null) {
			if (other.healthy != null)
				return false;
		} else if (!healthy.equals(other.healthy))
			return false;
		if (obese == null) {
			if (other.obese != null)
				return false;
		} else if (!obese.equals(other.obese))
			return false;
		if (over == null) {
			if (other.over != null)
				return false;
		} else if (!over.equals(other.over))
			return false;
		if (under == null) {
			if (other.under != null)
				return false;
		} else if (!under.equals(other.under))
			return false;
		return true;
	}


}