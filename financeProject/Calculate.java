package financeProject;

import java.text.NumberFormat;
import java.util.Locale;

public class Calculate {
	double sal; double taxableSal;
	double amtTaxed; double amtStateTax; double amtFedTax; double amtOtherTax;
	double propSavings; double savings/*yearly savings*/; double deductions;


	double[] fedBracket = {0, 9275, 37650, 91150, 190150, 413350, 415050, Integer.MAX_VALUE};
	double[] fedTax = {0, .1, .15, .25, .28, .33, .35, .396 };

	double[] stateBracket = {0, 25390, 83400, 156910, Integer.MAX_VALUE};
	double[] stateTax = {0, .0535, .0705, .0785, .0985,};

	public double getSalary(double salary) {
		sal = salary;
		return sal;
	}
	
	public double findPropSaved(double savingsRate){
		propSavings = savingsRate;
		return propSavings;
	}

	public double findAmtRetirement(){
		savings = sal * propSavings;
		return savings;
	}

	public double findDeductions(double ded){
		deductions = ded;
		return deductions;
	}

	public double findTaxableSalary() {
		taxableSal = sal - deductions - savings;
		return taxableSal;
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
		amtTaxed += amtStateTax;
		return amtStateTax;
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
		amtTaxed += amtFedTax;
		return amtFedTax;
	}

	public double findOtherTaxes(){
		amtOtherTax = 0;
		amtOtherTax += taxableSal*.0145;//medicare
		amtOtherTax += taxableSal*.062;//social security
		amtTaxed += amtOtherTax;
		return amtOtherTax;
	}

	public String toString() {
		return  "Your Salary: \t\t\t$"+(NumberFormat.getNumberInstance(Locale.US).format(sal))+"\n"
				+"Tax exempt retirement savings: \t$"+(NumberFormat.getNumberInstance(Locale.US).format(savings))+"\n"
				+"Other tax exempt deductions: \t$"+(NumberFormat.getNumberInstance(Locale.US).format(deductions))+"\n"
				+"Federal Income Tax: \t\t$"+(NumberFormat.getNumberInstance(Locale.US).format(amtFedTax))+"\n"
				+"Other Federal Taxes: \t\t$"+(NumberFormat.getNumberInstance(Locale.US).format(amtOtherTax))+"\n"
				+"State Income Tax: \t\t$"+(NumberFormat.getNumberInstance(Locale.US).format(amtStateTax))+"\n"
				+"Total taxes you pay: \t\t$" + (NumberFormat.getNumberInstance(Locale.US).format(amtTaxed)) +"\n"
				+"Amount you take home: \t\t$"+ (NumberFormat.getNumberInstance(Locale.US).format(taxableSal - amtTaxed + deductions));

	}
}
