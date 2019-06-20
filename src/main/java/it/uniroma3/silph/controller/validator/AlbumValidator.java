package it.uniroma3.silph.controller.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import it.uniroma3.silph.model.Album;

@Component
public class AlbumValidator implements Validator {

	   @Override
	    public void validate(Object o, Errors errors) {
	        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "titolo", "required");
	    }

	    @Override
	    public boolean supports(Class<?> aClass) {
	        return Album.class.equals(aClass);
	    }	
}
