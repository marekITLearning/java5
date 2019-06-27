package sk.itlearning.java5.ui;

import java.util.stream.Stream;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;

import sk.itlearning.java5.jpa.model.Customer;
import sk.itlearning.java5.jpa.model.CustomerService;

public class CustomerForm extends FormLayout {

    private TextField firstName = new TextField("First name");
    private TextField lastName = new TextField("Last name");
    private ComboBox<String> status = new ComboBox<>("Status");
    
    private CustomerService service = null;
    
    private Customer customer;
    private MainView mainView;
    private Binder<Customer> binder = new Binder<>(Customer.class);
    private Button save = new Button("Save");
    private Button delete = new Button("Delete");

    public CustomerForm(MainView mainView) {
    	
    	try {
			InitialContext ctx = new InitialContext();
			service = (CustomerService) ctx.lookup("java:global/vaadin/CustomerService");
		} catch (NamingException e1) {
			e1.printStackTrace();
		}
    	
        this.mainView = mainView;
        add(firstName, lastName, status);
        
        status.setItems(Stream.of("new", "lost", "active"));
        
        binder.bindInstanceFields(this);
        HorizontalLayout buttons = new HorizontalLayout(save, delete);
        add(firstName, lastName, status, buttons);
        save.getElement().setAttribute("theme", "primary");
        setCustomer(null);
        save.addClickListener(e -> this.save());
        delete.addClickListener(e -> this.delete());
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
        binder.setBean(customer);
        boolean enabled = customer != null;
        save.setEnabled(enabled);
        delete.setEnabled(enabled);
        if (enabled) {
            firstName.focus();
        }
    }

    private void delete() {
        service.delete(customer.getId());
        mainView.updateList();
        setCustomer(null);
    }

    private void save() {
        service.update(customer);
        mainView.updateList();
        setCustomer(null);
    }
}
