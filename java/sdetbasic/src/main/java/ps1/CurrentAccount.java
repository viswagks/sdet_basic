package ps1;

import java.text.ParseException;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class CurrentAccount extends Account
{
	public CurrentAccount(double principle, double rateOfInterest, String accountCreatedOn) throws ParseException
	{
		super(principle, rateOfInterest, accountCreatedOn);
	}

	@Override
	public void calculateInterest()
	{
		Date currentDate = new Date();
		long diffInMillies = Math.abs(currentDate.getTime() - accountCreatedOn.getTime());
	    long days = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
		this.accruedInterest = (this.principle * this.rateOfInterest * days/365)/100;
	}
	
	@Override
	public void displayInterest()
	{
		System.out.println("Current Account Accrued Interest is: " + this.accruedInterest);
	}
}
