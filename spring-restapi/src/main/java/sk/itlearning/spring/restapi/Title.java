package sk.itlearning.spring.restapi;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Title {

	@Id
	private String tconst;
	private String primarytitle;
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
