package robotTester;

import java.util.Scanner;

public class RobotRunner {
	public static void main(String args[]){
		Robot r = new Robot();
		Scanner scan = new Scanner(System.in);
		System.out.println("To begin the robot test, please enter your student ID number");
		r.getNum(scan.nextInt());
		if(r.isValidNum()){
			System.out.println("What is your name?");
			scan.next();
			System.out.println("What sound does a cow make?");
			scan.next();
			System.out.println("What color is the sky?");
			scan.next();
		}
		else{
			while(!r.isValidNum()){
				System.out.println("Don't lie to me, that's not your ID number\nTry again");
				r.getNum(scan.nextInt());
			}
			System.out.println("What is your name?");
			scan.next();
			System.out.println("What sound does a cow make?");
			scan.next();
			System.out.println("What color is the sky?");
			scan.next();
		}


		if(r.isTJ()){
			for(int i = 0; i< 35; i++){
				System.out.println("ROBOT!!!!!!!!!!!!!!!!!!!!!!!");
			}
		}
		else{
			System.out.println("Congratulations, you are not a robot");
		}
		scan.close();
	}
}
