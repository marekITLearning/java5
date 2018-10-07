package sk.itlearning.java5.flow.customer.view.ui;

import java.util.ArrayList;
import java.util.List;

import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.HtmlImport;
import com.vaadin.flow.component.dependency.Uses;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.templatemodel.TemplateModel;

import sk.itlearning.java5.flow.customer.view.cse.NewCase;
import sk.itlearning.java5.flow.customer.view.overview.OverView;
import sk.itlearning.java5.flow.customer.view.ui.model.MenuItem;
import sk.itlearning.java5.flow.customer.view.ui.model.Page;

/**
 * A Designer generated component for the customer-app.html template.
 *
 * Designer will add and remove fields with @Id mappings but
 * does not overwrite or otherwise change this file.
 */
@Route("")
@Tag("customer-app")
@HtmlImport("src/views/ui/customer-app.html")
@Uses(OverView.class)
@Uses(NewCase.class)
public class CustomerApp extends PolymerTemplate<CustomerApp.CustomerAppModel> {

	private static final long serialVersionUID = 1L;

	/**
     * Creates a new CustomerApp.
     */
    public CustomerApp() {
    	List<MenuItem> menuItems = new ArrayList<>();
    	menuItems.add(new MenuItem(Page.Overview));
    	menuItems.add(new MenuItem(Page.NewCase));
    	getModel().setMenuItems(menuItems);
    	getModel().setSelectedItem(getMenuItem(Page.Overview));
    }

    /**
     * This model binds properties between CustomerApp and customer-app.html
     */
    public interface CustomerAppModel extends TemplateModel {
    	void setMenuItems(List<MenuItem> menuItems);
    	List<MenuItem> getMenuItems();
    	void setSelectedItem(MenuItem selectedItem);
    	MenuItem getSelectedItem();
    }

    /**
     * Get MenuItem for an item by page from Page enum
     */
    public MenuItem getMenuItem(Page page) {
		return getModel().getMenuItems().stream().filter(mi -> mi.getPageName().equals(page.getModuleId())).findFirst().get();
	}

}
