package sk.itlearning.java5.flow.customer.view.overview;

import java.util.List;

import javax.enterprise.inject.spi.Bean;
import javax.enterprise.inject.spi.BeanManager;
import javax.enterprise.inject.spi.CDI;

import com.vaadin.flow.component.EventData;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.HtmlImport;
import com.vaadin.flow.component.polymertemplate.EventHandler;
import com.vaadin.flow.component.polymertemplate.Id;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.dom.Element;
import com.vaadin.flow.templatemodel.Encode;
import com.vaadin.flow.templatemodel.TemplateModel;

import sk.itlearning.java5.flow.view.encoders.DateToStringEncoder;
import sk.itlearning.java5.flow.view.encoders.LongToStringEncoder;
import sk.itlearning.java5.jpa.resloc.model.Customer;
import sk.itlearning.java5.jpa.resloc.service.CustomerService;

/**
 * A Designer generated component for the over-view.html template.
 *
 * Designer will add and remove fields with @Id mappings but
 * does not overwrite or otherwise change this file.
 */
@Tag("over-view")
@HtmlImport("src/views/overview/over-view.html")
public class OverView extends PolymerTemplate<OverView.OverViewModel> {

	private static final long serialVersionUID = 1L;

	@Id("grid")
	private Element caseStepsGrid;

    /**
     * Creates a new OverView.
     */
    public OverView() {
    	List<Customer> list = getCustomerService().findAll();
    	getModel().setCustomers(list);
    }

	/**
     * This model binds properties between OverView and over-view.html
     */
    public interface OverViewModel extends TemplateModel {
    	@Encode(value=LongToStringEncoder.class, path="id")
    	@Encode(value=LongToStringEncoder.class, path="version")
    	@Encode(value=DateToStringEncoder.class, path="lastModified")
    	List<Customer> getCustomers();
    	void setCustomers(List<Customer> c);
    }

    @EventHandler
    private void deleteItem() {
    	Customer entity = getModel().getCustomers().stream().filter(c -> c.getId() == 1l).findFirst().orElse(null);
    	getCustomerService().delete(entity);
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
