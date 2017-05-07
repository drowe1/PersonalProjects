package financeProject;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class FinanceRunner {
	public static void main(String[] args){
		double propSaved;
		double deductions;
		
		Scanner scan = new Scanner(System.in);
		System.out.println("What percent of your salary do you want to save for retirement?");
		double percent = scan.nextDouble();
		propSaved = percent/100;
		System.out.println("How many dollars worth of tax deductions do you have?");
		deductions = scan.nextDouble();
		
		Calculate test = new Calculate();

		test.getAge(22);
		test.getRetAge(50);
		
		Set<Double> sal = new TreeSet<Double>();
		sal = test.getSalInfo();
		
		
		for(Double income : sal){
			test.getSalary(income);
			test.findPropSaved(propSaved);
			test.findAmtRetirement();
			test.findDeductions(deductions);
			test.findTaxableSalary();
			test.findFedTax();
			test.findOtherTaxes();
			test.findStateTax();
			test.findTotalTaxes();
			test.getGrowthRate(.11);
			test.grow();
			System.out.println(test.toString());
		}
		scan.close();
	}
}
