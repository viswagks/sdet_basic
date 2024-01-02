package ps1;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class Account
{
	protected double principle, rateOfInterest;
	protected double accruedInterest;
	protected Date accountCreatedOn;
	protected SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy", Locale.ENGLISH);
	
	public Account(double principle, double rateOfInterest, String accountCreatedOn) throws ParseException
	{
		this.principle = principle;
		this.rateOfInterest = rateOfInterest;
		this.accountCreatedOn = sdf.parse(accountCreatedOn);
	}
	
	public void calculateInterest()
	{
		
		Date currentDate = new Date();
		long diffInMillies = Math.abs(currentDate.getTime() - accountCreatedOn.getTime());
	    long days = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
		this.accruedInterest = (this.principle * this.rateOfInterest * days/365)/100;
	}
	
	public void displayInterest()
	{
		System.out.println("Account Accrued Interest is: " + this.accruedInterest);
	}
}
