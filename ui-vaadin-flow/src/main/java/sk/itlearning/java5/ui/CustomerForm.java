package sk.itlearning.java5.ui;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;

import sk.itlearning.java5.jpa.model.Customer;
import sk.itlearning.java5.jpa.model.CustomerService;

public class CustomerForm extends FormLayout {

	private static final long serialVersionUID = 1L;

	private TextField firstName = new TextField("First name");
	private TextField lastName = new TextField("Last name");
	private ComboBox<String> status = new ComboBox<>("Status");
	private CustomerService service = new CustomerService();
	private Customer customer;
	private MainView mainView;
	private Button save = new Button("Save");
	private Button delete = new Button("Delete");
	private Button transactionTest = new Button("Transaction Test");
	private Binder<Customer> binder = new Binder<>(Customer.class);

	public CustomerForm(MainView mainView) {
		this.mainView = mainView;
		add(firstName, lastName, status);
		status.setItems("Active", "Retired");
		binder.bindInstanceFields(this);
		HorizontalLayout buttons = new HorizontalLayout(save, delete, transactionTest);
		add(firstName, lastName, status, buttons);
		save.getElement().setAttribute("theme", "primary");
		setCustomer(null);
		save.addClickListener(e -> this.save());
		delete.addClickListener(e -> this.delete());
		transactionTest.addClickListener(e -> this.testTransaction());
		binder.forField(firstName).asRequired().bind(Customer::getFirstName, Customer::setFirstName);
		binder.forField(lastName).asRequired().bind(Customer::getLastName, Customer::setLastName);
		binder.forField(status).asRequired().bind(Customer::getStatus, Customer::setStatus);
	}

	private void testTransaction() {
		Customer c1 = new Customer();
		c1.setFirstName("1");
		c1.setLastName("Test");
		c1.setStatus("Active");
		service.create(c1);
		
		Customer c2 = new Customer();
		c2.setFirstName("1");
		c2.setLastName("Test");
		service.create(c2);
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
		service.delete(customer);
		mainView.updateList();
		setCustomer(null);
	}

	private void save() {
		if (!binder.validate().hasErrors()) {
			Customer dbCustomer = service.find(customer);
			if (dbCustomer == null) {
				service.create(customer);
			} else {
				service.update(customer);
			}
			mainView.updateList();
			setCustomer(null);
		}
	}
	
}