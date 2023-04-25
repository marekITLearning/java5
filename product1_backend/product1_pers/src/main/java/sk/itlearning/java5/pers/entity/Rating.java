package sk.itlearning.java5.pers.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Rating {

	@Id
	private String tconst;

	private Float averagerating;

	private Integer numvotes;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "tconst", referencedColumnName = "tconst", insertable = false, updatable = false)
	private Title title;

	public String getTconst() {
		return tconst;
	}

	public void setTconst(String tconst) {
		this.tconst = tconst;
	}

	public Float getAveragerating() {
		return averagerating;
	}

	public void setAveragerating(Float averagerating) {
		this.averagerating = averagerating;
	}

	public Integer getNumvotes() {
		return numvotes;
	}

	public void setNumvotes(Integer numvotes) {
		this.numvotes = numvotes;
	}

	public Title getTitle() {
		return title;
	}

	public void setTitle(Title title) {
		this.title = title;
	}

}