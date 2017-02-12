package compound;

import java.text.NumberFormat;
import java.util.Locale;

public class Investments {
	
	double money;
	double monthlyInput;
	double yearlyInput;
	double interestRate;
	double spendYearly;
	int ageStartWorking;
	int ageRetire;
	int ageDeath;
	
	public double getStartingAmount(double start){
		money = start;
		return money;
	}
	
	public double getMonthlyInput(double input){
		monthlyInput = input;
		return monthlyInput;
	}
	
	public double getYearlyInput(){
		yearlyInput = monthlyInput * 12;
		return yearlyInput;
	}
	
	public double getRate(double growthRate){
		interestRate = growthRate;
		return interestRate;
	}
	
	public double getAnnualSpendingAfterRetirement(double spend){
		spendYearly = spend;
		return spendYearly;
	}
	
	public int getStartAge(int age){
		ageStartWorking = age;
		return ageStartWorking;
	}
	
	public int getRetirementAge(int age){
		ageRetire = age;
		return ageRetire;
	}
	
	public int getAgeDeath(int age){
		ageDeath = age;
		return ageDeath;
	}
	
	public double growth(){
		double principal = 0;
		for(int i = ageStartWorking; i<ageRetire; i++){
			principal += yearlyInput;
			money = (money + yearlyInput)*(1+interestRate);
			System.out.println("Age: "+i+", Money: $"+NumberFormat.getNumberInstance(Locale.US).format(money)+" \tAmount from principal: $"+NumberFormat.getNumberInstance(Locale.US).format(principal));
			
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
