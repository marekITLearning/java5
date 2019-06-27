package sk.itlearning;

import java.util.stream.Stream;

import java.util.List;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.datepicker.DatePicker;
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
	private DatePicker birthDate = new DatePicker("Birthdate");
	private Button save = new Button("Save");
	private Button delete = new Button("Delete");
	private Binder<Customer> binder = new Binder<>(Customer.class);
	private MainView mainView;
	private CustomerService service = new CustomerService();
	
	public CustomerForm(MainView mainView) {
	    this.mainView = mainView;
	    
	    status.setItems(Stream.of("new", "lost", "active"));

	    HorizontalLayout buttons = new HorizontalLayout(save, delete);
	    save.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
	    add(firstName, lastName, status, birthDate, buttons);
	    
	    binder.bindInstanceFields(this);
	    
	    save.addClickListener(event -> save());
	    
	    delete.addClickListener(event -> delete());
	}
	
	public void setCustomer(Customer customer) {
	    binder.setBean(customer);

	    if (customer == null) {
	        setVisible(false);
	    } else {
	        setVisible(true);
	        firstName.focus();
	    }
	}
	
	private void save() {
	    Customer customer = binder.getBean();
	    Customer c = service.readById(customer.getId());
	    if (c != null) {
	    	customer.setId(c.getId());
	    	service.update(customer);
	    } else {
	    	service.create(customer);
	    }
	    mainView.updateList();
	    setCustomer(null);
	}
	
	private void delete() {
	    Customer customer = binder.getBean();
	    service.delete(customer);
	    mainView.updateList();
	    setCustomer(null);
	}
	
}
