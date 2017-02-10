package taxes;

import java.text.NumberFormat;
import java.util.Locale;

public class StateTaxesMn {
	double sal=0;
	double tSal=0;
	double amtTaxed = 0;
	double deductions = 0;
	double[] tb = {0, 25390, 83400, 156910, Integer.MAX_VALUE};
	double[] tax = {0, .0535, .0705, .0785, .0985,};

	public StateTaxesMn() {
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

	public void findAmtTaxed() {
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

	public String toString() {
		return "You will pay $" + (NumberFormat.getNumberInstance(Locale.US).format(amtTaxed)) + " in taxes\nYou will take home $"+ (NumberFormat.getNumberInstance(Locale.US).format(tSal - amtTaxed)) +" of your salary";
	}
}
