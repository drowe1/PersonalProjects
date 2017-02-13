package taxes;

public class AllTaxesRunner {
	public static void main(String[] args){
		AllTaxes test = new AllTaxes();
		test.getSalary(100000);
		test.findAmtRetirement(10000);
		test.findDeductions(4000);
		test.findTaxableSalary();
		test.findStateTax();
		test.findFedTax();
		test.findOtherTaxes();
		System.out.println(test.toString());
	}

}
