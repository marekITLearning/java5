package sk.itlearning.java5.pers.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import io.swagger.v3.oas.annotations.media.Schema;

@Entity
@Schema(description = "Object to collect movie main information")
public class Title {

	public static String F_tconst = "tconst";

	public static String F_primarytitle = "primarytitle";

	public static String F_startyear = "startyear";

	@Id
	private String tconst;

	@Schema(description = "Primary title is the main movie title as used publicly")
	private String primarytitle;

	@Schema(description = "Year of issue")
	private Integer startyear;

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

}
