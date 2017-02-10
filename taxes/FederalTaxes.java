package taxes;

import java.text.NumberFormat;
import java.util.Locale;

public class FederalTaxes {
	double sal=0;
	double tSal=0;
	double amtTaxed = 0;
	double deductions = 0;
	double[] tb = {0, 9275, 37650, 91150, 190150, 413350, 415050, Integer.MAX_VALUE};
	double[] tax = {0, .1, .15, .25, .28, .33, .35, .396 };

	public FederalTaxes() {
	}

	public void getSalary(double salary) {
		sal = salary;
	}
	
	public void findDeductions(double ded){
		deductions = ded;
	}

	public void findTaxableSalary() {
		tSal = sal - deductions;
	}
	

	public void findIncomeTax() {
		for (int i = 1; i < tb.length; i++) {
			if (tSal >= tb[i]) {
				amtTaxed += (tb[i] - tb[i-1])*tax[i];
			}
			else{
				amtTaxed += (tSal - tb[i-1])*tax[i];
				break;
			}
		}
	}
	
	public void findOtherTaxes(){
		amtTaxed += tSal*.0145;//medicare
		amtTaxed += tSal*.062;//social security
	}

	public String toString() {
		return "You will pay $" + (NumberFormat.getNumberInstance(Locale.US).format(amtTaxed)) + " in taxes\nYou will take home $"+ (NumberFormat.getNumberInstance(Locale.US).format(tSal - amtTaxed)) +" of your salary";
	}
}
