package com.springboot.valid_exception.cofig.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;

import com.springboot.valid_exception.cofig.TelephoneValidator;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = TelephoneValidator.class)
public @interface Telephone {
	String message() default "전화번호 형식이 일치하지 않습니다";
	Class[] groups() default {};
	Class[] payload() default {};
}