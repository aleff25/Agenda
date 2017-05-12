package br.com.pcinfo.javaweb.spring.validation;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import br.com.pcinfo.javaweb.spring.java.Tarefa;

public class TaskValidation implements Validator {
	@Override
	public void validate(Object target, Errors errors) {
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "descricao", "field.required");
		Tarefa tarefa= (Tarefa) target;
		if (tarefa.getDescricao() == null) {
			errors.rejectValue("pages", "field.required");
		}
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return false;
	}
}