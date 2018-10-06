package sk.itlearning.java5.flow.view.customer;

import java.util.List;

import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.HtmlImport;
import com.vaadin.flow.component.polymertemplate.EventHandler;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.templatemodel.Encode;
import com.vaadin.flow.templatemodel.TemplateModel;

import sk.itlearning.java5.flow.view.encoders.DateToStringEncoder;
import sk.itlearning.java5.flow.view.encoders.LongToStringEncoder;
import sk.itlearning.java5.jpa.resloc.model.Customer;
import sk.itlearning.java5.jpa.resloc.service.CustomerService;

/**
 * A Designer generated component for the my-app.html template.
 *
 * Designer will add and remove fields with @Id mappings but
 * does not overwrite or otherwise change this file.
 */
@Route("myapp")
@Tag("my-app")
@HtmlImport("src/my-app.html")
public class MyApp extends PolymerTemplate<MyApp.MyAppModel> {

	private static final long serialVersionUID = 1L;

	/**
     * Creates a new MyApp.
     */
    public MyApp() {
    	List<Customer> list = CustomerService.findAll();
    	getModel().setCustomers(list);
    }

    /**
     * This model binds properties between MyApp and my-app.html
     */
    public interface MyAppModel extends TemplateModel {
    	@Encode(value=LongToStringEncoder.class, path="id")
    	@Encode(value=LongToStringEncoder.class, path="version")
    	@Encode(value=DateToStringEncoder.class, path="lastModified")
    	List<Customer> getCustomers();
    	void setCustomers(List<Customer> c);
    }
    
    @EventHandler
    public void addCustomer() {
    	Customer c = new Customer();
    	c.setCustomerName("Jano");
    	CustomerService.create(c);
    	List<Customer> list = CustomerService.findAll();
    	getModel().setCustomers(list);
    }
    
}
