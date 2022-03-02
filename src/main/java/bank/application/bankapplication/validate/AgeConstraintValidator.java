package bank.application.bankapplication.validate;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class AgeConstraintValidator implements ConstraintValidator<Age, Date> {

	private int minAge;

	@Override
	public void initialize(Age age) {
		this.minAge = age.min();
	}

	@Override
	public boolean isValid(Date dob, ConstraintValidatorContext context) {
		Date currDate = new Date();
		long difference_In_Time = currDate.getTime() - dob.getTime();
		long difference_In_Years = TimeUnit.MILLISECONDS.toDays(difference_In_Time) / 365l;
		return difference_In_Years >= this.minAge;
	}
}
