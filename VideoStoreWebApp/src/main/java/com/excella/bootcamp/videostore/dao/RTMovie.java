package com.excella.bootcamp.videostore.dao;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
public class RTMovie {

	private String title;
	private Integer year;
	private String synopsis;
	private Integer runtime;
	@JsonProperty(value="mpaa_rating")
	private String mpaaRating;

	public final String getTitle() {
		return title;
	}

	public final void setTitle(String title) {
		this.title = title;
	}

	public final Integer getYear() {
		return year;
	}

	public final void setYear(Integer year) {
		this.year = year;
	}

	public final String getSynopsis() {
		return synopsis;
	}

	public final void setSynopsis(String synopsis) {
		this.synopsis = synopsis;
	}

	public final Integer getRuntime() {
		return runtime;
	}

	public final void setRuntime(Integer runtime) {
		this.runtime = runtime;
	}
	
	public String getMpaaRating() {
		return mpaaRating;
	}

	public void setMpaaRating(String mpaaRating) {
		this.mpaaRating = mpaaRating;
	}

	@Override
	public int hashCode() {
		// you pick a hard-coded, randomly chosen, non-zero, odd number
		// ideally different for each class
		return new HashCodeBuilder(17, 37)
			.append(title)
			.append(year)
			.append(synopsis)
			.append(runtime)
			.append(mpaaRating)
			.toHashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (obj == this) {
			return true;
		}
		if (obj.getClass() != getClass()) {
			return false;
		}
		
		RTMovie rhs = (RTMovie) obj;
		return new EqualsBuilder()
			.append(title, rhs.title)
			.append(year, rhs.year)
			.append(synopsis, rhs.synopsis)
			.append(runtime, rhs.runtime)
			.append(mpaaRating, rhs.mpaaRating)
			.isEquals();
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}


}
