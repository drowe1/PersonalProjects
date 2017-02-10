package compound;

import java.text.NumberFormat;
import java.util.Locale;

public class investments {
	
	double money = 0;
	double monthlyInput = 1500;
	double yearlyInput = monthlyInput * 12;
	double interestRate = .2;
	double spendYearly = 60000;
	int ageStartWorking = 23;
	int ageRetire = 50;
	int ageDeath = 100;
	
	public double growth(){
		for(int i = ageStartWorking; i<ageRetire; i++){
			money = (money + yearlyInput)*(1+interestRate);
			System.out.println("Age: "+i+", Money: $"+NumberFormat.getNumberInstance(Locale.US).format(money));
		}
		System.out.println("Retirement");
		return money;
	}
	
	public double taxes(){
		money *= .6;
		return money;
	}
	
	public double afterRetirement(){
		for(int i = ageRetire; i<ageDeath; i++){
			money = (money - spendYearly)*(1 + interestRate);
			System.out.println("Age: "+i+", Money: $"+NumberFormat.getNumberInstance(Locale.US).format(money));
		}
		return money;
	}
}
