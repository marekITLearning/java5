package sk.itlearning.java5.flow.view.encoders;

import java.util.Date;
import java.util.Optional;

import com.vaadin.flow.templatemodel.ModelEncoder;

public class DateToStringEncoder implements ModelEncoder<Date, String> {

	private static final long serialVersionUID = 1L;

	@Override
	public String encode(Date modelValue) {
		return Optional.ofNullable(modelValue).map(Object::toString).orElse(null);
	}

	@Override
	public Date decode(String presentationValue) {
		return Optional.ofNullable(presentationValue).map(s -> new Date()).orElse(null);
	}

}