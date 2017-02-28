package financeProject;

public class FinanceRunner {
	public static void main(String[] args){
		Calculate test = new Calculate();
		test.getSalary(100000);
		test.findPropSaved(.15);
		test.findAmtRetirement();
		test.findDeductions(4000);
		test.findTaxableSalary();
		test.findStateTax();
		test.findFedTax();
		test.findOtherTaxes();
		System.out.println(test.toString());
	}
}
