package sk.itlearning.java5.ui;

import java.util.List;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.Route;

import sk.itlearning.java5.jpa.model.Customer;
import sk.itlearning.java5.jpa.model.CustomerService;

/**
 * The main view contains a button and a click listener.
 */
@Route("")
public class MainView extends VerticalLayout {
	
	private static final long serialVersionUID = 1L;
	
	private CustomerService service = new CustomerService();
    private Grid<Customer> grid = new Grid<>();
    private TextField filterText = new TextField();
    private CustomerForm form = new CustomerForm(this);

    List<Customer> data;
    
    public MainView() {
        filterText.setPlaceholder("Filter by name...");
        filterText.setValueChangeMode(ValueChangeMode.EAGER);
        filterText.addValueChangeListener(e -> updateList());
        Button clearFilterTextBtn = new Button(
                new Icon(VaadinIcon.CLOSE_CIRCLE));
        clearFilterTextBtn.addClickListener(e -> filterText.clear());
        HorizontalLayout filtering = new HorizontalLayout(filterText,
                clearFilterTextBtn);

        Button addCustomerBtn = new Button("Add new customer");
        addCustomerBtn.addClickListener(e -> {
                grid.asSingleSelect().clear();
                form.setCustomer(new Customer());
        });
        HorizontalLayout toolbar = new HorizontalLayout(filtering,
                addCustomerBtn);

        grid.setSizeFull();

        grid.addColumn(Customer::getFirstName).setHeader("First name");
        grid.addColumn(Customer::getLastName).setHeader("Last name");
        grid.addColumn(Customer::getStatus).setHeader("Status");

        HorizontalLayout main = new HorizontalLayout(grid, form);
        main.setAlignItems(Alignment.START);
        main.setSizeFull();

        add(toolbar, main);
        setHeight("100vh");
        updateList();

        grid.asSingleSelect().addValueChangeListener(event -> {
                form.setCustomer(event.getValue());
        });
    }

    public void updateList() {
    	grid.setItems(service.read(filterText.getValue()));
    }
}
