package sk.itlearning.java5.flow.customer.view.ui.model;

public enum Page {

	Overview("Customers", "over-view"),
	NewCase("New Customer", "new-case");
	
	private String menuLabel;
	private String moduleId;

	private Page(String menuLabel, String moduleId) {
		this.setMenuLabel(menuLabel);
		this.setModuleId(moduleId);
	}

	public String getMenuLabel() {
		return menuLabel;
	}

	public void setMenuLabel(String label) {
		this.menuLabel = label;
	}

	public String getModuleId() {
		return moduleId;
	}

	public void setModuleId(String moduleId) {
		this.moduleId = moduleId;
	}

}
