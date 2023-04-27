package sk.itlearning.java5.pers.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Title {

	public static String F_tconst = "tconst";

	public static String F_primarytitle = "primarytitle";

	public static String F_startyear = "startyear";

	@Id
	private String tconst;

	private String primarytitle;

	private Integer startyear;
	
	private Integer runtimeMinutes;

	public String getTconst() {
		return tconst;
	}

	public void setTconst(String tconst) {
		this.tconst = tconst;
	}

	public String getPrimarytitle() {
		return primarytitle;
	}

	public void setPrimarytitle(String primarytitle) {
		this.primarytitle = primarytitle;
	}

	public Integer getStartyear() {
		return startyear;
	}

	public void setStartyear(Integer startyear) {
		this.startyear = startyear;
	}

	public Integer getRuntimeMinutes() {
		return runtimeMinutes;
	}

	public void setRuntimeMinutes(Integer runtimeMinutes) {
		this.runtimeMinutes = runtimeMinutes;
	}

}
