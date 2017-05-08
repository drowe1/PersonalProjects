package compound;

public class InvestmentsRunner {
	public static void main(String[] args){
		Investments test = new Investments();
		test.getStartingAmount(000);
		test.getMonthlyInput(500);
		test.getYearlyInput();
		test.getRate(.10);
		test.getAnnualSpendingAfterRetirement(60000);
		test.getStartAge(23);
		test.getRetirementAge(50);
		test.getAgeDeath(100);
		test.growth();
		//test.taxes();
		test.afterRetirement();
	}

}
