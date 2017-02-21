package compound;

public class InvestmentsRunner {
	public static void main(String[] args){
		Investments test = new Investments();
		test.getStartingAmount(12000);
		test.getMonthlyInput(1000);
		test.getYearlyInput();
		test.getRate(.11);
		test.getAnnualSpendingAfterRetirement(60000);
		test.getStartAge(23);
		test.getRetirementAge(50);
		test.getAgeDeath(80);
		test.growth();
		//test.taxes();
		test.afterRetirement();
	}

}
