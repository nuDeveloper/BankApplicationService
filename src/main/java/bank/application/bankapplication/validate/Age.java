package bank.application.bankapplication.validate;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy = AgeConstraintValidator.class)
@Retention(RUNTIME)
@Target(FIELD)
public @interface Age {
	
	public int min() default 18;

	public String message() default "Age must be greater than or equal to 18.";

	public Class<?>[] groups() default {};

	public Class<? extends Payload>[] payload() default {};
}
