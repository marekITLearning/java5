package sk.itlearning.java5.flow;

import java.util.ArrayList;
import java.util.List;

import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.HtmlImport;
import com.vaadin.flow.component.polymertemplate.EventHandler;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.templatemodel.TemplateModel;

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

    /**
     * Creates a new MyApp.
     */
    public MyApp() {
    	Client c1 = new Client();
    	c1.setName("Jano");
    	Client c2 = new Client();
    	c2.setName("Miso");
    	List<Client> list = new ArrayList<>();
    	list.add(c1);
    	list.add(c2);
    	getModel().setClient(c1);
    	getModel().setClients(list);
    }

    /**
     * This model binds properties between MyApp and my-app.html
     */
    public interface MyAppModel extends TemplateModel {
    	Client getClient();
    	void setClient(Client c);
    	List<Client> getClients();
    	void setClients(List<Client> c);
    }
    
    @EventHandler
    public void onClick() {
    	getModel().getClient().setName("ine meno");
    }
    
}
