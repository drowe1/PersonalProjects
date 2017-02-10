package taxes;

public class StateTaxRunner {
	public static void main(String[] args){
		StateTaxesMn test = new StateTaxesMn();
		test.getSalary(60000);
		test.findDeductions(18000);
		test.findTaxableSalary();
		test.findAmtTaxed();
		System.out.println(test.toString());
	}

}