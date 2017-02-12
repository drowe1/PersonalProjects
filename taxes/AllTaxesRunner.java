package taxes;

public class AllTaxesRunner {
	public static void main(String[] args){
		AllTaxes test = new AllTaxes();
		test.getSalary(100000);
		test.findDeductions(12000);
		test.findTaxableSalary();
		test.findStateTax();
		test.findFedTax();
		test.findOtherTaxes();
		System.out.println(test.toString());
	}

}
