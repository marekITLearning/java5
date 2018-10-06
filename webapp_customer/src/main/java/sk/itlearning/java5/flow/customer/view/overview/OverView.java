package sk.itlearning.java5.flow.customer.view.overview;

import com.vaadin.flow.component.EventData;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.HtmlImport;
import com.vaadin.flow.component.polymertemplate.EventHandler;
import com.vaadin.flow.component.polymertemplate.Id;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.templatemodel.TemplateModel;

import sk.itlearning.java5.flow.customer.view.overview.model.Overview;

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

	private @Id("textOverview") TextField textOverview;

    /**
     * Creates a new OverView.
     */
    public OverView() {
    	Overview overview = new Overview();
    	Overview.Header header = new Overview.Header();
    	header.setText("Text from textfield set by constructor");
    	overview.setHeader(header);
    	getModel().setOverview(overview);

    	textOverview.addValueChangeListener(event -> getModel().getOverview().getHeader().setText("Set by Value Change Listener: " + event.getValue()));
    }

	/**
     * This model binds properties between OverView and over-view.html
     */
    public interface OverViewModel extends TemplateModel {
    	Overview getOverview();
    	void setOverview(Overview overview);
    }

    @EventHandler
    private void textOverviewChanged(@EventData("event.target.value") String text) {
    	getModel().getOverview().getHeader().setText("Set by Event Handler: " + text);
    }

}
