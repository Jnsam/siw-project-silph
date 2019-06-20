package it.uniroma3.silph.controller.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import it.uniroma3.silph.model.Richiesta;

@Component
public class FotoValidator implements Validator{
	   @Override
	    public void validate(Object o, Errors errors) {
	        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "titolo", "required");
	        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "indirizzo", "required");
	    }

	    @Override
	    public boolean supports(Class<?> aClass) {
	        return Richiesta.class.equals(aClass);
	    }	
}
