package sk.itlearning.java5.flow.view.encoders;

import java.util.Optional;

import com.vaadin.flow.templatemodel.ModelEncoder;

public class LongToStringEncoder implements ModelEncoder<Long, String> {

	private static final long serialVersionUID = 1L;

	@Override
	public String encode(Long modelValue) {
		return Optional.ofNullable(modelValue).map(Object::toString).orElse(null);
	}

	@Override
	public Long decode(String presentationValue) {
		return Optional.ofNullable(presentationValue).map(Long::valueOf).orElse(null);
	}

}