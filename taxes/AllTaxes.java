package taxes;

import java.text.NumberFormat;
import java.util.Locale;

public class AllTaxes {
	double sal=0;
	double taxableSal=0;
	double amtTaxed = 0;
	double deductions = 0;
	
	double[] fedBracket = {0, 9275, 37650, 91150, 190150, 413350, 415050, Integer.MAX_VALUE};
	double[] fedTax = {0, .1, .15, .25, .28, .33, .35, .396 };
	
	double[] stateBracket = {0, 25390, 83400, 156910, Integer.MAX_VALUE};
	double[] stateTax = {0, .0535, .0705, .0785, .0985,};
	
	public double getSalary(double salary) {
		sal = salary;
		return sal;
	}
	
	public double findDeductions(double ded){
		deductions = ded;
		return deductions;
	}

	public double findTaxableSalary() {
		taxableSal = sal - deductions;
		return taxableSal;
	}
	
	public double findStateTax() {
		double amtStateTax = 0;
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
		double amtFedTax= 0;
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
		double amtOtherTax = 0;
		amtOtherTax += taxableSal*.0145;//medicare
		amtOtherTax += taxableSal*.062;//social security
		amtTaxed += amtOtherTax;
		return amtOtherTax;
	}
	
	public String toString() {
		return  "Your Salary: \t\t$"+(NumberFormat.getNumberInstance(Locale.US).format(sal))+"\n"
				+"Tax exempt deductions: \t$"+(NumberFormat.getNumberInstance(Locale.US).format(deductions))+"\n"
				+"Total taxes you pay: \t$" + (NumberFormat.getNumberInstance(Locale.US).format(amtTaxed)) +"\n"
				+"Amount you take home: \t$"+ (NumberFormat.getNumberInstance(Locale.US).format(taxableSal - amtTaxed)) +"\n"
				+"Federal Income Tax: \t$"+(NumberFormat.getNumberInstance(Locale.US).format(findFedTax()))+"\n"
				+"Other Federal Taxes: \t$"+(NumberFormat.getNumberInstance(Locale.US).format(findOtherTaxes()))+"\n"
				+"State Income Tax: \t$"+(NumberFormat.getNumberInstance(Locale.US).format(findStateTax()));
	}
}
