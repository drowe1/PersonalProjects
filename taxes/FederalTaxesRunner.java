package taxes;

public class FederalTaxesRunner {
	public static void main(String[] agrs){
		FederalTaxes test = new FederalTaxes();
		test.getSalary(60000);
		test.findDeductions(18000);
		test.findTaxableSalary();
		test.findIncomeTax();
		test.findOtherTaxes();
		System.out.println(test.toString());
	}
}
