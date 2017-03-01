package financeProject;

import java.util.Set;
import java.util.TreeSet;

public class FinanceRunner {
	public static void main(String[] args){
		Calculate test = new Calculate();
		Set<Double> sal = new TreeSet<Double>();
		sal = test.getSalInfo();
		for(Double income : sal){
			test.getSalary(income);
			test.findPropSaved(.15);
			test.findAmtRetirement();
			test.findDeductions(4000);
			test.findTaxableSalary();
			test.findFedTax();
			test.findOtherTaxes();
			test.findStateTax();
			test.findTotalTaxes();
			test.getGrowthRate(.11);
			test.grow();
			System.out.println(test.toString()+"\n");
		}
		
	}
}
