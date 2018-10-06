package sk.itlearning.java5.flow.customer.view.cse.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class OeCase implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<CaseStep> steps = new ArrayList<CaseStep>();

	private Integer currentStepIdx;

	private String currentStepName;

	public List<CaseStep> getSteps() {
		return steps;
	}

	public void setSteps(List<CaseStep> steps) {
		this.steps = steps;
	}

	public CaseStep getStepById(Integer id) {
		return getSteps().stream().filter(i -> i.getStepIdx().equals(id)).findFirst().get();
	}

	public String getCurrentStepName() {
		return currentStepName;
	}

	public void setCurrentStepName(String currentStepName) {
		this.currentStepName = currentStepName;
	}

	public Integer getCurrentStepIdx() {
		return currentStepIdx;
	}

	public void setCurrentStepIdx(Integer currentStepIdx) {
		this.currentStepIdx = currentStepIdx;
	}

}
