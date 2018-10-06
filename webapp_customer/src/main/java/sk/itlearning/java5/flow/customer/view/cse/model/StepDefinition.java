package sk.itlearning.java5.flow.customer.view.cse.model;

import java.util.ArrayList;
import java.util.List;

import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.formlayout.FormLayout.ResponsiveStep;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.textfield.TextField;

import elemental.json.Json;
import elemental.json.JsonObject;

public class StepDefinition {

	private Integer id;

	private String name;

	public StepDefinition() {
		getStepList().add(new StepDefinition(0, "Select contract type"));
		getStepList().add(new StepDefinition(1, "Input person information"));
		getStepList().add(new StepDefinition(2, "Input id information"));
		getStepList().add(new StepDefinition(3, "Input residence countries"));
		getStepList().add(new StepDefinition(4, "Sanction list investigation"));
	}

	private StepDefinition(Integer id, String name) {
		this.setId(id);
		this.setName(name);
	}

	private List<StepDefinition> stepList = new ArrayList<>();

	public List<StepDefinition> getStepList() {
		return stepList;
	}

	public void setStepList(List<StepDefinition> stepList) {
		this.stepList = stepList;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public FormLayout getFormLayoutElement(FormLayout formLayout, CaseStep caseStep) {
    	switch (caseStep.getStepIdx()) {
    	case 0:
    		ComboBox<String> contractTypeCombo = new ComboBox<>("Contract Type");
    		contractTypeCombo.setPlaceholder("Select contract type");
    		contractTypeCombo.setItems("Zmluva o spolupráci", "Zmluva o rezervácii", "Zmluva o prevode");
        	formLayout.add(contractTypeCombo);

        	contractTypeCombo.addValueChangeListener(e -> {
        		JsonObject job = caseStep.getJsonData() == null ? Json.createObject() : Json.parse(caseStep.getJsonData());
        		job.put("contractType", e.getValue());
        		caseStep.setJsonData(job.toString());
        	});

        	return formLayout;
    	case 1:
        	TextField firstNameField = new TextField();
        	firstNameField.setLabel("First Name");
        	firstNameField.setPlaceholder("Input First Name");

        	firstNameField.addValueChangeListener(e -> {
        		JsonObject job = caseStep.getJsonData() == null ? Json.createObject() : Json.parse(caseStep.getJsonData());
        		job.put("firstName", e.getValue());
        		caseStep.setJsonData(job.toString());
        	});

        	TextField lastNameField = new TextField();
        	lastNameField.setLabel("Last Name");
        	lastNameField.setPlaceholder("Input Last Name");

        	lastNameField.addValueChangeListener(e -> {
        		JsonObject job = caseStep.getJsonData() == null ? Json.createObject() : Json.parse(caseStep.getJsonData());
        		job.put("lastName", e.getValue());
        		caseStep.setJsonData(job.toString());
        	});

        	formLayout.add(firstNameField, lastNameField);
        	formLayout.setResponsiveSteps(
        	        new ResponsiveStep("0", 1),
        	        new ResponsiveStep("28em", 2));
        	return formLayout;
    	case 2:
        	TextField personIdCard = new TextField();
        	personIdCard.setLabel("Person Id");
        	personIdCard.setPlaceholder("Input Person Id Number");

        	personIdCard.addValueChangeListener(e -> {
        		JsonObject job = caseStep.getJsonData() == null ? Json.createObject() : Json.parse(caseStep.getJsonData());
        		job.put("personId", e.getValue());
        		caseStep.setJsonData(job.toString());
        	});

        	TextField passportId = new TextField();
        	passportId.setLabel("Passport Id");
        	passportId.setPlaceholder("Input Passport Id Number");

        	passportId.addValueChangeListener(e -> {
        		JsonObject job = caseStep.getJsonData() == null ? Json.createObject() : Json.parse(caseStep.getJsonData());
        		job.put("passportId", e.getValue());
        		caseStep.setJsonData(job.toString());
        	});

        	formLayout.add(personIdCard, passportId);
        	formLayout.setResponsiveSteps(
        	        new ResponsiveStep("0", 1),
        	        new ResponsiveStep("28em", 2));
        	return formLayout;
    	case 3:
    		ComboBox<String> personCountry = new ComboBox<>("Person Country");
    		personCountry.setPlaceholder("Select Person Residence Country");
    		personCountry.setItems("Albania", "Macedonia", "Seycheleys");

    		personCountry.addValueChangeListener(e -> {
        		JsonObject job = caseStep.getJsonData() == null ? Json.createObject() : Json.parse(caseStep.getJsonData());
        		job.put("personCountry", e.getValue());
        		caseStep.setJsonData(job.toString());
        	});

    		ComboBox<String> taxCountry = new ComboBox<>("Tax Country");
    		taxCountry.setPlaceholder("Select Person Tax Country");
    		taxCountry.setItems("Albania", "Macedonia", "Seycheleys");

    		taxCountry.addValueChangeListener(e -> {
        		JsonObject job = caseStep.getJsonData() == null ? Json.createObject() : Json.parse(caseStep.getJsonData());
        		job.put("taxCountry", e.getValue());
        		caseStep.setJsonData(job.toString());
        	});

        	formLayout.add(personCountry, taxCountry);
        	formLayout.setResponsiveSteps(
        	        new ResponsiveStep("0", 1),
        	        new ResponsiveStep("28em", 2));
        	return formLayout;
    	case 4:
        	Label labelStep4 = new Label("Sanction list investigation has now all information needed. Hit 'next' to launch the investigation");
        	labelStep4.addClassName("dsDisplayContents");
        	labelStep4.addClassName("dsInfoText");
        	formLayout.add(labelStep4);
        	return formLayout;
        default:
        	Label labelDefault = new Label("Step form not defined for stepNr = " + (caseStep.getStepIdx() + 1));
        	labelDefault.addClassName("dsDisplayContents");
        	labelDefault.addClassName("dsInfoText");
        	formLayout.add(labelDefault);
        	return formLayout;
    	}
	}

}
