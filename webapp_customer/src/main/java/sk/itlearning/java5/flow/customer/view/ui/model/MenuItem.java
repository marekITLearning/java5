package sk.itlearning.java5.flow.customer.view.ui.model;

import java.io.Serializable;

public class MenuItem implements Serializable {

	private static final long serialVersionUID = 1L;

	private String name;
	private String pageName;
	private boolean hidden;

	public MenuItem() {
		super();
	}

	public MenuItem(Page page) {
		this.name = page.getMenuLabel();
		this.pageName = page.getModuleId();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPageName() {
		return pageName;
	}

	public void setPageName(String pageName) {
		this.pageName = pageName;
	}

	public boolean isHidden() {
		return hidden;
	}

	public void setHidden(boolean hidden) {
		this.hidden = hidden;
	}

	@Override
	public String toString() {
		return "MenuItem: " + name + "; PageName (moduleId): " + pageName + "; Hidden: " + hidden;
	}

}
