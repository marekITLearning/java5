package sk.itlearning.java5.flow.customer.view.cse.model;

import java.io.Serializable;

public class CaseStep implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer stepIdx;
	private String name;
	private String status;
	private String jsonData;

	public CaseStep() {
		super();
	}

	public CaseStep(int steIdx, String name) {
		this.setStepIdx(steIdx);
		this.setName(name);
	}

	public Integer getStepIdx() {
		return stepIdx;
	}

	public void setStepIdx(Integer stepIdx) {
		this.stepIdx = stepIdx;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getJsonData() {
		return jsonData;
	}

	public void setJsonData(String jsonData) {
		this.jsonData = jsonData;
	}

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append(getStepIdx() + "\n");
		sb.append(name + "\n");
		sb.append(status + "\n");
		return sb.toString();
	}

}
