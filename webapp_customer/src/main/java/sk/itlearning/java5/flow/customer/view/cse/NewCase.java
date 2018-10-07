package sk.itlearning.java5.flow.customer.view.cse;

import javax.enterprise.inject.spi.Bean;
import javax.enterprise.inject.spi.BeanManager;
import javax.enterprise.inject.spi.CDI;

import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.HtmlImport;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.polymertemplate.EventHandler;
import com.vaadin.flow.component.polymertemplate.Id;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.dom.Element;
import com.vaadin.flow.templatemodel.TemplateModel;

import sk.itlearning.java5.flow.customer.view.cse.model.StepDefinition;
import sk.itlearning.java5.jpa.resloc.model.Customer;
import sk.itlearning.java5.jpa.resloc.service.CustomerService;

/**
 * A Designer generated component for the new-case.html template.
 *
 * Designer will add and remove fields with @Id mappings but
 * does not overwrite or otherwise change this file.
 */
@Tag("new-case")
@HtmlImport("src/views/cse/new-case.html")
public class NewCase extends PolymerTemplate<NewCase.NewCaseModel> {

	private static final long serialVersionUID = 1L;

	private StepDefinition stepDefinition;

	@Id("dynamicContent")
	private Element dynamicContent;

	@Id("btnNewCustomer")
	private Element btnNewInvestigation;
	
	private TextField firstNameField;

	/**
     * Creates a new NewCase.
     */
    public NewCase() {
    	FormLayout formLayout = new FormLayout();
    	formLayout.setSizeFull();
    	firstNameField = new TextField();
    	firstNameField.setLabel("First Name");
    	firstNameField.setPlaceholder("Input First Name");
    	formLayout.add(firstNameField);
    	dynamicContent.setChild(0, formLayout.getElement());
    	dynamicContent.getClassList().add("dsDisplayContents");
    }

    /**
     * This model binds properties between NewCase and new-case.html
     */
    public interface NewCaseModel extends TemplateModel {
    	
    }

    @EventHandler
    private void saveNewCustomer() {
    	Customer c = new Customer();
    	c.setCustomerName(firstNameField.getValue());
    	getCustomerService().create(c);
    }

	private CustomerService getCustomerService() {
		BeanManager bm = CDI.current().getBeanManager();
		CustomerService instance = null;
		for (Bean<?> b : bm.getBeans(CustomerService.class)) {
			instance = (CustomerService) bm.getReference(b, CustomerService	.class, bm.createCreationalContext(b));
		}
		return instance;
	}

}
