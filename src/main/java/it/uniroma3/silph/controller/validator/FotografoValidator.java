package it.uniroma3.silph.controller.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import it.uniroma3.silph.model.Fotografo;

@Component
public class FotografoValidator implements Validator {

	   @Override
	    public void validate(Object o, Errors errors) {
	        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nome", "required");
	        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "cognome", "required");
	        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "required");
	    }

	    @Override
	    public boolean supports(Class<?> aClass) {
	        return Fotografo.class.equals(aClass);
	    }	

}
