package sk.itlearning.java5.flow.customer.view.cse;

import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.IntStream;

import javax.enterprise.inject.spi.Bean;
import javax.enterprise.inject.spi.BeanManager;
import javax.enterprise.inject.spi.CDI;

import com.vaadin.flow.component.EventData;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.HtmlImport;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.polymertemplate.EventHandler;
import com.vaadin.flow.component.polymertemplate.Id;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.dom.Element;
import com.vaadin.flow.templatemodel.TemplateModel;

import elemental.json.impl.JreJsonNumber;
import sk.itlearning.java5.flow.customer.view.cse.model.CaseStep;
import sk.itlearning.java5.flow.customer.view.cse.model.OeCase;
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

	@Id("caseStepper")
	private Element caseStepper;

	@Id("btnNewInvestigation")
	private Element btnNewInvestigation;

	@Id("caseStepsGrid")
	private Element caseStepsGrid;

	/**
     * Creates a new NewCase.
     */
    public NewCase() {
    	stepDefinition = new StepDefinition();
    }

    /**
     * This model binds properties between NewCase and new-case.html
     */
    public interface NewCaseModel extends TemplateModel {
    	void setOeCase(OeCase oeCase);
    	OeCase getOeCase();
    }

    public OeCase getOeCase() {
    	return getModel().getOeCase();
    }

    @EventHandler
    private void newInvestigation() {
    	getModel().setOeCase(new OeCase());
    	IntStream.range(0, stepDefinition.getStepList().size()+1).forEach(e -> {
        	caseStepper.appendChild(new Element("paper-step"));
    	});
    	caseStepper.getClassList().add("visible");
    	caseStepper.setProperty("backLabel", "Späť");
    	caseStepper.setProperty("nextLabel", "Ďalej");
    	caseStepper.setProperty("selected", 0);
    	btnNewInvestigation.getClassList().add("hidden");
    	dynamicContent.getClassList().add("visible");
    	addNextStep(0);
    }

    @EventHandler
    private void nextOrBackStep(@EventData("event.target.selected") JreJsonNumber e) {
    	int selectedStepIdx = Double.valueOf(e.getNumber()).intValue();
    	CaseStep current = getOeCase().getStepById(getOeCase().getCurrentStepIdx());
    	// if 'next' has been clicked
    	if (current.getStepIdx() < selectedStepIdx) {
        	processCurrent(current.getStepIdx());
        	addNextStep(selectedStepIdx);
    	}
    	// if 'previous' has been clicked
    	if (current.getStepIdx() >= selectedStepIdx) {
    		CaseStep previous = getOeCase().getStepById(selectedStepIdx);
    		getOeCase().setCurrentStepIdx(previous.getStepIdx());
        	getOeCase().setCurrentStepName(previous.getName());
    	    dynamicContent.removeAllChildren();
    	    dynamicContent.setChild(0, getStepForm(selectedStepIdx));
    	}
    }

	private void processCurrent(int currentNr) {
		CaseStep current = getOeCase().getStepById(getOeCase().getCurrentStepIdx());
		current.setStatus("OK");
		List<Customer> list = getCustomerService().findAll();
		if (list == null || list.isEmpty()) {
			Customer c = new Customer();
			c.setCustomerName("Miso");
			getCustomerService().create(c);
		} else {
			list.forEach(System.out::println);
		}
	}

	private void addNextStep(int currentNr) {
		if (currentNr >= stepDefinition.getStepList().size()) return;
		StepDefinition singleStep = stepDefinition.getStepList().get(currentNr);
		CaseStep caseStep = null;
		try {
			caseStep = getModel().getOeCase().getStepById(currentNr);
		} catch (IndexOutOfBoundsException | NoSuchElementException e) {
			caseStep = new CaseStep(singleStep.getId(), singleStep.getName());
			getOeCase().getSteps().add(caseStep);
		}
    	getOeCase().setCurrentStepIdx(caseStep.getStepIdx());
    	getOeCase().setCurrentStepName(caseStep.getName());
    	List<CaseStep> steps = getOeCase().getSteps();
	    Collections.sort(steps, (s1, s2) -> s2.getStepIdx().compareTo(s1.getStepIdx()));
	    dynamicContent.removeAllChildren();
	    dynamicContent.setChild(0, getStepForm(currentNr));
	}

	private Element getStepForm(int stepNr) {
    	FormLayout formLayout = new FormLayout();
    	formLayout.addClassName("padding");
    	CaseStep current = getOeCase().getStepById(getOeCase().getCurrentStepIdx());
	    formLayout = stepDefinition.getFormLayoutElement(formLayout, current);
    	return formLayout.getElement();
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
