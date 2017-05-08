package financeProject;

import java.text.NumberFormat;
import java.util.Set;
import java.util.TreeSet;
import java.util.Locale;

public class Calculate {
	double sal;
	Set<Double> salInfo = new TreeSet<Double>();
	double taxableSal;
	double amtTaxed; 
	double amtStateTax; 
	double amtFedTax; 
	double amtOtherTax;
	double propSavings; 
	double yearlySavings;
	double deductions;
	double growthRate;
	double totalAmtSaved = 0;
	int age;
	int retAge;

	double[] fedBracket = {0, 9275, 37650, 91150, 190150, 413350, 415050, Integer.MAX_VALUE};
	double[] fedTax = {0, .1, .15, .25, .28, .33, .35, .396 };

	double[] stateBracket = {0, 25390, 83400, 156910, Integer.MAX_VALUE};
	double[] stateTax = {0, .0535, .0705, .0785, .0985,};
	
	public Set<Double> getSalInfo(){
		for(int i = age; i<retAge; i++){
			salInfo.add((double) (((i-age)*2000)+60000));
		}
		return salInfo;
	}
	
	public int getAge(int ag){
		age = ag;
		return age;
	}
	
	public int getRetAge(int ag){
		retAge = ag;
		return retAge;
	}

	public double getSalary(double salary) {
		sal = salary;
		return sal;
	}
	
	public double findPropSaved(double savingsRate){
		propSavings = savingsRate;
		return propSavings;
	}

	public double findAmtRetirement(){
		yearlySavings = sal * propSavings;
		return yearlySavings;
	}

	public double findDeductions(double ded){
		deductions = ded;
		return deductions;
	}

	public double findTaxableSalary() {
		taxableSal = sal - deductions - yearlySavings;
		return taxableSal;
	}

	public double findFedTax() {
		amtFedTax= 0;
		for (int i = 1; i < fedBracket.length; i++) {
			if (taxableSal >= fedBracket[i]) {
				amtFedTax += (fedBracket[i] - fedBracket[i-1])*fedTax[i];
			}
			else{
				amtFedTax += (taxableSal - fedBracket[i-1])*fedTax[i];
				break;
			}
		}
		return amtFedTax;
	}

	public double findOtherTaxes(){
		amtOtherTax = 0;
		amtOtherTax += taxableSal*.0145;//medicare
		amtOtherTax += taxableSal*.062;//social security
		return amtOtherTax;
	}
	
	public double findStateTax() {
		amtStateTax = 0;
		for (int i = 1; i < stateBracket.length; i++) {
			if (taxableSal >= stateBracket[i]) {
				amtStateTax += (stateBracket[i] - stateBracket[i-1])*stateTax[i];
			}
			else{
				amtStateTax += (taxableSal - stateBracket[i-1])*stateTax[i];
				break;
			}
		}
		return amtStateTax;
	}

	
	public double findTotalTaxes(){
		amtTaxed = amtFedTax + amtOtherTax + amtStateTax;
		return amtTaxed;
	}
	
	public double getGrowthRate(double rate){
		growthRate = rate;
		return growthRate;
	}
	
	public double grow(){
		totalAmtSaved = (totalAmtSaved + yearlySavings)*(1+growthRate);
		return totalAmtSaved;
	}

	public String toString() {
		age++;
		return  "Age:\t\t\t\t\t\t" + (age)+"\n"
				+"Your Salary: \t\t\t\t$"+(NumberFormat.getNumberInstance(Locale.US).format(sal))+"\n"
				+"Tax exempt retirement savings: \t$"+(NumberFormat.getNumberInstance(Locale.US).format(yearlySavings))+"\n"
				+"Other tax exempt deductions: \t$"+(NumberFormat.getNumberInstance(Locale.US).format(deductions))+"\n"
				+"Federal Income Tax: \t\t\t$"+(NumberFormat.getNumberInstance(Locale.US).format(amtFedTax))+"\n"
				+"Other Federal Taxes: \t\t\t$"+(NumberFormat.getNumberInstance(Locale.US).format(amtOtherTax))+"\n"
				+"State Income Tax: \t\t\t$"+(NumberFormat.getNumberInstance(Locale.US).format(amtStateTax))+"\n"
				+"Total taxes you pay: \t\t\t$" + (NumberFormat.getNumberInstance(Locale.US).format(amtTaxed)) +"\n"
				+"Amount you take home: \t\t$"+ (NumberFormat.getNumberInstance(Locale.US).format(taxableSal - amtTaxed + deductions)) +"\n"
				+"Total retirement savings: \t\t$" + (NumberFormat.getNumberInstance(Locale.US).format(totalAmtSaved)) +"\n";

	}
}
